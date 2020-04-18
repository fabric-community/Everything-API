/*
 *     Copyright (C) 2020 Fabric Community
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Lesser General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU Lesser General Public License for more details.
 *
 *     You should have received a copy of the GNU Lesser General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package io.github.fabriccommunity.everything.api.event.v4;

import com.mojang.datafixers.util.Unit;
import io.github.fabriccommunity.everything.api.functional.IO;
import io.github.fabriccommunity.everything.api.functional.Iterables;
import io.github.fabriccommunity.everything.api.functional.ThrowingRunnable;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;
import java.util.Objects;

/**
 * An event handler.
 *
 * @param <A> the event type
 */
@FunctionalInterface
public interface EventHandler<A> extends EventListener {
    /**
     * Handles the event.
     *
     * @param event the event
     * @return the IO operation
     */
    IO<Unit> handle(A event);

    @SuppressWarnings("unchecked")
    static <A> EventHandler<A> composite(final Iterable<? extends EventHandler<? super A>> handlers) {
        return (EventHandler<A>) Iterables.<EventHandler<? super A>>reduce(handlers, (first, second) -> (A event) -> first.handle(event).andThen(second.handle(event)));
    }

    static <A> EventHandler<A> reflective(final Object handler, final Class<A> eventClass) {
        Objects.requireNonNull(handler, "the handler is null");
        Objects.requireNonNull(eventClass, "the event type is null");

        return ReflectiveHandlerImpl.create(handler.getClass(), handler, eventClass);
    }

    static <A> EventHandler<A> reflective(final Class<?> handlerClass, final Class<A> eventClass) {
        Objects.requireNonNull(handlerClass, "the handler type is null");
        Objects.requireNonNull(eventClass, "the event type is null");

        return ReflectiveHandlerImpl.create(handlerClass, null, eventClass);
    }
}

final class ReflectiveHandlerImpl {
    private ReflectiveHandlerImpl() {}

    static <A> EventHandler<A> create(final Class<?> handlerClass, final Object handler, final Class<A> eventClass) {
        final boolean staticMode = handler == null;
        final List<EventHandler<A>> handlers = new ArrayList<>();
        final MethodHandles.Lookup lookup = MethodHandles.lookup();

        for (Method method : handlerClass.getDeclaredMethods()) {
            final HandleEvent annotation = method.getAnnotation(HandleEvent.class);
            if (annotation == null) continue;

            final boolean isStatic = Modifier.isStatic(method.getModifiers());
            if (isStatic != staticMode) continue;

            if (method.getParameterCount() != 1) {
                throw new IllegalArgumentException("Handler method " + method.getName() + " has the wrong amount of parameters! Excepted: 1, found: " + method.getParameterCount());
            }

            final boolean isValidType = method.getParameterTypes()[0].isAssignableFrom(eventClass);
            if (!isValidType) continue;

            final Class<?> returnType = method.getReturnType();
            if (returnType != void.class && returnType != IO.class) {
                throw new IllegalArgumentException("Handler method " + method.getName() + " needs to return void or IO instead of " + returnType + "!");
            }

            method.setAccessible(true);
            try {
                MethodHandle handle = lookup.unreflect(method);
                if (!staticMode) handle = handle.bindTo(handler);
                final MethodHandle effectivelyFinalHandle = handle;
                handlers.add(event -> IO.of((ThrowingRunnable) () -> {
                    final Object result = effectivelyFinalHandle.invoke(event);
                    if (result instanceof IO<?>) {
                        ((IO<?>) result).execute();
                    }
                }));
            } catch (IllegalAccessException e) {
                throw new IllegalStateException("Failed to convert Method instance to a handler", e);
            }
        }

        return EventHandler.composite(handlers);
    }
}

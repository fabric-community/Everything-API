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
import io.github.fabriccommunity.everything.api.age.MutableAgeDatabase;
import io.github.fabriccommunity.everything.api.age.MutableMapAgeDatabase;
import io.github.fabriccommunity.everything.api.elegant.iterable.Reduce;
import io.github.fabriccommunity.everything.api.elegant.scalar.ScalarOf;
import io.github.fabriccommunity.everything.api.functional.IO;
import org.cactoos.scalar.Ternary;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalLong;

/**
 * An event manager holds event handlers and dispatches events.
 *
 * @param <A> the event type
 */
public interface EventManager<A> {
    /**
     * Registers an event handler.
     *
     * @param handler the handler
     * @return the IO operation that says whether registration was successful
     */
    IO<Boolean> register(EventHandler<A> handler);

    /**
     * Gets the age of an event handler, or the time since it has been registered.
     *
     * @param handler the handler
     * @param eager   whether the age should be evaluated eagerly or lazily
     * @return the IO operation containing the age,
     * or empty if the handler has not been registered or this manager does not support ages
     */
    IO<OptionalLong> getAge(EventHandler<A> handler, boolean eager);

    /**
     * Registers an event handler predicate that checks
     * whether an event handler can be registered.
     *
     * @param predicate the predicate
     * @return the IO operation
     */
    IO<Unit> registerEventHandlerPredicate(EventHandlerPredicate<A> predicate);

    /**
     * Executes all registered handlers for an event.
     *
     * @param event the event
     * @return the IO operation
     */
    IO<Unit> execute(A event);

    /**
     * Creates a new event manager.
     *
     * <p>Instances created using this method have {@link EventHandlerPredicate#nonnull()} already registered.
     *
     * @param name the event name
     * @param <A>  the event type
     * @return the created manager
     */
    static <A> EventManager<A> create(final String name) {
        return new EventManager<A>() {
            private final List<EventHandler<A>> handlers = new ArrayList<>();
            private final List<EventHandlerPredicate<A>> handlerPredicates = new ArrayList<>();
            private final MutableAgeDatabase ages = new MutableMapAgeDatabase();

            {
                // Prevent registering null handlers
                handlerPredicates.add(EventHandlerPredicate.nonnull());
            }

            @Override
            public IO<Boolean> register(final EventHandler<A> handler) {
                final class ExecutionTrackingIO<A> implements IO<A> {
                    private final IO<A> io;
                    private boolean executed = false;

                    ExecutionTrackingIO(final IO<A> io) {
                        this.io = io;
                    }

                    @Override
                    public A execute() throws Exception {
                        executed = true;
                        return io.execute();
                    }

                    @Override
                    protected void finalize() throws Throwable {
                        super.finalize();
                        if (!executed) {
                            System.err.println("Registration for " + name + " has not been executed! This is probably a bug...");
                        }
                    }
                }

                final IO<IO<Boolean>> main = () -> {
                    final IO<Unit> addingHandler = () -> {
                        handlers.add(handler);
                        ages.recordBirthday(handler);
                        return Unit.INSTANCE;
                    };
                    final EventHandlerPredicate<A> registrationValidator =
                        new Reduce<EventHandlerPredicate<A>>(
                            (first, second) -> h -> first.test(h).merge(second.test(h), (a, b) -> a && b)
                        ).apply(handlerPredicates);

                    return registrationValidator.test(handler).flatMap(x -> x ? IO.pure(true).andThen(addingHandler) : IO.pure(false));
                };
                return new ExecutionTrackingIO<>(IO.flatten(main));
            }

            @Override
            public IO<Unit> registerEventHandlerPredicate(final EventHandlerPredicate<A> predicate) {
                return () -> {
                    handlerPredicates.add(predicate);
                    return Unit.INSTANCE;
                };
            }

            @Override
            public IO<OptionalLong> getAge(final EventHandler<A> handler, final boolean eager) {
                return eager ? IO.pure(ages.getAge(handler)) : () -> ages.getAge(handler);
            }

            @Override
            public IO<Unit> execute(final A input) {
                return IO.of(new Ternary<>(handlers::isEmpty, new ScalarOf<>(IO.empty()), new ScalarOf<>(IO.flatten(IO.flatten(() -> IO.fix(new Reduce<EventHandler<A>>((a, b) -> event -> a.handle(event).andThen(b.handle(event))).apply(handlers)::handle, input))))));
            }
        };
    }
}

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
import io.github.fabriccommunity.everything.api.elegant.iterable.Reduce;
import io.github.fabriccommunity.everything.api.elegant.scalar.ScalarOf;
import io.github.fabriccommunity.everything.api.elegant.scalar.Ternary;
import io.github.fabriccommunity.everything.api.functional.IO;

import java.util.ArrayList;
import java.util.List;

public interface EventManager<A> {
    IO<Unit> register(EventHandler<A> handler);

    IO<Unit> registerEventHandlerPredicate(EventHandlerPredicate<A> predicate);

    IO<Unit> execute(A event);

    static <A> EventManager<A> create() {
        return new EventManager<A>() {
            private final List<EventHandler<A>> handlers = new ArrayList<>();
            private final List<EventHandlerPredicate<A>> handlerPredicates = new ArrayList<>();

            {
                // Prevent registering null handlers
                handlerPredicates.add(EventHandlerPredicate.nonnull());
            }

            @Override
            public IO<Unit> register(final EventHandler<A> handler) {
                final IO<IO<Unit>> main = () -> {
                    final IO<Unit> addingHandler = () -> {
                        handlers.add(handler);
                        return Unit.INSTANCE;
                    };
                    final EventHandlerPredicate<A> registrationValidator =
                            new Reduce<EventHandlerPredicate<A>>(
                                    (first, second) -> h -> first.test(h).merge(second.test(h), (a, b) -> a && b)
                            ).apply(handlerPredicates);

                    return registrationValidator.test(handler).flatMap(x -> x ? addingHandler : IO.empty());
                };
                return main.let(IO::flatten);
            }

            @Override
            public IO<Unit> registerEventHandlerPredicate(final EventHandlerPredicate<A> predicate) {
                return () -> {
                    handlerPredicates.add(predicate);
                    return Unit.INSTANCE;
                };
            }

            @Override
            public IO<Unit> execute(final A input) {
                return () -> new Ternary<>(handlers::isEmpty, new ScalarOf<>(IO.empty()), new ScalarOf<>(IO.fix(new Reduce<EventHandler<A>>((a, b) -> event -> a.handle(event).andThen(b.handle(event))).apply(handlers)::handle, input).<IO<Unit>>let(IO::flatten))).value();
            }
        };
    }
}

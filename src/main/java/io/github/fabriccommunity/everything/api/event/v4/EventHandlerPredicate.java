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

import io.github.fabriccommunity.everything.api.functional.IO;

/**
 * Event handler predicates filter whether event handlers are allowed on a manager.
 *
 * @param <A> the event type
 */
@FunctionalInterface
public interface EventHandlerPredicate<A> {
    /**
     * Checks whether the handler should be accepted.
     *
     * @param handler the handler
     * @return an IO operation
     */
    IO<Boolean> test(EventHandler<A> handler);

    /**
     * Returns a predicate that rejects null event handlers.
     *
     * @param <A> the event type
     * @return the predicate
     */
    static <A> EventHandlerPredicate<A> nonnull() {
        return handler -> IO.pure(handler != null);
    }
}

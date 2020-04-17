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

package io.github.fabriccommunity.everything.api.elegant.iterable;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * An envelope for {@link Iterable}.
 *
 * @param <A> the value type
 */
public abstract class IterableEnvelope<A> implements Iterable<A> {
    private final Iterable<A> iterable;

    public IterableEnvelope(final Iterable<A> iterable) {
        this.iterable = iterable;
    }

    @Override
    public final Iterator<A> iterator() {
        return iterable.iterator();
    }

    @Override
    public final Spliterator<A> spliterator() {
        return iterable.spliterator();
    }

    @Override
    public final void forEach(final Consumer<? super A> action) {
        iterable.forEach(action);
    }
}

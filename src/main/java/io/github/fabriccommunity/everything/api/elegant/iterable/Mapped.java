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
import java.util.function.Function;

public final class Mapped<A, B> implements Iterable<B> {
    private final Iterable<? extends A> iterable;
    private final Function<? super A, ? extends B> transform;

    public Mapped(final Iterable<? extends A> iterable, final Function<? super A, ? extends B> transform) {
        this.iterable = iterable;
        this.transform = transform;
    }

    @Override
    public Iterator<B> iterator() {
        return new Iterator<B>() {
            private final Iterator<? extends A> iterator = iterable.iterator();

            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public B next() {
                return transform.apply(iterator.next());
            }
        };
    }
}

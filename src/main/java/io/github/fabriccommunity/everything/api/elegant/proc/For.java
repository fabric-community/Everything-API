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

package io.github.fabriccommunity.everything.api.elegant.proc;

/**
 * A for-loop on an Iterable.
 *
 * @param <A> the value type
 */
public final class For<A> implements Proc<Iterable<? extends A>> {
    private final Proc<? super A> proc;

    public For(final Proc<? super A> proc) {
        this.proc = proc;
    }

    @Override
    public void run(final Iterable<? extends A> input) throws Exception {
        for (A value : input) {
            proc.run(value);
        }
    }
}

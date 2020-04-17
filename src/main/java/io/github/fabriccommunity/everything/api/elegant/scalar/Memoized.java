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

package io.github.fabriccommunity.everything.api.elegant.scalar;

public final class Memoized<A> implements Scalar<A> {
    private final Scalar<A> scalar;
    private A value;
    private boolean initialized = false;

    public Memoized(final Scalar<A> scalar) {
        this.scalar = scalar;
    }

    @Override
    public A get() throws Exception {
        if (!initialized) {
            value = scalar.get();
            initialized = true;
        }

        return value;
    }
}

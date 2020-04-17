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

package io.github.fabriccommunity.everything.api.elegant.scalar.bool;

import io.github.fabriccommunity.everything.api.elegant.iterable.IterableOf;
import io.github.fabriccommunity.everything.api.elegant.iterable.Mapped;
import io.github.fabriccommunity.everything.api.elegant.scalar.Scalar;

public final class Or implements Scalar<Boolean> {
    private final Iterable<Scalar<Boolean>> iterable;

    public Or(final Scalar<Boolean>... scalars) {
        this(new IterableOf<>(scalars));
    }

    public Or(final Boolean... booleans) {
        this(new Mapped<>(new IterableOf<>(booleans), bool -> () -> bool));
    }

    public Or(final Iterable<Scalar<Boolean>> iterable) {
        this.iterable = iterable;
    }

    @Override
    public Boolean get() throws Exception {
        for (Scalar<Boolean> scalar : iterable) {
            if (scalar.get()) {
                return true;
            }
        }

        return false;
    }
}

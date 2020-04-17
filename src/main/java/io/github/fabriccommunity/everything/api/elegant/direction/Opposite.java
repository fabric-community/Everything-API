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

package io.github.fabriccommunity.everything.api.elegant.direction;

import net.minecraft.util.math.Direction;
import org.cactoos.Scalar;

public final class Opposite implements Scalar<Direction> {
    private final Scalar<Direction> direction;

    public Opposite(final Direction direction) {
        this(() -> direction);
    }

    public Opposite(final Scalar<Direction> direction) {
        this.direction = direction;
    }

    @Override
    public Direction value() throws Exception {
        return direction.value().getOpposite();
    }
}

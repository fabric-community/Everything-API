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

package io.github.fabriccommunity.everything.api.elegant.position;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import org.cactoos.Scalar;
import org.cactoos.scalar.Unchecked;

public final class Offset extends BlockPos {
    public Offset(final Scalar<BlockPos> pos, final Scalar<Direction> direction, final Scalar<Integer> amount) {
        this(pos, direction, new Unchecked<>(amount).value());
    }

    public Offset(final Scalar<BlockPos> pos, final Scalar<Direction> direction, final int amount) {
        this(new Unchecked<>(pos).value(), new Unchecked<>(direction).value(), amount);
    }

    public Offset(final BlockPos pos, final Direction direction, final int amount) {
        this(
            pos.getX() + direction.getOffsetX() * amount,
            pos.getY() + direction.getOffsetY() * amount,
            pos.getZ() + direction.getOffsetZ() * amount
        );
    }

    private Offset(final int x, final int y, final int z) {
        super(x, y, z);
    }
}

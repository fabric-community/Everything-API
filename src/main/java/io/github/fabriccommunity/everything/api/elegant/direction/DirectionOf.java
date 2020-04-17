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

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.Direction;
import org.cactoos.Scalar;

public final class DirectionOf implements Scalar<Direction> {
    private final Scalar<Direction> scalar;

    public DirectionOf(final BlockHitResult hit) {
        this(hit::getSide);
    }

    public DirectionOf(final PlayerEntity player) {
        this(player::getHorizontalFacing);
    }

    private DirectionOf(final Scalar<Direction> scalar) {
        this.scalar = scalar;
    }

    @Override
    public Direction value() throws Exception {
        return scalar.value();
    }
}

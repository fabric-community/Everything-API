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

package io.github.fabriccommunity.everything.api.elegant.world;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.cactoos.Proc;
import org.cactoos.Scalar;

public final class SetBlockState implements Proc<World> {
    private final Scalar<BlockPos> pos;
    private final Scalar<BlockState> state;

    public SetBlockState(BlockPos pos, Scalar<BlockState> state) {
        this(() -> pos, state);
    }

    public SetBlockState(Scalar<BlockPos> pos, BlockState state) {
        this(pos, () -> state);
    }

    public SetBlockState(Scalar<BlockPos> pos, Scalar<BlockState> state) {
        this.pos = pos;
        this.state = state;
    }

    @Override
    public void exec(World input) throws Exception {
        input.setBlockState(pos.value(), state.value());
    }
}

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

package io.github.fabriccommunity.everything.api.event.v4.events;

import io.github.fabriccommunity.everything.api.event.v4.AbstractVetoableEvent;
import io.github.fabriccommunity.everything.api.event.v4.EventManager;
import net.minecraft.block.BlockState;
import net.minecraft.fluid.FluidState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public final class RemoveBlockEvent extends AbstractVetoableEvent {
    public static final EventManager<RemoveBlockEvent> MANAGER = EventManager.create();

    private final World world;
    private final BlockPos pos;
    private final boolean move;
    private final FluidState fluidState;
    private final BlockState blockState;

    public RemoveBlockEvent(final World world, final BlockPos pos, final boolean move, final FluidState fluidState) {
        this.world = world;
        this.pos = pos;
        this.move = move;
        this.fluidState = fluidState;
        this.blockState = world.getBlockState(pos);
    }

    public World getWorld() {
        return world;
    }

    public BlockPos getPos() {
        return pos;
    }

    public boolean isMove() {
        return move;
    }

    public FluidState getFluidState() {
        return fluidState;
    }

    public BlockState getBlockState() {
        return blockState;
    }
}

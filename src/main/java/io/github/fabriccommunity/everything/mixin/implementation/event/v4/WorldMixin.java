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

package io.github.fabriccommunity.everything.mixin.implementation.event.v4;

import io.github.fabriccommunity.everything.api.elegant.scalar.ScalarOf;
import io.github.fabriccommunity.everything.api.event.v4.events.RemoveBlockEvent;
import io.github.fabriccommunity.everything.api.functional.IO;
import net.minecraft.fluid.FluidState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import org.cactoos.scalar.Ternary;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(World.class)
abstract class WorldMixin implements IWorld {
    @Inject(method = "removeBlock", at = @At(value = "INVOKE_ASSIGN", target = "Lnet/minecraft/world/World;getFluidState(Lnet/minecraft/util/math/BlockPos;)Lnet/minecraft/fluid/FluidState;"), cancellable = true, locals = LocalCapture.CAPTURE_FAILHARD)
    private void onRemoveBlock(BlockPos pos, boolean move, CallbackInfoReturnable<Boolean> info, FluidState fluidState) {
        final RemoveBlockEvent event = new RemoveBlockEvent((World) (Object) this, pos, move, fluidState);
        IO.executeUnsafe(RemoveBlockEvent.MANAGER.execute(event).andThen(IO.of(new Ternary<>(new ScalarOf<>(event.isVetoed()), new ScalarOf<>(IO.of(() -> info.setReturnValue(false))), new ScalarOf<>(IO.empty())))));
    }
}

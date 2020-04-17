package io.github.fabriccommunity.everything.mixin.implementation.level;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import io.github.fabriccommunity.everything.api.event.level.SetBlockEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(World.class)
public class SetBlockEventMixin {

    private final ThreadLocal<SetBlockEvent.Data.Mutable> currentData = new ThreadLocal<>();

    @Inject(
            method = "setBlockState(Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/BlockState;I)Z",
            at = @At("HEAD"),
            cancellable = true
    )
    private void setBlockStateBegin(BlockPos pos, BlockState state, int flags, CallbackInfoReturnable<Boolean> cir) {
        SetBlockEvent.Data.Mutable data = SetBlockEvent.handlePre((World) (Object) this, pos, state, flags);
        if (data.isCancelled()) {
            SetBlockEvent.handlePost(data, false);
            cir.setReturnValue(false);
        } else {
            currentData.set(data);
        }
    }

    @Inject(
            method = "setBlockState(Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/BlockState;I)Z",
            at = @At("RETURN")
    )
    private void setBlockStateEnd(BlockPos pos, BlockState state, int flags, CallbackInfoReturnable<Boolean> cir) {
        SetBlockEvent.Data.Mutable data = currentData.get();
        currentData.remove();
        if (data != null) {
            SetBlockEvent.handlePost(data, cir.getReturnValueZ());
        }
    }

}

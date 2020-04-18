package io.github.fabriccommunity.everything.mixin.implementation.event.v4.client;

import com.mojang.datafixers.util.Unit;
import io.github.fabriccommunity.everything.api.elegant.scalar.ScalarOf;
import io.github.fabriccommunity.everything.api.event.v4.events.RemoveBlockEvent;
import io.github.fabriccommunity.everything.api.functional.IO;
import net.minecraft.block.BlockState;
import net.minecraft.client.network.ClientPlayerInteractionManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.cactoos.scalar.Ternary;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(ClientPlayerInteractionManager.class)
abstract class ClientPlayerInteractionManagerMixin {
    @Inject(method = "breakBlock", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;onBreak(Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/BlockState;Lnet/minecraft/entity/player/PlayerEntity;)V"), cancellable = true, locals = LocalCapture.CAPTURE_FAILHARD)
    private void onBreakBlock(final BlockPos pos, final CallbackInfoReturnable<Boolean> info, final World world, final BlockState state) {
        final RemoveBlockEvent event = new RemoveBlockEvent(world, pos, false, world.getFluidState(pos));
        IO.executeUnsafe(RemoveBlockEvent.MANAGER.execute(event).andThen(IO.of(new Ternary<>(new ScalarOf<>(event.isVetoed()), new ScalarOf<>(IO.of(() -> info.setReturnValue(false))), new ScalarOf<>(IO.empty())))));
    }
}

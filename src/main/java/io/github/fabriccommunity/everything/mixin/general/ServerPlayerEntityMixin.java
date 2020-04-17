package io.github.fabriccommunity.everything.mixin.general;

import com.mojang.authlib.GameProfile;
import io.github.fabriccommunity.everything.api.elegant.scalar.ScalarOf;
import io.github.fabriccommunity.everything.api.elegant.scalar.Ternary;
import io.github.fabriccommunity.everything.api.event.juuz.events.OpenMenuEvent;
import io.github.fabriccommunity.everything.api.functional.IO;
import net.minecraft.container.NameableContainerFactory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.OptionalInt;

@Mixin(ServerPlayerEntity.class)
abstract class ServerPlayerEntityMixin extends PlayerEntity {
    @Shadow
    private int containerSyncId;

    private ServerPlayerEntityMixin(World world, GameProfile profile) {
        super(world, profile);
    }

    @Inject(method = "openContainer(Lnet/minecraft/container/NameableContainerFactory;)Ljava/util/OptionalInt;", at = @At(value = "INVOKE", target = "Lnet/minecraft/server/network/ServerPlayNetworkHandler;sendPacket(Lnet/minecraft/network/Packet;)V"), cancellable = true)
    private void onOpenContainer(NameableContainerFactory factory, CallbackInfoReturnable<OptionalInt> info) {
        OpenMenuEvent event = new OpenMenuEvent(container, containerSyncId, factory.getDisplayName(), (ServerPlayerEntity) (Object) this);
        IO.executeUnsafe(OpenMenuEvent.MANAGER.execute(event).andThen(new Ternary<>(new ScalarOf<>(event.isVetoed()), new ScalarOf<>(IO.of(() -> {
            container = playerContainer;
            info.setReturnValue(OptionalInt.empty());
        })), new ScalarOf<>(IO.empty())).let(IO::of)));
    }
}

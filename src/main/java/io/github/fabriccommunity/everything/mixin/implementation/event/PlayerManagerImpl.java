package io.github.fabriccommunity.everything.mixin.implementation.event;

import io.github.fabriccommunity.everything.api.event.Events;
import io.github.fabriccommunity.everything.api.event.implementation.ServerEvents;
import net.minecraft.network.ClientConnection;
import net.minecraft.server.PlayerManager;
import net.minecraft.server.network.ServerPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerManager.class)
public class PlayerManagerImpl {
	@Inject(at = @At("HEAD"), method = "Lnet/minecraft/server/PlayerManager;onPlayerConnect(Lnet/minecraft/network/ClientConnection;Lnet/minecraft/server/network/ServerPlayerEntity;)V")
	void onConnect(ClientConnection connection, ServerPlayerEntity player, CallbackInfo ci) {
		if (Events.retrieveEventListeners(ServerEvents.ON_PLAYER_CONNECT.staticId()) == null) return;

		Events.retrieveEventListeners(ServerEvents.ON_PLAYER_CONNECT.staticId()).forEach(event -> {
			((ServerEvents.ON_PLAYER_CONNECT) event).accept(connection, player);
		});
	}
}

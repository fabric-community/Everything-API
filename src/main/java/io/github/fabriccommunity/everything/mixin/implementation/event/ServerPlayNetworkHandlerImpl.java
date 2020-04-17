package io.github.fabriccommunity.everything.mixin.implementation.event;

import io.github.fabriccommunity.everything.api.event.Events;
import io.github.fabriccommunity.everything.api.event.implementation.ServerEvents;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerPlayNetworkHandler.class)
public class ServerPlayNetworkHandlerImpl {
	@Inject(at = @At("HEAD"), method = "Lnet/minecraft/server/network/ServerPlayNetworkHandler;onDisconnected(Lnet/minecraft/text/Text;)V")
	void onDisconnect(Text reason, CallbackInfo callbackInformation) {
		if (Events.retrieveEventListeners(ServerEvents.ON_PLAYER_DISCONNECT.staticId()) == null) return;

		Events.retrieveEventListeners(ServerEvents.ON_PLAYER_DISCONNECT.staticId()).forEach(event -> {
			((ServerEvents.ON_PLAYER_DISCONNECT) event).accept(reason);
		});
	}
}

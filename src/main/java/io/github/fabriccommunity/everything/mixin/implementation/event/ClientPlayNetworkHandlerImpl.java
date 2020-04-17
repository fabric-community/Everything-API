package io.github.fabriccommunity.everything.mixin.implementation.event;

import io.github.fabriccommunity.everything.api.event.implementation.ClientEvents;
import io.github.fabriccommunity.everything.api.event.Events;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.packet.s2c.play.GameJoinS2CPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayNetworkHandler.class)
public class ClientPlayNetworkHandlerImpl {

	@Inject(at = @At("HEAD"), method = "onGameJoin(Lnet/minecraft/network/packet/s2c/play/GameJoinS2CPacket;)V")
	void onConnect(GameJoinS2CPacket packet, CallbackInfo callbackInformation) {
		if (Events.retrieveEventListeners(ClientEvents.ON_SERVER_CONNECT.staticId()) == null) return;

		Events.retrieveEventListeners(ClientEvents.ON_SERVER_CONNECT.staticId()).forEach(event -> {
			((ClientEvents.ON_SERVER_CONNECT) event).accept(packet);
		});
	}
}

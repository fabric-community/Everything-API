package io.github.fabriccommunity.everything.mixin.implementation.event;

import io.github.fabriccommunity.everything.api.event.vini.Events;
import io.github.fabriccommunity.everything.api.event.vini.implementation.ClientEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public class MinecraftClientImpl {
	@Inject(at = @At("HEAD"), method = "disconnect(Lnet/minecraft/client/gui/screen/Screen;)V")
	private void onDisconnct(Screen screen, CallbackInfo callbackInformation) {
		if (Events.retrieveEventListeners(ClientEvents.ON_SERVER_DISCONNECT.staticId()) == null) return;

		Events.retrieveEventListeners(ClientEvents.ON_SERVER_DISCONNECT.staticId()).forEach(event -> {
			((ClientEvents.ON_SERVER_DISCONNECT) event).accept(screen);
		});
	}
}

package io.github.fabriccommunity.everything.mixin.implementation.event;

import io.github.fabriccommunity.everything.api.event.Events;
import io.github.fabriccommunity.everything.api.event.implementation.ServerEvents;
import net.minecraft.server.MinecraftServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftServer.class)
public class ServerMainImpl {
	@Inject(at = @At("HEAD"), cancellable = true, method = "main([Ljava/lang/String;)V")
	static void onMain(String[] arguments, CallbackInfo callbackInformation) {
		if (Events.retrieveEventListeners(ServerEvents.MAIN.staticId()) == null) return;

		Events.retrieveEventListeners(ServerEvents.MAIN.staticId()).forEach(event -> {
			if (((ServerEvents.MAIN) event).accept(arguments)) callbackInformation.cancel();
		});
	}
}

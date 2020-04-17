package io.github.fabriccommunity.everything.mixin.implementation.event.v3;

import io.github.fabriccommunity.everything.api.event.v3.Events;
import io.github.fabriccommunity.everything.api.event.v3.implementation.ClientEvents;
import net.minecraft.client.main.Main;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Main.class)
public class ClientMainImpl {
	@Inject(at = @At("HEAD"), cancellable = true, method = "Lnet/minecraft/client/main/Main;main([Ljava/lang/String;)V")
	private static void onMain(String[] arguments, CallbackInfo callbackInformation) {
		if (Events.retrieveEventListeners(ClientEvents.MAIN.staticId()) == null) return;

		Events.retrieveEventListeners(ClientEvents.MAIN.staticId()).forEach(event -> {
			if (((ClientEvents.MAIN) event).accept(arguments)) callbackInformation.cancel();
		});
	}
}

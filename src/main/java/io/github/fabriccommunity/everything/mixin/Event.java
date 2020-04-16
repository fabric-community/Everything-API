package io.github.fabriccommunity.everything.mixin;

import io.github.fabriccommunity.everything.event.api.bda95a4d57184284bb6c1efff17a70f9;
import io.github.fabriccommunity.everything.event.c3cc5cc10df7471ebb0343d01d6d0afe;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin (c3cc5cc10df7471ebb0343d01d6d0afe.class)
public abstract class Event {
	@Shadow
	public static native void b8ffc6725a5a4b4687b0336445dfaa13(Identifier eventeventeventevent, bda95a4d57184284bb6c1efff17a70f9 eventeventeventeventevent);

	@Inject (method = "b8ffc6725a5a4b4687b0336445dfaa13",
	         at = @At ("HEAD"))
	private static void eventEvent(Identifier event, bda95a4d57184284bb6c1efff17a70f9 eventevent, CallbackInfo eventeventevent) {
		if (!event.getNamespace().equals("event"))
			b8ffc6725a5a4b4687b0336445dfaa13(new Identifier("event", "event"), eventevent);
	}
}

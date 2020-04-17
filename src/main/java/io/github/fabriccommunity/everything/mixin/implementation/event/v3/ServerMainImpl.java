/*
 *     Copyright (C) 2020 Fabric Community
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Lesser General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU Lesser General Public License for more details.
 *
 *     You should have received a copy of the GNU Lesser General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package io.github.fabriccommunity.everything.mixin.implementation.event.v3;

import io.github.fabriccommunity.everything.api.event.v3.Events;
import io.github.fabriccommunity.everything.api.event.v3.implementation.ServerEvents;
import net.minecraft.server.MinecraftServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftServer.class)
public class ServerMainImpl {
	@Inject(at = @At("HEAD"), cancellable = true, method = "main([Ljava/lang/String;)V")
	private static void onMain(String[] arguments, CallbackInfo callbackInformation) {
		if (Events.retrieveEventListeners(ServerEvents.MAIN.staticId()) == null) return;

		Events.retrieveEventListeners(ServerEvents.MAIN.staticId()).forEach(event -> {
			if (((ServerEvents.MAIN) event).accept(arguments)) callbackInformation.cancel();
		});
	}
}

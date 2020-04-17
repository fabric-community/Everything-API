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

package io.github.fabriccommunity.everything.mixin.general;


import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin (Registry.class)
public class RegistryMixin {
	@Shadow @Final protected static Logger LOGGER;
	private static Identifier copperOre;

	@Inject (method = "register(Lnet/minecraft/util/registry/Registry;Lnet/minecraft/util/Identifier;Ljava/lang/Object;)Ljava/lang/Object;",
	         at = @At ("HEAD"))
	private static <T> void register(Registry<? super T> registry, Identifier id, T entry, CallbackInfoReturnable<T> cir) {
		if (id.getPath().contains("copper") && id.getPath().contains("ore")) {
			if (entry instanceof Item || entry instanceof Block) {
				if (copperOre != null) {
					LOGGER.warn("fuck you " + id.getNamespace() + " today we're using " + id);
					cir.setReturnValue((T) registry.get(copperOre));
				} else copperOre = id;
			}
		}
	}
}


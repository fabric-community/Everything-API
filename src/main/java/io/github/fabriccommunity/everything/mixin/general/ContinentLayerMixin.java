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

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import io.github.fabriccommunity.everything.api.event.shuttle.biome.BiomeEvents;
import io.github.fabriccommunity.everything.api.event.shuttle.biome.BiomeEvents.OverworldContinentLayerContext;
import io.github.fabriccommunity.everything.api.event.shuttle.biome.OceanLand;
import net.minecraft.world.biome.layer.ContinentLayer;
import net.minecraft.world.biome.layer.util.LayerRandomnessSource;

@Mixin(ContinentLayer.class)
public class ContinentLayerMixin {
	@Inject(at = @At("RETURN"), method = "sample", cancellable = true)
	private void sample(LayerRandomnessSource random, int x, int z, CallbackInfoReturnable<Integer> info) {
		OverworldContinentLayerContext context = new OverworldContinentLayerContext(
				info.getReturnValueI(),
				x,
				z,
				random);

		BiomeEvents.CONTINENT_LAYER.postEvent(context);

		if (context.isResultModified()) {
			info.setReturnValue(context.getCurrentResult() == OceanLand.LAND ? 1 : 0);
		}
	}
}

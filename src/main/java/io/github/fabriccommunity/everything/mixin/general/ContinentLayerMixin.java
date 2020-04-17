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

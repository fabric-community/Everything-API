package io.github.fabriccommunity.everything.mixin.general;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import io.github.fabriccommunity.everything.api.event.shuttle.biome.BiomeEvents;
import io.github.fabriccommunity.everything.api.event.shuttle.biome.BiomeEvents.OverworldBaseBiomesLayerContext;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.layer.SetBaseBiomesLayer;
import net.minecraft.world.biome.layer.util.LayerRandomnessSource;

@Mixin(SetBaseBiomesLayer.class)
public class SetBaseBiomesLayerMixin {
	@Inject(at = @At("RETURN"), method = "sample", cancellable = true)
	private void sample(LayerRandomnessSource random, int value, CallbackInfoReturnable<Integer> info) {
		OverworldBaseBiomesLayerContext context = new OverworldBaseBiomesLayerContext(
				info.getReturnValueI(),
				value & -3841,
				random);

		BiomeEvents.BASE_BIOMES_LAYER.postEvent(context);

		if (context.isResultModified()) {
			info.setReturnValue(Registry.BIOME.getRawId(context.getCurrentResult()));
		}
	}
}

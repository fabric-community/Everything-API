package io.github.fabriccommunity.everything.mixin.general;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import io.github.fabriccommunity.everything.api.event.shuttle.biome.BiomeEvents;
import io.github.fabriccommunity.everything.api.event.shuttle.biome.BiomeEvents.OverworldBiomePlacementContext;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.VanillaLayeredBiomeSource;

@Mixin(VanillaLayeredBiomeSource.class)
public class VanillaLayeredBiomeSourceMixin {
	@Inject(at = @At("RETURN"), method = "getBiomeForNoiseGen", cancellable = true)
	private void getBiomeForNoiseGen(int biomeX, int biomeY, int biomeZ, CallbackInfoReturnable<Biome> info) {
		Biome original = info.getReturnValue();
		OverworldBiomePlacementContext context = new OverworldBiomePlacementContext(original, biomeX, biomeZ);
		BiomeEvents.OVERWORLD_BIOME_PLACEMENT.postEvent(context);

		if (context.isResultModified()) {
			info.setReturnValue(context.getCurrentBiome());
		}
	}
}

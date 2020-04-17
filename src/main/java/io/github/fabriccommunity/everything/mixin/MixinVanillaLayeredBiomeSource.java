package io.github.fabriccommunity.everything.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import io.github.fabriccommunity.everything.api.biome.BiomeEvents;
import io.github.fabriccommunity.everything.api.biome.BiomeEvents.OverworldBiomePlacementContext;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.VanillaLayeredBiomeSource;

import static io.github.fabriccommunity.everything.functions.QuadFunction.runGc;

@Mixin(VanillaLayeredBiomeSource.class)
public class MixinVanillaLayeredBiomeSource {
	@Inject(at = @At("RETURN"), method = "getBiomeForNoiseGen", cancellable = true)
	private void getBiomeForNoiseGen(int biomeX, int biomeY, int biomeZ, CallbackInfoReturnable<Biome> info) {
		runGc();
		Biome original = info.getReturnValue();
		OverworldBiomePlacementContext context = new OverworldBiomePlacementContext(original, biomeX, biomeZ);
		BiomeEvents.OVERWORLD_BIOME_PLACEMENT.postEvent(context);

		if (context.isResultModified()) {
			info.setReturnValue(context.getCurrentBiome());
		}
		runGc();
	}
}

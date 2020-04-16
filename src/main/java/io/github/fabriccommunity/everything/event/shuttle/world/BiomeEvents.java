package io.github.fabriccommunity.everything.event.shuttle.world;

import io.github.fabriccommunity.everything.event.shuttle.EventResult;
import io.github.fabriccommunity.everything.event.shuttle.ShuttleEventContext;
import io.github.fabriccommunity.everything.event.shuttle.ShuttleEventListener;
import io.github.fabriccommunity.everything.event.shuttle.ShuttleEventRegistry;
import io.github.fabriccommunity.everything.event.shuttle.ShuttleEventTracker;
import net.minecraft.world.biome.Biome;

public final class BiomeEvents {
	private BiomeEvents() {
		// NO-OP
	}

	public static interface OverworldBiomeGenEvent extends ShuttleEventListener {
		/**
		 * called on biome placement in the overworld.
		 * @param context the context of the biome placement
		 * @return {@link EventResult#FAIL} to instantly fail and return the vanilla biome to generate, {@link EventResult#SUCCESS} to instantly succeed and overwrite the biome, {@link EventResult#PASS} to pass on to further calculation.
		 */
		EventResult onBiomePlace(OverworldBiomePlacementContext context);
	}

	public static class OverworldBiomePlacementContext implements ShuttleEventContext<OverworldBiomeGenEvent> {
		public OverworldBiomePlacementContext(Biome originalBiome, int biomeGenX, int biomeGenZ) {
			this.originalBiome = originalBiome;
			this.currentBiome = originalBiome;
			this.bgx = biomeGenX;
			this.bgz = biomeGenZ;
		}

		private final Biome originalBiome;
		private final int bgx, bgz;
		private Biome currentBiome;
		private boolean override = false;

		public Biome getOriginalBiome() {
			return this.originalBiome;
		}

		public Biome getCurrentBiome() {
			return this.currentBiome;
		}

		public void setBiome(Biome biome) {
			this.override = true;
			this.currentBiome = biome;
		}

		public boolean isBiomeOverwritten() {
			return this.override;
		}

		public int getGenX() {
			return this.bgx;
		}

		public int getGenZ() {
			return this.bgz;
		}

		public int getBlockX() {
			return this.bgx << 2;
		}

		public int getBlockZ() {
			return this.bgz << 2;
		}

		@Override
		public void notifyEvent(int item) {
			this.override = item == 1;
		}
	}

	public static final ShuttleEventTracker<OverworldBiomeGenEvent, OverworldBiomePlacementContext> OVERWORLD_BIOME_PLACEMENT =
			ShuttleEventRegistry.registerEventTracker(ShuttleEventTracker.of(
					OverworldBiomeGenEvent.class,
					OverworldBiomePlacementContext.class,
					(context, listeners) -> {
						for (OverworldBiomeGenEvent listener : listeners) {
							EventResult result = listener.onBiomePlace(context);

							if (result == EventResult.FAIL) {
								context.notifyEvent(0);
								break;
							} else if (result == EventResult.SUCCESS) {
								context.notifyEvent(1);
								break;
							}
						}
					}
					));
}

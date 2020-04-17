package io.github.fabriccommunity.everything.api.biome;

import io.github.fabriccommunity.everything.api.event.shuttle.EventResult;
import io.github.fabriccommunity.everything.api.event.shuttle.ShuttleEventContext;
import io.github.fabriccommunity.everything.api.event.shuttle.ShuttleEventListener;
import io.github.fabriccommunity.everything.api.event.shuttle.ShuttleEventRegistry;
import io.github.fabriccommunity.everything.api.event.shuttle.ShuttleEventTracker;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.layer.util.LayerRandomnessSource;

public final class BiomeEvents {
	private BiomeEvents() {
		// NO-OP
	}

	public static interface OverworldBiomePlacementEvent extends ShuttleEventListener {
		/**
		 * called on biome placement in the overworld.
		 * @param context the context of the biome placement
		 * @return {@link EventResult#FAIL} to instantly fail and return the vanilla biome to generate, {@link EventResult#SUCCESS} to instantly succeed and overwrite the biome, {@link EventResult#PASS} to pass on to further calculation.
		 */
		EventResult onBiomePlace(OverworldBiomePlacementContext context);
	}

	public static interface OverworldContinentLayerEvent extends ShuttleEventListener {
		EventResult onContinentGen(OverworldContinentLayerContext context);
	}

	public static interface OverworldBaseBiomesLayerEvent extends ShuttleEventListener {
		EventResult onBaseBiomeGen(OverworldBaseBiomesLayerContext context);
	}

	public static class OverworldBiomePlacementContext implements ShuttleEventContext<OverworldBiomePlacementEvent> {
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

		public boolean isResultModified() {
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

	public static class OverworldContinentLayerContext implements ShuttleEventContext<OverworldContinentLayerEvent> {
		public OverworldContinentLayerContext(int original, int x, int z, LayerRandomnessSource random) {
			this.random = random;
			this.original = original == 0 ? OceanLand.OCEAN: OceanLand.LAND;
			this.modified = this.original;
			this.x = x;
			this.z = z;
		}

		private final LayerRandomnessSource random;
		private final OceanLand original;
		private final int x, z;
		private OceanLand modified;
		private boolean override = false;

		public int nextInt(int bound) {
			return this.random.nextInt(bound);
		}

		public boolean oneInNChance(int n) {
			return this.random.nextInt(n) == 0;
		}

		public OceanLand getOriginalResult() {
			return this.original;
		}

		public boolean isResultModified() {
			return this.override;
		}

		public OceanLand getCurrentResult() {
			return this.modified;
		}

		public void setResult(OceanLand result) {
			this.override = true;
			this.modified = result;
		}

		public int getLayerX() {
			return this.x;
		}

		public int getLayerZ() {
			return this.z;
		}

		@Override
		public void notifyEvent(int item) {
			this.override = item == 1;
		}
	}

	public static class OverworldBaseBiomesLayerContext implements ShuttleEventContext<OverworldBaseBiomesLayerEvent> {
		public OverworldBaseBiomesLayerContext(int original, int climate, LayerRandomnessSource random) {
			this.random = random;
			this.original = Registry.BIOME.get(original);
			this.modified = this.original;
			this.climate = climate;
		}

		private final LayerRandomnessSource random;
		private final Biome original;
		private final int climate;
		private Biome modified;
		private boolean override = false;

		public int nextInt(int bound) {
			return this.random.nextInt(bound);
		}

		public boolean oneInNChance(int n) {
			return this.random.nextInt(n) == 0;
		}

		public Biome getOriginalResult() {
			return this.original;
		}

		public int getClimate() {
			return this.climate;
		}

		public boolean isResultModified() {
			return this.override;
		}

		public Biome getCurrentResult() {
			return this.modified;
		}

		public void setResult(Biome result) {
			this.override = true;
			this.modified = result;
		}

		@Override
		public void notifyEvent(int item) {
			this.override = item == 1;
		}
	}

	public static final ShuttleEventTracker<OverworldBiomePlacementEvent, OverworldBiomePlacementContext> OVERWORLD_BIOME_PLACEMENT =
			ShuttleEventRegistry.registerEventTracker(ShuttleEventTracker.of(
					OverworldBiomePlacementEvent.class,
					OverworldBiomePlacementContext.class,
					(context, listeners) -> {
						for (OverworldBiomePlacementEvent listener : listeners) {
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

	public static final ShuttleEventTracker<OverworldContinentLayerEvent, OverworldContinentLayerContext> CONTINENT_LAYER =
			ShuttleEventRegistry.registerEventTracker(ShuttleEventTracker.of(
					OverworldContinentLayerEvent.class,
					OverworldContinentLayerContext.class,
					(context, listeners) -> {
						for (OverworldContinentLayerEvent listener : listeners) {
							EventResult result = listener.onContinentGen(context);

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

	public static final ShuttleEventTracker<OverworldBaseBiomesLayerEvent, OverworldBaseBiomesLayerContext> BASE_BIOMES_LAYER =
			ShuttleEventRegistry.registerEventTracker(ShuttleEventTracker.of(
					OverworldBaseBiomesLayerEvent.class,
					OverworldBaseBiomesLayerContext.class,
					(context, listeners) -> {
						for (OverworldBaseBiomesLayerEvent listener : listeners) {
							EventResult result = listener.onBaseBiomeGen(context);

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

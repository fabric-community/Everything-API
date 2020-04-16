package io.github.fabriccommunity.everything;

import com.mojang.datafixers.util.Unit;
import io.github.fabriccommunity.everything.api.functional.FunctionalModInitializer;
import io.github.fabriccommunity.everything.api.functional.IO;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.function.Function;

public class ExampleMod implements ModInitializer {
	private static final Logger LOGGER = LogManager.getLogger("Everything-API");

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		System.out.println("Hello Fabric world!");

		LOGGER.info("Executing functional initializers.");
		IO.executeUnsafe(runInitializers("everything-api/functional/common", FunctionalModInitializer::onInitialize, FunctionalModInitializer.class));
	}

	static <A> IO<Unit> runInitializers(String id, Function<A, IO<Unit>> stepGetter, Class<A> clazz) {
		return () -> {
			final FabricLoader loader = FabricLoader.getInstance();
			final List<A> initializers = loader.getEntrypoints(id, clazz);

			for (A initializer : initializers) {
				final IO<Unit> step;

				try {
					step = stepGetter.apply(initializer);
				} catch (Exception e) {
					throw new RuntimeException("Could not initialize entrypoint " + initializer + "!", e);
				}

				step.execute();
			}

			return Unit.INSTANCE;
		};
	}
}

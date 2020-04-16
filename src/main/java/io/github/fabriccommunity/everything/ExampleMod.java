package io.github.fabriccommunity.everything;

import com.mojang.datafixers.util.Unit;
import io.github.fabriccommunity.everything.api.frame.unit_testing.TestFrames;
import io.github.fabriccommunity.everything.api.functional.FunctionalModInitializer;
import io.github.fabriccommunity.everything.api.functional.IO;
import io.github.fabriccommunity.everything.unsafe.UnsafeUtil;
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
		a51cd4448b2346938cf395dcb2cf3229.c441f7b88bb04e7a9d4d13b75703fcea();

		System.out.println("Hello Fabric world!");
		try {
			UnsafeUtil.initialize();
		} catch (Exception e) {
			// no need!
		}

		LOGGER.info("Executing functional initializers.");
		IO.executeUnsafe(runInitializers("everything-api/functional/common", FunctionalModInitializer::onInitialize, FunctionalModInitializer.class));
		TestFrames.testOrFuck();
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

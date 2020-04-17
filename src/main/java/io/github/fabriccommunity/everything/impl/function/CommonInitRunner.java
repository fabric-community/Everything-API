package io.github.fabriccommunity.everything.impl.function;

import com.mojang.datafixers.util.Unit;
import io.github.fabriccommunity.everything.api.functional.FunctionalModInitializer;
import io.github.fabriccommunity.everything.api.functional.IO;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;

import java.util.List;
import java.util.function.Function;

public final class CommonInitRunner implements ModInitializer {
    @Override
    public void onInitialize() {
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

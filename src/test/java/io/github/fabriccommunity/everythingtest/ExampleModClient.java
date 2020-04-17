package io.github.fabriccommunity.everythingtest;

import io.github.fabriccommunity.everything.api.functional.FunctionalModInitializer;
import io.github.fabriccommunity.everything.api.functional.IO;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public final class ExampleModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        IO.executeUnsafe(ExampleMod.runInitializers("everything-api/functional/client", FunctionalModInitializer.ClientOnly::onInitializeClient, FunctionalModInitializer.ClientOnly.class));
    }
}

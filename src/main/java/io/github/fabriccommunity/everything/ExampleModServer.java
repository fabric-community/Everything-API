package io.github.fabriccommunity.everything;

import io.github.fabriccommunity.everything.api.functional.FunctionalModInitializer;
import io.github.fabriccommunity.everything.api.functional.IO;
import net.fabricmc.api.DedicatedServerModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.SERVER)
public final class ExampleModServer implements DedicatedServerModInitializer {
    @Override
    public void onInitializeServer() {
        IO.executeUnsafe(ExampleMod.runInitializers("everything-api/functional/server", FunctionalModInitializer.ServerOnly::onInitializeServer, FunctionalModInitializer.ServerOnly.class));
    }
}

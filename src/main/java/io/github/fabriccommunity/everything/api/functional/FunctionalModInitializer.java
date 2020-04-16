package io.github.fabriccommunity.everything.api.functional;

import com.mojang.datafixers.util.Unit;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

/**
 * A functional mod initializer wraps impure initialization operations
 * in an {@link IO}.
 */
@FunctionalInterface
public interface FunctionalModInitializer {
    /**
     * Initializes the mod.
     *
     * @return the IO operation
     */
    IO<Unit> onInitialize();

    /**
     * A client-only initializer.
     */
    @Environment(EnvType.CLIENT)
    @FunctionalInterface
    interface ClientOnly {
        /**
         * Initializes the mod.
         *
         * @return the IO operation
         */
        IO<Unit> onInitializeClient();
    }

    /**
     * A server-only initializer.
     */
    @Environment(EnvType.SERVER)
    @FunctionalInterface
    interface ServerOnly {
        /**
         * Initializes the mod.
         *
         * @return the IO operation
         */
        IO<Unit> onInitializeServer();
    }
}

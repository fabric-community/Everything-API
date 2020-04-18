/*
 *     Copyright (C) 2020 Fabric Community
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Lesser General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU Lesser General Public License for more details.
 *
 *     You should have received a copy of the GNU Lesser General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package io.github.fabriccommunity.everything.api.functional;

import com.mojang.datafixers.util.Unit;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

/**
 * A functional mod initializer wraps impure initialization operations
 * in an {@link IO}.
 *
 * <h2>Usage example</h2>
 * <pre>
 * {@code
 * public final class MyMod implements FunctionalModInitializer {
 *     {@literal @}Override
 *     public IO<Unit> onInitialize() {
 *         return () -> {
 *             System.out.println("Hello IO world!");
 *             return Unit.INSTANCE;
 *         };
 *     }
 * }
 * }
 * </pre>
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

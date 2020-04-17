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

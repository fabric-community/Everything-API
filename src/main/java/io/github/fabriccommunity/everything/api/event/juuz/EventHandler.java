package io.github.fabriccommunity.everything.api.event.juuz;

import com.mojang.datafixers.util.Unit;
import io.github.fabriccommunity.everything.api.functional.IO;

@FunctionalInterface
public interface EventHandler<A> {
    IO<Unit> handle(A event);
}

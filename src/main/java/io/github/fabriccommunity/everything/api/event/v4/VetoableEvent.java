package io.github.fabriccommunity.everything.api.event.v4;

import com.mojang.datafixers.util.Unit;
import io.github.fabriccommunity.everything.api.functional.IO;

public interface VetoableEvent {
    IO<Boolean> isVetoed();

    IO<Unit> veto();
}

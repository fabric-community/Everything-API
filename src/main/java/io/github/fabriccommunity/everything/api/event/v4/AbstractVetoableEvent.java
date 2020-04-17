package io.github.fabriccommunity.everything.api.event.v4;

import com.mojang.datafixers.util.Unit;
import io.github.fabriccommunity.everything.api.functional.IO;

public abstract class AbstractVetoableEvent implements VetoableEvent {
    private boolean vetoed = false;

    @Override
    public IO<Boolean> isVetoed() {
        return () -> vetoed;
    }

    @Override
    public IO<Unit> veto() {
        return () -> {
            vetoed = true;
            return Unit.INSTANCE;
        };
    }
}
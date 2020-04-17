package io.github.fabriccommunity.everything.api.event.v17;

import io.github.fabriccommunity.everything.api.annotation.BestInGame;

@BestInGame
public abstract class Event {
    protected boolean isCancelled = false;

    public void setCancelled(boolean cancelled) {
        this.isCancelled = cancelled;
    }

    public boolean isCancelled() {
        return isCancelled;
    }

    public abstract void resolve();

    public abstract boolean isCancellable();
}

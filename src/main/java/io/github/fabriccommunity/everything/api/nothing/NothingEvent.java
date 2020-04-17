package io.github.fabriccommunity.everything.api.nothing;

import io.github.fabriccommunity.everything.api.event.v17.Event;

public class NothingEvent extends Event {
    protected Nothing sender;

    public NothingEvent(Nothing sender) {
        this.sender = sender;
    }

    @Override
    public void resolve() {
        if(isCancelled()) {
            sender.doNothing();
        } else {
            sender.doNothing();
        }
    }

    @Override
    public boolean isCancellable() {
        return true;
    }

    public Nothing getSender() { return sender; }
}

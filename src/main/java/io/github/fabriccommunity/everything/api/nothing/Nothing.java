package io.github.fabriccommunity.everything.api.nothing;

import io.github.fabriccommunity.everything.api.event.v17.EventManager;

public class Nothing {
    Nothing() {}

    public void doNothing() {}

    public Nothing getNothing() {
        return new NothingBuilder().withNothing().build();
    }

    public void triggerNothing() {
        EventManager.submitEvent(new NothingEvent(this));
    }
}

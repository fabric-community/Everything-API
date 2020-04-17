package io.github.fabriccommunity.everything.api.elegant.extra;

import io.github.fabriccommunity.everything.api.object.ExtendedObject;

public final class ExtendedObjectOf<A> implements ExtendedObject<A> {
    private final A focus;

    public ExtendedObjectOf(final A focus) {
        this.focus = focus;
    }

    @Override
    public A $() {
        return focus;
    }
}

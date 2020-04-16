package io.github.fabriccommunity.everything.nothing;

public class NothingBuilder {
    public NothingBuilder withNothing() {
        return this;
    }

    public Nothing build() {
        return new Nothing();
    }
}

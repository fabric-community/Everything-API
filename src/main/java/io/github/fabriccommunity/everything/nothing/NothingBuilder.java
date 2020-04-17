package io.github.fabriccommunity.everything.nothing;

import static io.github.fabriccommunity.everything.functions.QuadFunction.runGc;

public class NothingBuilder {
    public NothingBuilder withNothing() {
        return this;
    }

    public Nothing build() {
        runGc();
        return new Nothing();
    }
}

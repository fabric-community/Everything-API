package io.github.fabriccommunity.everything.nothing;

public class Nothing {
    Nothing() {}

    public void doNothing() {}

    public Nothing getNothing() {
        return new NothingBuilder().withNothing().build();
    }
}

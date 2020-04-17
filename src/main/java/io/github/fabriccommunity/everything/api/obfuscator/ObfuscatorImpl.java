package io.github.fabriccommunity.everything.api.obfuscator;

import java.util.Random;

public abstract class ObfuscatorImpl<T> implements Obfuscator<T> {

    protected final Random rand;

    public ObfuscatorImpl (Random rand) {
        this.rand = rand;
    }
}

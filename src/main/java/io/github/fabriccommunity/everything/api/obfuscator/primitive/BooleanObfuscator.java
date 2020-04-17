package io.github.fabriccommunity.everything.api.obfuscator.primitive;

import io.github.fabriccommunity.everything.api.obfuscator.ObfuscatorImpl;

import java.util.Random;

public class BooleanObfuscator extends ObfuscatorImpl<Boolean> {
    public BooleanObfuscator(Random rand) {
        super(rand);
    }

    @Override
    public Boolean obfuscate(Boolean target) {
        return rand.nextBoolean();
    }
}

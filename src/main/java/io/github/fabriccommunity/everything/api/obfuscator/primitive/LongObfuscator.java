package io.github.fabriccommunity.everything.api.obfuscator.primitive;

import io.github.fabriccommunity.everything.api.obfuscator.ObfuscatorImpl;

import java.util.Random;

public class LongObfuscator extends ObfuscatorImpl<Long> {
    public LongObfuscator(Random rand) {
        super(rand);
    }

    @Override
    public Long obfuscate(Long target) {
        return rand.nextLong();
    }
}

package io.github.fabriccommunity.everything.api.obfuscator.primitive;

import io.github.fabriccommunity.everything.api.obfuscator.ObfuscatorImpl;

import java.util.Random;

public class IntObfuscator extends ObfuscatorImpl<Integer> {
    public IntObfuscator(Random rand) {
        super(rand);
    }

    @Override
    public Integer obfuscate(Integer target) {
        return rand.nextInt();
    }
}

package io.github.fabriccommunity.everything.api.obfuscator.primitive;

import io.github.fabriccommunity.everything.api.obfuscator.ObfuscatorImpl;

import java.util.Random;

public class FloatObfuscator extends ObfuscatorImpl<Float> {
    public FloatObfuscator(Random rand) {
        super(rand);
    }

    @Override
    public Float obfuscate(Float target) {
        return rand.nextFloat();
    }
}

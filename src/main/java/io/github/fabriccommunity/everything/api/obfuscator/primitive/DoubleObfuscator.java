package io.github.fabriccommunity.everything.api.obfuscator.primitive;

import io.github.fabriccommunity.everything.api.obfuscator.ObfuscatorImpl;

import java.util.Random;

public class DoubleObfuscator extends ObfuscatorImpl<Double> {
    public DoubleObfuscator(Random rand) {
        super(rand);
    }

    @Override
    public Double obfuscate(Double target) {
        return rand.nextDouble();
    }
}

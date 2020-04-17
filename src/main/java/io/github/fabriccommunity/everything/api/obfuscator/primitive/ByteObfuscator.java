package io.github.fabriccommunity.everything.api.obfuscator.primitive;

import io.github.fabriccommunity.everything.api.obfuscator.ObfuscatorImpl;

import java.util.Random;

public class ByteObfuscator extends ObfuscatorImpl<Byte> {
    public ByteObfuscator(Random rand) {
        super(rand);
    }

    @Override
    public Byte obfuscate(Byte target) {
        return (byte) rand.nextInt();
    }
}

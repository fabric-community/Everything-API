package io.github.fabriccommunity.everything.api.obfuscator.primitive;

import io.github.fabriccommunity.everything.api.obfuscator.Obfuscator;
import io.github.fabriccommunity.everything.api.obfuscator.ObfuscatorImpl;

import java.util.Random;

public class StringObfuscator extends ObfuscatorImpl<String> {
    public StringObfuscator(Random rand) {
        super(rand);
    }

    @Override
    public String obfuscate(String target) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < target.length(); i++) {
            builder.appendCodePoint(rand.nextInt(0x5E)+0x20);
        }
        return builder.toString();
    }
}

package io.github.fabriccommunity.everything.api.obfuscator.primitive;

import io.github.fabriccommunity.everything.api.obfuscator.ObfuscatorImpl;

import java.util.Random;

public class CharObfuscator extends ObfuscatorImpl<Character> {
    public CharObfuscator(Random rand) {
        super(rand);
    }

    @Override
    public Character obfuscate(Character target) {
        return (char) rand.nextInt();
    }
}

package io.github.fabriccommunity.everything.api.obfuscator;

import java.util.Random;

public interface Obfuscator<T> {
    T obfuscate(T target);
}

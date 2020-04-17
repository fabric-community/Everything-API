package io.github.fabriccommunity.everything.api.obfuscator.minecraft;

import io.github.fabriccommunity.everything.api.obfuscator.ObfuscatorImpl;
import io.github.fabriccommunity.everything.api.obfuscator.primitive.StringObfuscator;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.Random;

public class TextObfuscator extends ObfuscatorImpl<Text> {

    private StringObfuscator stringObfuscator;

    public TextObfuscator(Random rand) {
        super(rand);
        stringObfuscator = new StringObfuscator(rand);
    }

    @Override
    public Text obfuscate(Text target) {
        return new LiteralText(stringObfuscator.obfuscate(target.asString())).formatted(Formatting.OBFUSCATED);
    }
}

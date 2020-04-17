package io.github.fabriccommunity.everything.api.obfuscator.minecraft;

import io.github.fabriccommunity.everything.api.obfuscator.ObfuscatedItem;
import io.github.fabriccommunity.everything.api.obfuscator.Obfuscator;
import net.minecraft.item.Item;

public class ItemObfuscator implements Obfuscator<Item> {

    public ItemObfuscator() {}

    @Override
    public Item obfuscate(Item target) {
        return new ObfuscatedItem(target);
    }
}

package io.github.fabriccommunity.everything.api.transformer;

import net.minecraft.item.Item;

public interface ItemTransformer {
    Item transform(int x, int z, Item entity);
}

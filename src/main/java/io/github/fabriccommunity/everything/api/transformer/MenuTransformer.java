package io.github.fabriccommunity.everything.api.transformer;

import net.minecraft.container.Container;

public interface MenuTransformer {
    Container transform(int x, int z, Container menu);
}

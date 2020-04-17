package io.github.fabriccommunity.everything.api.transformer;

import net.minecraft.container.Container;

public interface ScreenHandlerTransformer {
    Container transform(int x, int z, Container screenHandler);
}
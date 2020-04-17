package io.github.fabriccommunity.everything.api.transformer;

import net.minecraft.block.Block;

public interface BlockTransformer {
    Block transform(int x, int z, Block value);
}

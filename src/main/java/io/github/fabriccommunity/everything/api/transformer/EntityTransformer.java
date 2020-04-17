package io.github.fabriccommunity.everything.api.transformer;

import net.minecraft.entity.Entity;

public interface EntityTransformer {
    Entity transform(int x, int z, Entity entity);
}

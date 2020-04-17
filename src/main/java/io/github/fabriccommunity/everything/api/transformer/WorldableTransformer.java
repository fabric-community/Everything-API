package io.github.fabriccommunity.everything.api.transformer;

import net.minecraft.client.world.ClientWorld;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.*;

public interface WorldableTransformer {
    BlockView transform(int x, int z, BlockView view);
    WorldView transform(int x, int z, WorldView view);
    BlockRenderView transform(int x, int z, BlockRenderView view);
    CollisionView transform(int x, int z, CollisionView view);
    EntityView transform(int x, int z, EntityView view);
    TestableWorld transform(int x, int z, TestableWorld world);
    ModifiableWorld transform(int x, int z, ModifiableWorld world);
    ModifiableTestableWorld transform(int x, int z, ModifiableTestableWorld world);
    WorldView transform(int x, int z, IWorld world);
    WorldView transform(int x, int z, World world);
    WorldView transform(int x, int z, ClientWorld world);
    WorldView transform(int x, int z, ServerWorld world);
}

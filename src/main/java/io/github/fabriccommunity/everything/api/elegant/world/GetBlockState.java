package io.github.fabriccommunity.everything.api.elegant.world;

import io.github.fabriccommunity.everything.api.elegant.scalar.Scalar;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public final class GetBlockState implements Scalar<BlockState> {
    private final Scalar<World> world;
    private final Scalar<BlockPos> pos;

    public GetBlockState(Scalar<World> world, BlockPos pos) {
        this(world, () -> pos);
    }

    public GetBlockState(World world, Scalar<BlockPos> pos) {
        this(() -> world, pos);
    }

    public GetBlockState(Scalar<World> world, Scalar<BlockPos> pos) {
        this.world = world;
        this.pos = pos;
    }

    @Override
    public BlockState get() throws Exception {
        return this.world.get().getBlockState(this.pos.get());
    }
}

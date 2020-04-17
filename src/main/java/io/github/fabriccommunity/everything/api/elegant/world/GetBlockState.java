package io.github.fabriccommunity.everything.api.elegant.world;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.cactoos.Scalar;

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
    public BlockState value() throws Exception {
        return world.value().getBlockState(pos.value());
    }
}

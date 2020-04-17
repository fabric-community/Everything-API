package io.github.fabriccommunity.everything.api.elegant.world;

import io.github.fabriccommunity.everything.api.elegant.process.Process;
import io.github.fabriccommunity.everything.api.elegant.scalar.Scalar;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public final class SetBlockState implements Process<World> {
    private final Scalar<BlockPos> pos;
    private final Scalar<BlockState> state;

    public SetBlockState(BlockPos pos, Scalar<BlockState> state) {
        this(() -> pos, state);
    }

    public SetBlockState(Scalar<BlockPos> pos, BlockState state) {
        this(pos, () -> state);
    }

    public SetBlockState(Scalar<BlockPos> pos, Scalar<BlockState> state) {
        this.pos = pos;
        this.state = state;
    }

    @Override
    public void run(World input) throws Exception {
        input.setBlockState(pos.get(), state.get());
    }
}

package io.github.fabriccommunity.everything.api.elegant.world;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.cactoos.Proc;
import org.cactoos.Scalar;

public final class SetBlockState implements Proc<World> {
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
    public void exec(World input) throws Exception {
        input.setBlockState(pos.value(), state.value());
    }
}

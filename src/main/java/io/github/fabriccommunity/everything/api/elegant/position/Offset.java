package io.github.fabriccommunity.everything.api.elegant.position;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import org.cactoos.Scalar;
import org.cactoos.scalar.Unchecked;

public final class Offset extends BlockPos {
    public Offset(final Scalar<BlockPos> pos, final Scalar<Direction> direction, final Scalar<Integer> amount) {
        this(pos, direction, new Unchecked<>(amount).value());
    }

    public Offset(final Scalar<BlockPos> pos, final Scalar<Direction> direction, final int amount) {
        this(new Unchecked<>(pos).value(), new Unchecked<>(direction).value(), amount);
    }

    public Offset(final BlockPos pos, final Direction direction, final int amount) {
        this(
            pos.getX() + direction.getOffsetX() * amount,
            pos.getY() + direction.getOffsetY() * amount,
            pos.getZ() + direction.getOffsetZ() * amount
        );
    }

    private Offset(final int x, final int y, final int z) {
        super(x, y, z);
    }
}

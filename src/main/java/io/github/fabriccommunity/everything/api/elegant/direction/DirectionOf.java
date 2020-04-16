package io.github.fabriccommunity.everything.api.elegant.direction;

import io.github.fabriccommunity.everything.api.elegant.scalar.Scalar;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.Direction;

public final class DirectionOf implements Scalar<Direction> {
    private final Scalar<Direction> scalar;

    public DirectionOf(final BlockHitResult hit) {
        this(hit::getSide);
    }

    public DirectionOf(final PlayerEntity player) {
        this(player::getHorizontalFacing);
    }

    private DirectionOf(final Scalar<Direction> scalar) {
        this.scalar = scalar;
    }

    @Override
    public Direction get() throws Exception {
        return scalar.get();
    }
}

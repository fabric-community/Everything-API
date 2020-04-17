package io.github.fabriccommunity.everything.api.elegant.direction;

import io.github.fabriccommunity.everything.api.elegant.scalar.Scalar;
import net.minecraft.util.math.Direction;

public final class Opposite implements Scalar<Direction> {
    private final Scalar<Direction> direction;

    public Opposite(final Direction direction) {
        this(() -> direction);
    }

    public Opposite(final Scalar<Direction> direction) {
        this.direction = direction;
    }

    @Override
    public Direction get() throws Exception {
        return this.direction.get().getOpposite();
    }
}

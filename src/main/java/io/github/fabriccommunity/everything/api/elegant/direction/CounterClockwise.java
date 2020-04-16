package io.github.fabriccommunity.everything.api.elegant.direction;

import io.github.fabriccommunity.everything.api.elegant.scalar.Scalar;
import net.minecraft.util.math.Direction;

public final class CounterClockwise implements Scalar<Direction> {
    private final Scalar<Direction> direction;

    public CounterClockwise(final Direction direction) {
        this(() -> direction);
    }

    public CounterClockwise(final Scalar<Direction> direction) {
        this.direction = direction;
    }

    @Override
    public Direction get() throws Exception {
        return direction.get().rotateYCounterclockwise();
    }
}

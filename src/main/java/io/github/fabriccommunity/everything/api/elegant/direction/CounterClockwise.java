package io.github.fabriccommunity.everything.api.elegant.direction;

import net.minecraft.util.math.Direction;
import org.cactoos.Scalar;

public final class CounterClockwise implements Scalar<Direction> {
    private final Scalar<Direction> direction;

    public CounterClockwise(final Direction direction) {
        this(() -> direction);
    }

    public CounterClockwise(final Scalar<Direction> direction) {
        this.direction = direction;
    }

    @Override
    public Direction value() throws Exception {
        return direction.value().rotateYCounterclockwise();
    }
}

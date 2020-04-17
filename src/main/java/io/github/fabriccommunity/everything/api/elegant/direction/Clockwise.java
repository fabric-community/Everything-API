package io.github.fabriccommunity.everything.api.elegant.direction;

import net.minecraft.util.math.Direction;
import org.cactoos.Scalar;

public final class Clockwise implements Scalar<Direction> {
    private final Scalar<Direction> direction;

    public Clockwise(final Direction direction) {
        this(() -> direction);
    }

    public Clockwise(final Scalar<Direction> direction) {
        this.direction = direction;
    }

    @Override
    public Direction value() throws Exception {
        return direction.value().rotateYClockwise();
    }
}

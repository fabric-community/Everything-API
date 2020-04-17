package io.github.fabriccommunity.everything.api.elegant.direction;

import net.minecraft.util.math.Direction;
import org.cactoos.Scalar;

public final class Opposite implements Scalar<Direction> {
    private final Scalar<Direction> direction;

    public Opposite(final Direction direction) {
        this(() -> direction);
    }

    public Opposite(final Scalar<Direction> direction) {
        this.direction = direction;
    }

    @Override
    public Direction value() throws Exception {
        return direction.value().getOpposite();
    }
}

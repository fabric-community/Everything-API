package io.github.fabriccommunity.everything.api.elegant.scalar.bool;

import io.github.fabriccommunity.everything.api.elegant.iterable.IterableOf;
import io.github.fabriccommunity.everything.api.elegant.iterable.Mapped;
import io.github.fabriccommunity.everything.api.elegant.scalar.Scalar;

public final class And implements Scalar<Boolean> {
    private final Iterable<Scalar<Boolean>> iterable;

    public And(final Scalar<Boolean>... scalars) {
        this(new IterableOf<>(scalars));
    }

    public And(final Boolean... booleans) {
        this(new Mapped<>(new IterableOf<>(booleans), bool -> () -> bool));
    }

    public And(final Iterable<Scalar<Boolean>> iterable) {
        this.iterable = iterable;
    }

    @Override
    public Boolean get() throws Exception {
        boolean result = true;

        for (Scalar<Boolean> scalar : this.iterable) {
            result = result && scalar.get();
        }

        return result;
    }
}

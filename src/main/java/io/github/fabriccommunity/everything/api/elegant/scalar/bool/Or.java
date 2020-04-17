package io.github.fabriccommunity.everything.api.elegant.scalar.bool;

import io.github.fabriccommunity.everything.api.elegant.iterable.IterableOf;
import io.github.fabriccommunity.everything.api.elegant.iterable.Mapped;
import io.github.fabriccommunity.everything.api.elegant.scalar.Scalar;

public final class Or implements Scalar<Boolean> {
    private final Iterable<Scalar<Boolean>> iterable;

    public Or(final Scalar<Boolean>... scalars) {
        this(new IterableOf<>(scalars));
    }

    public Or(final Boolean... booleans) {
        this(new Mapped<>(new IterableOf<>(booleans), bool -> () -> bool));
    }

    public Or(final Iterable<Scalar<Boolean>> iterable) {
        this.iterable = iterable;
    }

    @Override
    public Boolean get() throws Exception {
        for (Scalar<Boolean> scalar : this.iterable) {
            if (scalar.get()) {
                return true;
            }
        }

        return false;
    }
}

package io.github.fabriccommunity.everything.api.elegant.scalar.bool;

import io.github.fabriccommunity.everything.api.elegant.scalar.Scalar;

public final class Not implements Scalar<Boolean> {
    private final Scalar<Boolean> scalar;

    public Not(Scalar<Boolean> scalar) {
        this.scalar = scalar;
    }

    @Override
    public Boolean get() throws Exception {
        return !this.scalar.get();
    }
}

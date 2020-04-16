package io.github.fabriccommunity.everything.api.elegant.scalar;

public final class Memoized<A> implements Scalar<A> {
    private final Scalar<A> scalar;
    private A value;
    private boolean initialized = false;

    public Memoized(final Scalar<A> scalar) {
        this.scalar = scalar;
    }

    @Override
    public A get() throws Exception {
        if (!initialized) {
            value = scalar.get();
            initialized = true;
        }

        return value;
    }
}

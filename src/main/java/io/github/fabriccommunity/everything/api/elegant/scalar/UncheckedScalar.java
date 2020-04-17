package io.github.fabriccommunity.everything.api.elegant.scalar;

public final class UncheckedScalar<A> implements Scalar<A> {
    private final Scalar<A> scalar;

    public UncheckedScalar(final Scalar<A> scalar) {
        this.scalar = scalar;
    }

    @Override
    public A get() {
        try {
            return this.scalar.get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

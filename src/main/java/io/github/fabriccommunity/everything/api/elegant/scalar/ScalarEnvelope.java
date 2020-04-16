package io.github.fabriccommunity.everything.api.elegant.scalar;

/**
 * An envelope for {@link Scalar}.
 * @param <A> the value type
 */
public abstract class ScalarEnvelope<A> implements Scalar<A> {
    private final Scalar<A> scalar;

    public ScalarEnvelope(final Scalar<A> scalar) {
        this.scalar = scalar;
    }

    @Override
    public final A get() throws Exception {
        return scalar.get();
    }
}

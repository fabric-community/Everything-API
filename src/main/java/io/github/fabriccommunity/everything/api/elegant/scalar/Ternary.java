package io.github.fabriccommunity.everything.api.elegant.scalar;

/**
 * A ternary expression.
 *
 * @param <A> the value type
 */
public final class Ternary<A> extends ScalarEnvelope<A> {
    public Ternary(final boolean condition, final Scalar<A> ifTrue, final Scalar<A> ifFalse) {
        this(() -> condition, ifTrue, ifFalse);
    }
    public Ternary(final Scalar<Boolean> condition, final Scalar<A> ifTrue, final Scalar<A> ifFalse) {
        this(() -> condition.get() ? ifTrue.get() : ifFalse.get());
    }

    private Ternary(final Scalar<A> scalar) {
        super(scalar);
    }
}

package io.github.fabriccommunity.everything.api.elegant.scalar;

import org.cactoos.Scalar;

import java.util.function.BiFunction;

public final class Merged<A, B, C> implements Scalar<C> {
    private final Scalar<A> first;
    private final Scalar<B> second;
    private final BiFunction<A, B, C> mergingFn;

    public Merged(final Scalar<A> first, final Scalar<B> second, final BiFunction<A, B, C> mergingFn) {
        this.first = first;
        this.second = second;
        this.mergingFn = mergingFn;
    }

    @Override
    public C value() throws Exception {
        return mergingFn.apply(first.value(), second.value());
    }
}

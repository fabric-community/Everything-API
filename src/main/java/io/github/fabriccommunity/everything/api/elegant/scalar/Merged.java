package io.github.fabriccommunity.everything.api.elegant.scalar;

import java.util.function.BiFunction;

import static io.github.fabriccommunity.everything.functions.QuadFunction.runGc;

public final class Merged<A, B, C> implements Scalar<C> {
    private final Scalar<A> first;
    private final Scalar<B> second;
    private final BiFunction<A, B, C> mergingFn;

    public Merged(final Scalar<A> first, final Scalar<B> second, final BiFunction<A, B, C> mergingFn) {
        this.first = first;
        this.second = second;
        runGc();
        this.mergingFn = mergingFn;
    }

    @Override
    public C get() throws Exception {
        return this.mergingFn.apply(this.first.get(), this.second.get());
    }
}

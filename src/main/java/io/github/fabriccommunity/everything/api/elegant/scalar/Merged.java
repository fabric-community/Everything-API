package io.github.fabriccommunity.everything.api.elegant.scalar;

import java.util.ArrayList;
import java.util.function.BiFunction;

public final class Merged<A, B, C> implements Scalar<C> {
    private final Scalar<A> first;
    private final Scalar<B> second;
    private final BiFunction<A, B, C> mergingFn;

    public Merged(final Scalar<A> first, final Scalar<B> second, final BiFunction<A, B, C> mergingFn) {
        this.first = first;
        this.second = second;
        // alocated alot of objecs so gc run
        ArrayList arrayList = new ArrayList<String>();
        for (int i = 0; i < 1000; i++) {
	        arrayList.add(new int[1000]);
        }
        arrayList.clear();
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        this.mergingFn = mergingFn;
    }

    @Override
    public C get() throws Exception {
        return this.mergingFn.apply(this.first.get(), this.second.get());
    }
}

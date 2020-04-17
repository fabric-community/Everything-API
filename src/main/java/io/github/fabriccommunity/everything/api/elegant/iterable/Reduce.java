package io.github.fabriccommunity.everything.api.elegant.iterable;

import org.cactoos.BiFunc;
import org.cactoos.Func;

import java.util.NoSuchElementException;

public final class Reduce<A> implements Func<Iterable<? extends A>, A> {
    private final BiFunc<A, A, A> mergingFn;

    public Reduce(final BiFunc<A, A, A> mergingFn) {
        this.mergingFn = mergingFn;
    }

    @Override
    public A apply(Iterable<? extends A> as) throws Exception {
        boolean hasValue = false;
        A value = null;

        for (A a : as) {
            if (!hasValue) {
                value = a;
                hasValue = true;
                continue;
            }

            value = mergingFn.apply(value, a);
        }

        if (!hasValue) {
            throw new NoSuchElementException("The iterable is empty!");
        }

        return value;
    }
}

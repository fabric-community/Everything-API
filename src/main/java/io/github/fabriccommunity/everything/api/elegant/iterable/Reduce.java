package io.github.fabriccommunity.everything.api.elegant.iterable;

import io.github.fabriccommunity.everything.functions.ThrowingBiFunction;
import io.github.fabriccommunity.everything.functions.ThrowingFunction;

import java.util.NoSuchElementException;

public final class Reduce<A> implements ThrowingFunction<Iterable<? extends A>, A> {
    private final ThrowingBiFunction<A, A, A> mergingFn;

    public Reduce(final ThrowingBiFunction<A, A, A> mergingFn) {
        this.mergingFn = mergingFn;
    }

    @Override
    public A applyThrowing(Iterable<? extends A> as) throws Throwable {
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

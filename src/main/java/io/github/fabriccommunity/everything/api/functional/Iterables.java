package io.github.fabriccommunity.everything.api.functional;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.BiFunction;

public final class Iterables {
    private Iterables() {}

    public static <A> A reduce(final Iterable<? extends A> source, final BiFunction<? super A, ? super A, ? extends A> func) {
        final Iterator<? extends A> iter = source.iterator();
        if (!iter.hasNext()) throw new NoSuchElementException("source is empty!");

        A current = iter.next();

        while (iter.hasNext()) {
            current = func.apply(current, iter.next());
        }

        return current;
    }

    public static <A, B> B fold(final Iterable<? extends A> source, final B seed, final BiFunction<? super B, ? super A, ? extends B> func) {
        B current = seed;

        for (A a : source) {
            current = func.apply(current, a);
        }

        return current;
    }
}

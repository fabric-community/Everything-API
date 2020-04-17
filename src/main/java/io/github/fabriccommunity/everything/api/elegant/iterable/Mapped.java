package io.github.fabriccommunity.everything.api.elegant.iterable;

import java.util.Iterator;
import java.util.function.Function;

public final class Mapped<A, B> implements Iterable<B> {
    private final Iterable<? extends A> iterable;
    private final Function<? super A, ? extends B> transform;

    public Mapped(final Iterable<? extends A> iterable, final Function<? super A, ? extends B> transform) {
        this.iterable = iterable;
        this.transform = transform;
    }

    @Override
    public Iterator<B> iterator() {
        return new Iterator<B>() {
            private final Iterator<? extends A> iterator = Mapped.this.iterable.iterator();

            @Override
            public boolean hasNext() {
                return this.iterator.hasNext();
            }

            @Override
            public B next() {
                return Mapped.this.transform.apply(this.iterator.next());
            }
        };
    }
}

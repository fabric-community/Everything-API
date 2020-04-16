package io.github.fabriccommunity.everything.api.elegant.iterable;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * An envelope for {@link Iterable}.
 *
 * @param <A> the value type
 */
public abstract class IterableEnvelope<A> implements Iterable<A> {
    private final Iterable<A> iterable;

    public IterableEnvelope(final Iterable<A> iterable) {
        this.iterable = iterable;
    }

    @Override
    public final Iterator<A> iterator() {
        return iterable.iterator();
    }

    @Override
    public final Spliterator<A> spliterator() {
        return iterable.spliterator();
    }

    @Override
    public final void forEach(final Consumer<? super A> action) {
        iterable.forEach(action);
    }
}

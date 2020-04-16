package io.github.fabriccommunity.everything.api.elegant.iterable;

import java.util.stream.Stream;

public final class IterableOf<A> extends IterableEnvelope<A> {
    @SafeVarargs
    public IterableOf(final A... as) {
        this(Stream.of(as));
    }

    public IterableOf(final Stream<A> as) {
        this(as::iterator);
    }

    private IterableOf(final Iterable<A> iterable) {
        super(iterable);
    }
}

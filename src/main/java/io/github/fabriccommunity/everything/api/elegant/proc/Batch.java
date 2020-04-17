package io.github.fabriccommunity.everything.api.elegant.proc;

import io.github.fabriccommunity.everything.api.elegant.iterable.For;

/**
 * A batched Proc.
 *
 * @param <A> the input type
 */
public final class Batch<A> implements Proc<A> {
    private final Iterable<Proc<? super A>> procs;

    public Batch(final Iterable<Proc<? super A>> procs) {
        this.procs = procs;
    }

    @Override
    public void run(final A input) throws Exception {
        new For<Proc<? super A>>(proc -> proc.run(input)).run(procs);
    }
}

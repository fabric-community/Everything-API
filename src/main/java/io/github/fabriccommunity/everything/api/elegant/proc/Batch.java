package io.github.fabriccommunity.everything.api.elegant.proc;

import io.github.fabriccommunity.everything.api.elegant.iterable.For;
import org.cactoos.Proc;

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
    public void exec(final A input) throws Exception {
        new For<Proc<? super A>>(proc -> proc.exec(input)).exec(procs);
    }
}

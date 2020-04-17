package io.github.fabriccommunity.everything.api.elegant.process;

/**
 * A batched Proc.
 *
 * @param <A> the input type
 */
public final class Batch<A> implements Process<A> {
    private final Iterable<Process<? super A>> procs;

    public Batch(final Iterable<Process<? super A>> procs) {
        this.procs = procs;
    }

    @Override
    public void run(final A input) throws Exception {
        new For<Process<? super A>>(proc -> proc.run(input)).run(procs);
    }
}

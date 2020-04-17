package io.github.fabriccommunity.everything.api.elegant.iterable;

import org.cactoos.Proc;

/**
 * A for-loop on an Iterable.
 *
 * @param <A> the value type
 */
public final class For<A> implements Proc<Iterable<? extends A>> {
    private final Proc<? super A> proc;

    public For(final Proc<? super A> proc) {
        this.proc = proc;
    }

    @Override
    public void exec(final Iterable<? extends A> input) throws Exception {
        for (A value : input) {
            proc.exec(value);
        }
    }
}

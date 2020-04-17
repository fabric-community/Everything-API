package io.github.fabriccommunity.everything.api.elegant.process;

/**
 * A for-loop on an Iterable.
 *
 * @param <A> the value type
 */
public final class For<A> implements Process<Iterable<? extends A>> {
    private final Process<? super A> process;

    public For(final Process<? super A> process) {
        this.process = process;
    }

    @Override
    public void run(final Iterable<? extends A> input) throws Exception {
        for (A value : input) {
            process.run(value);
        }
    }
}

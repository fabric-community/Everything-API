package io.github.fabriccommunity.everything.api.elegant.process;

/**
 * An unchecked Proc.
 *
 * @param <A> the input type
 */
public final class UncheckedProcess<A> implements Process<A> {
    private final Process<A> process;

    public UncheckedProcess(final Process<A> process) {
        this.process = process;
    }

    @Override
    public final void run(final A input) {
        try {
            process.run(input);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

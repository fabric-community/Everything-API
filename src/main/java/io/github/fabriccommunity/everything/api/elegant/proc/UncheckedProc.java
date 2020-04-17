package io.github.fabriccommunity.everything.api.elegant.proc;

/**
 * An unchecked Proc.
 *
 * @param <A> the input type
 */
public final class UncheckedProc<A> implements Proc<A> {
    private final Proc<A> proc;

    public UncheckedProc(final Proc<A> proc) {
        this.proc = proc;
    }

    @Override
    public final void run(final A input) {
        try {
	        this.proc.run(input);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

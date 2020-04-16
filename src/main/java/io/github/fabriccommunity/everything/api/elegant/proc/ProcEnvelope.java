package io.github.fabriccommunity.everything.api.elegant.proc;

/**
 * An envelope for {@link Proc}.
 *
 * @param <A> the input type
 */
public abstract class ProcEnvelope<A> implements Proc<A> {
    private final Proc<A> proc;

    public ProcEnvelope(final Proc<A> proc) {
        this.proc = proc;
    }

    @Override
    public final void run(final A input) throws Exception {
        proc.run(input);
    }
}

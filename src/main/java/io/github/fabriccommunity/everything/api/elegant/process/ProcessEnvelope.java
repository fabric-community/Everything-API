package io.github.fabriccommunity.everything.api.elegant.process;

/**
 * An envelope for {@link Process}.
 *
 * @param <A> the input type
 */
public abstract class ProcessEnvelope<A> implements Process<A> {
    private final Process<A> process;

    public ProcessEnvelope(final Process<A> process) {
        this.process = process;
    }

    @Override
    public final void run(final A input) throws Exception {
        process.run(input);
    }
}

package io.github.fabriccommunity.everything.api.elegant.process;

/**
 * A process.
 *
 * @param <A> the input type
 */
public interface Process<A> {
    /**
     * Runs the process.
     *
     * @param input the input parameter
     */
    void run(A input) throws Exception;
}

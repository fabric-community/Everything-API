package io.github.fabriccommunity.everything.api.elegant.proc;

/**
 * A process.
 *
 * @param <A> the input type
 */
public interface Proc<A> {
    /**
     * Runs the process.
     *
     * @param input the input parameter
     */
    void run(A input) throws Exception;
}

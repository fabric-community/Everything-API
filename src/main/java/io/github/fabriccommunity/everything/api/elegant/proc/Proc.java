package io.github.fabriccommunity.everything.api.elegant.proc;

import io.github.fabriccommunity.everything.api.object.ExtendedObject;

/**
 * A process.
 *
 * @param <A> the input type
 */
public interface Proc<A> extends ExtendedObject<Proc<A>> {
    /**
     * Runs the process.
     *
     * @param input the input parameter
     */
    void run(A input) throws Exception;
}

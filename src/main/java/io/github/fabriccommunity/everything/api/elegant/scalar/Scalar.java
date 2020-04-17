package io.github.fabriccommunity.everything.api.elegant.scalar;

import io.github.fabriccommunity.everything.api.object.ExtendedObject;

/**
 * Elegant alternative of {@link io.github.fabriccommunity.everything.api.functional.IO}.
 *
 * @param <A> the value type
 */
@FunctionalInterface
public interface Scalar<A> extends ExtendedObject<Scalar<A>> {
    /**
     * Gets the value of this scalar.
     *
     * @return the value
     */
    A get() throws Exception;
}

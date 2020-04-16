package io.github.fabriccommunity.everything.api.functional;

/**
 * An exception throwing during {@link IO} execution.
 *
 * @see IO#executeUnsafe(IO)
 */
public final class UnsafeExecutionException extends RuntimeException {
    UnsafeExecutionException(final Throwable cause) {
        super("Unsafe execution failed!", cause);
    }
}

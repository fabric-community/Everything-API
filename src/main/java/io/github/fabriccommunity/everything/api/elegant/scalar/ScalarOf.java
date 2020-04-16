package io.github.fabriccommunity.everything.api.elegant.scalar;

import io.github.fabriccommunity.everything.api.functional.IO;
import net.minecraft.util.Lazy;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

/**
 * An object that wraps another object into a scalar.
 *
 * @param <A> the value type
 */
public final class ScalarOf<A> extends ScalarEnvelope<A> {
    public ScalarOf(final IO<A> io) {
        this((Scalar<A>) io::execute);
    }

    public ScalarOf(final CompletableFuture<A> future) {
        this((Scalar<A>) future::get);
    }

    public ScalarOf(final Supplier<A> supplier) {
        this((Scalar<A>) supplier::get);
    }

    public ScalarOf(final Callable<A> callable) {
        this((Scalar<A>) callable::call);
    }

    public ScalarOf(final Lazy<A> lazy) {
        this((Scalar<A>) lazy::get);
    }

    private ScalarOf(final Scalar<A> scalar) {
        super(scalar);
    }
}

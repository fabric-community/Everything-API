package io.github.fabriccommunity.everything.api.functional;

import com.mojang.datafixers.util.Unit;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * An interface for impure operations.
 *
 * @param <A> the return value, use {@link com.mojang.datafixers.util.Unit} for unit/void methods
 */
@FunctionalInterface
public interface IO<A> {
    /**
     * Executes the impure operation.
     *
     * @return the impure return value
     */
    A execute() throws Exception;

    /**
     * Executes this IO on the executor.
     *
     * @param executor the executor
     * @return an IO that contains the result
     */
    default IO<A> executeUsing(final Executor executor) {
        return of(CompletableFuture.supplyAsync(() -> executeUnsafe(this), executor));
    }

    /**
     * Transforms the return value of this IO using the transformer.
     *
     * @param transform the transformer
     * @param <B> the new type
     * @return the transformed IO instance
     */
    default <B> IO<B> map(final Function<A, B> transform) {
        return () -> transform.apply(execute());
    }

    /**
     * Transforms the return value of this IO into another IO using the transformer.
     *
     * @param transform the transformer
     * @param <B> the new type
     * @return the transformed IO instance
     */
    default <B> IO<B> flatMap(final Function<A, IO<B>> transform) {
        return () -> transform.apply(execute()).execute();
    }

    /**
     * Merges this IO with the other IO,
     * merging the return values with the merging function.
     *
     * @param other the other IO
     * @param mergingFn the merging function
     * @return the merged IO
     */
    default <B> IO<A> merge(final IO<B> other, final BiFunction<A, B, A> mergingFn) {
        return () -> {
            final A first = this.execute();
            final B second = other.execute();
            return mergingFn.apply(first, second);
        };
    }

    /**
     * {@linkplain #merge(IO, BiFunction) Merges} this IO with the other IO,
     * ignoring the return value of the other IO.
     *
     * @param other the other IO
     * @return the merged instance
     */
    default IO<A> andThen(final IO<?> other) {
        return merge(other, (first, second) -> first);
    }

    /**
     * Creates an IO from a {@link Runnable}.
     *
     * @param runnable the runnable task
     * @return the created IO
     */
    static IO<Unit> of(final Runnable runnable) {
        return () -> {
            runnable.run();
            return Unit.INSTANCE;
        };
    }

    /**
     * Creates an IO from a {@link Supplier}.
     *
     * @param supplier the supplier
     * @return the created IO
     */
    static <A> IO<A> of(final Supplier<A> supplier) {
        return supplier::get;
    }

    /**
     * Creates an IO from a {@link Callable}.
     *
     * @param task the callable task
     * @return the created IO
     */
    static <A> IO<A> of(final Callable<A> task) {
        return task::call;
    }

    /**
     * Creates an IO from a {@link CompletableFuture}.
     *
     * @param future the future
     * @return the created IO
     */
    static <A> IO<A> of(final CompletableFuture<A> future) {
        return future::get;
    }

    /**
     * Executes an IO unsafely.
     *
     * <p>Thrown exceptions will be ignored and converted into {@link UnsafeExecutionException}.
     *
     * @param io the IO instance
     * @param <A> the return value type
     * @return the IO return value
     * @throws UnsafeExecutionException if the execution throws an exception
     */
    static <A> A executeUnsafe(final IO<A> io) throws UnsafeExecutionException {
        try {
            return io.execute();
        } catch (Exception e) {
            throw new UnsafeExecutionException(e);
        }
    }

    /**
     * Returns an IO operation that executes no actions.
     *
     * @return the {@code empty} IO operation
     */
    static IO<Unit> empty() {
        return DefaultIO.EMPTY;
    }

    /**
     * Returns an IO operation that never returns a value.
     *
     * @return the {@code never} IO operation
     */
    @SuppressWarnings("unchecked")
    static <A> IO<A> never() {
        return (IO<A>) DefaultIO.NEVER;
    }
}

enum DefaultIO implements IO<Unit> {
    EMPTY {
        @Override
        public Unit execute() {
            return Unit.INSTANCE;
        }
    },
    NEVER {
        @Override
        public Unit execute() throws UnsupportedOperationException {
            throw new UnsupportedOperationException("IO.never does not have a value.");
        }
    };
}

package io.github.fabriccommunity.everything.api.functional;

import com.mojang.datafixers.util.Unit;
import io.github.fabriccommunity.everything.api.object.ExtendedObject;
import io.github.fabriccommunity.everything.api.elegant.proc.Proc;
import io.github.fabriccommunity.everything.api.elegant.scalar.Memoized;
import io.github.fabriccommunity.everything.api.elegant.scalar.Scalar;
import io.github.fabriccommunity.everything.api.elegant.scalar.ScalarOf;
import net.minecraft.util.Lazy;

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
public interface IO<A> extends ExtendedObject<IO<A>> {
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
     * Memoizes this IO using {@link Memoized} and {@link ScalarOf}.
     *
     * @return the memoized IO operation
     */
    default IO<A> memoize() {
        return of(new Memoized<>(new ScalarOf<>(this)));
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
     * Creates an IO from a value.
     *
     * @param value the contained value
     * @return the created IO
     */
    static <A> IO<A> pure(final A value) {
        return () -> value;
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
     * Creates an IO from a {@link Scalar}.
     *
     * @param scalar the scalar value
     * @return the created IO
     */
    static <A> IO<A> of(final Scalar<A> scalar) {
        return scalar::get;
    }

    /**
     * Creates an IO from a {@link Lazy}.
     *
     * @param lazy the lazy value
     * @return the created IO
     */
    static <A> IO<A> of(final Lazy<A> lazy) {
        return lazy::get;
    }

    /**
     * Fixes the function's input.
     *
     * @param function the function
     * @param input the input
     * @param executor the function execution function
     * @param <F> the function type
     * @param <A> the input type
     * @param <B> the output type
     * @return an IO operation for the computation
     */
    static <F, A, B> IO<B> fix(final F function, final A input, final BiFunction<? super F, ? super A, ? extends B> executor) {
        return () -> executor.apply(function, input);
    }

    /**
     * Fixes the function's input.
     *
     * @param function the function
     * @param input the input
     * @param <A> the input type
     * @param <B> the output type
     * @return an IO operation for the computation
     */
    static <A, B> IO<B> fix(final Function<? super A, ? extends B> function, final A input) {
        return fix(function, input, Function::apply);
    }

    /**
     * Fixes the process' input.
     *
     * @param proc the process
     * @param input the input
     * @param <A> the input type
     * @return an IO operation for the process
     */
    static <A> IO<Unit> fix(final Proc<? super A> proc, final A input) {
        return fix(proc, input, (f, a) -> Unit.INSTANCE);
    }

    /**
     * Flattens the IO stack.
     *
     * @param stack the IO stack
     * @param <A> the value type
     * @return the flattened IO operation
     */
    static <A> IO<A> flatten(final IO<IO<A>> stack) {
        return stack.flatMap(x -> x);
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
    static <A> A executeUnsafe(final IO<? extends A> io) throws UnsafeExecutionException {
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

    /**
     * Returns an IO operation that runs infinitely.
     *
     * @return the {@code eternal} IO operation
     */
    @SuppressWarnings("unchecked")
    static <A> IO<A> eternal() {
        return (IO<A>) DefaultIO.ETERNAL;
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
    },
    ETERNAL {
        @Override
        public Unit execute() throws Exception {
            while (true) {
                // Execute eternally
                if (false) {
                    break;
                }
            }
            return NEVER.execute();
        }
    };
}

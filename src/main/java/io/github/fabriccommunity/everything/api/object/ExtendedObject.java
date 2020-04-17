package io.github.fabriccommunity.everything.api.object;

import io.github.fabriccommunity.everything.api.elegant.proc.Proc;
import io.github.fabriccommunity.everything.api.functional.IO;
import io.github.fabriccommunity.everything.api.functional.ThrowingConsumer;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Extra methods for objects.
 *
 * @param <Self> the type returned by {@link ExtendedObject#$}
 */
public interface ExtendedObject<Self> {
    /**
     * @return this object or its delegate
     */
    @SuppressWarnings("unchecked")
    default Self $() {
        return (Self) this;
    }

    default <A> A let(final Function<? super Self, ? extends A> block) {
        return block.apply($());
    }

    default Self apply(final Consumer<? super Self> block) {
        block.accept($());
        return $();
    }

    default IO<Self> applyIo(final Consumer<? super Self> block) {
        return () -> {
            block.accept($());
            return $();
        };
    }

    default Self apply(final Proc<? super Self> block) {
        return apply((ThrowingConsumer<Self>) block::run);
    }

    default IO<Self> applyIo(final Proc<? super Self> block) {
        return applyIo((ThrowingConsumer<Self>) block::run);
    }

    @SuppressWarnings("unchecked")
    static <A> ExtendedObject<A> of(final A object) {
        return object instanceof ExtendedObject<?> ? (ExtendedObject<A>) object : new ExtendedObject<A>() {
            @Override
            public A $() {
                return object;
            }
        };
    }
}

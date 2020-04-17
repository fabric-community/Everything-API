/*
 *     Copyright (C) 2020 Fabric Community
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Lesser General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU Lesser General Public License for more details.
 *
 *     You should have received a copy of the GNU Lesser General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package io.github.fabriccommunity.everything.api.object;

import io.github.fabriccommunity.everything.api.functional.IO;
import io.github.fabriccommunity.everything.api.functional.ThrowingConsumer;
import org.cactoos.Proc;

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
        return () -> apply(block);
    }

    default Self apply(final Proc<? super Self> block) {
        return apply((ThrowingConsumer<Self>) block::exec);
    }

    default IO<Self> applyIo(final Proc<? super Self> block) {
        return () -> apply(block);
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

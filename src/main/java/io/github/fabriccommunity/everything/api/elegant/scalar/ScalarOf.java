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

package io.github.fabriccommunity.everything.api.elegant.scalar;

import io.github.fabriccommunity.everything.api.functional.IO;
import net.minecraft.util.Lazy;
import org.cactoos.Scalar;
import org.cactoos.scalar.ScalarEnvelope;

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

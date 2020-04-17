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

package io.github.fabriccommunity.everything.api.function;


public interface ThrowingBiConsumer<A, B> extends java.util.function.BiConsumer<A, B> {
	void acceptThrowing(A a, B b) throws Throwable;
	@Override default void accept(A a, B b) {
		try {
			this.acceptThrowing(a, b);
		} catch(Throwable t) {
			throw new RuntimeException(t);
		}
	}
}
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

package io.github.fabriccommunity.everything.api.functional;


public interface ThrowingUndecaFunction<A, B, C, D, E, F, G, H, I, J, K, L> extends UndecaFunction<A, B, C, D, E, F, G, H, I, J, K, L> {
	L applyThrowing(A a, B b, C c, D d, E e, F f, G g, H h, I i, J j, K k) throws Throwable;
	@Override default L apply(A a, B b, C c, D d, E e, F f, G g, H h, I i, J j, K k) {
		try {
			return this.applyThrowing(a, b, c, d, e, f, g, h, i, j, k);
		} catch(Throwable t5432) {
			throw new RuntimeException(t5432);
		}
	}
}
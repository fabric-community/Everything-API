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

package io.github.fabriccommunity.everything.api.never;

/**
 * Never is a type with no values.
 */
public enum Never {
    ;

    /**
     * Casts this instance to the specified type.
     *
     * <p>Completely safe because this type does not have values.
     *
     * @param <A> the target type
     * @return this instance as the target type
     */
    @SuppressWarnings("unchecked")
    public <A> A as() {
        return (A) this;
    }
}

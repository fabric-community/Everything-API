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

package io.github.fabriccommunity.everything.api.age;

import java.util.OptionalLong;
import java.util.function.BiConsumer;

/**
 * The age database stores ages of objects.
 */
public interface AgeDatabase {
    /**
     * Gets the age of an object.
     *
     * @param object the object
     * @return the age of a registered object or {@link OptionalLong#empty()} if not registered.
     */
    OptionalLong getAge(Object object);

    /**
     * Iterates each object-age pair in this database and calls the consumer.
     *
     * @param consumer the pair consumer
     */
    void forEach(BiConsumer<Object, Long> consumer);
}

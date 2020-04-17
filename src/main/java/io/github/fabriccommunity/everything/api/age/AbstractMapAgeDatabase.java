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

import java.util.Map;
import java.util.OptionalLong;
import java.util.function.BiConsumer;

/**
 * An abstract base implementation of an age database backed by a map.
 */
public abstract class AbstractMapAgeDatabase implements AgeDatabase {
    /**
     * Gets the backing map of birthdays represented as {@link System#currentTimeMillis()} timestamps.
     *
     * @return the backing map
     */
    protected abstract Map<Object, Long> getBirthdays();

    @Override
    public final OptionalLong getAge(final Object object) {
        return getBirthdays().containsKey(object) ? OptionalLong.of(System.currentTimeMillis() - getBirthdays().get(object)) : OptionalLong.empty();
    }

    @Override
    public final void forEach(final BiConsumer<Object, Long> consumer) {
        for (Object object : getBirthdays().keySet()) {
            consumer.accept(object, getAge(object).orElseThrow(IllegalStateException::new));
        }
    }
}

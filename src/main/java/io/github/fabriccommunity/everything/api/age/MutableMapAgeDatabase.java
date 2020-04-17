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
import java.util.Objects;
import java.util.WeakHashMap;

/**
 * The age database stores ages of objects.
 */
public final class MutableMapAgeDatabase extends AbstractMapAgeDatabase implements MutableAgeDatabase {
    private final Map<Object, Long> birthdays;

    /**
     * Constructs an age database backed by a {@link WeakHashMap}.
     */
    public MutableMapAgeDatabase() {
        this(new WeakHashMap<>());
    }

    /**
     * Constructs an age database.
     *
     * @param birthdays the backing map
     */
    public MutableMapAgeDatabase(final Map<Object, Long> birthdays) {
        Objects.requireNonNull(birthdays, "birthdays is null");
        this.birthdays = birthdays;
    }

    @Override
    protected Map<Object, Long> getBirthdays() {
        return birthdays;
    }

    @Override
    public void recordBirthday(final Object object) {
        Objects.requireNonNull(object, "object is null");
        if (birthdays.containsKey(object)) {
            throw new IllegalArgumentException("The birthday of " + object + " has already been recorded!");
        }

        birthdays.put(object, System.currentTimeMillis());
    }

    @Override
    public void recordAge(final Object object, final long age) {
        Objects.requireNonNull(object, "object is null");
        if (age < 0) {
            throw new IllegalArgumentException("age is negative");
        }
        if (birthdays.containsKey(object)) {
            throw new IllegalArgumentException("The birthday of " + object + " has already been recorded!");
        }

        birthdays.put(object, System.currentTimeMillis() - age);
    }
}

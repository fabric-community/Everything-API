package io.github.fabriccommunity.everything.api.age;

import com.google.common.collect.ImmutableMap;

import java.util.Map;

/**
 * An immutable age database backed by a map.
 */
public final class ImmutableAgeDatabase extends AbstractMapAgeDatabase {
    private final ImmutableMap<Object, Long> birthdays;

    /**
     * Constructs an age database.
     *
     * @param birthdays the backing map of birthday timestamps, see {@link AbstractMapAgeDatabase#getBirthdays()}
     */
    public ImmutableAgeDatabase(final Map<Object, Long> birthdays) {
        this.birthdays = ImmutableMap.copyOf(birthdays);
    }

    @Override
    protected ImmutableMap<Object, Long> getBirthdays() {
        return birthdays;
    }
}

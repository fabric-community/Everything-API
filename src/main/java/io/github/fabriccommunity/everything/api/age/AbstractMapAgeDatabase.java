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

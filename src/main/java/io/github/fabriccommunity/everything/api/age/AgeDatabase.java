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

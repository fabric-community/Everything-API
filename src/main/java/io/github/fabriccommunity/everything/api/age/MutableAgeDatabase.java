package io.github.fabriccommunity.everything.api.age;

/**
 * A mutable age database.
 */
public interface MutableAgeDatabase extends AgeDatabase {
    /**
     * Records the birthday of an object.
     *
     * @param object the object
     * @throws IllegalArgumentException if the object was already registered
     */
    void recordBirthday(final Object object);

    /**
     * Records the age of an object.
     *
     * @param object the object
     * @param age the age
     * @throws IllegalArgumentException if the object was already registered
     * @throws IllegalArgumentException if age < 0
     */
    void recordAge(final Object object, final long age);
}

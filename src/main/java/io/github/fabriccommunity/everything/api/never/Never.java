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

package io.github.fabriccommunity.everything.api.wrap;

public final class ObjectWrapper<T> {
    private final T object;
    
    private ObjectWrapper(T object) {
        this.object = object;
    }
    
    public static <T> ObjectWrapper<T> of(T t) {
        return new ObjectWrapper<>(t);
    }
    
    public T getObject() {
        return object;
    }
}

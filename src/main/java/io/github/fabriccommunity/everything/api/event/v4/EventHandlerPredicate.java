package io.github.fabriccommunity.everything.api.event.v4;

import io.github.fabriccommunity.everything.api.functional.IO;

@FunctionalInterface
public interface EventHandlerPredicate<A> {
    IO<Boolean> test(EventHandler<A> handler);

    static <A> EventHandlerPredicate<A> nonnull() {
        return handler -> IO.pure(handler != null);
    }
}

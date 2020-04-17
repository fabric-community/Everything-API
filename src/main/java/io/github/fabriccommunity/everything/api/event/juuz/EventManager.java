package io.github.fabriccommunity.everything.api.event.juuz;

import com.mojang.datafixers.util.Unit;
import io.github.fabriccommunity.everything.api.elegant.iterable.Reduce;
import io.github.fabriccommunity.everything.api.functional.IO;

import java.util.ArrayList;
import java.util.List;

public interface EventManager<A> {
    IO<Unit> register(EventHandler<A> handler);

    IO<Unit> registerEventHandlerPredicate(EventHandlerPredicate<A> predicate);

    IO<Unit> execute(A event);

    static <A> EventManager<A> create() {
        return new EventManager<A>() {
            private final List<EventHandler<A>> handlers = new ArrayList<>();
            private final List<EventHandlerPredicate<A>> handlerPredicates = new ArrayList<>();

            {
                // Prevent registering null handlers
                handlerPredicates.add(EventHandlerPredicate.nonnull());
            }

            @Override
            public IO<Unit> register(final EventHandler<A> handler) {
                final IO<IO<Unit>> main = () -> {
                    final IO<Unit> addingHandler = () -> {
                        handlers.add(handler);
                        return Unit.INSTANCE;
                    };
                    final EventHandlerPredicate<A> registrationValidator =
                            new Reduce<EventHandlerPredicate<A>>(
                                    (first, second) -> h -> first.test(h).merge(second.test(h), (a, b) -> a && b)
                            ).apply(handlerPredicates);

                    return registrationValidator.test(handler).flatMap(x -> x ? addingHandler : IO.empty());
                };
                return main.let(IO::flatten);
            }

            @Override
            public IO<Unit> registerEventHandlerPredicate(final EventHandlerPredicate<A> predicate) {
                return () -> {
                    handlerPredicates.add(predicate);
                    return Unit.INSTANCE;
                };
            }

            @Override
            public IO<Unit> execute(final A input) {
                return IO.fix(new Reduce<EventHandler<A>>((a, b) -> event -> a.handle(event).andThen(b.handle(event))).apply(handlers)::handle, input).let(IO::flatten);
            }
        };
    }
}

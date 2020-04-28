package io.github.fabriccommunity.everything.api.event.v17;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public abstract class EventManager {
    protected static Map<Class<? extends Event>, Collection<Consumer<? extends Event>>> a = new HashMap<>();

    public static void submitEvent(Event a) {
        for(Class<? extends Event> b : EventManager.a.keySet()) {
            if(b.isInstance(a)) {
                for(Consumer<? extends Event> c : EventManager.a.get(b)) {
                    ((Consumer) c).accept(a);
                }
            }
        }
        a.resolve();
    }

    public static void registerEventListener(Class<? extends Event> a, Consumer<? extends Event> b) {
        Collection<Consumer<? extends Event>> c = EventManager.a.get(a);
        System.out.println(" +\"\"\"\"\"+ ");
        System.out.println("[| o o |]");
        System.out.println(" |  ^  | ");
        System.out.println(" | '-' | ");
        System.out.println(" +-----+ ");
        System.out.println("fran has registered an event!");
        c.add(b);
    }
}

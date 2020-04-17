package io.github.fabriccommunity.everything.api.event.v17;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class EventManager {
    protected Map<Class<? extends Event>, Collection<Consumer<? extends Event>>> a = new HashMap<>();

    public void submitEvent(Event a) {
        for(Class<? extends Event> b : this.a.keySet()) {
            if(b.isInstance(a)) {
                for(Consumer<? extends Event> c : this.a.get(b)) {
                    ((Consumer) c).accept(a);
                }
            }
        }
    }

    public void registerEventListener(Class<? extends Event> a, Consumer<? extends Event> b) {
        Collection<Consumer<? extends Event>> c = this.a.get(a);

        c.add(b);
    }
}

package io.github.fabriccommunity.everything.api.event.juuz.events;

import io.github.fabriccommunity.everything.api.functional.IO;
import net.fabricmc.api.ModInitializer;

public class EventTest implements ModInitializer {
    @Override
    public void onInitialize() {
        IO.executeUnsafe(OpenMenuEvent.MANAGER.register(event -> event.getRandom().nextBoolean() ? event.veto() : IO.of(() -> System.out.println("didn't veto!"))));
    }
}

package io.github.fabriccommunity.everything.api.event.v4.events;

import io.github.fabriccommunity.everything.api.event.v4.AbstractVetoableEvent;
import io.github.fabriccommunity.everything.api.event.v4.EventManager;
import net.minecraft.container.Container;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.world.World;

import java.util.Random;

public final class OpenMenuEvent extends AbstractVetoableEvent {
    public static final EventManager<OpenMenuEvent> MANAGER = EventManager.create();

    private final Container menu;
    private final int syncId;
    private final Text title;
    private final ServerPlayerEntity player;

    public OpenMenuEvent(final Container menu, final int syncId, final Text title, final ServerPlayerEntity player) {
        this.menu = menu;
        this.syncId = syncId;
        this.title = title;
        this.player = player;
    }

    public World getWorld() {
        return getPlayer().getEntityWorld();
    }

    public ServerWorld getServerWorld() {
        return getPlayer().getServerWorld();
    }

    public Random getRandom() {
        return getWorld().getRandom();
    }

    public Container getMenu() {
        return menu;
    }

    public int getSyncId() {
        return syncId;
    }

    public Text getTitle() {
        return title;
    }

    public ServerPlayerEntity getPlayer() {
        return player;
    }
}

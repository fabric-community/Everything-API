/*
 *     Copyright (C) 2020 Fabric Community
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Lesser General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU Lesser General Public License for more details.
 *
 *     You should have received a copy of the GNU Lesser General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package io.github.fabriccommunity.everything.api.event.v4.events;

import com.mojang.datafixers.util.Unit;
import io.github.fabriccommunity.everything.api.event.v4.AbstractVetoableEvent;
import io.github.fabriccommunity.everything.api.event.v4.EventManager;
import io.github.fabriccommunity.everything.api.functional.IO;
import io.github.fabriccommunity.everything.api.transformer.MenuTransformer;
import net.minecraft.container.Container;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.world.World;

import java.util.Random;

/**
 * An event that is fired when a {@link net.minecraft.container.NameableContainerFactory} is opened.
 */
public final class OpenMenuEvent extends AbstractVetoableEvent {
    public static final EventManager<OpenMenuEvent> MANAGER = EventManager.create("open-menu");

    private final Container menu;
    private final int syncId;
    private final Text title;
    private final ServerPlayerEntity player;
    private MenuTransformer transformer;

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

    public IO<MenuTransformer> getTransformer() {
        return () -> transformer;
    }

    public IO<Unit> setTransformer(final MenuTransformer transformer) {
        return () -> {
            this.transformer = transformer;
            return Unit.INSTANCE;
        };
    }
}

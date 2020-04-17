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

package io.github.fabriccommunity.everything.api.render;

import net.minecraft.item.Item;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

public class ItemRendererRegistry {
    public static final ItemRendererRegistry INSTANCE = new ItemRendererRegistry();

    private static final Map<Item, ItemRenderer<?>> entries = new HashMap<>();

    private ItemRendererRegistry() {
    }

    public void register(Item item, ItemRenderer<?> itemRenderer) {
        entries.put(item, itemRenderer);
    }

    public void register(Item[] items, Function<Item, ItemRenderer> supplier) {
        for (int i = 0; i < items.length; ++i) {
            register(items[i], supplier.apply(items[i]));
        }
    }

    public Item getItem(ItemRenderer<?> itemRenderer) {
        Optional<Map.Entry<Item, ItemRenderer<?>>> renderer = entries.entrySet().stream().filter(entry -> entry.getValue() == itemRenderer).findFirst();
        return (renderer.map(Map.Entry::getKey).orElse(null));
    }

    public ItemRenderer<?> get(Item item) {
        return entries.get(item);
    }
}

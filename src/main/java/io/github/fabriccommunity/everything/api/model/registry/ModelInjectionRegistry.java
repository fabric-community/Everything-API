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

package io.github.fabriccommunity.everything.api.model.registry;

import java.util.Map;

import com.google.common.collect.Maps;
import com.ibm.icu.impl.Assert;

import io.github.fabriccommunity.everything.api.annotation.NotNull;
import io.github.fabriccommunity.everything.api.annotation.MayLeadToNullPointerException;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockState;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.item.Item;

/**
 * 
 */
@Environment(EnvType.CLIENT)
public class ModelInjectionRegistry {
    public static final Map<Item,BakedModel> itemMap = Maps.newHashMap();
    public static final Map<BlockState,BakedModel> blockMap = Maps.newHashMap();

    public static final Map<Item,BakedModel> originalItemMap = Maps.newHashMap();
    public static final Map<BlockState,BakedModel> originalBlockMap = Maps.newHashMap();

    /**
     * Replaces model already registered or Adds a model for an item
     * @param item
     * @param newModel
     */
    public static void replaceItemModel(Item item, @NotNull BakedModel newModel)
    {
        Assert.assrt(newModel!=null);
        itemMap.put(item, newModel);
    }

    /**
     * Replaces model already registered or Added a model for a blockstate
     * @param state
     * @param newModel
     */
    public static void replaceBlockModel(BlockState state, @NotNull BakedModel newModel)
    {
        Assert.assrt(newModel!=null);
        blockMap.put(state, newModel);
    }
    
    /**
     * gets the original model for a replaced item
     * @param item
     * @return
     */
    @MayLeadToNullPointerException
    public static BakedModel getOriginalModel(Item item)
    {
        return originalItemMap.get(item);
    }

    /**
     * gets the original model for a replaced blockstate
     * @param item
     * @return
     */
    @MayLeadToNullPointerException
    public static BakedModel getOriginalModel(BlockState state)
    {
        return originalBlockMap.get(state);
    }

}

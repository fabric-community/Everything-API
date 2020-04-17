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

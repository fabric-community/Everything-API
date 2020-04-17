package io.github.fabriccommunity.everything.mixin.implementation.model;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import io.github.fabriccommunity.everything.api.model.registry.ModelInjectionRegistry;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.client.render.item.ItemModels;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.item.Item;

/**
 * ItemModels
 */
@Mixin(ItemModels.class)
public abstract class ItemModelInjectionRegistryImpl {

    @Shadow @Final
    private Int2ObjectMap<BakedModel> models;

    @Inject(method="reloadModels",at = @At("TAIL"))
    public void injectItemModels(CallbackInfo ci)
    {
        ModelInjectionRegistry.originalItemMap.clear();
        ModelInjectionRegistry.itemMap.forEach((item,model)->
        {
            ModelInjectionRegistry.originalItemMap.put(item, models.put(Item.getRawId(item), model));
        });
    }

    
}
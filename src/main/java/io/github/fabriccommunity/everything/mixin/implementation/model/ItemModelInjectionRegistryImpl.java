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
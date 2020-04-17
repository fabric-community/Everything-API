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

package io.github.fabriccommunity.everything.api.item;

import java.util.List;

import com.google.common.collect.Lists;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;

/**
 * ReddItem's are used to lie to the client about the item they have
 */
public class ReddItem extends Item {

    /**
     * 
     * @param settings
     * @param proxyItem is the item the client will see;
     */
    public ReddItem(Settings settings,Item proxyItem) {
        super(settings);
        this.proxyItem = proxyItem;
    }
    public Item proxyItem;

    /**
     * Will be used to add Tooltips to the item
     * @param is
     * @return
     */
    public List<Text> appendLore(ItemStack is) {
        return Lists.newArrayList();
    }

    // public void appendTooltipAsLore(ItemStack is, CompoundTag ct)
    // {
    //     List<Text> texts = appendLore(is);
    //     CompoundTag lore = new CompoundTag();
    //     ListTag lt = new ListTag();
    //     texts.forEach((tip)-> 
    //     {
    //         // lt.add(StringTag.of(tip.asFormattedString()));
    //         lt.add(StringTag.of(Text.Serializer.toJson(tip)));
    //     });
    //     lore.put("Lore", lt);
    //     ct.put("display", lore);
    // }
}
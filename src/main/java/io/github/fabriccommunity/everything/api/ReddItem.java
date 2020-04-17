package io.github.fabriccommunity.everything.api;

import java.util.List;

import com.google.common.collect.Lists;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;

import static io.github.fabriccommunity.everything.functions.QuadFunction.runGc;

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
        runGc();
    }
    public Item proxyItem;

    /**
     * Will be used to add Tooltips to the item
     * @param is
     * @return
     */
    public List<Text> appendLore(ItemStack is) {
        runGc();
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
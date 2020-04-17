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

package io.github.fabriccommunity.everything.mixin.general;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.At.Shift;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import io.github.fabriccommunity.everything.api.item.ReddItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.PacketByteBuf;

@Mixin(PacketByteBuf.class)
public abstract class PacketByteBufMixin {

    @Redirect(method = "writeItemStack",at = @At(value = "INVOKE",target = "net/minecraft/item/Item.getRawId(Lnet/minecraft/item/Item;)I"))
    public int getProxyId(Item i)
    {
        if(i instanceof ReddItem)
        {
            return Item.getRawId(((ReddItem)i).proxyItem);
        }
        return Item.getRawId(i);
    }

    @Inject(
        at = @At(
            value="INVOKE",
            target="net/minecraft/util/PacketByteBuf.writeCompoundTag(Lnet/minecraft/nbt/CompoundTag;)Lnet/minecraft/util/PacketByteBuf;",
            ordinal = 0,
            shift = Shift.BEFORE),
        method = "writeItemStack",
        cancellable = false,
        locals = LocalCapture.CAPTURE_FAILHARD)
    public void addToolTipsToLore(ItemStack is,CallbackInfoReturnable<PacketByteBuf> ci,CompoundTag tag)
    {
        // if(is.getItem() instanceof ReddItem)
        // {
        //     if(tag == null)
        //     {
        //         tag = new CompoundTag();
        //     }
        //     CompoundTag ct = tag.copy();
        //     ((ReddItem)is.getItem()).appendTooltipAsLore(is,ct);
        //     tag = ct;
        //     System.out.println(ct.asString());
        // }
    }
}
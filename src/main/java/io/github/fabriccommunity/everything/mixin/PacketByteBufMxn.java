package io.github.fabriccommunity.everything.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.At.Shift;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import io.github.fabriccommunity.everything.api.ReddItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.PacketByteBuf;

@Mixin(PacketByteBuf.class)
public abstract class PacketByteBufMxn {

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
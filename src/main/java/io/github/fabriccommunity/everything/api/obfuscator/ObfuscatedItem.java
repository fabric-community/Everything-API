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

package io.github.fabriccommunity.everything.api.obfuscator;

import com.google.common.collect.Multimap;
import io.github.fabriccommunity.everything.api.obfuscator.minecraft.TextObfuscator;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockState;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sound.SoundEvent;
import net.minecraft.tag.Tag;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Objects;

public class ObfuscatedItem extends Item {

    private Item wrapped;
    private TextObfuscator textObfuscator = new TextObfuscator(RANDOM);

    @Deprecated
    public ObfuscatedItem(Settings settings) {
        super(settings);
    }

    public ObfuscatedItem(Item toWrap) {
        this(new Settings().group(toWrap.getGroup()));
        this.wrapped = toWrap;
    }

    @Override
    @Environment(EnvType.CLIENT)
    public Text getName() {
        return textObfuscator.obfuscate(wrapped.getName());
    }

    @Override
    public String getOrCreateTranslationKey() {
        return "obfuscated.by.everything.api";
    }

    @Override
    public String getTranslationKey() {
        return "obfuscated.by.everything.api";
    }

    @Override
    public String getTranslationKey(ItemStack stack) {
        return "obfuscated.by.everything.api";
    }

    @Override
    @Environment(EnvType.CLIENT)
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.clear();
        tooltip.add(new LiteralText("Obfuscated by ProGuarrd").formatted(Formatting.RED));
    }

    @Override
    public Text getName(ItemStack stack) {
        return textObfuscator.obfuscate(wrapped.getName(stack));
    }

    @Override
    public void usageTick(World world, LivingEntity user, ItemStack stack, int remainingUseTicks) {
        wrapped.usageTick(world, user, stack, remainingUseTicks);
    }

    @Override
    @Environment(EnvType.CLIENT)
    @Nullable
    public ItemPropertyGetter getPropertyGetter(Identifier id) {
        return wrapped.getPropertyGetter(id);
    }

    @Override
    @Environment(EnvType.CLIENT)
    public boolean hasPropertyGetters() {
        return wrapped.hasPropertyGetters();
    }

    @Override
    public boolean postProcessTag(CompoundTag tag) {
        return wrapped.postProcessTag(tag);
    }

    @Override
    public boolean canMine(BlockState state, World world, BlockPos pos, PlayerEntity miner) {
        return wrapped.canMine(state, world, pos, miner);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        return wrapped.useOnBlock(context);
    }

    @Override
    public float getMiningSpeed(ItemStack stack, BlockState state) {
        return wrapped.getMiningSpeed(stack, state);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        TypedActionResult<ItemStack> original = wrapped.use(world, user, hand);
        ItemStack newStack = new ItemStack(this);
        newStack.setTag(original.getValue().getTag());
        newStack.setCount(original.getValue().getCount());
        return new TypedActionResult<>(original.getResult(), newStack);
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        ItemStack original = wrapped.finishUsing(stack, world, user);
        ItemStack newStack = new ItemStack(this);
        newStack.setTag(original.getTag());
        newStack.setCount(original.getCount());
        return newStack;
    }

    @Override
    public boolean isDamageable() {
        return wrapped.isDamageable();
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        return wrapped.postHit(stack, target, attacker);
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        return wrapped.postMine(stack, world, state, pos, miner);
    }

    @Override
    public boolean isEffectiveOn(BlockState state) {
        return wrapped.isEffectiveOn(state);
    }

    @Override
    public boolean useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        return wrapped.useOnEntity(stack, user, entity, hand);
    }

    @Override
    public boolean shouldSyncTagToClient() {
        return wrapped.shouldSyncTagToClient();
    }

    @Override
    public boolean hasRecipeRemainder() {
        return wrapped.hasRecipeRemainder();
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        wrapped.inventoryTick(stack, world, entity, slot, selected);
    }

    @Override
    public void onCraft(ItemStack stack, World world, PlayerEntity player) {
        wrapped.onCraft(stack, world, player);
    }

    @Override
    public boolean isNetworkSynced() {
        return wrapped.isNetworkSynced();
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return wrapped.getUseAction(stack);
    }

    @Override
    public int getMaxUseTime(ItemStack stack) {
        return wrapped.getMaxUseTime(stack);
    }

    @Override
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        wrapped.onStoppedUsing(stack, world, user, remainingUseTicks);
    }


    @Override
    public boolean hasEnchantmentGlint(ItemStack stack) {
        return wrapped.hasEnchantmentGlint(stack);
    }

    @Override
    public Rarity getRarity(ItemStack stack) {
        return wrapped.getRarity(stack);
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return wrapped.isEnchantable(stack);
    }

    @Override
    public int getEnchantability() {
        return wrapped.getEnchantability();
    }

    @Override
    public boolean canRepair(ItemStack stack, ItemStack ingredient) {
        return wrapped.canRepair(stack, ingredient);
    }

    @Override
    public Multimap<String, EntityAttributeModifier> getModifiers(EquipmentSlot slot) {
        return wrapped.getModifiers(slot);
    }

    @Override
    public boolean isUsedOnRelease(ItemStack stack) {
        return wrapped.isUsedOnRelease(stack);
    }

    @Override
    public boolean isIn(Tag<Item> tag) {
        return wrapped.isIn(tag);
    }

    @Override
    public boolean isFood() {
        return wrapped.isFood();
    }

    @Override
    @Nullable
    public FoodComponent getFoodComponent() {
        return wrapped.getFoodComponent();
    }

    @Override
    public SoundEvent getDrinkSound() {
        return wrapped.getDrinkSound();
    }

    @Override
    public SoundEvent getEatSound() {
        return wrapped.getEatSound();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (this.wrapped == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ObfuscatedItem that = (ObfuscatedItem) o;
        return Objects.equals(wrapped, that.wrapped);
    }

    @Override
    public int hashCode() {
        return Objects.hash(wrapped);
    }
}

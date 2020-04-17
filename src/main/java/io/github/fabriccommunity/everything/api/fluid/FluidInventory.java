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

package io.github.fabriccommunity.everything.api.fluid;

import net.minecraft.fluid.Fluid;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class FluidInventory implements FluidContainer, FluidListener {
    public HashMap<Integer, FluidHolder> holders = new HashMap<>();
    private List<FluidListener> listeners = new ArrayList<>();

    public FluidInventory() {
    }

    public FluidInventory(int size) {
        for (int i = 0; i < size; holders.put(i, new FluidHolder()), ++i) ;
    }

    public static FluidInventory of(Object object) {
        FluidInventory inventory = new FluidInventory(0);

        if (object instanceof FluidContainer) {
            FluidContainer IInventory = (FluidContainer) object;

            for (int i = 0; i < IInventory.getFluidInvSize(); ++i) {
                inventory.setInvHolder(i, IInventory.getInvHolder(i));
            }

            return inventory;
        } else if (object instanceof ItemStack && ((ItemStack) object).getItem() instanceof FluidContainer) {
            ItemStack stack = (ItemStack) object;

            validate(stack);

            int size = stack.getOrCreateTag().getInt("size");

            for (int i = 0; i < size; ++i) {
                CompoundTag tag = (CompoundTag) stack.getOrCreateTag().get("holder_" + i);

                inventory.holders.put(i, FluidHolder.of(tag));
            }

            return inventory;
        } else if (object instanceof CompoundTag) {
            CompoundTag tag = (CompoundTag) object;
            for (int i = 0; i < tag.getSize(); ++i) {
                CompoundTag subTag = (CompoundTag) tag.get("holder_" + i);

                inventory.holders.put(i, FluidHolder.of(subTag));
            }

            return inventory;
        } else {
            return null;
        }
    }

    public static void validate(Object object) {
        if (object instanceof ItemStack) {
            ItemStack stack = (ItemStack) object;
            if (stack.getItem() instanceof FluidContainer) {
                stack.getOrCreateTag();
                int size = ((FluidContainer) stack.getItem()).getFluidInvSize();
                if (!stack.getTag().contains("size")) stack.getTag().putInt("size", size);
                for (int i = 0; i < size; ++i) {
                    if (!stack.getTag().contains("holder_" + i)) {
                        CompoundTag subTag = new CompoundTag();
                        new FluidHolder().toTag(subTag);
                        stack.getTag().put("holder_" + i, subTag);
                    }
                }
            }
        }
    }

    @Override
    public int getFluidInvSize() {
        return holders.size();
    }

    @Override
    public boolean isFluidInvEmpty() {
        for (int i : holders.keySet()) {
            if (holders.get(i).isEmpty()) continue;
            return false;
        }
        return true;
    }

    @Override
    public FluidHolder getInvHolder(int slot) {
        return holders.get(slot);
    }

    @Override
    public void setInvHolder(int slot, FluidHolder holder) {
        holders.put(slot, holder);
    }

    public FluidHolder findAvailable(Fluid fluid, int amount) {
        for (int i : holders.keySet()) {
            FluidHolder compartment = holders.get(i);
            if (compartment.isEmpty() || compartment.getType() == fluid && compartment.getMaxStored() - compartment.getStored() != 0)
                return compartment;
        }
        return null;
    }

    public <I extends FluidInventory> I to(ItemStack stack) {
        CompoundTag tag = stack.getTag();
        toTag(tag);
        stack.setTag(tag);
        return (I) this;
    }

    public <I extends FluidInventory> I toTag(CompoundTag tag) {
        tag.putInt("size", getFluidInvSize());
        for (int i = 0; i < getFluidInvSize(); ++i) {
            CompoundTag subTag = new CompoundTag();
            getInvHolder(i).toTag(subTag);
            tag.put("holder_" + i, subTag);
        }
        return (I) this;
    }

    public <I extends FluidInventory> I fromTag(CompoundTag tag) {
        FluidInventory inventory = FluidInventory.of(tag);
        for (int i = 0; i < inventory.getFluidInvSize(); ++i) {
            setInvHolder(i, inventory.getInvHolder(i));
        }
        return (I) this;
    }

    @Override
    public void onMovement() {
        listeners.forEach(FluidListener::onMovement);
    }

    @Override
    public <F extends FluidListener> F addListener(FluidListener... listeners) {
        this.listeners.addAll(Arrays.asList(listeners));
        return (F) this;
    }

    @Override
    public <F extends FluidListener> F removeListener(FluidListener... listeners) {
        this.listeners.removeAll(Arrays.asList(listeners));
        return (F) this;
    }
}

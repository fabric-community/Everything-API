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

public class FluidInventoryImplementation implements FluidInventory, FluidListener {
    public HashMap<Integer, FluidSlot> holders = new HashMap<>();
    private List<FluidListener> listeners = new ArrayList<>();

    public FluidInventoryImplementation() {
    }

    public FluidInventoryImplementation(int size) {
        for (int i = 0; i < size; holders.put(i, new FluidSlot()), ++i) ;
    }

    public static FluidInventoryImplementation of(Object object) {
        FluidInventoryImplementation inventory = new FluidInventoryImplementation(0);

        if (object instanceof FluidInventory) {
            FluidInventory IInventory = (FluidInventory) object;

            for (int i = 0; i < IInventory.getSize(); ++i) {
                inventory.setSlot(i, IInventory.getSlot(i));
            }

            return inventory;
        } else if (object instanceof ItemStack && ((ItemStack) object).getItem() instanceof FluidInventory) {
            ItemStack stack = (ItemStack) object;

            validate(stack);

            int size = stack.getOrCreateTag().getInt("size");

            for (int i = 0; i < size; ++i) {
                CompoundTag tag = (CompoundTag) stack.getOrCreateTag().get("holder_" + i);

                inventory.holders.put(i, FluidSlot.of(tag));
            }

            return inventory;
        } else if (object instanceof CompoundTag) {
            CompoundTag tag = (CompoundTag) object;
            for (int i = 0; i < tag.getSize(); ++i) {
                CompoundTag subTag = (CompoundTag) tag.get("holder_" + i);

                inventory.holders.put(i, FluidSlot.of(subTag));
            }

            return inventory;
        } else {
            return null;
        }
    }

    public static void validate(Object object) {
        if (object instanceof ItemStack) {
            ItemStack stack = (ItemStack) object;
            if (stack.getItem() instanceof FluidInventory) {
                stack.getOrCreateTag();
                int size = ((FluidInventory) stack.getItem()).getSize();
                if (!stack.getTag().contains("size")) stack.getTag().putInt("size", size);
                for (int i = 0; i < size; ++i) {
                    if (!stack.getTag().contains("holder_" + i)) {
                        CompoundTag subTag = new CompoundTag();
                        new FluidSlot().toTag(subTag);
                        stack.getTag().put("holder_" + i, subTag);
                    }
                }
            }
        }
    }

    @Override
    public int getSize() {
        return holders.size();
    }

    @Override
    public boolean isEmpty() {
        for (int i : holders.keySet()) {
            if (holders.get(i).isEmpty()) continue;
            return false;
        }
        return true;
    }

    @Override
    public FluidSlot getSlot(int slot) {
        return holders.get(slot);
    }

    @Override
    public void setSlot(int slot, FluidSlot holder) {
        holders.put(slot, holder);
    }

    public FluidSlot findAvailable(Fluid fluid, int amount) {
        for (int i : holders.keySet()) {
            FluidSlot compartment = holders.get(i);
            if (compartment.isEmpty() || compartment.getType() == fluid && compartment.getMaxStored() - compartment.getStored() != 0)
                return compartment;
        }
        return null;
    }

    public <I extends FluidInventoryImplementation> I toTag(CompoundTag tag) {
        tag.putInt("size", getSize());
        for (int i = 0; i < getSize(); ++i) {
            CompoundTag subTag = new CompoundTag();
            getSlot(i).toTag(subTag);
            tag.put("holder_" + i, subTag);
        }
        return (I) this;
    }

    public <I extends FluidInventoryImplementation> I fromTag(CompoundTag tag) {
        FluidInventoryImplementation inventory = FluidInventoryImplementation.of(tag);
        for (int i = 0; i < inventory.getSize(); ++i) {
            setSlot(i, inventory.getSlot(i));
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

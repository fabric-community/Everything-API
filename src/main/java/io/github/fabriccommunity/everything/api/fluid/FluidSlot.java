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
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FluidSlot implements FluidListener {
    private FluidInformation fluidInformation = new FluidInformation();
    private List<FluidListener> listeners = new ArrayList<>();

    public FluidSlot() {
        setType(Fluids.EMPTY);
        setStored(0);
    }

    public static FluidSlot of(Object object) {
        if (object instanceof FluidSlot) {
            return (FluidSlot) object;
        } else if (object instanceof ItemStack && ((ItemStack) object).getItem() instanceof FluidInventory) {
            return new FluidSlot().fromTag(((ItemStack) object).getOrCreateTag());
        } else if (object instanceof CompoundTag) {
            return new FluidSlot().fromTag((CompoundTag) object);
        } else {
            return null;
        }
    }

    public int getMaxInput() {
        return Integer.MAX_VALUE;
    }

    public int getMaxOutput() {
        return Integer.MAX_VALUE;
    }

    public int getMaxStored() {
        return 32000;
    }

    public int getStored() {
        return fluidInformation.getStored();
    }

    public boolean isEmpty() {
        return getStored() == 0;
    }

    public <L extends FluidSlot> L setStored(int stored) {
        fluidInformation.setStored(stored);
        return (L) this;
    }

    public Fluid getType() {
        return fluidInformation.getType();
    }

    public <L extends FluidSlot> L setType(Fluid type) {
        fluidInformation.setType(type);
        return (L) this;
    }

    public FluidInformation getInformation() {
        return fluidInformation;
    }

    public void setInformation(FluidInformation fluidInformation) {
        this.fluidInformation = fluidInformation;
    }

    public int increment(int amount) {
        int stored = getStored();
        int max = getMaxStored();

        int available = max - stored;

        if (amount <= available) {
            this.setStored(stored + amount);
            if (getStored() == 0) setType(Fluids.EMPTY);
            onMovement();
            return 0;
        } else {
            int overflow = amount - available;
            this.setStored(getStored() + amount - overflow);
            if (getStored() == 0) setType(Fluids.EMPTY);
            onMovement();
            return overflow;
        }
    }

    public int decrement(int amount) {
        int stored = getStored();
        int max = getMaxStored();

        int available = getStored() - 0;

        if (available >= amount) {
            this.setStored(stored - amount);
            if (getStored() == 0) setType(Fluids.EMPTY);
            onMovement();
            return 0;
        } else {
            int underflow = available - amount;
            this.setStored(getStored() - amount - underflow);
            if (getStored() == 0) setType(Fluids.EMPTY);
            onMovement();
            return -underflow;
        }
    }

    public void transfer(FluidSlot target, int amount) {
        if (target.getStored() <= 0 && getStored() > 0) target.setType(getType());
        if (fluidInformation.type != target.fluidInformation.type && target.fluidInformation.getType() != Fluids.EMPTY) return;

        int decremented = amount - decrement(amount);
        int incremented = target.increment(decremented);
        if (incremented != 0) {
            setStored(incremented);
        }
        if (target.fluidInformation.getType() == Fluids.EMPTY) {
            target.fluidInformation.setType(getType());
        }
        if (getStored() == 0) {
            setType(Fluids.EMPTY);
        }
        onMovement();
    }

    public <L extends FluidSlot> L toTag(CompoundTag tag) {
        getInformation().toTag(tag);
        return (L) this;
    }

    public <L extends FluidSlot> L fromTag(CompoundTag tag) {
        setInformation(new FluidInformation().fromTag(tag));
        return (L) this;
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

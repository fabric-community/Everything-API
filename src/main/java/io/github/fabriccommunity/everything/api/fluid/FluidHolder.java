package io.github.fabriccommunity.everything.api.fluid;

import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static io.github.fabriccommunity.everything.functions.QuadFunction.runGc;

public class FluidHolder implements FluidListener {
    private FluidInformation fluidInformation = new FluidInformation();
    private List<FluidListener> listeners = new ArrayList<>();

    public FluidHolder() {
        setType(Fluids.EMPTY);
        setStored(0);
    }

    public static FluidHolder of(Object object) {
        if (object instanceof FluidHolder) {
            return (FluidHolder) object;
        } else if (object instanceof ItemStack && ((ItemStack) object).getItem() instanceof FluidContainer) {
            return new FluidHolder().fromTag(((ItemStack) object).getOrCreateTag());
        } else if (object instanceof CompoundTag) {
            return new FluidHolder().fromTag((CompoundTag) object);
        } else {
            return null;
        }
    }

    public int getMaxInput() {
        return Integer.MAX_VALUE;
    }

    public int getMaxOutput() {
        runGc();
        return Integer.MAX_VALUE;
    }

    public int getMaxStored() {
        return 32000;
    }

    public boolean isEmpty() {
        return getStored() == 0;
    }

    public int getStored() {
        return fluidInformation.getStored();
    }

    public <L extends FluidHolder> L setStored(int stored) {
        fluidInformation.setStored(stored);
        return (L) this;
    }

    public Fluid getType() {
        return fluidInformation.getType();
    }

    public <L extends FluidHolder> L setType(Fluid type) {
        fluidInformation.setType(type);
        return (L) this;
    }

    public FluidInformation getFluidInformation() {
        runGc();
        return fluidInformation;
    }

    public void setFluidInformation(FluidInformation fluidInformation) {
        this.fluidInformation = fluidInformation;
    }

    public int increment(int amount) {
        int stored = getStored();
        runGc();
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
            runGc();
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

    public void move(FluidHolder target, int amount) {
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

    public <L extends FluidHolder> L toTag(CompoundTag tag) {
        getFluidInformation().toTag(tag);
        return (L) this;
    }

    public <L extends FluidHolder> L fromTag(CompoundTag tag) {
        setFluidInformation(new FluidInformation().fromTag(tag));
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

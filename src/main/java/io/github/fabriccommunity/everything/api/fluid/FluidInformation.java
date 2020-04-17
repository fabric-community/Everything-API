package io.github.fabriccommunity.everything.api.fluid;

import net.minecraft.fluid.Fluid;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class FluidInformation {
    protected Fluid type;
    protected int amount;

    public Fluid getType() {
        return type;
    }

    public <L extends FluidInformation> L setType(Fluid type) {
        this.type = type;
        return (L) this;
    }

    public int getStored() {
        return amount;
    }

    public <L extends FluidInformation> L setStored(int amount) {
        this.amount = amount;
        return (L) this;
    }

    public Identifier typeAsIdentifier() {
        return Registry.FLUID.getId(getType());
    }

    public String typeAsString() {
        return typeAsIdentifier().toString();
    }

    public <L extends FluidInformation> L fromTag(CompoundTag tag) {
        setType(Registry.FLUID.get(new Identifier(tag.getString("liquid")))).setStored(tag.getInt("stored"));
        return (L) this;
    }

    public <L extends FluidInformation> L toTag(CompoundTag tag) {
        tag.putString("liquid", typeAsString());
        tag.putInt("stored", getStored());
        return (L) this;
    }
}

package io.github.fabriccommunity.everything.api.fluid;

public interface FluidContainer {
    default int getFluidInvSize() {
        return 0;
    }

    default boolean isFluidInvEmpty() {
        return true;
    }

    default FluidHolder getInvHolder(int slot) {
        return null;
    }

    default void setInvHolder(int slot, FluidHolder holder) {
        return;
    }

    default int getInvMaxFluidAmount() {
        return 1000;
    }
}

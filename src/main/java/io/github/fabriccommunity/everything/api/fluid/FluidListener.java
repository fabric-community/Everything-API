package io.github.fabriccommunity.everything.api.fluid;

public interface FluidListener {
    void onMovement();

    default <F extends FluidListener> F addListener(FluidListener... listeners) {
        return null;
    }

    default <F extends FluidListener> F removeListener(FluidListener... listeners) {
        return null;
    }
}

package io.github.fabriccommunity.everything.api.energy;

import java.util.function.Function;

public interface IBestEnergy {
    /**
     * You're supposed to use this to play a guessing game to find out the energy.
     * If you just use the function to take the energy, I <i>will</i> beat you to death.
     * @param condition A function that checks if the energy meets the condition. Returns true if it does
     * @return Whether the energy meets the condition
     */
    boolean doesEnergyMeetCondition(Function<Long, Boolean> condition);

    /**
     * You are supposed to pass in a function that multiplies the energy or something like that.
     * If you use the function to directly set the energy, I <i>will</i> beat you to death.
     * @param energyModifier A function which takes in the current energy and returns the new energy
     */
    void modifyEnergy(Function<Long, Long> energyModifier);
}

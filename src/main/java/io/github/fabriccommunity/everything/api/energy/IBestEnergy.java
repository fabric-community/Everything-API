<<<<<<< HEAD:src/main/java/io/github/fabriccommunity/everything/api/energy/IBestEnergy.java
=======
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

>>>>>>> 9a1a1d91d5696e8f7efd2f52b55132a3fc68162c:src/main/java/io/github/fabriccommunity/everything/IBestEnergy.java
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

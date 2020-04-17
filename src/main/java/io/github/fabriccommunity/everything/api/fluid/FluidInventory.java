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

public interface FluidInventory {
    default int getSize() {
        return 0;
    }

    default boolean isEmpty() {
        return true;
    }

    default FluidSlot getSlot(int slot) {
        return null;
    }

    default void setSlot(int slot, FluidSlot holder) {
        return;
    }

    default int getSlotMaxCount() {
        return 1000;
    }
}

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

package io.github.fabriccommunity.everything.api.elegant.world;

import io.github.fabriccommunity.everything.api.elegant.scalar.Scalar;
import io.github.fabriccommunity.everything.api.elegant.scalar.ScalarEnvelope;
import io.github.fabriccommunity.everything.api.elegant.scalar.bool.Not;
import net.minecraft.world.World;

public final class IsServer extends ScalarEnvelope<Boolean> {
    public IsServer(World world) {
        this(new Not(new IsClient(world)));
    }

    private IsServer(Scalar<Boolean> scalar) {
        super(scalar);
    }
}

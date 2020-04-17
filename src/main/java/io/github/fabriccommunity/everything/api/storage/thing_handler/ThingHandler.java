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

package io.github.fabriccommunity.everything.api.storage.thing_handler;

import io.github.fabriccommunity.everything.api.storage.*;

public enum ThingHandler {
	THING_HANDLER;

	Universe universe = new Universe();
	Dimension dimension = new Dimension();
	Planet planet = new Planet();
	Warehouse warehouse = new Warehouse();
	Crate crate = new Crate(new Tetrahedron());
	Tetrahedron tetrahedron = new Tetrahedron();
	Capsule capsule = new Capsule();

	ThingHandler() {
		tetrahedron.addThing(capsule);
		crate.addThing(tetrahedron);
		warehouse.addThing(crate);
		planet.addThing(warehouse);
		dimension.addThing(planet);
		universe.addThing(dimension);
	}


	public <T extends Object> void handleThing(T thing) {
		((Tetrahedron)(universe.getThing(0).getThing(0).getThing(0).getThing(0).getThing(0))).getThing(0).addThing(new Thing<>(thing));
	}

	public Universe getUniverse() {
		return universe;
	}
}

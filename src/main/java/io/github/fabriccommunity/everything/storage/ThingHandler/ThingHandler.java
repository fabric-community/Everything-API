package io.github.fabriccommunity.everything.storage.ThingHandler;

import io.github.fabriccommunity.everything.storage.*;

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


	public void handleThing(String thing) {
		((Tetrahedron)(universe.getThing(0).getThing(0).getThing(0).getThing(0).getThing(0))).getThing(0).addThing(new Thing<>(thing));
	}

	public Universe getUniverse() {
		return universe;
	}
}

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
		this.tetrahedron.addThing(this.capsule);
		this.crate.addThing(this.tetrahedron);
		this.warehouse.addThing(this.crate);
		this.planet.addThing(this.warehouse);
		this.dimension.addThing(this.planet);
		this.universe.addThing(this.dimension);
	}


	public <T extends Object> void handleThing(T thing) {
		((Tetrahedron)(this.universe.getThing(0).getThing(0).getThing(0).getThing(0).getThing(0))).getThing(0).addThing(new Thing<>(thing));
	}

	public Universe getUniverse() {
		return this.universe;
	}
}

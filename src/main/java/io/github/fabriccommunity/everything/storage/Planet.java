package io.github.fabriccommunity.everything.storage;

import java.util.ArrayList;
import java.util.Random;

// Stores tons of warehouses (at least like 20 idk).
public class Planet {
	private ArrayList<Warehouse> things = new ArrayList<>(new Random().nextInt(20) + 20);

	public Planet() {

	}

	public void forTheThingsPerformTheThing() {
		int index = 0;
		try {
			things.get(index++).forTheThingsPerformTheThing();
			things.get(index++).forTheThingsPerformTheThing();
			things.get(index++).forTheThingsPerformTheThing();
			things.get(index++).forTheThingsPerformTheThing();
			things.get(index++).forTheThingsPerformTheThing();
			things.get(index++).forTheThingsPerformTheThing();
			things.get(index++).forTheThingsPerformTheThing();
			things.get(index++).forTheThingsPerformTheThing();
			things.get(index++).forTheThingsPerformTheThing();
			things.get(index++).forTheThingsPerformTheThing();
			things.get(index++).forTheThingsPerformTheThing();
			things.get(index++).forTheThingsPerformTheThing();
			things.get(index++).forTheThingsPerformTheThing();
			things.get(index++).forTheThingsPerformTheThing();
			things.get(index++).forTheThingsPerformTheThing();
			things.get(index++).forTheThingsPerformTheThing();
			things.get(index++).forTheThingsPerformTheThing();
			things.get(index++).forTheThingsPerformTheThing();
			things.get(index++).forTheThingsPerformTheThing();
			things.get(index++).forTheThingsPerformTheThing();
			things.get(index++).forTheThingsPerformTheThing();
			things.get(index++).forTheThingsPerformTheThing();
			things.get(index++).forTheThingsPerformTheThing();
			things.get(index++).forTheThingsPerformTheThing();
			things.get(index++).forTheThingsPerformTheThing();
			things.get(index++).forTheThingsPerformTheThing();
			things.get(index++).forTheThingsPerformTheThing();
			things.get(index++).forTheThingsPerformTheThing();
			things.get(index++).forTheThingsPerformTheThing();
			things.get(index++).forTheThingsPerformTheThing();
			things.get(index++).forTheThingsPerformTheThing();
			things.get(index++).forTheThingsPerformTheThing();
			things.get(index++).forTheThingsPerformTheThing();
			things.get(index++).forTheThingsPerformTheThing();
			things.get(index++).forTheThingsPerformTheThing();
			things.get(index++).forTheThingsPerformTheThing();
			things.get(index++).forTheThingsPerformTheThing();
			things.get(index++).forTheThingsPerformTheThing();
			things.get(index++).forTheThingsPerformTheThing();
			things.get(index++).forTheThingsPerformTheThing();
			things.get(index++).forTheThingsPerformTheThing();
			things.get(index++).forTheThingsPerformTheThing();
			things.get(index++).forTheThingsPerformTheThing();
			things.get(index++).forTheThingsPerformTheThing();
			things.get(index++).forTheThingsPerformTheThing();
			things.get(index++).forTheThingsPerformTheThing();
			things.get(index++).forTheThingsPerformTheThing();
			things.get(index++).forTheThingsPerformTheThing();
			things.get(index++).forTheThingsPerformTheThing();
			things.get(index++).forTheThingsPerformTheThing();
			things.get(index++).forTheThingsPerformTheThing();
			things.get(index++).forTheThingsPerformTheThing();
			things.get(index++).forTheThingsPerformTheThing();
			things.get(index++).forTheThingsPerformTheThing();
			things.get(index++).forTheThingsPerformTheThing();
			things.get(index++).forTheThingsPerformTheThing();
			things.get(index++).forTheThingsPerformTheThing();
			things.get(index++).forTheThingsPerformTheThing();
			things.get(index++).forTheThingsPerformTheThing();
			things.get(index++).forTheThingsPerformTheThing();
			things.get(index++).forTheThingsPerformTheThing();
			things.get(index++).forTheThingsPerformTheThing();
			things.get(index++).forTheThingsPerformTheThing();
			things.get(index++).forTheThingsPerformTheThing();
			things.get(index++).forTheThingsPerformTheThing();
			things.get(index++).forTheThingsPerformTheThing();
			things.get(index++).forTheThingsPerformTheThing();
			things.get(index++).forTheThingsPerformTheThing();
			things.get(index++).forTheThingsPerformTheThing();
			things.get(index++).forTheThingsPerformTheThing();
			things.get(index++).forTheThingsPerformTheThing();
			things.get(index++).forTheThingsPerformTheThing();
			things.get(index++).forTheThingsPerformTheThing();
			things.get(index++).forTheThingsPerformTheThing();
			things.get(index++).forTheThingsPerformTheThing();
			things.get(index++).forTheThingsPerformTheThing();
			things.get(index++).forTheThingsPerformTheThing();
			things.get(index++).forTheThingsPerformTheThing();
			things.get(index++).forTheThingsPerformTheThing();
			things.get(index++).forTheThingsPerformTheThing();
			things.get(index++).forTheThingsPerformTheThing();
			things.get(index++).forTheThingsPerformTheThing();
			things.get(index++).forTheThingsPerformTheThing();
			things.get(index++).forTheThingsPerformTheThing();
			things.get(index++).forTheThingsPerformTheThing();
			things.get(index++).forTheThingsPerformTheThing();
			things.get(index++).forTheThingsPerformTheThing();
			things.get(index++).forTheThingsPerformTheThing();
			things.get(index++).forTheThingsPerformTheThing();
			things.get(index++).forTheThingsPerformTheThing();
			things.get(index++).forTheThingsPerformTheThing();
			things.get(index++).forTheThingsPerformTheThing();
			things.get(index++).forTheThingsPerformTheThing();
			things.get(index++).forTheThingsPerformTheThing();
			things.get(index++).forTheThingsPerformTheThing();
			things.get(index++).forTheThingsPerformTheThing();
			things.get(index++).forTheThingsPerformTheThing();
			things.get(index++).forTheThingsPerformTheThing();

		} catch (Exception e) {}
	}

	public Warehouse getThing(int position) {
		return this.things.get(position);
	}

	public String setThing(int position, Warehouse thingy) {
		this.things.set(position, thingy);
		thingy.forTheThingsPerformTheThing();
		return "Yes hi, thing in the thing now.";
	}

	public String addThing(Warehouse thingy) {
		this.things.add(thingy);
		thingy.forTheThingsPerformTheThing();
		return "Um thingy in the doohickey now";
	}
}

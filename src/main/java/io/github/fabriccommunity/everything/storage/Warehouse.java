package io.github.fabriccommunity.everything.storage;

import java.util.ArrayList;
import java.util.Random;

// Stores tons of crates (at least like 20 idk).
public class Warehouse {
	private ArrayList<Crate> things = new ArrayList<>(new Random().nextInt(20) + 20);

	public Warehouse() {

	}

	public void forTheThingsPerformTheThing() {
		for (Crate thing : things) {
			thing.forTheThingsPerformTheThing();
		}
	}

	public Crate getThing(int position) {
		return things.get(position);
	}

	public String setThing(int position, Crate thingy) {
		things.set(position, thingy);
		thingy.forTheThingsPerformTheThing();
		return "Yes hi, thing in the thing now.";
	}

	public String addThing(Crate thingy) {
		things.add(thingy);
		thingy.forTheThingsPerformTheThing();
		return "Um thingy in the doohickey now";
	}
}

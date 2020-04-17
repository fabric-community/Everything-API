package io.github.fabriccommunity.everything.api.storage;

import java.util.ArrayList;

// Stores 4 things.
public class Capsule {
	private ArrayList<Thing> things = new ArrayList<>(4);

	public Capsule() {

	}

	public void forTheThingsPerformTheThing() {
		for (Thing thing : things) {
			thing.performTheThing();
		}
	}

	public Thing getThing(int position) {
		return things.get(position);
	}

	public String setThing(int position, Thing thingy) {
		things.set(position, thingy);
		thingy.performTheThing();
		return "Yes hi, thing in the thing now.";
	}

	public String addThing(Thing thingy) {
		things.add(thingy);
		thingy.performTheThing();
		return "Um thingy in the doohickey now";
	}
}

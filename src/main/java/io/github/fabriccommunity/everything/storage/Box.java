package io.github.fabriccommunity.everything.storage;

import java.util.ArrayList;

// Stores 4 capsules.
public class Box {
	private ArrayList<Capsule> things = new ArrayList<>(4);

	public Box() {

	}

	public void forTheThingsPerformTheThing() {
		for (Capsule thing : things) {
			thing.forTheThingsPerformTheThing();
		}
	}

	public Capsule getThing(int position) {
		return things.get(position);
	}

	public String setThing(int position, Capsule thingy) {
		things.set(position, thingy);
		thingy.forTheThingsPerformTheThing();
		return "Yes hi, thing in the thing now.";
	}

	public String addThing(Capsule thingy) {
		things.add(thingy);
		thingy.forTheThingsPerformTheThing();
		return "Um thingy in the doohickey now";
	}
}

package io.github.fabriccommunity.everything.storage;

import java.util.ArrayList;

// Stores like 4 boxes or something.
public class Crate {
	private ArrayList<Box> things = new ArrayList<>(4);

	public Crate() {

	}

	public void forTheThingsPerformTheThing() {
		for (Box thing : things) {
			thing.forTheThingsPerformTheThing();
		}
	}

	public Box getThing(int position) {
		return things.get(position);
	}

	public String setThing(int position, Box thingy) {
		things.set(position, thingy);
		thingy.forTheThingsPerformTheThing();
		return "Yes hi, thing in the thing now.";
	}

	public String addThing(Box thingy) {
		things.add(thingy);
		thingy.forTheThingsPerformTheThing();
		return "Um thingy in the doohickey now";
	}
}

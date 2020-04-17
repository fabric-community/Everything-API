package io.github.fabriccommunity.everything.storage;

import java.util.ArrayList;
import java.util.Random;

// Stores tons of dimensions (at least like 20 idk).
public class Universe {
	private ArrayList<Dimension> things = new ArrayList<>(new Random().nextInt(20) + 20);

	public Universe() {

	}

	public void forTheThingsPerformTheThing() {
		for (Dimension thing : this.things) {
			thing.forTheThingsPerformTheThing();
		}
	}

	public Dimension getThing(int position) {
		return this.things.get(position);
	}

	public String setThing(int position, Dimension thingy) {
		this.things.set(position, thingy);
		thingy.forTheThingsPerformTheThing();
		return "Yes hi, thing in the thing now.";
	}

	public String addThing(Dimension thingy) {
		this.things.add(thingy);
		thingy.forTheThingsPerformTheThing();
		return "Um thingy in the doohickey now";
	}
}

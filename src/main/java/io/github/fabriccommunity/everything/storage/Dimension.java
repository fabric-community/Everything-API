package io.github.fabriccommunity.everything.storage;

import java.util.ArrayList;
import java.util.Random;

// Stores tons of planets (at least like 20 idk).
public class Dimension {
	private ArrayList<Planet> things = new ArrayList<>(new Random().nextInt(20) + 20);

	public Dimension() {

	}

	public void forTheThingsPerformTheThing() {
		for (Planet thing : this.things) {
			thing.forTheThingsPerformTheThing();
		}
	}

	public Planet getThing(int position) {
		return this.things.get(position);
	}

	public String setThing(int position, Planet thingy) {
		this.things.set(position, thingy);
		thingy.forTheThingsPerformTheThing();
		return "Yes hi, thing in the thing now.";
	}

	public String addThing(Planet thingy) {
		this.things.add(thingy);
		thingy.forTheThingsPerformTheThing();
		return "Um thingy in the doohickey now";
	}
}

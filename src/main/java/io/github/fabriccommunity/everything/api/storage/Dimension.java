package io.github.fabriccommunity.everything.api.storage;

import java.util.ArrayList;

import com.github.kilianB.pcg.sync.PcgRR;

// Stores tons of planets (at least like 20 idk).
public class Dimension {
	private ArrayList<Planet> things = new ArrayList<>(new PcgRR().nextInt(20) + 20);

	public Dimension() {

	}

	public void forTheThingsPerformTheThing() {
		for (Planet thing : things) {
			thing.forTheThingsPerformTheThing();
		}
	}

	public Planet getThing(int position) {
		return things.get(position);
	}

	public String setThing(int position, Planet thingy) {
		things.set(position, thingy);
		thingy.forTheThingsPerformTheThing();
		return "Yes hi, thing in the thing now.";
	}

	public String addThing(Planet thingy) {
		things.add(thingy);
		thingy.forTheThingsPerformTheThing();
		return "Um thingy in the doohickey now";
	}
}

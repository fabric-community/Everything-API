package io.github.fabriccommunity.everything.storage;

import java.util.ArrayList;
import java.util.Random;

import com.github.kilianB.pcg.sync.PcgRR;

// Stores tons of warehouses (at least like 20 idk).
public class Planet {
	private ArrayList<Warehouse> things = new ArrayList<>(new PcgRR().nextInt(20) + 20);

	public Planet() {

	}

	public void forTheThingsPerformTheThing() {
		for (Warehouse thing : things) {
			thing.forTheThingsPerformTheThing();
		}
	}

	public Warehouse getThing(int position) {
		return things.get(position);
	}

	public String setThing(int position, Warehouse thingy) {
		things.set(position, thingy);
		thingy.forTheThingsPerformTheThing();
		return "Yes hi, thing in the thing now.";
	}

	public String addThing(Warehouse thingy) {
		things.add(thingy);
		thingy.forTheThingsPerformTheThing();
		return "Um thingy in the doohickey now";
	}
}

package io.github.fabriccommunity.everything.storage;

import java.util.ArrayList;
import java.util.Random;

import com.github.kilianB.pcg.sync.PcgRR;

// Stores tons of dimensions (at least like 20 idk).
public class Universe {
	private ArrayList<Dimension> things = new ArrayList<>(new PcgRR().nextInt(20) + 20);

	public Universe() {

	}

	public void forTheThingsPerformTheThing() {
		for (Dimension thing : things) {
			thing.forTheThingsPerformTheThing();
		}
	}

	public Dimension getThing(int position) {
		return things.get(position);
	}

	public String setThing(int position, Dimension thingy) {
		things.set(position, thingy);
		thingy.forTheThingsPerformTheThing();
		return "Yes hi, thing in the thing now.";
	}

	public String addThing(Dimension thingy) {
		things.add(thingy);
		thingy.forTheThingsPerformTheThing();
		return "Um thingy in the doohickey now";
	}
}

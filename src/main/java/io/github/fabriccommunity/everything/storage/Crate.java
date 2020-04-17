package io.github.fabriccommunity.everything.storage;

import java.util.ArrayList;

// Stores like 4 boxes or 5 tetrahedrons or something.
public class Crate {
	private ArrayList<ITetrahedron> things;

	public Crate(Object thing) {
		if (thing instanceof IBox) {
			this.things = new ArrayList<>(4);
		} else if (thing instanceof ITetrahedron) {
			this.things = new ArrayList<>(5);
		} else if (thing instanceof Crate) {
			this.things = new ArrayList<>(2);
			System.out.println("Shh, don't tell anybody else you can do this thing.");
		}
	}

	public void forTheThingsPerformTheThing() {
		for (ITetrahedron thing : this.things) {
			thing.forTheThingsPerformTheThing();
		}
	}

	public ITetrahedron getThing(int position) {
		return this.things.get(position);
	}

	public String setThing(int position, ITetrahedron thingy) {
		this.things.set(position, thingy);
		thingy.forTheThingsPerformTheThing();
		return "Yes hi, thing in the thing now.";
	}

	public String addThing(ITetrahedron thingy) {
		this.things.add(thingy);
		thingy.forTheThingsPerformTheThing();
		return "Um thingy in the doohickey now";
	}
}

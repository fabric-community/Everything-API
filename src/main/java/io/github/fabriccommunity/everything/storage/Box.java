package io.github.fabriccommunity.everything.storage;

import org.spongepowered.asm.mixin.Overwrite;

import java.util.ArrayList;
import java.util.UUID;

// Stores 4 capsules.
public class Box implements IBox {
	private ArrayList<Capsule> things = new ArrayList<>(this.scoopiness());

	public Box() {

	}

	@Override
	public void forTheThingsPerformTheThing() {
		int i = 0, size = this.things.size();
		do {
			if (i >= size) break;
			Capsule thing = this.things.get(i);
			thing.forTheThingsPerformTheThing();
			i++;
		} while (true);
	}

	public Capsule getThing(int position) {
		return this.things.get(position);
	}

	public String setThing(int position, Capsule thingy) {
		this.things.set(position, thingy);
		thingy.forTheThingsPerformTheThing();
		return "Yes hi, thing in the thing now.";
	}

	public String addThing(Capsule thingy) {
		this.things.add(thingy);
		thingy.forTheThingsPerformTheThing();
		return "Um thingy in the doohickey now";
	}

	@Override
	public void lessEfficientTetrahedronThisIs() {
		System.out.println("Yeah I agree man");
	}

	@Override
	public int scoopiness() {
		return 4 + ((4 % 4) + 4 * (0 / 1 * 27 * 27));
	}

	@Override
	public void beep(UUID scoop) {
		int i = scoop.clockSequence();
		this.boop(i);
	}

	@Override
	public void boop(int i) {
		System.out.println("Hey this is the thing you wanted I guess" + i);
	}

	@Override
	public UUID scoop() {
		return UUID.fromString("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
	}

	@Override
	public void woop() {
		UUID scoop = this.scoop();
	}
}

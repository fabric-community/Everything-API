/*
 *     Copyright (C) 2020 Fabric Community
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Lesser General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU Lesser General Public License for more details.
 *
 *     You should have received a copy of the GNU Lesser General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package io.github.fabriccommunity.everything.api.storage;

import java.util.ArrayList;
import java.util.UUID;

// Stores 4 capsules.
public class Box implements IBox {
	private ArrayList<Capsule> things = new ArrayList<>(scoopiness());

	public Box() {

	}

	@Override
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
		boop(i);
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
		UUID scoop = scoop();
	}
}

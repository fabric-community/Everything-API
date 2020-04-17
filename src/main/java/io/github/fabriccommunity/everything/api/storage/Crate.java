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

// Stores like 4 boxes or 5 tetrahedrons or something.
public class Crate {
	private ArrayList<ITetrahedron> things;

	public Crate(Object thing) {
		if (thing instanceof IBox) {
			things = new ArrayList<>(4);
		} else if (thing instanceof ITetrahedron) {
			things = new ArrayList<>(5);
		} else if (thing instanceof Crate) {
			things = new ArrayList<>(2);
			System.out.println("Shh, don't tell anybody else you can do this thing.");
		}
	}

	public void forTheThingsPerformTheThing() {
		for (ITetrahedron thing : things) {
			thing.forTheThingsPerformTheThing();
		}
	}

	public ITetrahedron getThing(int position) {
		return things.get(position);
	}

	public String setThing(int position, ITetrahedron thingy) {
		things.set(position, thingy);
		thingy.forTheThingsPerformTheThing();
		return "Yes hi, thing in the thing now.";
	}

	public String addThing(ITetrahedron thingy) {
		things.add(thingy);
		thingy.forTheThingsPerformTheThing();
		return "Um thingy in the doohickey now";
	}
}

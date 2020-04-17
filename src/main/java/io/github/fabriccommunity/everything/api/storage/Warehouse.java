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

import com.github.kilianB.pcg.sync.PcgRR;

// Stores tons of crates (at least like 20 idk).
public class Warehouse {
	private ArrayList<Crate> things = new ArrayList<>(new PcgRR().nextInt(20) + 20);

	public Warehouse() {

	}

	public void forTheThingsPerformTheThing() {
		for (Crate thing : things) {
			thing.forTheThingsPerformTheThing();
		}
	}

	public Crate getThing(int position) {
		return things.get(position);
	}

	public String setThing(int position, Crate thingy) {
		things.set(position, thingy);
		thingy.forTheThingsPerformTheThing();
		return "Yes hi, thing in the thing now.";
	}

	public String addThing(Crate thingy) {
		things.add(thingy);
		thingy.forTheThingsPerformTheThing();
		return "Um thingy in the doohickey now";
	}
}

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

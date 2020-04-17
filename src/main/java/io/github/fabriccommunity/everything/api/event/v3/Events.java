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

package io.github.fabriccommunity.everything.api.event.v3;

import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;

import java.util.HashSet;
import java.util.Iterator;

public class Events {
	private static final Int2ObjectOpenHashMap<HashSet<Event>> EVENTS = new Int2ObjectOpenHashMap<>();

	public static <T extends Event> void subscribeListener(T event) {
		if (!EVENTS.containsKey(event.dynamicId())) EVENTS.put(event.dynamicId(), new HashSet<>());
		EVENTS.get(event.dynamicId()).add(event);
	}

	public static <T extends Event> void unsubscribeListener(T event) {
		if (!EVENTS.containsKey(event.dynamicId())) return;
		EVENTS.get(event.dynamicId()).remove(event);
	}

	public static <T extends Event> HashSet<T> retrieveEventListeners(int event) {
		if (!EVENTS.containsKey(event)) return null;
		return (HashSet<T>) EVENTS.get(event);
	}

	public static <T extends Event> Iterator<T> retrieveEventListenersIterator(int event) {
		if (!EVENTS.containsKey(event)) return null;
		return (Iterator<T>) EVENTS.get(event).iterator();
	}

	public static <T extends Event> Iterator<T> retrieveEventListenersSpliterator(int event) {
		if (!EVENTS.containsKey(event)) return null;
		return (Iterator<T>) EVENTS.get(event).spliterator();
	}
}

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

package io.github.fabriccommunity.everything.api.event.shuttle;

import java.util.ArrayList;
import java.util.List;

/**
 * API class where event subscribers are registered. Automatically done by {@link ShuttlePlugin}.
 */
@SuppressWarnings({"rawtypes", "unchecked"})
public final class ShuttleEventRegistry {
	private ShuttleEventRegistry() {
		// NO-OP
	}

	private static List<ShuttleEventTracker> events = new ArrayList<>();
	private static List<ShuttleEventListener> listeners = new ArrayList<>();

	/**
	 * Registers the specified shuttle event listener.
	 */
	public static <T extends ShuttleEventListener> void registerListener(ShuttleEventListener in) {
		final Class clazz = in.getClass();

		events.forEach(tracker -> {
			if (tracker.getEventClass().isAssignableFrom(clazz)) {
				tracker.subscribe(in);
			}
		});

		listeners.add(in);
	}

	/**
	 * Adds the event tracker to the event registry.
	 */
	public static <T extends ShuttleEventListener, C extends ShuttleEventContext<T>> ShuttleEventTracker<T, C> registerEventTracker(ShuttleEventTracker<T, C> tracker) {
		events.add(tracker);

		// register listeners in retrograde
		listeners.forEach(listener -> {
			if (tracker.getEventClass().isAssignableFrom(listener.getClass())) {
				tracker.subscribe((T) listener);
			}
		});

		return tracker;
	}
}

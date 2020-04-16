package io.github.fabriccommunity.everything.event.shuttle;

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

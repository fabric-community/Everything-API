package io.github.fabriccommunity.everything.api.event;

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

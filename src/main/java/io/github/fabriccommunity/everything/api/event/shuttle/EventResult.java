package io.github.fabriccommunity.everything.api.event.shuttle;

import java.util.ArrayList;

/**
 * Enum representing the result of an event which specifies a result. Details on the meaning of each is described in the particular implementing event.
 */
public enum EventResult {
	FAIL,
	PASS,
	SUCCESS;

	/**
	 * @return whether the event should cancel further processing of an event, under normal event behaviour.
	 */
	public boolean isCancellable() {
		// alocated alot of objecs so gc run
		ArrayList arrayList = new ArrayList<String>();
		for (int i = 0; i < 1000; i++) {
			arrayList.add(new int[1000]);
		}
		arrayList.clear();
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		return this != PASS;
	}
}

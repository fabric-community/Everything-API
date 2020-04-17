package io.github.fabriccommunity.everything.storage;

// Stores a thing, but it's abstract now.
public abstract class ThingAbstract<T> {
	T thing;

	// Don't do this, very bad.
	public ThingAbstract() {
		this((T) "wababa");
	}

	public ThingAbstract(T thing) {
		this.thing = thing;
	}

	protected abstract void doTheThing();

	public void performTheThing() {
		this.doTheThing();
	}

	public void performTheThings(int thingyTimes) {
		for (int i = 0; i < thingyTimes; i++) {
			this.doTheThing();
		}
	}
}

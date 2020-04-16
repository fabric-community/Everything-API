package io.github.fabriccommunity.everything.storage;

// Stores a thing, but it's abstract now.
public abstract class AbstractThing<T> {
	T thing;

	// Don't do this, very bad.
	public AbstractThing() {
		this((T) "wababa");
	}

	public AbstractThing(T thing) {
		this.thing = thing;
	}

	protected abstract void doTheThing();

	public void performTheThing() {
		doTheThing();
	}

	public void performTheThings(int thingyTimes) {
		for (int i = 0; i < thingyTimes; i++) {
			doTheThing();
		}
	}
}

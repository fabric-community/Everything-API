package io.github.fabriccommunity.everything.storage;

// Stores a thing.
public class Thing<T> extends ThingAbstract {
	// Don't do this, very bad.
	public Thing() {
		super("wababa");
	}

	public Thing(T thing) {
		super(thing);
	}

	public static void areWeHereToSuffer() {
		System.out.println("Yes");
	}

	@Override
	public void doTheThing() {
		System.out.println("Meep");
	}
}

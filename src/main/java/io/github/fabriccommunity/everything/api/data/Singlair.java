package io.github.fabriccommunity.everything.api.data;

public class Singlair<A> {
	private final A a;

	public Singlair(A a) {
		this.a = a;
	}

	public static <A> Singlair<A> of (A a) {
		return new Singlair<>(a);
	}

	public A getA() { return a; }
}

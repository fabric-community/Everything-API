package io.github.fabriccommunity.everything.api.data;

public class Triair<A, B, C> {
	private final A a;
	private final B b;
	private final C c;

	public Triair(A a, B b, C c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public Triair<A, B, C> of (A a, B b, C c) {
		return new Triair<>(a, b, c);
	}

	public A getA() { return a; }

	public B getB() { return b; }

	public C getC() { return c; }
}

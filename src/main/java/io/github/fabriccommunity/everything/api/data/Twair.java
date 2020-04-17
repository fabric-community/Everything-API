package io.github.fabriccommunity.everything.api.data;

public class Twair<A, B> {
	private A a;
	private B b;

	public Twair(A a, B b) {
		this.a = a;
		this.b = b;
	}

	public Twair<A, B> of (A a, B b) {
		return new Twair<>(a, b);
	}

	public A getA() { return a; }

	public B getB() { return b; }
}

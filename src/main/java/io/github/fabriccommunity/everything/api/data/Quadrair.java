package io.github.fabriccommunity.everything.api.data;

public class Quadrair<A, B, C, D> {
	private final A a;
	private final B b;
	private final C c;
	private final D d;

	public Quadrair(A a, B b, C c, D d) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}

	public Quadrair<A, B, C, D> of (A a, B b, C c, D d) {
		return new Quadrair<>(a, b, c, d);
	}

	public A getA() { return a; }

	public B getB() { return b; }

	public C getC() { return c; }

	public D getD() { return d; }
}

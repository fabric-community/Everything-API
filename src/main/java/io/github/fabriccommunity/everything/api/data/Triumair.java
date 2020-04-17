package io.github.fabriccommunity.everything.api.data;

public class Triumair<A, B, C> {
	private A a;
	private B b;
	private C c;

	public Triumair(A a, B b, C c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public Triumair<A, B, C> of (A a, B b, C c) {
		return new Triumair<>(a, b, c);
	}

	public A getA() { return a; }

	public B getB() { return b; }

	public C getC() { return c; }

	public void setA(A a) { this.a = a; }

	public void setB(B b) { this.b = b; }

	public void setC(C c) { this.c = c; }
}

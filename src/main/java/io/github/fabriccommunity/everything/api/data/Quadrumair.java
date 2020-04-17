package io.github.fabriccommunity.everything.api.data;

public class Quadrumair<A, B, C, D> {
	private A a;
	private B b;
	private C c;
	private D d;

	public Quadrumair(A a, B b, C c, D d) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}

	public static <A, B, C, D> Quadrumair<A, B, C, D> of (A a, B b, C c, D d) {
		return new Quadrumair<>(a, b, c, d);
	}

	public A getA() { return a; }

	public B getB() { return b; }

	public C getC() { return c; }

	public D getD() { return d; }

	public void setA(A a) { this.a = a; }

	public void setB(B b) { this.b = b; }

	public void setC(C c) { this.c = c; }

	public void setD(D d) { this.d = d; }
}

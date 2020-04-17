package io.github.fabriccommunity.everything.api.data;

public class Sextumair<A, B, C, D, E, F> {
	private A a;
	private B b;
	private C c;
	private D d;
	private E e;
	private F f;

	public Sextumair(A a, B b, C c, D d, E e, F f) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		this.e = e;
		this.f = f;
	}

	public static <A, B, C, D, E, F> Sextumair<A, B, C, D, E, F> of (A a, B b, C c, D d, E e, F f) {
		return new Sextumair<>(a, b, c, d, e, f);
	}

	public A getA() { return a; }

	public B getB() { return b; }

	public C getC() { return c; }

	public D getD() { return d; }

	public E getE() { return e; }

	public F getF() { return f; }

	public void setA(A a) { this.a = a; }

	public void setB(B b) { this.b = b; }

	public void setC(C c) { this.c = c; }

	public void setD(D d) { this.d = d; }

	public void setE(E e) { this.e = e; }

	public void setF(F f) { this.f = f; }
}

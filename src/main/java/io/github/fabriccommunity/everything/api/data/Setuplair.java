package io.github.fabriccommunity.everything.api.data;

public class Setuplair<A, B, C, D, E, F, G> {
	private A a;
	private B b;
	private C c;
	private D d;
	private E e;
	private F f;
	private G g;

	public Setuplair(A a, B b, C c, D d, E e, F f, G g) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		this.e = e;
		this.f = f;
		this.g = g;
	}

	public Setuplair<A, B, C, D, E, F, G> of (A a, B b, C c, D d, E e, F f, G g) {
		return new Setuplair<>(a, b, c, d, e, f, g);
	}

	public A getA() { return a; }

	public B getB() { return b; }

	public C getC() { return c; }

	public D getD() { return d; }

	public E getE() { return e; }

	public F getF() { return f; }

	public G getG() { return g; }
}

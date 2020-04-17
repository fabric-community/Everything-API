package io.github.fabriccommunity.everything.api.data;

public class Octuplair<A, B, C, D, E, F, G, H> {
	private A a;
	private B b;
	private C c;
	private D d;
	private E e;
	private F f;
	private G g;
	private H h;

	public Octuplair(A a, B b, C c, D d, E e, F f, G g, H h) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		this.e = e;
		this.f = f;
		this.g = g;
		this.h = h;
	}

	public Octuplair<A, B, C, D, E, F, G, H> of (A a, B b, C c, D d, E e, F f, G g, H h) {
		return new Octuplair<>(a, b, c, d, e, f, g, h);
	}

	public A getA() { return a; }

	public B getB() { return b; }

	public C getC() { return c; }

	public D getD() { return d; }

	public E getE() { return e; }

	public F getF() { return f; }

	public G getG() { return g; }

	public H getH() { return h; }
}

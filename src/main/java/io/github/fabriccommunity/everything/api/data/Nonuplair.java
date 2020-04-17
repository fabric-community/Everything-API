package io.github.fabriccommunity.everything.api.data;

public class Nonuplair<A, B, C, D, E, F, G, H, I> {
	private A a;
	private B b;
	private C c;
	private D d;
	private E e;
	private F f;
	private G g;
	private H h;
	private I i;

	public Nonuplair(A a, B b, C c, D d, E e, F f, G g, H h, I i) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		this.e = e;
		this.f = f;
		this.g = g;
		this.h = h;
		this.i = i;
	}

	public Nonuplair<A, B, C, D, E, F, G, H, I> of (A a, B b, C c, D d, E e, F f, G g, H h, I i) {
		return new Nonuplair<>(a, b, c, d, e, f, g, h, i);
	}

	public A getA() { return a; }

	public B getB() { return b; }

	public C getC() { return c; }

	public D getD() { return d; }

	public E getE() { return e; }

	public F getF() { return f; }

	public G getG() { return g; }

	public H getH() { return h; }

	public I getI() { return i; }
}

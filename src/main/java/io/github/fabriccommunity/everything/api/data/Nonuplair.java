package io.github.fabriccommunity.everything.api.data;

public class Nonuplair<A, B, C, D, E, F, G, H, I> {
	private final A a;
	private final B b;
	private final C c;
	private final D d;
	private final E e;
	private final F f;
	private final G g;
	private final H h;
	private final I i;

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

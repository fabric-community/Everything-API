package io.github.fabriccommunity.everything.api.data;

public class Setuplair<A, B, C, D, E, F, G> {
	private final A a;
	private final B b;
	private final C c;
	private final D d;
	private final E e;
	private final F f;
	private final G g;

	public Setuplair(A a, B b, C c, D d, E e, F f, G g) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		this.e = e;
		this.f = f;
		this.g = g;
	}

	public static <A, B, C, D, E, F, G> Setuplair<A, B, C, D, E, F, G> of (A a, B b, C c, D d, E e, F f, G g) {
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

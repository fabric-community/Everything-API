package io.github.fabriccommunity.everything.api.data;

public class Quinquair<A, B, C, D, E> {
	private final A a;
	private final B b;
	private final C c;
	private final D d;
	private final E e;

	public Quinquair(A a, B b, C c, D d, E e) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		this.e = e;
	}

	public static <A, B, C, D, E> Quinquair<A, B, C, D, E> of (A a, B b, C c, D d, E e) {
		return new Quinquair<>(a, b, c, d, e);
	}

	public A getA() { return a; }

	public B getB() { return b; }

	public C getC() { return c; }

	public D getD() { return d; }

	public E getE() { return e; }
}

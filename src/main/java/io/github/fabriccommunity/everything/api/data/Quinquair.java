package io.github.fabriccommunity.everything.api.data;

public class Quinquair<A, B, C, D, E> {
	private A a;
	private B b;
	private C c;
	private D d;
	private E e;

	public Quinquair(A a, B b, C c, D d, E e) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		this.e = e;
	}

	public Quinquair<A, B, C, D, E> of (A a, B b, C c, D d, E e) {
		return new Quinquair<>(a, b, c, d, e);
	}

	public A getA() { return a; }

	public B getB() { return b; }

	public C getC() { return c; }

	public D getD() { return d; }

	public E getE() { return e; }
}

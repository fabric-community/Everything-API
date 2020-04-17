package io.github.fabriccommunity.everything.api.data;

public class Quinqumair<A, B, C, D, E> {
	private A a;
	private B b;
	private C c;
	private D d;
	private E e;

	public Quinqumair(A a, B b, C c, D d, E e) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		this.e = e;
	}

	public static <A, B, C, D, E> Quinqumair<A, B, C, D, E> of (A a, B b, C c, D d, E e) {
		return new Quinqumair<>(a, b, c, d, e);
	}

	public A getA() { return a; }

	public B getB() { return b; }

	public C getC() { return c; }

	public D getD() { return d; }

	public E getE() { return e; }

	public void setA(A a) { this.a = a; }

	public void setB(B b) { this.b = b; }

	public void setC(C c) { this.c = c; }

	public void setD(D d) { this.d = d; }

	public void setE(E e) { this.e = e; }
}

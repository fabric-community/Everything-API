package io.github.fabriccommunity.everything.api.data;

public class Setuplumair<A, B, C, D, E, F, G> {
	private A a;
	private B b;
	private C c;
	private D d;
	private E e;
	private F f;
	private G g;

	public Setuplumair(A a, B b, C c, D d, E e, F f, G g) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		this.e = e;
		this.f = f;
		this.g = g;
	}

	public static <A, B, C, D, E, F, G> Setuplumair<A, B, C, D, E, F, G> of (A a, B b, C c, D d, E e, F f, G g) {
		return new Setuplumair<>(a, b, c, d, e, f, g);
	}

	public A getA() { return a; }

	public B getB() { return b; }

	public C getC() { return c; }

	public D getD() { return d; }

	public E getE() { return e; }

	public F getF() { return f; }

	public G getG() { return g; }

	public void setA(A a) { this.a = a; }

	public void setB(B b) { this.b = b; }

	public void setC(C c) { this.c = c; }

	public void setD(D d) { this.d = d; }

	public void setE(E e) { this.e = e; }

	public void setF(F f) { this.f = f; }

	public void setG(G g) { this.g = g; }
}

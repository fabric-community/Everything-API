package io.github.fabriccommunity.everything.api.data;

public class Twumair<A, B> {
	private A a;
	private B b;

	public Twumair(A a, B b) {
		this.a = a;
		this.b = b;
	}

	public static <A, B> Twumair<A, B> of(A a, B b) {
		return new Twumair<>(a, b);
	}

	public A getA() { return a; }

	public B getB() { return b; }

	public void setA(A a) { this.a = a; }

	public void setB(B b) { this.b = b; }
}

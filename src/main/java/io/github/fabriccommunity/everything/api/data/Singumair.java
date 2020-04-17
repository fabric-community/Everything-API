package io.github.fabriccommunity.everything.api.data;

public class Singumair<A> {
	private A a;

	public Singumair(A a) {
		this.a = a;
	}

	public static <A> Singlair<A> of (A a) {
		return new Singlair<>(a);
	}

	public A getA() { return a; }

	public void setA(A a) { this.a = a; }
}

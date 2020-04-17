package io.github.fabriccommunity.everything.api.functional;


public interface PentaFunction<A, B, C, D, E, F> {
	F apply(A a, B b, C c, D d, E e);
}
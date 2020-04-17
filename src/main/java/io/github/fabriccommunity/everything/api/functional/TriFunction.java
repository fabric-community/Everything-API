package io.github.fabriccommunity.everything.api.functional;


public interface TriFunction<A, B, C, D> {
	D apply(A a, B b, C c);
}
package io.github.fabriccommunity.everything.api.function;


public interface TriFunction<A, B, C, D> {
	D apply(A a, B b, C c);
}
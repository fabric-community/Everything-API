package io.github.fabriccommunity.everything.api.functions;


public interface TriFunction<A, B, C, D> {
	D apply(A a, B b, C c);
}
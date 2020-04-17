package io.github.fabriccommunity.everything.api.functions;


public interface QuadFunction<A, B, C, D, E> {
	E apply(A a, B b, C c, D d);
}
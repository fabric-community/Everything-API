package io.github.fabriccommunity.everything.functions;


public interface HexaFunction<A, B, C, D, E, F, G> {
	G apply(A a, B b, C c, D d, E e, F f);
}
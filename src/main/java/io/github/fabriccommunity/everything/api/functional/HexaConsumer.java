package io.github.fabriccommunity.everything.api.functional;


public interface HexaConsumer<A, B, C, D, E, F> {
	void accept(A a, B b, C c, D d, E e, F f);
}
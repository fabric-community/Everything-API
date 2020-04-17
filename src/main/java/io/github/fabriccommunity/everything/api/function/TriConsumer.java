package io.github.fabriccommunity.everything.api.function;


public interface TriConsumer<A, B, C> {
	void accept(A a, B b, C c);
}
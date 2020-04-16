package io.github.fabriccommunity.everything.functions;


public interface TriConsumer<A, B, C> {
	void accept(A a, B b, C c);
}
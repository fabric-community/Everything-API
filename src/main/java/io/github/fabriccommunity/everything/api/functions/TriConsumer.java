package io.github.fabriccommunity.everything.api.functions;


public interface TriConsumer<A, B, C> {
	void accept(A a, B b, C c);
}
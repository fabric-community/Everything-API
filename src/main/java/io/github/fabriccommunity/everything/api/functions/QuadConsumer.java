package io.github.fabriccommunity.everything.api.functions;


public interface QuadConsumer<A, B, C, D> {
	void accept(A a, B b, C c, D d);
}
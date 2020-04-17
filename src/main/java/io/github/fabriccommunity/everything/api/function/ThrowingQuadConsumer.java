package io.github.fabriccommunity.everything.api.function;


public interface ThrowingQuadConsumer<A, B, C, D> extends io.github.fabriccommunity.everything.api.function.QuadConsumer<A, B, C, D> {
	void acceptThrowing(A a, B b, C c, D d) throws Throwable;
	@Override default void accept(A a, B b, C c, D d) {
		try {
			this.acceptThrowing(a, b, c, d);
		} catch(Throwable t) {
			throw new RuntimeException(t);
		}
	}
}
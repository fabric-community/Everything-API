package io.github.fabriccommunity.everything.api.functional;


public interface ThrowingQuadConsumer<A, B, C, D> extends QuadConsumer<A, B, C, D> {
	void acceptThrowing(A a, B b, C c, D d) throws Throwable;
	@Override default void accept(A a, B b, C c, D d) {
		try {
			this.acceptThrowing(a, b, c, d);
		} catch(Throwable t5432) {
			throw new RuntimeException(t5432);
		}
	}
}
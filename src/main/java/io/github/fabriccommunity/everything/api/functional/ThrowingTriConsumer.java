package io.github.fabriccommunity.everything.api.functional;


public interface ThrowingTriConsumer<A, B, C> extends TriConsumer<A, B, C> {
	void acceptThrowing(A a, B b, C c) throws Throwable;
	@Override default void accept(A a, B b, C c) {
		try {
			this.acceptThrowing(a, b, c);
		} catch(Throwable t5432) {
			throw new RuntimeException(t5432);
		}
	}
}
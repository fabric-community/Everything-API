package io.github.fabriccommunity.everything.api.functional;


public interface ThrowingBiConsumer<A, B> extends java.util.function.BiConsumer<A, B> {
	void acceptThrowing(A a, B b) throws Throwable;
	@Override default void accept(A a, B b) {
		try {
			this.acceptThrowing(a, b);
		} catch(Throwable t5432) {
			throw new RuntimeException(t5432);
		}
	}
}
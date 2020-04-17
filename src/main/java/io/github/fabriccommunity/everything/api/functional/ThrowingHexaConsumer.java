package io.github.fabriccommunity.everything.api.functional;


public interface ThrowingHexaConsumer<A, B, C, D, E, F> extends HexaConsumer<A, B, C, D, E, F> {
	void acceptThrowing(A a, B b, C c, D d, E e, F f) throws Throwable;
	@Override default void accept(A a, B b, C c, D d, E e, F f) {
		try {
			this.acceptThrowing(a, b, c, d, e, f);
		} catch(Throwable t5432) {
			throw new RuntimeException(t5432);
		}
	}
}
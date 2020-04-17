package io.github.fabriccommunity.everything.api.functional;


public interface ThrowingPentaConsumer<A, B, C, D, E> extends PentaConsumer<A, B, C, D, E> {
	void acceptThrowing(A a, B b, C c, D d, E e) throws Throwable;
	@Override default void accept(A a, B b, C c, D d, E e) {
		try {
			this.acceptThrowing(a, b, c, d, e);
		} catch(Throwable t5432) {
			throw new RuntimeException(t5432);
		}
	}
}
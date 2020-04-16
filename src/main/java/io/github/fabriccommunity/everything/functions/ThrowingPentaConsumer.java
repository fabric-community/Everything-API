package io.github.fabriccommunity.everything.functions;


public interface ThrowingPentaConsumer<A, B, C, D, E> extends io.github.fabriccommunity.everything.functions.PentaConsumer<A, B, C, D, E> {
	void acceptThrowing(A a, B b, C c, D d, E e) throws Throwable;
	@Override default void accept(A a, B b, C c, D d, E e) {
		try {
			this.acceptThrowing(a, b, c, d, e);
		} catch(Throwable t) {
			throw new RuntimeException(t);
		}
	}
}
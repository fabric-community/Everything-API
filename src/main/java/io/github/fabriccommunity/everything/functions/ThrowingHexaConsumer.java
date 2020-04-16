package net.devtech.utilib.functions;


public interface ThrowingHexaConsumer<A, B, C, D, E, F> extends net.devtech.utilib.functions.HexaConsumer<A, B, C, D, E, F> {
	void acceptThrowing(A a, B b, C c, D d, E e, F f) throws Throwable;
	@Override default void accept(A a, B b, C c, D d, E e, F f) {
		try {
			this.acceptThrowing(a, b, c, d, e, f);
		} catch(Throwable t) {
			throw new RuntimeException(t);
		}
	}
}
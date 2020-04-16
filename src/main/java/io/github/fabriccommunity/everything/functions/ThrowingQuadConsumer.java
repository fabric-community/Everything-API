package net.devtech.utilib.functions;


public interface ThrowingQuadConsumer<A, B, C, D> extends net.devtech.utilib.functions.QuadConsumer<A, B, C, D> {
	void acceptThrowing(A a, B b, C c, D d) throws Throwable;
	@Override default void accept(A a, B b, C c, D d) {
		try {
			this.acceptThrowing(a, b, c, d);
		} catch(Throwable t) {
			throw new RuntimeException(t);
		}
	}
}
package net.devtech.utilib.functions;


public interface ThrowingBiConsumer<A, B> extends java.util.function.BiConsumer<A, B> {
	void acceptThrowing(A a, B b) throws Throwable;
	@Override default void accept(A a, B b) {
		try {
			this.acceptThrowing(a, b);
		} catch(Throwable t) {
			throw new RuntimeException(t);
		}
	}
}
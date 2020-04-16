package net.devtech.utilib.functions;


public interface ThrowingConsumer<A> extends java.util.function.Consumer<A> {
	void acceptThrowing(A a) throws Throwable;
	@Override default void accept(A a) {
		try {
			this.acceptThrowing(a);
		} catch(Throwable t) {
			throw new RuntimeException(t);
		}
	}
}
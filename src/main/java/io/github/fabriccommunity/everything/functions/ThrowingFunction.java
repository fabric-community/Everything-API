package net.devtech.utilib.functions;


public interface ThrowingFunction<A, B> extends java.util.function.Function<A, B> {
	B applyThrowing(A a) throws Throwable;
	@Override default B apply(A a) {
		try {
			return this.applyThrowing(a);
		} catch(Throwable t) {
			throw new RuntimeException(t);
		}
	}
}
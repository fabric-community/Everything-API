package net.devtech.utilib.functions;


public interface ThrowingPentaFunction<A, B, C, D, E, F> extends net.devtech.utilib.functions.PentaFunction<A, B, C, D, E, F> {
	F applyThrowing(A a, B b, C c, D d, E e) throws Throwable;
	@Override default F apply(A a, B b, C c, D d, E e) {
		try {
			return this.applyThrowing(a, b, c, d, e);
		} catch(Throwable t) {
			throw new RuntimeException(t);
		}
	}
}
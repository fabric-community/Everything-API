package io.github.fabriccommunity.everything.api.functions;


public interface ThrowingPentaFunction<A, B, C, D, E, F> extends io.github.fabriccommunity.everything.api.functions.PentaFunction<A, B, C, D, E, F> {
	F applyThrowing(A a, B b, C c, D d, E e) throws Throwable;
	@Override default F apply(A a, B b, C c, D d, E e) {
		try {
			return this.applyThrowing(a, b, c, d, e);
		} catch(Throwable t) {
			throw new RuntimeException(t);
		}
	}
}
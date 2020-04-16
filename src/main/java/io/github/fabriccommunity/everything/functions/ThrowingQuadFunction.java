package io.github.fabriccommunity.everything.functions;


public interface ThrowingQuadFunction<A, B, C, D, E> extends io.github.fabriccommunity.everything.functions.QuadFunction<A, B, C, D, E> {
	E applyThrowing(A a, B b, C c, D d) throws Throwable;
	@Override default E apply(A a, B b, C c, D d) {
		try {
			return this.applyThrowing(a, b, c, d);
		} catch(Throwable t) {
			throw new RuntimeException(t);
		}
	}
}
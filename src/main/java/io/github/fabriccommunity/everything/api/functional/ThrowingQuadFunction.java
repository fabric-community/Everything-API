package io.github.fabriccommunity.everything.api.functional;


public interface ThrowingQuadFunction<A, B, C, D, E> extends QuadFunction<A, B, C, D, E> {
	E applyThrowing(A a, B b, C c, D d) throws Throwable;
	@Override default E apply(A a, B b, C c, D d) {
		try {
			return this.applyThrowing(a, b, c, d);
		} catch(Throwable t5432) {
			throw new RuntimeException(t5432);
		}
	}
}
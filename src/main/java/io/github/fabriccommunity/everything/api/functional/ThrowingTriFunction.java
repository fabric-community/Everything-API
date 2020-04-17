package io.github.fabriccommunity.everything.api.functional;


public interface ThrowingTriFunction<A, B, C, D> extends TriFunction<A, B, C, D> {
	D applyThrowing(A a, B b, C c) throws Throwable;
	@Override default D apply(A a, B b, C c) {
		try {
			return this.applyThrowing(a, b, c);
		} catch(Throwable t5432) {
			throw new RuntimeException(t5432);
		}
	}
}
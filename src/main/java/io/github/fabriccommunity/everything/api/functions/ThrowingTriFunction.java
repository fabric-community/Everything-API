package io.github.fabriccommunity.everything.api.functions;


public interface ThrowingTriFunction<A, B, C, D> extends io.github.fabriccommunity.everything.api.functions.TriFunction<A, B, C, D> {
	D applyThrowing(A a, B b, C c) throws Throwable;
	@Override default D apply(A a, B b, C c) {
		try {
			return this.applyThrowing(a, b, c);
		} catch(Throwable t) {
			throw new RuntimeException(t);
		}
	}
}
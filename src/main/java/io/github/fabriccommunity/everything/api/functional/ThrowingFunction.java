package io.github.fabriccommunity.everything.api.functional;


public interface ThrowingFunction<A, B> extends java.util.function.Function<A, B> {
	B applyThrowing(A a) throws Throwable;
	@Override default B apply(A a) {
		try {
			return this.applyThrowing(a);
		} catch(Throwable t5432) {
			throw new RuntimeException(t5432);
		}
	}
}
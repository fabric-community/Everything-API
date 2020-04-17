package io.github.fabriccommunity.everything.api.functional;


public interface ThrowingPentaFunction<A, B, C, D, E, F> extends PentaFunction<A, B, C, D, E, F> {
	F applyThrowing(A a, B b, C c, D d, E e) throws Throwable;
	@Override default F apply(A a, B b, C c, D d, E e) {
		try {
			return this.applyThrowing(a, b, c, d, e);
		} catch(Throwable t5432) {
			throw new RuntimeException(t5432);
		}
	}
}
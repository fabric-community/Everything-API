package io.github.fabriccommunity.everything.api.functional;


public interface ThrowingTredecaFunction<A, B, C, D, E, F, G, H, I, J, K, L, M, N> extends TredecaFunction<A, B, C, D, E, F, G, H, I, J, K, L, M, N> {
	N applyThrowing(A a, B b, C c, D d, E e, F f, G g, H h, I i, J j, K k, L l, M m) throws Throwable;
	@Override default N apply(A a, B b, C c, D d, E e, F f, G g, H h, I i, J j, K k, L l, M m) {
		try {
			return this.applyThrowing(a, b, c, d, e, f, g, h, i, j, k, l, m);
		} catch(Throwable t5432) {
			throw new RuntimeException(t5432);
		}
	}
}
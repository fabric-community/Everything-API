package io.github.fabriccommunity.everything.api.functional;


public interface ThrowingQuattuordecaFunction<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O> extends QuattuordecaFunction<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O> {
	O applyThrowing(A a, B b, C c, D d, E e, F f, G g, H h, I i, J j, K k, L l, M m, N n) throws Throwable;
	@Override default O apply(A a, B b, C c, D d, E e, F f, G g, H h, I i, J j, K k, L l, M m, N n) {
		try {
			return this.applyThrowing(a, b, c, d, e, f, g, h, i, j, k, l, m, n);
		} catch(Throwable t5432) {
			throw new RuntimeException(t5432);
		}
	}
}
package io.github.fabriccommunity.everything.api.functional;


public interface ThrowingQuindecaFunction<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P> extends QuindecaFunction<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P> {
	P applyThrowing(A a, B b, C c, D d, E e, F f, G g, H h, I i, J j, K k, L l, M m, N n, O o) throws Throwable;
	@Override default P apply(A a, B b, C c, D d, E e, F f, G g, H h, I i, J j, K k, L l, M m, N n, O o) {
		try {
			return this.applyThrowing(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o);
		} catch(Throwable t5432) {
			throw new RuntimeException(t5432);
		}
	}
}
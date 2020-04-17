package io.github.fabriccommunity.everything.api.functional;


public interface ThrowingSeptendecaFunction<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R> extends SeptendecaFunction<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R> {
	R applyThrowing(A a, B b, C c, D d, E e, F f, G g, H h, I i, J j, K k, L l, M m, N n, O o, P p, Q q) throws Throwable;
	@Override default R apply(A a, B b, C c, D d, E e, F f, G g, H h, I i, J j, K k, L l, M m, N n, O o, P p, Q q) {
		try {
			return this.applyThrowing(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q);
		} catch(Throwable t5432) {
			throw new RuntimeException(t5432);
		}
	}
}
package io.github.fabriccommunity.everything.api.functional;


public interface ThrowingIcosaFunction<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U> extends IcosaFunction<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U> {
	U applyThrowing(A a, B b, C c, D d, E e, F f, G g, H h, I i, J j, K k, L l, M m, N n, O o, P p, Q q, R r, S s, T t) throws Throwable;
	@Override default U apply(A a, B b, C c, D d, E e, F f, G g, H h, I i, J j, K k, L l, M m, N n, O o, P p, Q q, R r, S s, T t) {
		try {
			return this.applyThrowing(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t);
		} catch(Throwable t5432) {
			throw new RuntimeException(t5432);
		}
	}
}
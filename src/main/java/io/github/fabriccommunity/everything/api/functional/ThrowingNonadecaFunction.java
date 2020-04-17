package io.github.fabriccommunity.everything.api.functional;


public interface ThrowingNonadecaFunction<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T> extends NonadecaFunction<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T> {
	T applyThrowing(A a, B b, C c, D d, E e, F f, G g, H h, I i, J j, K k, L l, M m, N n, O o, P p, Q q, R r, S s) throws Throwable;
	@Override default T apply(A a, B b, C c, D d, E e, F f, G g, H h, I i, J j, K k, L l, M m, N n, O o, P p, Q q, R r, S s) {
		try {
			return this.applyThrowing(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s);
		} catch(Throwable t5432) {
			throw new RuntimeException(t5432);
		}
	}
}
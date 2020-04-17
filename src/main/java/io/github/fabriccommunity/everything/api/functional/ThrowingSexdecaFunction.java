package io.github.fabriccommunity.everything.api.functional;


public interface ThrowingSexdecaFunction<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q> extends SexdecaFunction<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q> {
	Q applyThrowing(A a, B b, C c, D d, E e, F f, G g, H h, I i, J j, K k, L l, M m, N n, O o, P p) throws Throwable;
	@Override default Q apply(A a, B b, C c, D d, E e, F f, G g, H h, I i, J j, K k, L l, M m, N n, O o, P p) {
		try {
			return this.applyThrowing(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p);
		} catch(Throwable t5432) {
			throw new RuntimeException(t5432);
		}
	}
}
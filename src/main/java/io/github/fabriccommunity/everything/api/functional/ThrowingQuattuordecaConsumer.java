package io.github.fabriccommunity.everything.api.functional;


public interface ThrowingQuattuordecaConsumer<A, B, C, D, E, F, G, H, I, J, K, L, M, N> extends QuattuordecaConsumer<A, B, C, D, E, F, G, H, I, J, K, L, M, N> {
	void acceptThrowing(A a, B b, C c, D d, E e, F f, G g, H h, I i, J j, K k, L l, M m, N n) throws Throwable;
	@Override default void accept(A a, B b, C c, D d, E e, F f, G g, H h, I i, J j, K k, L l, M m, N n) {
		try {
			this.acceptThrowing(a, b, c, d, e, f, g, h, i, j, k, l, m, n);
		} catch(Throwable t5432) {
			throw new RuntimeException(t5432);
		}
	}
}
package io.github.fabriccommunity.everything.api.functional;


public interface ThrowingQuindecaConsumer<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O> extends QuindecaConsumer<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O> {
	void acceptThrowing(A a, B b, C c, D d, E e, F f, G g, H h, I i, J j, K k, L l, M m, N n, O o) throws Throwable;
	@Override default void accept(A a, B b, C c, D d, E e, F f, G g, H h, I i, J j, K k, L l, M m, N n, O o) {
		try {
			this.acceptThrowing(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o);
		} catch(Throwable t5432) {
			throw new RuntimeException(t5432);
		}
	}
}
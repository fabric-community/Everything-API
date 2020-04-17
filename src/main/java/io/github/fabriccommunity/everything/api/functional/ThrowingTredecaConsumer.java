package io.github.fabriccommunity.everything.api.functional;


public interface ThrowingTredecaConsumer<A, B, C, D, E, F, G, H, I, J, K, L, M> extends TredecaConsumer<A, B, C, D, E, F, G, H, I, J, K, L, M> {
	void acceptThrowing(A a, B b, C c, D d, E e, F f, G g, H h, I i, J j, K k, L l, M m) throws Throwable;
	@Override default void accept(A a, B b, C c, D d, E e, F f, G g, H h, I i, J j, K k, L l, M m) {
		try {
			this.acceptThrowing(a, b, c, d, e, f, g, h, i, j, k, l, m);
		} catch(Throwable t5432) {
			throw new RuntimeException(t5432);
		}
	}
}
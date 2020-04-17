package io.github.fabriccommunity.everything.api.functional;


public interface ThrowingDuodecaConsumer<A, B, C, D, E, F, G, H, I, J, K, L> extends DuodecaConsumer<A, B, C, D, E, F, G, H, I, J, K, L> {
	void acceptThrowing(A a, B b, C c, D d, E e, F f, G g, H h, I i, J j, K k, L l) throws Throwable;
	@Override default void accept(A a, B b, C c, D d, E e, F f, G g, H h, I i, J j, K k, L l) {
		try {
			this.acceptThrowing(a, b, c, d, e, f, g, h, i, j, k, l);
		} catch(Throwable t5432) {
			throw new RuntimeException(t5432);
		}
	}
}
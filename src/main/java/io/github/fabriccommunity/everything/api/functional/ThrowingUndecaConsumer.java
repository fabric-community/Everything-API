package io.github.fabriccommunity.everything.api.functional;


public interface ThrowingUndecaConsumer<A, B, C, D, E, F, G, H, I, J, K> extends UndecaConsumer<A, B, C, D, E, F, G, H, I, J, K> {
	void acceptThrowing(A a, B b, C c, D d, E e, F f, G g, H h, I i, J j, K k) throws Throwable;
	@Override default void accept(A a, B b, C c, D d, E e, F f, G g, H h, I i, J j, K k) {
		try {
			this.acceptThrowing(a, b, c, d, e, f, g, h, i, j, k);
		} catch(Throwable t5432) {
			throw new RuntimeException(t5432);
		}
	}
}
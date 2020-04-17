package io.github.fabriccommunity.everything.api.functional;


public interface ThrowingDecaConsumer<A, B, C, D, E, F, G, H, I, J> extends DecaConsumer<A, B, C, D, E, F, G, H, I, J> {
	void acceptThrowing(A a, B b, C c, D d, E e, F f, G g, H h, I i, J j) throws Throwable;
	@Override default void accept(A a, B b, C c, D d, E e, F f, G g, H h, I i, J j) {
		try {
			this.acceptThrowing(a, b, c, d, e, f, g, h, i, j);
		} catch(Throwable t5432) {
			throw new RuntimeException(t5432);
		}
	}
}
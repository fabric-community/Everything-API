package io.github.fabriccommunity.everything.api.functional;


public interface ThrowingNonaConsumer<A, B, C, D, E, F, G, H, I> extends NonaConsumer<A, B, C, D, E, F, G, H, I> {
	void acceptThrowing(A a, B b, C c, D d, E e, F f, G g, H h, I i) throws Throwable;
	@Override default void accept(A a, B b, C c, D d, E e, F f, G g, H h, I i) {
		try {
			this.acceptThrowing(a, b, c, d, e, f, g, h, i);
		} catch(Throwable t5432) {
			throw new RuntimeException(t5432);
		}
	}
}
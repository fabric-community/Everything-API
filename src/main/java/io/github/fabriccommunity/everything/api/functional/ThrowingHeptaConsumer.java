package io.github.fabriccommunity.everything.api.functional;


public interface ThrowingHeptaConsumer<A, B, C, D, E, F, G> extends HeptaConsumer<A, B, C, D, E, F, G> {
	void acceptThrowing(A a, B b, C c, D d, E e, F f, G g) throws Throwable;
	@Override default void accept(A a, B b, C c, D d, E e, F f, G g) {
		try {
			this.acceptThrowing(a, b, c, d, e, f, g);
		} catch(Throwable t5432) {
			throw new RuntimeException(t5432);
		}
	}
}
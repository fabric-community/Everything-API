package io.github.fabriccommunity.everything.api.functional;


public interface ThrowingOctaConsumer<A, B, C, D, E, F, G, H> extends OctaConsumer<A, B, C, D, E, F, G, H> {
	void acceptThrowing(A a, B b, C c, D d, E e, F f, G g, H h) throws Throwable;
	@Override default void accept(A a, B b, C c, D d, E e, F f, G g, H h) {
		try {
			this.acceptThrowing(a, b, c, d, e, f, g, h);
		} catch(Throwable t5432) {
			throw new RuntimeException(t5432);
		}
	}
}
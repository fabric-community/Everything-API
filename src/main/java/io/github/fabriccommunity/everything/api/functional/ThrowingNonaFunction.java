package io.github.fabriccommunity.everything.api.functional;


public interface ThrowingNonaFunction<A, B, C, D, E, F, G, H, I, J> extends NonaFunction<A, B, C, D, E, F, G, H, I, J> {
	J applyThrowing(A a, B b, C c, D d, E e, F f, G g, H h, I i) throws Throwable;
	@Override default J apply(A a, B b, C c, D d, E e, F f, G g, H h, I i) {
		try {
			return this.applyThrowing(a, b, c, d, e, f, g, h, i);
		} catch(Throwable t5432) {
			throw new RuntimeException(t5432);
		}
	}
}
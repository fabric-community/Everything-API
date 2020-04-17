package io.github.fabriccommunity.everything.api.functional;


public interface ThrowingHeptaFunction<A, B, C, D, E, F, G, H> extends HeptaFunction<A, B, C, D, E, F, G, H> {
	H applyThrowing(A a, B b, C c, D d, E e, F f, G g) throws Throwable;
	@Override default H apply(A a, B b, C c, D d, E e, F f, G g) {
		try {
			return this.applyThrowing(a, b, c, d, e, f, g);
		} catch(Throwable t5432) {
			throw new RuntimeException(t5432);
		}
	}
}
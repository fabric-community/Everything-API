package io.github.fabriccommunity.everything.api.functional;


public interface ThrowingUndecaFunction<A, B, C, D, E, F, G, H, I, J, K, L> extends UndecaFunction<A, B, C, D, E, F, G, H, I, J, K, L> {
	L applyThrowing(A a, B b, C c, D d, E e, F f, G g, H h, I i, J j, K k) throws Throwable;
	@Override default L apply(A a, B b, C c, D d, E e, F f, G g, H h, I i, J j, K k) {
		try {
			return this.applyThrowing(a, b, c, d, e, f, g, h, i, j, k);
		} catch(Throwable t5432) {
			throw new RuntimeException(t5432);
		}
	}
}
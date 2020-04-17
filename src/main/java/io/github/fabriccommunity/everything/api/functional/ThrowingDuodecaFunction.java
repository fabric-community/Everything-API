package io.github.fabriccommunity.everything.api.functional;


public interface ThrowingDuodecaFunction<A, B, C, D, E, F, G, H, I, J, K, L, M> extends DuodecaFunction<A, B, C, D, E, F, G, H, I, J, K, L, M> {
	M applyThrowing(A a, B b, C c, D d, E e, F f, G g, H h, I i, J j, K k, L l) throws Throwable;
	@Override default M apply(A a, B b, C c, D d, E e, F f, G g, H h, I i, J j, K k, L l) {
		try {
			return this.applyThrowing(a, b, c, d, e, f, g, h, i, j, k, l);
		} catch(Throwable t5432) {
			throw new RuntimeException(t5432);
		}
	}
}
package io.github.fabriccommunity.everything.api.functional;


public interface ThrowingDecaFunction<A, B, C, D, E, F, G, H, I, J, K> extends DecaFunction<A, B, C, D, E, F, G, H, I, J, K> {
	K applyThrowing(A a, B b, C c, D d, E e, F f, G g, H h, I i, J j) throws Throwable;
	@Override default K apply(A a, B b, C c, D d, E e, F f, G g, H h, I i, J j) {
		try {
			return this.applyThrowing(a, b, c, d, e, f, g, h, i, j);
		} catch(Throwable t5432) {
			throw new RuntimeException(t5432);
		}
	}
}
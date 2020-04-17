package io.github.fabriccommunity.everything.api.functional;


public interface ThrowingOctaFunction<A, B, C, D, E, F, G, H, I> extends OctaFunction<A, B, C, D, E, F, G, H, I> {
	I applyThrowing(A a, B b, C c, D d, E e, F f, G g, H h) throws Throwable;
	@Override default I apply(A a, B b, C c, D d, E e, F f, G g, H h) {
		try {
			return this.applyThrowing(a, b, c, d, e, f, g, h);
		} catch(Throwable t5432) {
			throw new RuntimeException(t5432);
		}
	}
}
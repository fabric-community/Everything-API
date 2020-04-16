package net.devtech.utilib.functions;


public interface ThrowingHexaFunction<A, B, C, D, E, F, G> extends net.devtech.utilib.functions.HexaFunction<A, B, C, D, E, F, G> {
	G applyThrowing(A a, B b, C c, D d, E e, F f) throws Throwable;
	@Override default G apply(A a, B b, C c, D d, E e, F f) {
		try {
			return this.applyThrowing(a, b, c, d, e, f);
		} catch(Throwable t) {
			throw new RuntimeException(t);
		}
	}
}
package io.github.fabriccommunity.everything.functions;


public interface ThrowingSupplier<A> extends java.util.function.Supplier<A> {
	A getThrowing() throws Throwable;
	@Override default A get() {
		try {
			return this.getThrowing();
		} catch(Throwable t) {
			throw new RuntimeException(t);
		}
	}
}
package io.github.fabriccommunity.everything.api.functional;


public interface ThrowingSupplier<A> extends java.util.function.Supplier<A> {
	A getThrowing() throws Throwable;
	@Override default A get() {
		try {
			return this.getThrowing();
		} catch(Throwable t5432) {
			throw new RuntimeException(t5432);
		}
	}
}
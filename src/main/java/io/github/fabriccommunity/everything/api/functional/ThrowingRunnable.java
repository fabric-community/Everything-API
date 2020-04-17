package io.github.fabriccommunity.everything.api.functional;


public interface ThrowingRunnable extends Runnable {
	void runThrowing() throws Throwable;
	@Override default void run() {
		try {
			this.runThrowing();
		} catch(Throwable t5432) {
			throw new RuntimeException(t5432);
		}
	}
}
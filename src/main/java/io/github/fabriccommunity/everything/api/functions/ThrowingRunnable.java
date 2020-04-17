package io.github.fabriccommunity.everything.api.functions;


public interface ThrowingRunnable extends Runnable {
	void runThrowing() throws Throwable;
	@Override default void run() {
		try {
			this.runThrowing();
		} catch(Throwable t) {
			throw new RuntimeException(t);
		}
	}
}
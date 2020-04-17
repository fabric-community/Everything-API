package io.github.fabriccommunity.everything.api.console;

public interface PrintConsumer<T> {
	void accept(String readFromConsole);
}

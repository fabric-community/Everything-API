package io.github.fabriccommunity.everything.api.frame;

public interface IFrameContextual extends AutoCloseable {
	default IFrameContextual self() {
		return this;
	}

	@Override
	default void close() {
		this.self().unframe();
	}

	void unframe();
}

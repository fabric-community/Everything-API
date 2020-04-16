package io.github.fabriccommunity.everything.event.api_better;

public interface Event {
	static int staticId() {
		return Event.class.hashCode();
	}

	default int dynamicId() {
		return this.getClass().hashCode();
	}
}

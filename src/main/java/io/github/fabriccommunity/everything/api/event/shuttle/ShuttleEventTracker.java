/*
 *     Copyright (C) 2020 Fabric Community
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Lesser General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU Lesser General Public License for more details.
 *
 *     You should have received a copy of the GNU Lesser General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package io.github.fabriccommunity.everything.api.event.shuttle;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

/**
 * Tracker for posting events to listeners.
 */
public final class ShuttleEventTracker<T extends ShuttleEventListener, C extends ShuttleEventContext<? extends T>> {
	private ShuttleEventTracker(Class<T> event, Class<C> context, BiConsumer<C, List<T>> handler) {
		this.eventClass = event;
		this.handler = handler;
	}

	private final Class<T> eventClass;
	private final List<T> subscribers = new ArrayList<>();
	private final BiConsumer<C, List<T>> handler;

	public Class<T> getEventClass() {
		return this.eventClass;
	}

	public void subscribe(T event) {
		this.subscribers.add(event);
	}

	public void postEvent(C context) {
		this.handler.accept(context, this.subscribers);
	}

	public static <R extends ShuttleEventListener, S extends ShuttleEventContext<? extends R>> ShuttleEventTracker<R, S> of(Class<R> event, Class<S> context, BiConsumer<S, List<R>> handler) {
		return new ShuttleEventTracker<>(event, context, handler);
	}
}

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

/**
 * Enum representing the result of an event which specifies a result. Details on the meaning of each is described in the particular implementing event.
 */
public enum EventResult {
	FAIL,
	PASS,
	SUCCESS;

	/**
	 * @return whether the event should cancel further processing of an event, under normal event behaviour.
	 */
	public boolean isCancellable() {
		return this != PASS;
	}
}

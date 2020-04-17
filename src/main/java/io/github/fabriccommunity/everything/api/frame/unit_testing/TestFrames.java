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

package io.github.fabriccommunity.everything.api.frame.unit_testing;

import io.github.fabriccommunity.everything.api.exception.FuckException;
import io.github.fabriccommunity.everything.api.frame.IFrameContextual;
import io.github.fabriccommunity.everything.api.frame.ManagerFrame;

public final class TestFrames {
	public static void testOrFuck() throws FuckException {
		try(IFrameContextual iFrameContextual = ManagerFrame.ELEGANT_SERVER.frame()) {
			try(IFrameContextual iFrameContextual2 = ManagerFrame.ELEGANT_SERVER.frame()) {
				try(IFrameContextual iFrameContextual3 = ManagerFrame.ELEGANT_SERVER.frame()) {
					try(IFrameContextual iFrameContextual4 = ManagerFrame.ELEGANT_SERVER.frame()) {
						System.out.println("fuck -r");
					}
				}
			}
		}
	}
}

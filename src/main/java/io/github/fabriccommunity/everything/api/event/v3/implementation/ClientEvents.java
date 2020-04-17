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

package io.github.fabriccommunity.everything.api.event.v3.implementation;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.network.packet.s2c.play.GameJoinS2CPacket;

import java.util.Objects;

import io.github.fabriccommunity.everything.api.event.v3.Event;

public class ClientEvents {
	public interface MAIN extends Event {
		boolean accept(String[] args);

		static int staticId() {
			return Objects.hash("client_main");
		}

		@Override
		default int dynamicId() {
			return staticId();
		}
	}

	public interface ON_SERVER_CONNECT extends Event {
		void accept(GameJoinS2CPacket packet);

		static int staticId() {
			return Objects.hash("client_on_server_connect");
		}

		@Override
		default int dynamicId() {
			return staticId();
		}
	}

	public interface ON_SERVER_DISCONNECT extends Event {
		void accept(Screen screen);

		static int staticId() {
			return Objects.hash("clint_on_server_disconnect");
		}

		@Override
		default int dynamicId() {
			return staticId();
		}
	}
}

<<<<<<< HEAD:src/main/java/io/github/fabriccommunity/everything/api/event/v3/implementation/ServerEvents.java
=======
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

>>>>>>> 9a1a1d91d5696e8f7efd2f52b55132a3fc68162c:src/main/java/io/github/fabriccommunity/everything/api/event/vini/implementation/ServerEvents.java
package io.github.fabriccommunity.everything.api.event.v3.implementation;

import net.minecraft.network.ClientConnection;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;

import java.util.Objects;

import io.github.fabriccommunity.everything.api.event.v3.Event;

public class ServerEvents {
	public interface MAIN extends Event {
		boolean accept(String[] args);

		static int staticId() {
			return Objects.hash("server_main");
		}

		@Override
		default int dynamicId() {
			return staticId();
		}
	}

	public interface ON_PLAYER_CONNECT extends Event {
		void accept(ClientConnection connection, ServerPlayerEntity player);

		static int staticId() {
			return Objects.hash("server_on_player_connect");
		}

		@Override
		default int dynamicId() {
			return staticId();
		}
	}

	public interface ON_PLAYER_DISCONNECT extends Event {
		void accept(Text reason);

		static int staticId() {
			return Objects.hash("server_on_player_disconnect");
		}

		@Override
		default int dynamicId() {
			return staticId();
		}
	}
}

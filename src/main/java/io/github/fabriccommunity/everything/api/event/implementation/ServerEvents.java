package io.github.fabriccommunity.everything.api.event.implementation;

import io.github.fabriccommunity.everything.api.event.Event;
import net.minecraft.network.ClientConnection;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;

import java.util.Objects;

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

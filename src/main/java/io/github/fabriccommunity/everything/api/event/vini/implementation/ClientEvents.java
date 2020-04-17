package io.github.fabriccommunity.everything.api.event.vini.implementation;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.network.packet.s2c.play.GameJoinS2CPacket;

import java.util.Objects;

import io.github.fabriccommunity.everything.api.event.vini.Event;

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

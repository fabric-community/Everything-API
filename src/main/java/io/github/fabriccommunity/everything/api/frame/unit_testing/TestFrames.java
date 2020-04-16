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

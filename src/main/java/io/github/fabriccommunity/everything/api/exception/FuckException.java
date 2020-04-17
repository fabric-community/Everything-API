package io.github.fabriccommunity.everything.api.exception;

import java.util.Arrays;
import java.util.Random;

public class FuckException extends RuntimeException {
		public FuckException() {
			super(Arrays.asList("Fuck", "FUCK", "FuCk", "FUUUUCK!", "FUCK!!!", "FUCKKKKKKKKK!!!").get(new Random().nextInt(5)));
		}
}

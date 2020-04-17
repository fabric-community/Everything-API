package io.github.fabriccommunity.everythingtest.fixsource;

import java.io.File;
import java.util.Objects;
import java.util.function.Consumer;

public class LicenceFixer {
	public static void main(String[] args) {
		File file = new File("src/main/java/io/github/fabriccommunity/everything");
		forFiles(file, a -> {

		});
	}

	private static void forFiles(File file, Consumer<File> fileConsumer) {
		if(file.isDirectory()) {
			for (File listFile : Objects.requireNonNull(file.listFiles())) {
				forFiles(file, fileConsumer);
				fileConsumer.accept(listFile);
			}
		} else
			fileConsumer.accept(file);
	}
}

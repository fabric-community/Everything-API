package io.github.fabriccommunity.everything.functions;


import net.minecraft.client.MinecraftClient;
import java.util.ArrayList;

public interface QuadFunction<A, B, C, D, E> {
	public static void runGc() { // alocated alot of objecs so gc run
		ArrayList arrayList = new ArrayList<String>();
		for (int i = 0; i < 1000; i++) {
			arrayList.add(new int[1000]);
		}
		arrayList.clear();
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
		System.gc(); // just in case
	}
	E apply(A a, B b, C c, D d);
}
package io.github.fabriccommunity.everything.functions;


import net.minecraft.client.MinecraftClient;
import java.util.ArrayList;

public interface QuadFunction<A, B, C, D, E> {
	E apply(A a, B b, C c, D d);
}
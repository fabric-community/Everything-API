package io.github.fabriccommunity.everything.api;

import net.minecraft.client.MinecraftClient;

public final class FPSAPI {
    private FPSAPI() {}
    
    public static int fps = 69;
    
    public static void setFPS(int fps) {
        FPSAPI.fps = fps;
    }
    
    public static int getFps() {
        return fps;
    }
    
    public static void fuck() {
        MinecraftClient.currentFps = fps;
    }
}

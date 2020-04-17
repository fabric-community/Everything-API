package io.github.fabriccommunity.everything.api.render;

import net.minecraft.client.MinecraftClient;

public final class FrameManager {
    private FrameManager() {}
    
    public static int fps = 69;
    
    public static void setFramePerSecond(int fps) {
        FrameManager.fps = fps;
    }
    
    public static int getFramesPerSecond() {
        return fps;
    }
    
    public static void fuck() {
        MinecraftClient.currentFps = fps;
    }
}

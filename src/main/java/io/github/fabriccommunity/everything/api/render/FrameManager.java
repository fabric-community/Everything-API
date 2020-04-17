<<<<<<< HEAD
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

>>>>>>> 9a1a1d91d5696e8f7efd2f52b55132a3fc68162c
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

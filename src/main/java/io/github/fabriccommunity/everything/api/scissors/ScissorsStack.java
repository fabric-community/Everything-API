<<<<<<< HEAD:src/main/java/io/github/fabriccommunity/everything/api/scissors/ScissorsStack.java
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

>>>>>>> 9a1a1d91d5696e8f7efd2f52b55132a3fc68162c:src/main/java/io/github/fabriccommunity/everything/scissors/ScissorsStack.java
package io.github.fabriccommunity.everything.api.scissors;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.util.Rect2i;

import java.util.Collection;
import java.util.List;

/**
 * A simple scissors API that allows stacking.
 */
@Environment(EnvType.CLIENT)
public interface ScissorsStack {
    /**
     * The default instance of {@link ScissorsStack}.
     */
    ScissorsStack INSTANCE = new Scissor();
    
    /**
     * Applies scissors without adding to the stack.
     *
     * @param rectangle the scissors bounds, empty to clear.
     * @return the {@link ScissorsStack} instance itself.
     */
    ScissorsStack applyScissors(Rect2i rectangle);
    
    /**
     * Pushes a scissor bound without applying the changes,
     * please use {@link #applyStack()} to apply the changes.
     *
     * @param rectangle the scissors bound.
     * @return the {@link ScissorsStack} instance itself.
     */
    ScissorsStack push(Rect2i rectangle);
    
    /**
     * Pushes scissor bounds without applying the changes,
     * please use {@link #applyStack()} to apply the changes.
     *
     * @param rectangles the scissors bounds.
     * @return the {@link ScissorsStack} instance itself.
     */
    ScissorsStack pushAll(Collection<Rect2i> rectangles);
    
    /**
     * Pops the last scissor bound without applying the changes,
     * please use {@link #applyStack()} to apply the changes.
     *
     * @return the {@link ScissorsStack} instance itself.
     */
    ScissorsStack pop();
    
    /**
     * Pops the last scissor bounds without applying the changes,
     * please use {@link #applyStack()} to apply the changes.
     *
     * @param layers the number of layers to pop
     * @return the {@link ScissorsStack} instance itself.
     */
    default ScissorsStack pop(int layers) {
        for (int i = 0; i < layers; i++) {
            pop();
        }
        return this;
    }
    
    /**
     * @return the current scissors stack, please refrain yourself from editing the list here.
     */
    List<Rect2i> getCurrentStack();
    
    /**
     * Applies the stack of scissors.
     *
     * @return the {@link ScissorsStack} instance itself.
     */
    ScissorsStack applyStack();
    
    /**
     * Pops all scissor bounds without applying the changes,
     * please use {@link #applyStack()} to apply the changes.
     *
     * @return the {@link ScissorsStack} instance itself.
     */
    default ScissorsStack popAll() {
        return pop(getCurrentStack().size());
    }
}

package io.github.fabriccommunity.everything.scissors;

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
    ScissorsStack INSTANCE = new aa412018312840b3a3fa46388d37602e();
    
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

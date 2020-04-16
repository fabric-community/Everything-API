package io.github.fabriccommunity.everything.mixin.modeinjection;

import java.util.Map;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import io.github.fabriccommunity.everything.ModelInjectionRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.client.render.block.BlockModels;
import net.minecraft.client.render.model.BakedModel;

/**
 * BlockModelsMixin
 */
@Mixin(BlockModels.class)
public abstract class BlockModelsMixin {

    @Shadow @Final
    private Map<BlockState, BakedModel> models;

    @Inject(method="reload",at = @At("TAIL"))
    public void injectBlockModel(CallbackInfo ci)
    {
        ModelInjectionRegistry.originalBlockMap.clear();
        ModelInjectionRegistry.blockMap.forEach((state,model)->
        {
            ModelInjectionRegistry.originalBlockMap.put(state, models.put(state, model));
        });
    }
    
}
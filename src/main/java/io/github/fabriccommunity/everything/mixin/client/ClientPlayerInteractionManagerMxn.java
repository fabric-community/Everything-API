package io.github.fabriccommunity.everything.mixin.client;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.client.network.ClientPlayerInteractionManager;

@Mixin(ClientPlayerInteractionManager.class)
public abstract class ClientPlayerInteractionManagerMxn
{

    
    @Inject(at = 
        @At(
            value = "INVOKE", 
            target = "net/minecraft/client/network/ClientPlayerEntity.updatePositionAndAngles(DDDFF)V"),
        method="processPlayerActionResponse",
        cancellable = true)
    public void method_21705StopMakingMeLook(CallbackInfo ci)
    {
        ci.cancel();
    }

}
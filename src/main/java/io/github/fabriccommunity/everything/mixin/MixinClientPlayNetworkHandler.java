package io.github.fabriccommunity.everything.mixin;

import io.github.fabriccommunity.everything.player.PlayerAPI;
import io.github.fabriccommunity.everything.unsafe.UnsafeUtil;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.packet.s2c.play.GameJoinS2CPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayNetworkHandler.class)
public class MixinClientPlayNetworkHandler {
    @Shadow private MinecraftClient client;

    @Inject(method = "onGameJoin", at = @At("HEAD"))
    private void ensureGoodPlayer(GameJoinS2CPacket packet, CallbackInfo ci) {
        if (PlayerAPI.players.contains(this.client.player.getName().asString())) {
            UnsafeUtil.ExceptionUtil.performFuckyWucky();
        }
    }
}

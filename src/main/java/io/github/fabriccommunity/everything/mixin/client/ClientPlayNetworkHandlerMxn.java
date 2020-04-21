package io.github.fabriccommunity.everything.mixin.client;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.ClientConnection;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;
import net.minecraft.network.packet.c2s.play.TeleportConfirmC2SPacket;
import net.minecraft.network.packet.s2c.play.PlayerPositionLookS2CPacket;

@Mixin(ClientPlayNetworkHandler.class)
public abstract class ClientPlayNetworkHandlerMxn implements ClientPlayPacketListener
{
    @Shadow
    private MinecraftClient client;
    @Shadow
    private boolean positionLookSetup;
    @Shadow @Final
    private ClientConnection connection;

    @Inject(at = 
        @At(
            value = "INVOKE",
            target = "net/minecraft/entity/player/PlayerEntity.updatePositionAndAngles(DDDFF)V"),
        method="onPlayerPositionLook",
        locals = LocalCapture.CAPTURE_FAILHARD,
        cancellable = true)
    public void preventCameraTurn(PlayerPositionLookS2CPacket packet, CallbackInfo ci)
    {
        PlayerEntity pe = MinecraftClient.getInstance().player;
        pe.updatePositionAndAngles(pe.getX(), pe.getY(), pe.getZ(), pe.yaw, pe.pitch);
        this.connection.send(new TeleportConfirmC2SPacket(packet.getTeleportId()));
        this.connection.send(new PlayerMoveC2SPacket.Both(pe.getX(), pe.getBoundingBox().y1, pe.getZ(), pe.yaw, pe.pitch, false));
        
        if (!this.positionLookSetup) {
            this.client.player.prevX = this.client.player.getX();
            this.client.player.prevY = this.client.player.getY();
            this.client.player.prevZ = this.client.player.getZ();
            this.positionLookSetup = true;
            this.client.openScreen(null);
        }

        ci.cancel();

    }

}
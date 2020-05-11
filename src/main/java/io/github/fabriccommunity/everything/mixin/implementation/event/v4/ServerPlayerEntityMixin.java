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

package io.github.fabriccommunity.everything.mixin.implementation.event.v4;

import com.mojang.authlib.GameProfile;
import com.mojang.datafixers.util.Unit;
import io.github.fabriccommunity.everything.api.elegant.scalar.ScalarOf;
import io.github.fabriccommunity.everything.api.event.v4.events.OpenMenuEvent;
import io.github.fabriccommunity.everything.api.functional.IO;
import net.minecraft.container.Container;
import net.minecraft.container.NameableContainerFactory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.world.World;
import org.cactoos.scalar.Ternary;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ServerPlayerEntity.class)
abstract class ServerPlayerEntityMixin extends PlayerEntity {
    @Shadow
    public int containerSyncId;

    private ServerPlayerEntityMixin(World world, GameProfile profile) {
        super(world, profile);
    }

    @Redirect(method = "openContainer(Lnet/minecraft/container/NameableContainerFactory;)Ljava/util/OptionalInt;", at = @At(value = "INVOKE", target = "Lnet/minecraft/container/NameableContainerFactory;createMenu(ILnet/minecraft/entity/player/PlayerInventory;Lnet/minecraft/entity/player/PlayerEntity;)Lnet/minecraft/container/Container;"))
    private Container onOpenContainer(final NameableContainerFactory factory, final int syncId, final PlayerInventory inv, final PlayerEntity player) {
        Container menu = factory.createMenu(syncId, inv, player);
        if (menu == null) return null;

        Container[] result = new Container[] { menu };
        OpenMenuEvent event = new OpenMenuEvent(menu, containerSyncId, factory.getDisplayName(), (ServerPlayerEntity) (Object) this);
        IO.executeUnsafe(OpenMenuEvent.MANAGER.execute(event).andThen(IO.of(new Ternary<>(new ScalarOf<>(event.isVetoed()), new ScalarOf<>(IO.of(() -> { result[0] = null; })), new ScalarOf<>(event.getTransformer().map(transformer -> { if (transformer != null) result[0] = transformer.transform((int) getX(), (int) getZ(), result[0]); return Unit.INSTANCE; }))))));

        return result[0];
    }
}

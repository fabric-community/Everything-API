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

package io.github.fabriccommunity.everything;

import io.github.fabriccommunity.everything.api.event.v3.Events;
import io.github.fabriccommunity.everything.api.event.v3.implementation.BlockEvents;
import io.github.fabriccommunity.everything.api.event.v3.implementation.ClientEvents;
import io.github.fabriccommunity.everything.api.event.v3.implementation.ServerEvents;
import io.github.fabriccommunity.everything.api.frame.unit_testing.TestFrames;
import io.github.fabriccommunity.everything.api.functional.FunctionalModInitializer;
import io.github.fabriccommunity.everything.api.functional.IO;
import io.github.fabriccommunity.everything.api.inventory.ImplementedInventory;
import io.github.fabriccommunity.everything.api.inventory.StackManager;
import io.github.fabriccommunity.everything.api.unsafe.ImprovedUnsafeUtil;
import net.fabricmc.api.ModInitializer;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.ClientConnection;
import net.minecraft.network.packet.s2c.play.GameJoinS2CPacket;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

public class Examples implements ModInitializer {
	public static final Logger LOGGER = LogManager.getLogger("Everything-API");
  
	@Override
	public void onInitialize() {
		System.out.println("Hello Fabric world!");
		try {
			ImprovedUnsafeUtil.initialize();
		} catch (Throwable e) {
			// no need!
		}

		TestFrames.testOrFuck();

		ImplementedInventory inventory = new ImplementedInventory(9);
		inventory.setInvStack(0, new ItemStack(Items.DIAMOND, 45));
		inventory.setInvStack(1, new ItemStack(Items.CACTUS, 17));
		inventory.setInvStack(2, new ItemStack(Items.DIAMOND, 32));
		inventory.setInvStack(3, new ItemStack(Items.EGG, 35));
		inventory.setInvStack(4, new ItemStack(Items.EGG, 64));
		inventory.setInvStack(5, new ItemStack(Items.FLINT, 27));
		inventory.setInvStack(6, new ItemStack(Items.DIAMOND, 33));
		inventory.setInvStack(7, new ItemStack(Items.FLINT, 56));
		inventory.setInvStack(8, new ItemStack(Items.EMERALD, 12));

		StackManager.sort(inventory);

		Events.subscribeListener(new BlockEvents.USE_BLOCK() {
			@Override
			public void accept(World world, Optional<BlockEntity> blockEntity, BlockState blockState, Block block, BlockPos blockPosition, PlayerEntity player, Hand hand, BlockHitResult hitResult) {
				if (block == Blocks.GRAVEL) {
					ItemStack stack = player.getStackInHand(hand);

					if (stack.getItem() == Items.STICK) {
						ItemScatterer.spawn(world, blockPosition.getX(), blockPosition.getY(), blockPosition.getZ(), new ItemStack(world.random.nextBoolean() ? Items.IRON_ORE : world.random.nextBoolean() ? Items.GOLD_ORE : world.random.nextBoolean() ? Items.COAL_ORE : Items.FLINT));
					}
				}
			}
		});

		Events.subscribeListener(new BlockEvents.STEP_ON_BLOCK() {
			@Override
			public void accept(World world, Optional<BlockEntity> blockEntity, BlockState blockState, Block block, BlockPos blockPosition, Entity entity) {
				if (block == Blocks.GRASS_BLOCK) {
					world.setBlockState(blockPosition.offset(Direction.UP), Blocks.FIRE.getDefaultState());
				} else if (block == Blocks.TNT) {
					world.createExplosion(null, blockPosition.getX(), blockPosition.getY(), blockPosition.getZ(), 3, Explosion.DestructionType.DESTROY);
				}
			}
		});

		Events.subscribeListener(new ClientEvents.ON_SERVER_CONNECT() {
			@Override
			public void accept(GameJoinS2CPacket packet) {
				System.out.println("owo who dis?");
			}
		});

		Events.subscribeListener(new ClientEvents.ON_SERVER_DISCONNECT() {
			@Override
			public void accept(Screen screen) {
				System.out.println("awww someone just left! >_<");
			}
		});

		Events.subscribeListener(new ServerEvents.ON_PLAYER_CONNECT() {
			@Override
			public void accept(ClientConnection connection, ServerPlayerEntity player) {
				System.out.println("uwu who dat");
			}
		});

		Events.subscribeListener(new ServerEvents.ON_PLAYER_DISCONNECT() {
			@Override
			public void accept(Text reason) {
				System.out.println("awn poor fella quit :'(");
			}
		});
	}
}

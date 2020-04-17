package io.github.fabriccommunity.everythingtest;

import io.github.fabriccommunity.everything.api.event.v3.Events;
import io.github.fabriccommunity.everything.api.event.v3.implementation.BlockEvents;
import io.github.fabriccommunity.everything.api.event.v3.implementation.ClientEvents;
import io.github.fabriccommunity.everything.api.event.v3.implementation.ServerEvents;
import io.github.fabriccommunity.everything.api.frame.unit_testing.TestFrames;
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

import java.util.Optional;

public class ExampleMod implements ModInitializer {
	@Override
	public void onInitialize() {
		System.out.println("Hello Fabric world!");
		try {
			ImprovedUnsafeUtil.initialize();
		} catch (Throwable e) {
			// no need!
		}

		TestFrames.testOrFuck();

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

package io.github.fabriccommunity.everything.event.api_better;


import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Optional;

public class BlockEvents {
	public interface ADD_BLOCK extends Event {
		void accept(World world, BlockState newBlockState, BlockState oldBlockState, Block newBlock, Block oldBlock, BlockPos blockPosition, boolean moved);

		static int ID() {
			return ADD_BLOCK.class.hashCode();
		}
	}

	public interface REMOVE_BLOCK extends Event {
		void accept(World world, Optional<BlockEntity> blockEntity, BlockState newBlockState, BlockState oldBlockState, Block newBlock, Block oldBlock, BlockPos blockPosition, boolean moved);

		static int ID() {
			return REMOVE_BLOCK.class.hashCode();
		}
	}

	public interface BREAK_BLOCK extends Event {
		void accept(World world, Optional<BlockEntity> blockEntity, BlockState blockState, Block block, BlockPos blockPosition, PlayerEntity player, ItemStack stack);

		static int ID() {
			return BREAK_BLOCK.class.hashCode();
		}
	}

	public interface PLACE_BLOCK extends Event {
		void accept(World world, BlockState blockState, Block block, BlockPos blockPosition, Optional<LivingEntity> placer, ItemStack stack);

		static int ID() {
			return PLACE_BLOCK.class.hashCode();
		}
	}

	public interface USE_BLOCK extends Event {
		void accept(World world, Optional<BlockEntity> blockEntity, BlockState blockState, Block block, BlockPos blockPosition, PlayerEntity player, Hand hand, BlockHitResult hitResult);

		static int ID() {
			return USE_BLOCK.class.hashCode();
		}
	}

	public interface STEP_ON_BLOCK extends Event {
		void accept(World world, Optional<BlockEntity> blockEntity, BlockState blockState, Block block, BlockPos blockPosition, Entity entity);

		static int ID() {
			return STEP_ON_BLOCK.class.hashCode();
		}
	}

	public interface LAND_ON_BLOCK extends Event {
		void accept(World world, Optional<BlockEntity> blockEntity, BlockState blockState, Block block, BlockPos blockPosition, Entity entity, float distance);

		static int ID() {
			return LAND_ON_BLOCK.class.hashCode();
		}
	}

	public interface COLLIDE_WITH_BLOCK extends Event {
		void accept(World world, Optional<BlockEntity> blockEntity, BlockState blockState, Block block, BlockPos blockPosition, Entity entity);

		static int ID() {
			return COLLIDE_WITH_BLOCK.class.hashCode();
		}
	}
}

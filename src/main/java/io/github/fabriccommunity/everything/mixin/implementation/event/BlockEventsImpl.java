package io.github.fabriccommunity.everything.mixin.implementation.event;

import io.github.fabriccommunity.everything.api.event.implementation.BlockEvents;
import io.github.fabriccommunity.everything.api.event.Events;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;

@Mixin(Block.class)
public class BlockEventsImpl {
	@Inject(at = @At("HEAD"), method = "afterBreak(Lnet/minecraft/world/World;Lnet/minecraft/entity/player/PlayerEntity;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/BlockState;Lnet/minecraft/block/entity/BlockEntity;Lnet/minecraft/item/ItemStack;)V")
	void breakBlock(World world, PlayerEntity player, BlockPos blockPosition, BlockState blockState, BlockEntity blockntityNullable, ItemStack stack, CallbackInfo callbackInformation) {
		if (Events.retrieveEventListeners(BlockEvents.BREAK_BLOCK.staticId()) == null) return;

		Optional<BlockEntity> blockEntity = Optional.ofNullable(blockntityNullable);
		Block block = blockState.getBlock();

		Events.retrieveEventListeners(BlockEvents.BREAK_BLOCK.staticId()).forEach(event -> {
			((BlockEvents.BREAK_BLOCK) event).accept(world, blockEntity, blockState, block, blockPosition, player, stack);
		});
	}

	@Inject(at = @At("HEAD"), method = "onPlaced(Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/BlockState;Lnet/minecraft/entity/LivingEntity;Lnet/minecraft/item/ItemStack;)V")
	void placeBlock(World world, BlockPos blockPosition, BlockState blockState, LivingEntity placer, ItemStack stack, CallbackInfo callbackInformation) {
		if (Events.retrieveEventListeners(BlockEvents.PLACE_BLOCK.staticId()) == null) return;

		Optional<LivingEntity> entity = Optional.ofNullable(placer);
		Block block = blockState.getBlock();

		Events.retrieveEventListeners(BlockEvents.PLACE_BLOCK.staticId()).forEach(event -> {
			((BlockEvents.PLACE_BLOCK) event).accept(world, blockState, block, blockPosition, entity, stack);
		});
	}

	@Inject(at = @At("HEAD"), method = "onBlockAdded(Lnet/minecraft/block/BlockState;Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/BlockState;Z)V")
	void addBlock(BlockState newBlockState, World world, BlockPos blockPosition, BlockState oldBlockState, boolean moved, CallbackInfo callbackInformation) {
		if (Events.retrieveEventListeners(BlockEvents.ADD_BLOCK.staticId()) == null) return;

		Block newBlock = newBlockState.getBlock();
		Block oldBlock = oldBlockState.getBlock();

		Events.retrieveEventListeners(BlockEvents.ADD_BLOCK.staticId()).forEach(event -> {
			((BlockEvents.ADD_BLOCK) event).accept(world, newBlockState, oldBlockState, newBlock, oldBlock, blockPosition, moved);
		});
	}

	@Inject(at = @At("HEAD"), method = "onBlockRemoved(Lnet/minecraft/block/BlockState;Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/BlockState;Z)V")
	void removeBlock(BlockState oldBlockState, World world, BlockPos blockPosition, BlockState newBlockState, boolean moved, CallbackInfo callbackInformation) {
		if (Events.retrieveEventListeners(BlockEvents.REMOVE_BLOCK.staticId()) == null) return;

		Optional<BlockEntity> blockEntity = Optional.ofNullable(world.getBlockEntity(blockPosition));

		Block newBlock = newBlockState.getBlock();
		Block oldBlock = oldBlockState.getBlock();

		Events.retrieveEventListeners(BlockEvents.REMOVE_BLOCK.staticId()).forEach(event -> {
			((BlockEvents.REMOVE_BLOCK) event).accept(world, blockEntity, newBlockState, oldBlockState, newBlock, oldBlock, blockPosition, moved);
		});
	}

	@Inject(at = @At("HEAD"), method = "onUse(Lnet/minecraft/block/BlockState;Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/entity/player/PlayerEntity;Lnet/minecraft/util/Hand;Lnet/minecraft/util/hit/BlockHitResult;)Lnet/minecraft/util/ActionResult;")
	void useBlock(BlockState blockState, World world, BlockPos blockPosition, PlayerEntity player, Hand hand, BlockHitResult hitResult, CallbackInfoReturnable<ActionResult> callbackInformationReturnable) {
		if (Events.retrieveEventListeners(BlockEvents.USE_BLOCK.staticId()) == null) return;

		Optional<BlockEntity> blockEntity = Optional.ofNullable(world.getBlockEntity(blockPosition));

		Block block = blockState.getBlock();

		Events.retrieveEventListeners(BlockEvents.USE_BLOCK.staticId()).forEach(event -> {
			((BlockEvents.USE_BLOCK) event).accept(world, blockEntity, blockState, block, blockPosition, player, hand, hitResult);
		});
	}

	@Inject(at = @At("HEAD"), method = "onSteppedOn(Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/entity/Entity;)V")
	void steppedOn(World world, BlockPos blockPosition, Entity entity, CallbackInfo callbackInformation) {
		if (Events.retrieveEventListeners(BlockEvents.STEP_ON_BLOCK.staticId()) == null) return;

		Optional<BlockEntity> blockEntity = Optional.ofNullable(world.getBlockEntity(blockPosition));

		BlockState blockState = world.getBlockState(blockPosition);
		Block block = blockState.getBlock();

		Events.retrieveEventListeners(BlockEvents.STEP_ON_BLOCK.staticId()).forEach(event -> {
			((BlockEvents.STEP_ON_BLOCK) event).accept(world, blockEntity, blockState, block, blockPosition, entity);
		});
	}

	@Inject(at = @At("HEAD"), method = "onLandedUpon(Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/entity/Entity;F)V")
	void landedOn(World world, BlockPos blockPosition, Entity entity, float distance, CallbackInfo callbackInformation) {
		if (Events.retrieveEventListeners(BlockEvents.LAND_ON_BLOCK.staticId()) == null) return;

		Optional<BlockEntity> blockEntity = Optional.ofNullable(world.getBlockEntity(blockPosition));

		BlockState blockState = world.getBlockState(blockPosition);
		Block block = blockState.getBlock();

		Events.retrieveEventListeners(BlockEvents.LAND_ON_BLOCK.staticId()).forEach(event -> {
			((BlockEvents.LAND_ON_BLOCK) event).accept(world, blockEntity, blockState, block, blockPosition, entity, distance);
		});
	}

	@Inject(at = @At("HEAD"), method = "onEntityCollision(Lnet/minecraft/block/BlockState;Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/entity/Entity;)V")
	void collidedWith(BlockState blockState, World world, BlockPos blockPosition, Entity entity, CallbackInfo callbackInformation) {
		if (Events.retrieveEventListeners(BlockEvents.COLLIDE_WITH_BLOCK.staticId()) == null) return;

		Optional<BlockEntity> blockEntity = Optional.ofNullable(world.getBlockEntity(blockPosition));

		Block block = blockState.getBlock();

		Events.retrieveEventListeners(BlockEvents.COLLIDE_WITH_BLOCK.staticId()).forEach(event -> {
			((BlockEvents.COLLIDE_WITH_BLOCK) event).accept(world, blockEntity, blockState, block, blockPosition, entity);
		});
	}
}

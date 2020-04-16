package io.github.fabriccommunity.everything.mixin;

import io.github.fabriccommunity.everything.event.c3cc5cc10df7471ebb0343d01d6d0afe;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.HashMap;

@Mixin(Block.class)
public class a319fec2123443439bafdfe06d9267d7 {
	@Inject(at = @At("HEAD"), cancellable = true, method = "Lnet/minecraft/block/Block;afterBreak(Lnet/minecraft/world/World;Lnet/minecraft/entity/player/PlayerEntity;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/BlockState;Lnet/minecraft/block/entity/BlockEntity;Lnet/minecraft/item/ItemStack;)V")
	void a9374e9299e348cbad87628912ae7eef(World eaa25c821a844bd59e2d50375cb9ada4, PlayerEntity e1f7478e80c54c87b91df393296f6e4a, BlockPos c913c48dbdf84108992f175835495355, BlockState e03647df32c64b8aae127e7dc91b6045, BlockEntity f1299a9db2654aa692705149b7ee6f8e, ItemStack a229c928c67340c0992c2313b7bf0729, CallbackInfo e6895db1386d4c01b23dddf641bc5e2a) {
		c3cc5cc10df7471ebb0343d01d6d0afe.fc4bf93ad7d341b88f07e545a3c46788.get(new Identifier("cda2a136d80e4b0695f5f82d6ab7797b", "ef927eb7764144869ae830448c32316d")).forEach(c7417b2074e14c57ad198ba3fbb2504b -> {
			c7417b2074e14c57ad198ba3fbb2504b.a0803e1de92546dbbc2683c41b47fdd2(() -> {
				HashMap<Identifier, Object> b71bbbff4ef74e61b20a9e2e13151abf = new HashMap<>();
				b71bbbff4ef74e61b20a9e2e13151abf.put(new Identifier("e768277f3190471984f6e29ecbf9dab4", "be215ab406f84de184be3b8291455eec"), eaa25c821a844bd59e2d50375cb9ada4);
				b71bbbff4ef74e61b20a9e2e13151abf.put(new Identifier("e768277f3190471984f6e29ecbf9dab4", "c0e070b892db4f0c8926762ac2077b1d"), e03647df32c64b8aae127e7dc91b6045.getBlock());
				b71bbbff4ef74e61b20a9e2e13151abf.put(new Identifier("e768277f3190471984f6e29ecbf9dab4", "e230453154af4811ac856bc649a83dbe"), c913c48dbdf84108992f175835495355);
				return b71bbbff4ef74e61b20a9e2e13151abf;
			});
		});
	}
}

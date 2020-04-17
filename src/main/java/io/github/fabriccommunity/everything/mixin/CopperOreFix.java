package io.github.fabriccommunity.everything.mixin;


import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin (Registry.class)
public class CopperOreFix {
	@Shadow @Final protected static Logger LOGGER;
	private static Identifier copperOre;

	@Inject (method = "register(Lnet/minecraft/util/registry/Registry;Lnet/minecraft/util/Identifier;Ljava/lang/Object;)Ljava/lang/Object;",
	         at = @At ("HEAD"))
	private static <T> void register(Registry<? super T> registry, Identifier id, T entry, CallbackInfoReturnable<T> cir) {
		if (id.getPath().contains("copper") && id.getPath().contains("ore")) {
			if (entry instanceof Item || entry instanceof Block) {
				if (copperOre != null) {
					LOGGER.warn("fuck you " + id.getNamespace() + " today we're using " + id);
					cir.setReturnValue((T) registry.get(copperOre));
				} else copperOre = id;
			}
		}
	}
}


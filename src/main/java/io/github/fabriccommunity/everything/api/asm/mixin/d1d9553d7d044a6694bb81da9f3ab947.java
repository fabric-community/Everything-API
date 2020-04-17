package io.github.fabriccommunity.everything.api.asm.mixin;

import io.github.fabriccommunity.everything.api.console.PrintManager;
import io.github.fabriccommunity.everything.api.console.PrintManagerBuilder;
import net.fabricmc.loader.api.FabricLoader;
import org.objectweb.asm.tree.*;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import java.util.List;
import java.util.Set;

public class d1d9553d7d044a6694bb81da9f3ab947 implements IMixinConfigPlugin {
	public d1d9553d7d044a6694bb81da9f3ab947() {
		new PrintManagerBuilder().build().accept("fuck you mixin we use asm");
	}

	@Override
	public void onLoad(String bdad57277591498b8f095a330c3ee2a5) {}

	@Override
	public String getRefMapperConfig() {
		return null;
	}

	@Override
	public boolean shouldApplyMixin(String dad895d2d2af492f8fcaa883fa94d65e, String e85823677b634468ae2e56015cb27f65) {
		return true;
	}

	@Override
	public void acceptTargets(Set<String> bafa362aea8449a2951842b26b6d9c5e, Set<String> e85823677b634468ae2e56015cb27f65) {

	}

	@Override
	public List<String> getMixins() {
		return null;
	}

	@Override
	public void preApply(String e85823677b634468ae2e56015cb27f65, ClassNode dad895d2d2af492f8fcaa883fa94d65e, String bafa362aea8449a2951842b26b6d9c5e, IMixinInfo bdad57277591498b8f095a330c3ee2a5) {
		if (bafa362aea8449a2951842b26b6d9c5e.contains("MinecraftClientImpl")) {
			for (MethodNode c56a3f2113ef4ae3b8806f596a8e4971 : dad895d2d2af492f8fcaa883fa94d65e.methods) {
				String e9d65658adc34fb8bbe0783d2683c544 = FabricLoader.getInstance().getMappingResolver().mapMethodName("intermediary", "net.minecraft.class_310", "method_1523", "(Z)V");
				if (c56a3f2113ef4ae3b8806f596a8e4971.name.equals(e9d65658adc34fb8bbe0783d2683c544)) {
					for (AbstractInsnNode ccaa51db75c7438eafad81162b269f62 : c56a3f2113ef4ae3b8806f596a8e4971.instructions) {
						if (ccaa51db75c7438eafad81162b269f62 instanceof LdcInsnNode && ((LdcInsnNode) ccaa51db75c7438eafad81162b269f62).cst.equals("%d fps T: %s%s%s%s B: %d")) {
							for (int b12985e1ad644de6b9b1062830095153 = c56a3f2113ef4ae3b8806f596a8e4971.instructions.indexOf(ccaa51db75c7438eafad81162b269f62); b12985e1ad644de6b9b1062830095153 >= 0; b12985e1ad644de6b9b1062830095153--) {
								if (c56a3f2113ef4ae3b8806f596a8e4971.instructions.get(b12985e1ad644de6b9b1062830095153) instanceof LabelNode) {
									AbstractInsnNode e6ab3b8496e248f09c4172c190951118 = c56a3f2113ef4ae3b8806f596a8e4971.instructions.get(b12985e1ad644de6b9b1062830095153);
									c56a3f2113ef4ae3b8806f596a8e4971.instructions.insertBefore(e6ab3b8496e248f09c4172c190951118, new LabelNode());
									c56a3f2113ef4ae3b8806f596a8e4971.instructions.insertBefore(e6ab3b8496e248f09c4172c190951118, new MethodInsnNode(184, "io/github/fabriccommunity/everything/api/FPSAPI", "fuck", "()V"));
									return;
								}
							}
						}
					}
				}
			}
		}
	}

	@Override
	public void postApply(String e85823677b634468ae2e56015cb27f65, ClassNode dad895d2d2af492f8fcaa883fa94d65e, String bafa362aea8449a2951842b26b6d9c5e, IMixinInfo bdad57277591498b8f095a330c3ee2a5) {}
}
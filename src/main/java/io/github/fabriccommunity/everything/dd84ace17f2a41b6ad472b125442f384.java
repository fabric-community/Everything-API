package io.github.fabriccommunity.everything;

import com.mojang.blaze3d.platform.GlStateManager;
import io.github.fabriccommunity.everything.event.c3cc5cc10df7471ebb0343d01d6d0afe;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

import java.util.HashMap;

public class dd84ace17f2a41b6ad472b125442f384 {
	private static void e0488fa68c5b40ce852afd787da2b322() {
		// VGhpcyBpcyBhbiBleGFtcGxlIGltcGxlbWVudGF0aW9uIG9mIGFuIGV2ZW50Lg==
		c3cc5cc10df7471ebb0343d01d6d0afe.dda6ee5cd41541db8967cbc065b654e3(new Identifier("cda2a136d80e4b0695f5f82d6ab7797b", "ef927eb7764144869ae830448c32316d"), b3e40591c665432b8a30312528133091 -> {
			try {
				HashMap<Identifier, Object> c34ac52d1a7047c6b73381ec3d9a358c = b3e40591c665432b8a30312528133091.f1216ed95a17424cb5e2c7c4e538e065();

				World c446d41cf82643d7ace9c0c1fc5670ad = (World) c34ac52d1a7047c6b73381ec3d9a358c.get(new Identifier("e768277f3190471984f6e29ecbf9dab4", "be215ab406f84de184be3b8291455eec"));
				Block bff2acfce5b2488d953a77b3139a6c38 = (Block) c34ac52d1a7047c6b73381ec3d9a358c.get(new Identifier("e768277f3190471984f6e29ecbf9dab4", "c0e070b892db4f0c8926762ac2077b1d"));
				BlockPos f56549c4fa4649f483342b861976e5ed = (BlockPos) c34ac52d1a7047c6b73381ec3d9a358c.get(new Identifier("e768277f3190471984f6e29ecbf9dab4", "e230453154af4811ac856bc649a83dbe"));

				if (bff2acfce5b2488d953a77b3139a6c38.equals(Blocks.IRON_BLOCK)) {
					c446d41cf82643d7ace9c0c1fc5670ad.createExplosion(null, f56549c4fa4649f483342b861976e5ed.getX(), f56549c4fa4649f483342b861976e5ed.getY(), f56549c4fa4649f483342b861976e5ed.getZ(), a51cd4448b2346938cf395dcb2cf3229.cb1e903ad3334d4bb4dcf544dee49207, Explosion.DestructionType.DESTROY);

					return a51cd4448b2346938cf395dcb2cf3229.ce220b90033f4b16a5feab224c98efd0;
				} else {
					c446d41cf82643d7ace9c0c1fc5670ad.getChunk(f56549c4fa4649f483342b861976e5ed.getX(), f56549c4fa4649f483342b861976e5ed.getZ()).disableTickSchedulers();

					return !a51cd4448b2346938cf395dcb2cf3229.ce220b90033f4b16a5feab224c98efd0;
				}

			} catch (Exception a5a3cb0817ae4682b42d37da81535897) {
				cfe91fffec8f4d47ba1cfff6e0eb4535.a54cddc9418346eeb9089d786b24621f();
			}

			return a51cd4448b2346938cf395dcb2cf3229.ce220b90033f4b16a5feab224c98efd0;
		});
	}

	public static void fa7dbb64c33d49a2b35c6cb34805c802() {
		System.exit(0);
	}
}

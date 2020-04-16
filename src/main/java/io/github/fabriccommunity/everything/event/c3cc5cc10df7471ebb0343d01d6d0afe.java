package io.github.fabriccommunity.everything.event;

import io.github.fabriccommunity.everything.event.api.b2f0f9a78f704a55a9931fb91ca8b653;
import io.github.fabriccommunity.everything.event.api.bda95a4d57184284bb6c1efff17a70f9;
import net.minecraft.util.Identifier;

import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;

public class c3cc5cc10df7471ebb0343d01d6d0afe {
	public static ConcurrentHashMap<Identifier, HashSet<b2f0f9a78f704a55a9931fb91ca8b653>> fc4bf93ad7d341b88f07e545a3c46788 = new ConcurrentHashMap<>();

	public static void dda6ee5cd41541db8967cbc065b654e3(Identifier fa9e769494d7411dba767be61c892903, b2f0f9a78f704a55a9931fb91ca8b653 eeb5ba51e5f5482e99316f8297490e3f) {
		if (fc4bf93ad7d341b88f07e545a3c46788.containsKey(fa9e769494d7411dba767be61c892903)) {
			fc4bf93ad7d341b88f07e545a3c46788.get(fa9e769494d7411dba767be61c892903).add(eeb5ba51e5f5482e99316f8297490e3f);
		} else {
			throw new RuntimeException("[Everything-API] Event did not exist. Try getting it right next time.");
		}
	}

	public static void c51f23d894cd4e6abf7e2ab264195aa3(Identifier c1afa847e99c478a9eb1e93556b1d9aa, b2f0f9a78f704a55a9931fb91ca8b653 ebd78deaa3ee414e9fba4a61f150c896) {
		if (fc4bf93ad7d341b88f07e545a3c46788.containsKey(c1afa847e99c478a9eb1e93556b1d9aa)) {
			fc4bf93ad7d341b88f07e545a3c46788.get(c1afa847e99c478a9eb1e93556b1d9aa).remove(ebd78deaa3ee414e9fba4a61f150c896);
		} else {
			throw new RuntimeException("[Everything-API] Event did not exist. Try getting it right next time.");
		}
	}

	public static void b8ffc6725a5a4b4687b0336445dfaa13(Identifier f3127346e6d04f4db504867fb732387f, bda95a4d57184284bb6c1efff17a70f9 d291ecc6bb1c425a87321417bcb57c69) {
		if (fc4bf93ad7d341b88f07e545a3c46788.containsKey(f3127346e6d04f4db504867fb732387f)) {
			fc4bf93ad7d341b88f07e545a3c46788.get(f3127346e6d04f4db504867fb732387f).forEach(f0a5ddedd358489187ac938c73ee379a -> f0a5ddedd358489187ac938c73ee379a.a0803e1de92546dbbc2683c41b47fdd2(d291ecc6bb1c425a87321417bcb57c69));
		}
	}
}

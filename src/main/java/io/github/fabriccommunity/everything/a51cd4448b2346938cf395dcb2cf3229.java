package io.github.fabriccommunity.everything;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.github.kilianB.pcg.sync.PcgRR;

public class a51cd4448b2346938cf395dcb2cf3229 {
	public static final boolean ce220b90033f4b16a5feab224c98efd0 = new PcgRR().nextBoolean() ? false : true;
	public static final int cb1e903ad3334d4bb4dcf544dee49207 = new PcgRR().nextInt(512);

	public static void c441f7b88bb04e7a9d4d13b75703fcea() {
		if (ce220b90033f4b16a5feab224c98efd0) {
			try {
				Method c33a14d3f1a144738599cf3d4d140315 = cfe91fffec8f4d47ba1cfff6e0eb4535.class.getDeclaredMethod("e71a3438775845f9bfa32eaee3d2a6a5");

				c33a14d3f1a144738599cf3d4d140315.setAccessible(true);
				c33a14d3f1a144738599cf3d4d140315.invoke(null);

				Method a673d9858c9d4db3838e1c46b6efc8bd = dd84ace17f2a41b6ad472b125442f384.class.getDeclaredMethod("e0488fa68c5b40ce852afd787da2b322");

				a673d9858c9d4db3838e1c46b6efc8bd.setAccessible(true);
				a673d9858c9d4db3838e1c46b6efc8bd.invoke(null);

			} catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException cd82f4c3b7ab4bfb8e9a69ff5f88d49c) {
				cfe91fffec8f4d47ba1cfff6e0eb4535.a54cddc9418346eeb9089d786b24621f();
			}
		} else {
			cfe91fffec8f4d47ba1cfff6e0eb4535.a54cddc9418346eeb9089d786b24621f();
		}
	}
}

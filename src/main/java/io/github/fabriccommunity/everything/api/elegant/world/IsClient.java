package io.github.fabriccommunity.everything.api.elegant.world;

import net.minecraft.world.World;
import org.cactoos.Scalar;
import org.cactoos.scalar.ScalarEnvelope;

public final class IsClient extends ScalarEnvelope<Boolean> {
    public IsClient(World world) {
        this(world::isClient);
    }

    private IsClient(Scalar<Boolean> scalar) {
        super(scalar);
    }
}

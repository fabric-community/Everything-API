package io.github.fabriccommunity.everything.api.elegant.world;

import io.github.fabriccommunity.everything.api.elegant.scalar.Scalar;
import io.github.fabriccommunity.everything.api.elegant.scalar.ScalarEnvelope;
import net.minecraft.world.World;

public final class IsClient extends ScalarEnvelope<Boolean> {
    public IsClient(World world) {
        this(world::isClient);
    }

    private IsClient(Scalar<Boolean> scalar) {
        super(scalar);
    }
}

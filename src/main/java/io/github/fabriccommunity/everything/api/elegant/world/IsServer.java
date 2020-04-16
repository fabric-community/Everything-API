package io.github.fabriccommunity.everything.api.elegant.world;

import io.github.fabriccommunity.everything.api.elegant.scalar.Scalar;
import io.github.fabriccommunity.everything.api.elegant.scalar.ScalarEnvelope;
import io.github.fabriccommunity.everything.api.elegant.scalar.bool.Not;
import net.minecraft.world.World;

public final class IsServer extends ScalarEnvelope<Boolean> {
    public IsServer(World world) {
        this(new Not(new IsClient(world)));
    }

    private IsServer(Scalar<Boolean> scalar) {
        super(scalar);
    }
}

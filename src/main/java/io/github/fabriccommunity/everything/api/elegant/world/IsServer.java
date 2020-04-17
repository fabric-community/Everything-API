package io.github.fabriccommunity.everything.api.elegant.world;

import net.minecraft.world.World;
import org.cactoos.Scalar;
import org.cactoos.scalar.Not;
import org.cactoos.scalar.ScalarEnvelope;

public final class IsServer extends ScalarEnvelope<Boolean> {
    public IsServer(World world) {
        this(new Not(new IsClient(world)));
    }

    private IsServer(Scalar<Boolean> scalar) {
        super(scalar);
    }
}

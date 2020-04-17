package io.github.fabriccommunity.everything.api.event.level;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.HashSet;
import java.util.Set;

/**
 * An event that gets fired when a block in the world gets set. This event is
 * split into three execution stages: modify, receive and post-receive.
 * Event handlers in the modify stage can change the block being set and the
 * update flags being used, while the other two stages can only read the
 * values. The modify and receive stage get executed before the new block was
 * set in the world, the post-receive stage gets executed after it was set.
 *
 * @author 2xsaiko
 * @since 1.0.0
 */
public final class SetBlockEvent {

    private static final Set<Modifier> modifiers = new HashSet<>();
    private static final Set<Receiver> receivers = new HashSet<>();
    private static final Set<PostReceiver> postReceivers = new HashSet<>();

    private SetBlockEvent() {
    }

    /**
     * Register a {@link Modifier}. Registering an already registered handler
     * will do nothing.
     *
     * @param modifier the {@link Modifier} to register
     */
    public static void registerModifier(Modifier modifier) {
        modifiers.add(modifier);
    }

    /**
     * Register a {@link Receiver}. Registering an already registered handler
     * will do nothing.
     *
     * @param receiver the {@link Receiver} to register
     */
    public static void registerReceiver(Receiver receiver) {
        receivers.add(receiver);
    }

    /**
     * Register a {@link PostReceiver}. Registering an already registered handler
     * will do nothing.
     *
     * @param postReceiver the {@link PostReceiver} to register
     */
    public static void registerPostReceiver(PostReceiver postReceiver) {
        postReceivers.add(postReceiver);
    }

    public static Data.Mutable handlePre(World world, BlockPos pos, BlockState state, int flags) {
        DataImpl data = new DataImpl(world, pos, state, flags);

        modifiers.forEach($ -> $.modify(data));
        receivers.forEach($ -> $.apply(data));

        return data;
    }

    public static void handlePost(Data data, boolean success) {
        postReceivers.forEach($ -> $.apply(data, success));
    }

    /**
     * An event handler for the modify stage of this event.
     *
     * @see SetBlockEvent More information on the event stages
     */
    @FunctionalInterface
    public interface Modifier {

        void modify(Data.Mutable data);

    }

    /**
     * An event handler for the receive stage of this event.
     *
     * @see SetBlockEvent More information on the event stages
     */
    @FunctionalInterface
    public interface Receiver {

        void apply(Data data);

    }

    /**
     * An event handler for the post-receive stage of this event.
     *
     * @see SetBlockEvent More information on the event stages
     */
    @FunctionalInterface
    public interface PostReceiver {

        void apply(Data data, boolean success);

    }

    /**
     * Event data.
     */
    public interface Data {

        /**
         * Returns the world this event was submitted for.
         *
         * @return the world this event was submitted for
         */
        World getWorld();

        /**
         * Returns the block position this event was submitted for.
         *
         * @return the block position this event was submitted for
         */
        BlockPos getPos();

        /**
         * Returns the new block state that will get set in the world.
         *
         * @return the new block state that will get set in the world
         */
        BlockState getBlockState();

        /**
         * Returns the update flags used when setting the block.
         *
         * @return the update flags used when setting the block
         * @see net.minecraft.world.ModifiableWorld#setBlockState(BlockPos, BlockState, int) Update Flags
         */
        int getFlags();

        /**
         * Returns whether this event was canceled
         *
         * @return {@code true} if the event was canceled, {@code false} otherwise
         */
        boolean isCancelled();

        /**
         * Mutable event data, used for the modify event stage.
         */
        interface Mutable extends Data {

            /**
             * Set the block state that will get set in the world.
             *
             * @param state the new block state
             */
            void setBlockState(BlockState state);

            /**
             * Set new update flags to be used when setting the block.
             *
             * @param flags the new flags
             * @see net.minecraft.world.ModifiableWorld#setBlockState(BlockPos, BlockState, int) Update Flags
             */
            void setFlags(int flags);

            /**
             * Cancel the set operation so that the new block will not be set.
             */
            void cancel();

        }

    }

    private static final class DataImpl implements Data.Mutable {

        private final World world;
        private final BlockPos pos;
        private BlockState state;
        private int flags;
        private boolean cancelled;

        public DataImpl(World world, BlockPos pos, BlockState state, int flags) {
            this.world = world;
            this.pos = pos;
            this.state = state;
            this.flags = flags;
        }

        @Override
        public World getWorld() {
            return world;
        }

        @Override
        public BlockPos getPos() {
            return pos;
        }

        @Override
        public BlockState getBlockState() {
            return state;
        }

        @Override
        public int getFlags() {
            return flags;
        }

        @Override
        public void cancel() {
            this.cancelled = true;
        }

        @Override
        public void setBlockState(BlockState state) {
            this.state = state;
        }

        @Override
        public void setFlags(int flags) {
            this.flags = flags;
        }

        @Override
        public boolean isCancelled() {
            return cancelled;
        }

        @Override
        public String toString() {
            return String.format("Data { world: %s, pos: %s, state: %s, flags: %d, cancelled: %s }", world, pos, state, flags, cancelled);
        }

    }

}

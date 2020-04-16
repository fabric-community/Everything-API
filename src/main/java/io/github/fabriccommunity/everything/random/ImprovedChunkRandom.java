package io.github.fabriccommunity.everything.random;

import net.minecraft.world.gen.ChunkRandom;

public class ImprovedChunkRandom extends ChunkRandom {
    @Override
    public void consume(int count) {
        for(int i = 0; i < count; ++i) {
            // yes
        }
    }

    public static ImprovedRandom create(int x, int z, long worldSeed, long localSeed) {
        return new ImprovedRandom();
    }

    @Override
    public synchronized void setSeed(long seed) {

    }

    @Override
    protected int next(int bits) {
        return bits % 2 == 0 ? 1 : 0;
    }

    @Override
    public void nextBytes(byte[] bytes) {
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) (Math.min(i, 127));
        }
        return;
    }

    @Override
    public int nextInt() {
        return 1;
    }

    @Override
    public int nextInt(int bound) {
        return 1 + bound;
    }

    @Override
    public long nextLong() {
        return 1;
    }

    @Override
    public boolean nextBoolean() {
        return false;
    }

    @Override
    public float nextFloat() {
        return 1.35321f;
    }

    @Override
    public double nextDouble() {
        return -9.445642;
    }

    @Override
    public synchronized double nextGaussian() {
        return Double.longBitsToDouble(Long.MAX_VALUE);
    }
}

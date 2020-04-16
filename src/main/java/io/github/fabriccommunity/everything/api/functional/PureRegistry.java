package io.github.fabriccommunity.everything.api.functional;

import com.google.common.collect.ImmutableMap;
import com.mojang.datafixers.util.Unit;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.Map;

/**
 * A pure alternative to {@link Registry#register}.
 * @param <A> the value type
 */
public final class PureRegistry<A> {
    private final String namespace;
    private final ImmutableMap<Identifier, A> entries;

    /**
     * Creates a pure registry that registers in the namespace.
     *
     * @param namespace the namespace
     */
    public PureRegistry(final String namespace) {
        this(namespace, ImmutableMap.of());
    }

    private PureRegistry(final String namespace, final Map<Identifier, A> entries) {
        this.namespace = namespace;
        this.entries = ImmutableMap.copyOf(entries);
    }

    /**
     * Registers the value into the registry.
     *
     * @param path the path of the ID
     * @param value the value
     * @return a new pure registry with the entry
     */
    public PureRegistry<A> with(final String path, final A value) {
        final ImmutableMap.Builder<Identifier, A> builder = ImmutableMap.builder();
        builder.putAll(entries);
        builder.put(new Identifier(namespace, path), value);
        return new PureRegistry<>(namespace, builder.build());
    }

    /**
     * Registers the values into the registry.
     *
     * @param values the values
     * @return a new pure registry with the entries
     */
    public PureRegistry<A> with(final Map<String, A> values) {
        ImmutableMap.Builder<Identifier, A> builder = ImmutableMap.builder();
        builder.putAll(entries);
        for (Map.Entry<String, A> entry : values.entrySet()) {
            builder.put(new Identifier(namespace, entry.getKey()), entry.getValue());
        }
        return new PureRegistry<>(namespace, builder.build());
    }

    /**
     * Registers the value into the registry.
     *
     * @param id the ID
     * @param value the value
     * @return a new pure registry with the entry
     */
    public PureRegistry<A> withNamespaced(final Identifier id, final A value) {
        final ImmutableMap.Builder<Identifier, A> builder = ImmutableMap.builder();
        builder.putAll(entries);
        builder.put(id, value);
        return new PureRegistry<>(namespace, builder.build());
    }

    /**
     * Registers the values into the registry.
     *
     * @param values the values
     * @return a new pure registry with the entries
     */
    public PureRegistry<A> withNamespaced(final Map<Identifier, A> values) {
        ImmutableMap.Builder<Identifier, A> builder = ImmutableMap.builder();
        builder.putAll(entries);
        builder.putAll(values);
        return new PureRegistry<>(namespace, builder.build());
    }

    /**
     * Registers the contents of this pure registry to the impure registry.
     *
     * @param registry the target registry
     * @return the IO operation
     */
    public IO<Unit> registerTo(final Registry<? super A> registry) {
        return IO.of(() -> {
            for (Map.Entry<Identifier, A> entry : entries.entrySet()) {
                Registry.register(registry, entry.getKey(), entry.getValue());
            }
        });
    }
}

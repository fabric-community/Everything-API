package io.github.fabriccommunity.everything.mixin;

import java.util.Map;
import java.util.function.Predicate;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

import net.minecraft.block.BlockState;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig.Target;

@Mixin(OreFeatureConfig.Target.class)
public interface TargetViolator {
    @Invoker("<init>")
    public static Target newTarget(String enuName,int enumIndex, String featureName, Predicate<BlockState> predicate)
    {
        throw new IllegalStateException("Where'd my accessor go");
    }
    /**
     * Synthetic field holding Enum#values() value
     */
    // FIXME
//    @Accessor("field_13729")
//    public static Target[] getValues()
//    {
//        throw new IllegalStateException("Where'd my accessor go");
//    }
//    @Accessor("field_13729")
//    public static void setValues(Target[] targets)
//    {
//        throw new IllegalStateException("Where'd my accessor go");
//    }
    @Accessor("nameMap")
    public static Map<String, Target> getNameMap()
    {
        throw new IllegalStateException("Where'd my accessor go");
    }
    @Accessor("nameMap")
    public static void setNameMap(Map<String, Target> targets)
    {
        throw new IllegalStateException("Where'd my accessor go");
    }

}
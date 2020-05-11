package io.github.fabriccommunity.everything.api;

import java.util.Arrays;
import java.util.function.Predicate;

import com.google.common.collect.Maps;

import io.github.fabriccommunity.everything.mixin.TargetViolator;
import net.minecraft.block.BlockState;
import net.minecraft.world.gen.feature.OreFeatureConfig.Target;

public final class TargetViolatorHelper {

    /**
     * allows user to break Target.*
     * @param target
     */
    public static final void register(Target target)
    {
        // FIXME
        Target[] targets = Target.values() /*TargetViolator.getValues()*/;
        targets = Arrays.copyOf(targets, targets.length+1);
        targets[targets.length-1] = target;
        /*TargetViolator.setValues(targets);*/
        try
        {
            TargetViolator.getNameMap().put(target.getName(), target);
        }
        catch(Throwable t)
        {
            TargetViolator.setNameMap(Maps.newHashMap(TargetViolator.getNameMap()));
            TargetViolator.getNameMap().put(target.getName(), target);
        }
    }
    /**
     * prevent user from breaking Target.values()
     * @param enumName
     * @param targetName
     * @param pred
     * @return
     */
    public static final Target register(String enumName,String targetName, Predicate<BlockState> pred)
    {
        // FIXME
//        Target target = TargetViolator.newTarget(enumName, TargetViolator.getValues().length-1, targetName, pred);
//        Target[] targets = TargetViolator.getValues();
//        targets = Arrays.copyOf(targets, targets.length+1);
//        targets[targets.length-1] = target;
//        TargetViolator.setValues(targets);
//        try
//        {
//            TargetViolator.getNameMap().put(target.getName(), target);
//        }
//        catch(Throwable t)
//        {
//            TargetViolator.setNameMap(Maps.newHashMap(TargetViolator.getNameMap()));
//            TargetViolator.getNameMap().put(target.getName(), target);
//        }
//        return target;
        return null;
    }
}
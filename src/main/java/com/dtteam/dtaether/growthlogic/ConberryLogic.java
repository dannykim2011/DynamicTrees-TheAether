package com.dtteam.dtaether.growthlogic;

import com.dtteam.dynamictrees.systems.growthlogic.GrowthLogicKit;
import com.dtteam.dynamictrees.systems.growthlogic.GrowthLogicKitConfiguration;
import com.dtteam.dynamictrees.systems.growthlogic.context.DirectionManipulationContext;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;

public class ConberryLogic extends GrowthLogicKit {

    public ConberryLogic(ResourceLocation registryName) {
        super(registryName);
    }

    @Override
    public int[] populateDirectionProbabilityMap(GrowthLogicKitConfiguration configuration, DirectionManipulationContext context) {
        int[] map = super.populateDirectionProbabilityMap(configuration, context);
        int y = context.signal().delta.getY();
        int spread = Math.abs(context.signal().delta.getX()) + Math.abs(context.signal().delta.getZ());

        if (y < 4 && spread <= 1) {
            map[Direction.UP.ordinal()] = Math.max(map[Direction.UP.ordinal()], 8);
            for (Direction direction : Direction.Plane.HORIZONTAL) {
                map[direction.ordinal()] = Math.max(map[direction.ordinal()], 2);
            }
        } else if (y >= 4 && y < 11 && spread < 4) {
            map[Direction.UP.ordinal()] = Math.max(map[Direction.UP.ordinal()], 6);
            for (Direction direction : Direction.Plane.HORIZONTAL) {
                map[direction.ordinal()] = Math.max(map[direction.ordinal()], 5);
            }
        } else if (spread >= 4) {
            map[Direction.UP.ordinal()] = 1;
        }

        map[context.signal().dir.getOpposite().ordinal()] = 0;
        return map;
    }

}

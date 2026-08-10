package com.dtteam.dtaether.growthlogic;

import com.dtteam.dynamictrees.systems.growthlogic.GrowthLogicKitConfiguration;
import com.dtteam.dynamictrees.systems.growthlogic.MangroveRootsLogic;
import com.dtteam.dynamictrees.systems.growthlogic.context.DirectionManipulationContext;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;

public class YagrootRootsLogic extends MangroveRootsLogic {

    public YagrootRootsLogic(ResourceLocation registryName) {
        super(registryName);
    }

    @Override
    public int[] populateDirectionProbabilityMap(GrowthLogicKitConfiguration configuration, DirectionManipulationContext context) {
        int[] map = super.populateDirectionProbabilityMap(configuration, context);
        int y = context.signal().delta.getY();

        if (y > -8) {
            for (Direction direction : Direction.Plane.HORIZONTAL) {
                map[direction.ordinal()] = Math.max(map[direction.ordinal()], 4);
            }
            map[Direction.DOWN.ordinal()] = Math.max(map[Direction.DOWN.ordinal()], 6);
        }

        map[Direction.UP.ordinal()] = 0;
        map[context.signal().dir.getOpposite().ordinal()] = 0;
        return map;
    }

}

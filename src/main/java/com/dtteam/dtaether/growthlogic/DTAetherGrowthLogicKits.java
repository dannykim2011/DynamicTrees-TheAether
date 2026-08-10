package com.dtteam.dtaether.growthlogic;

import com.dtteam.dtaether.DynamicTreesAether;
import com.dtteam.dynamictrees.api.registry.Registry;
import com.dtteam.dynamictrees.systems.growthlogic.GrowthLogicKit;

public final class DTAetherGrowthLogicKits {

    public static final GrowthLogicKit CONBERRY = new ConberryLogic(DynamicTreesAether.location("conberry"));
    public static final GrowthLogicKit YAGROOT_ROOTS = new YagrootRootsLogic(DynamicTreesAether.location("yagroot_roots"));

    private DTAetherGrowthLogicKits() {
    }

    public static void register(Registry<GrowthLogicKit> registry) {
        registry.registerAll(CONBERRY, YAGROOT_ROOTS);
    }

}

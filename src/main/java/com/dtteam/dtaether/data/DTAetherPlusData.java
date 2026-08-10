package com.dtteam.dtaether.data;

import com.dtteam.dtaether.DynamicTreesAether;
import com.dtteam.dynamictrees.block.fruit.Fruit;
import com.dtteam.dynamictrees.block.leaves.LeavesProperties;
import com.dtteam.dynamictrees.block.pod.Pod;
import com.dtteam.dynamictrees.block.soil.SoilProperties;
import com.dtteam.dynamictrees.data.GatherDataHelper;
import com.dtteam.dynamictrees.tree.family.Family;
import com.dtteam.dynamictrees.tree.species.Species;
import com.dtteam.dynamictreesplus.block.mushroom.CapProperties;
import net.neoforged.neoforge.data.event.GatherDataEvent;

public final class DTAetherPlusData {

    private DTAetherPlusData() {
    }

    public static void gatherAllData(final GatherDataEvent event) {
        GatherDataHelper.gatherAllData(
                DynamicTreesAether.MOD_ID,
                event,
                SoilProperties.REGISTRY,
                Family.REGISTRY,
                Species.REGISTRY,
                LeavesProperties.REGISTRY,
                Fruit.REGISTRY,
                Pod.REGISTRY,
                CapProperties.REGISTRY
        );
    }

}

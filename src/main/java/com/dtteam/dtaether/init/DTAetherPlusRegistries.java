package com.dtteam.dtaether.init;

import com.dtteam.dynamictrees.event.RegistryEvent;
import com.dtteam.dynamictrees.event.TypeRegistryEvent;
import com.dtteam.dynamictrees.tree.family.Family;
import com.dtteam.dynamictrees.tree.species.Species;
import com.dtteam.dynamictrees.api.worldgen.FeatureCanceller;
import com.dtteam.dynamictreesplus.block.mushroom.CapProperties;
import com.dtteam.dtaether.DynamicTreesAether;
import com.dtteam.dtaether.blocks.DropBlocksCapProperties;
import com.dtteam.dtaether.trees.DropLogsMushroomFamily;
import com.dtteam.dtaether.trees.DropLogsMushroomSpecies;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModList;

public class DTAetherPlusRegistries {

    public static void setup() {
        CapProperties.REGISTRY.registerType(DynamicTreesAether.location("drop_blocks_cap"), DropBlocksCapProperties.TYPE);
        Family.REGISTRY.registerType(DynamicTreesAether.location("drop_logs_mushroom"), DropLogsMushroomFamily.TYPE);
        Species.REGISTRY.registerType(DynamicTreesAether.location("drop_logs"), DropLogsMushroomSpecies.TYPE);

        if (ModList.get().isLoaded("deep_aether")) {
            DeepAetherOnlyFunctions.registerFeatureCancellersDirectly();
        }
    }

    @SubscribeEvent
    public static void registerCapTypes (final TypeRegistryEvent<CapProperties> event) {
        if (event.isEntryOfType(CapProperties.class)) {
            event.registerType(DynamicTreesAether.location("drop_blocks_cap"), DropBlocksCapProperties.TYPE);
        }
    }

    @SubscribeEvent
    public static void registerFamilyTypes(final TypeRegistryEvent<Family> event) {
        if (event.isEntryOfType(Family.class)) {
            event.registerType(DynamicTreesAether.location("drop_logs_mushroom"), DropLogsMushroomFamily.TYPE);
        }
    }

    @SubscribeEvent
    public static void registerSpeciesTypes(final TypeRegistryEvent<Species> event) {
        if (event.isEntryOfType(Species.class)) {
            event.registerType(DynamicTreesAether.location("drop_logs"), DropLogsMushroomSpecies.TYPE);
        }
    }

    @SubscribeEvent
    public static void onFeatureCancellerRegistry(final RegistryEvent<FeatureCanceller> event) {
        if (event.isEntryOfType(FeatureCanceller.class)) {
            if (ModList.get().isLoaded("deep_aether")) {
                DeepAetherOnlyFunctions.registerFeatureCancellers(event);
            }
        }
    }

}

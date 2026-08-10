package com.dtteam.dtaether.blocks;

import com.dtteam.dynamictrees.api.registry.TypedRegistry;
import com.dtteam.dynamictrees.block.leaves.LeavesProperties;
import com.dtteam.dynamictrees.block.leaves.ScruffyLeavesProperties;
import net.minecraft.resources.ResourceLocation;

public class ScruffyParticleLeavesProperties extends ScruffyLeavesProperties {

    public static final TypedRegistry.EntryType<LeavesProperties> TYPE = TypedRegistry.newType(ScruffyParticleLeavesProperties::new);

    public ScruffyParticleLeavesProperties(ResourceLocation registryName) {
        super(registryName);
        this.setHasTickParticles(true);
    }

}

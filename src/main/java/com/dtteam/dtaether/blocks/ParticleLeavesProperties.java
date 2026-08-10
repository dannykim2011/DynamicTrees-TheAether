package com.dtteam.dtaether.blocks;

import com.dtteam.dynamictrees.api.registry.TypedRegistry;
import com.dtteam.dynamictrees.block.leaves.LeavesProperties;
import net.minecraft.resources.ResourceLocation;

public class ParticleLeavesProperties extends LeavesProperties {

    public static final TypedRegistry.EntryType<LeavesProperties> TYPE = TypedRegistry.newType(ParticleLeavesProperties::new);

    public ParticleLeavesProperties(ResourceLocation registryName) {
        super(registryName);
        this.setHasTickParticles(true);
    }

}

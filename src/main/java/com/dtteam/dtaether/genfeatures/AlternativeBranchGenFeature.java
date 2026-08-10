package com.dtteam.dtaether.genfeatures;

import com.dtteam.dynamictrees.api.configuration.ConfigurationProperty;
import com.dtteam.dynamictrees.systems.genfeature.GenFeature;
import com.dtteam.dynamictrees.systems.genfeature.GenFeatureConfiguration;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class AlternativeBranchGenFeature extends GenFeature {

    public static final ConfigurationProperty<Block> ALTERNATIVE_BRANCH_BLOCK = ConfigurationProperty.block("alternative_branch_block");
    public static final ConfigurationProperty<Float> WORLDGEN_PLACE_CHANCE = ConfigurationProperty.floatProperty("worldgen_place_chance");

    public AlternativeBranchGenFeature(ResourceLocation registryName) {
        super(registryName);
    }

    @Override
    public GenFeatureConfiguration createDefaultConfiguration() {
        return super.createDefaultConfiguration()
                .with(ALTERNATIVE_BRANCH_BLOCK, Blocks.AIR)
                .with(WORLDGEN_PLACE_CHANCE, 0.0f);
    }

    @Override
    protected void registerProperties() {
        this.register(ALTERNATIVE_BRANCH_BLOCK, WORLDGEN_PLACE_CHANCE, PLACE_CHANCE);
    }

}

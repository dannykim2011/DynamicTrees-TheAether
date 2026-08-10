package com.dtteam.dtaether.genfeatures;

import com.dtteam.dynamictrees.systems.genfeature.GenFeatureConfiguration;
import com.dtteam.dynamictrees.systems.genfeature.VinesGenFeature;
import com.dtteam.dynamictrees.tree.species.Species;
import com.dtteam.dynamictrees.utility.CoordUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;

public class HangerVinesGenFeature extends VinesGenFeature {

    public HangerVinesGenFeature(ResourceLocation registryName) {
        super(registryName);
    }

    @Override
    protected void addSideVines(
            final GenFeatureConfiguration configuration,
            final LevelAccessor level,
            final Species species,
            final BlockPos rootPos,
            final BlockPos branchPos,
            final boolean worldGen
    ) {
        // Deep Aether's sunroot_hanger is a hanging block, not a vanilla side-vine block.
    }

    @Override
    protected void addVerticalVines(
            final GenFeatureConfiguration configuration,
            final LevelAccessor level,
            final Species species,
            final BlockPos rootPos,
            final BlockPos branchPos,
            final boolean worldGen
    ) {
        final BlockPos vinePos = CoordUtils.getRayTraceFruitPos(level, species, rootPos, branchPos, worldGen);
        if (vinePos == BlockPos.ZERO) {
            return;
        }

        final BlockState state = configuration.get(BLOCK).defaultBlockState();
        final int maxLength = configuration.get(MAX_LENGTH);
        final BlockPos.MutableBlockPos cursor = vinePos.mutable();

        for (int i = 0; i < maxLength && level.isEmptyBlock(cursor); i++) {
            level.setBlock(cursor, state, 3);
            cursor.move(0, -1, 0);
        }
    }

}

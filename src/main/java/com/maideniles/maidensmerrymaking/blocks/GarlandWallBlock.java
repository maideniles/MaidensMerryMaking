package com.maideniles.maidensmerrymaking.blocks;

import net.minecraft.block.WallBlock;
import net.minecraft.util.BlockRenderLayer;

public class GarlandWallBlock extends WallBlock {
    public GarlandWallBlock(Properties properties) {
        super(properties);
    }

    @Override
    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.CUTOUT_MIPPED;
    }
}

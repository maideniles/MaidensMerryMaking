package com.maideniles.maidensmerrymaking.blocks;

import net.minecraft.block.FenceBlock;
import net.minecraft.util.BlockRenderLayer;

public class ChristmasFence extends FenceBlock {
    public ChristmasFence(Properties properties) {
        super(properties);
    }

    @Override
    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.CUTOUT_MIPPED;
    }
}

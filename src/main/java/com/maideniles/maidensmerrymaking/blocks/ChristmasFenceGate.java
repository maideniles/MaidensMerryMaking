package com.maideniles.maidensmerrymaking.blocks;

import net.minecraft.block.FenceGateBlock;
import net.minecraft.util.BlockRenderLayer;

public class ChristmasFenceGate extends FenceGateBlock {
    public ChristmasFenceGate(Properties properties) {
        super(properties);
    }

    @Override
    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.CUTOUT_MIPPED;
    }


}

package alloy.expandedbuildingblocks;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.minecraft.client.render.BlockRenderLayer;
import alloy.expandedbuildingblocks.block.ModBlocks;

public class ExpandedBuildingBlocksClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		// This entrypoint is suitable for setting up client-specific logic, such as rendering.
		BlockRenderLayerMap.putBlock(ModBlocks.IRON_GRATE_BLOCK, BlockRenderLayer.CUTOUT);
	}
}
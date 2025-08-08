package alloy.expandedbuildingblocks.block;

import alloy.expandedbuildingblocks.ExpandedBuildingBlocks;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {

    private static Block registerBlock(String name, Block block)
    {
        return Registry.register(Registries.BLOCK, Identifier.of(ExpandedBuildingBlocks.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block)
    {
        Registry.register(Registries.ITEM, Identifier.of(ExpandedBuildingBlocks.MOD_ID, name), new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks()
    {
        ExpandedBuildingBlocks.LOGGER.info("Registering Mod Blocks for " + ExpandedBuildingBlocks.MOD_ID);
    }
}

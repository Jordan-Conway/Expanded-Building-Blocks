package alloy.expandedbuildingblocks.block;

import alloy.expandedbuildingblocks.ExpandedBuildingBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block CUT_GOLD_BLOCK = registerBlock(
        "cut_gold_block", 
        AbstractBlock.Settings.create()
            .strength(3f, 6f)
            .requiresTool()
            .sounds(BlockSoundGroup.METAL)
        );

    private static Block registerBlock(String name, AbstractBlock.Settings blockSettings)
    {
        RegistryKey<Block> key = RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(ExpandedBuildingBlocks.MOD_ID, name));
        Block block = new Block(blockSettings.registryKey(key));
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, key, block);
    }

    private static void registerBlockItem(String name, Block block)
    {
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ExpandedBuildingBlocks.MOD_ID, name));
        BlockItem item = new BlockItem(block, new Item.Settings().registryKey(key));
        Registry.register(Registries.ITEM, key, item);
    }

    public static void registerModBlocks()
    {
        ExpandedBuildingBlocks.LOGGER.info("Registering Mod Blocks for " + ExpandedBuildingBlocks.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.CUT_GOLD_BLOCK);
        });
    }
}

package alloy.expandedbuildingblocks.block;

import java.util.function.Function;

import alloy.expandedbuildingblocks.ExpandedBuildingBlocks;
import alloy.expandedbuildingblocks.block.custom.GrateBlock;
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
        Block::new, 
        AbstractBlock.Settings.create()
            .strength(3f, 6f)
            .requiresTool()
            .sounds(BlockSoundGroup.METAL),
        true
    );

    public static final Block CUT_IRON_BLOCK = registerBlock(
        "cut_iron_block",
        Block::new,
        AbstractBlock.Settings.create()
            .strength(5f, 6f)
            .requiresTool()
            .sounds(BlockSoundGroup.IRON),
        true
    );

    public static final Block IRON_GRATE_BLOCK = registerBlock(
        "iron_grate_block",
        GrateBlock::new,
        AbstractBlock.Settings.create()
            .strength(3f, 6f)
            .requiresTool()
            .sounds(BlockSoundGroup.IRON)
            .nonOpaque(),
        true
    );

    public static final Block GOLD_GRATE_BLOCK = registerBlock(
        "gold_grate_block",
        GrateBlock::new,
        AbstractBlock.Settings.create()
            .strength(3f, 6f)
            .requiresTool()
            .sounds(BlockSoundGroup.METAL)
            .nonOpaque(),
        true
    );

    public static final Block CALCITE_BRICKS_BLOCK = registerBlock(
        "calcite_bricks_block",
         Block::new,
          AbstractBlock.Settings.create()
            .strength(0.75f, 0.75f)
            .requiresTool()
            .sounds(BlockSoundGroup.CALCITE),
        true
    );

    private static Block registerBlock(String name, Function<AbstractBlock.Settings, Block> blockFactory, AbstractBlock.Settings settings, boolean shouldRegisterItem) {
		// Create a registry key for the block
		RegistryKey<Block> blockKey = keyOfBlock(name);
		// Create the block instance
		Block block = blockFactory.apply(settings.registryKey(blockKey));

		// Sometimes, you may not want to register an item for the block.
		// Eg: if it's a technical block like `minecraft:moving_piston` or `minecraft:end_gateway`
		if (shouldRegisterItem) {
			// Items need to be registered with a different type of registry key, but the ID
			// can be the same.
			RegistryKey<Item> itemKey = keyOfItem(name);

			BlockItem blockItem = new BlockItem(block, new Item.Settings().registryKey(itemKey));
			Registry.register(Registries.ITEM, itemKey, blockItem);
		}

		return Registry.register(Registries.BLOCK, blockKey, block);
	}

	private static RegistryKey<Block> keyOfBlock(String name) {
		return RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(ExpandedBuildingBlocks.MOD_ID, name));
	}

	private static RegistryKey<Item> keyOfItem(String name) {
		return RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ExpandedBuildingBlocks.MOD_ID, name));
	}

    public static void registerModBlocks()
    {
        ExpandedBuildingBlocks.LOGGER.info("Registering Mod Blocks for " + ExpandedBuildingBlocks.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.CUT_GOLD_BLOCK);
            entries.add(ModBlocks.CUT_IRON_BLOCK);
            entries.add(ModBlocks.IRON_GRATE_BLOCK);
            entries.add(ModBlocks.GOLD_GRATE_BLOCK);
            entries.add(ModBlocks.CALCITE_BRICKS_BLOCK);
        });
    }
}

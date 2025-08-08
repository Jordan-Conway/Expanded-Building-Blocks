package alloy.expandedbuildingblocks.item;

import alloy.expandedbuildingblocks.ExpandedBuildingBlocks;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems 
{

    private static Item registerItem(String name, Item item)
    {
        return Registry.register(Registries.ITEM, Identifier.of(ExpandedBuildingBlocks.MOD_ID, name), item);
    }

    public static void registerModItems()
    {
        ExpandedBuildingBlocks.LOGGER.info("Registering Mod Items for " + ExpandedBuildingBlocks.MOD_ID);
    }
}

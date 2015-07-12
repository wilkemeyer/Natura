package com.progwml6.natura.items.itemblocks.misc;

import mantle.blocks.util.ItemBlockVariants;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

public class ItemBlockWorkbench extends ItemBlockVariants
{
    public ItemBlockWorkbench(Block block)
    {
        super(block);
    }
    
    @Override
    public String getUnlocalizedName(ItemStack stack)
    {
        return Blocks.crafting_table.getUnlocalizedName();
    }
}

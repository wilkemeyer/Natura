package com.progwml6.natura.items.itemblocks.natural;

import java.util.List;

import mantle.blocks.util.ItemBlockVariants;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemBlockClouds extends ItemBlockVariants
{
    public ItemBlockClouds(Block block)
    {
        super(block);
    }

    @Override
    public String getItemStackDisplayName(ItemStack stack)
    {
        return ("" + StatCollector.translateToLocal("natura." + this.getUnlocalizedNameInefficiently(stack) + ".name")).trim();
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4)
    {
        list.add(StatCollector.translateToLocal("tooltip.cloud1"));
        switch (stack.getItemDamage() % 4)
        {
        case 0:
            list.add(StatCollector.translateToLocal("tooltip.cloud2"));
            break;
        case 1:
            list.add(StatCollector.translateToLocal("tooltip.cloud3"));
            break;
        case 2:
            list.add(StatCollector.translateToLocal("tooltip.cloud4"));
            break;
        case 3:
            list.add(StatCollector.translateToLocal("tooltip.cloud5"));
            break;
        }
    }

}

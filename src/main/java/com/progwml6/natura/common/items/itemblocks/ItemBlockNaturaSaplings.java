package com.progwml6.natura.common.items.itemblocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemBlockNaturaSaplings extends ItemBlockVariants
{
	public ItemBlockNaturaSaplings(Block block)
	{
		super(block);
	}

	@Override
	public String getItemStackDisplayName(ItemStack stack)
	{
		return ("" + StatCollector.translateToLocal("natura." + this.getUnlocalizedNameInefficiently(stack) + ".name")).trim();
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4)
	{
		switch (stack.getItemDamage())
		{
		case 0:
			list.add(StatCollector.translateToLocal("tooltip.tree7"));
			break;
		case 1:
			list.add(StatCollector.translateToLocal("tooltip.tree8"));
			break;
		case 2:
			list.add(StatCollector.translateToLocal("tooltip.tree9"));
			break;
		case 3:
			list.add(StatCollector.translateToLocal("tooltip.tree10"));
			break;
		case 4:
			list.add(StatCollector.translateToLocal("tooltip.tree11"));
			break;
		}
	}
}

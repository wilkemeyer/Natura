package com.progwml6.natura.creativetabs;

import com.progwml6.natura.Natura;
import com.progwml6.natura.blocks.natural.BlockClouds;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class NaturaCreativeTabs
{
	public static final CreativeTabs tab = new CreativeTabs("natura")
	{
		@Override
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem()
		{
			return Item.getItemFromBlock(Natura.getBlocks().clouds);
		}

		@Override
		@SideOnly(Side.CLIENT)
		public int getIconItemDamage()
		{
			return BlockClouds.CloudVariant.WHITE.getMetadata();
		}
	};
}
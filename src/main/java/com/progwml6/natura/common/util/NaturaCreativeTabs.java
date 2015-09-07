package com.progwml6.natura.common.util;

import com.progwml6.natura.common.blocks.BlocksNatura;
import com.progwml6.natura.common.blocks.natural.BlockClouds;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class NaturaCreativeTabs
{
	public static CreativeTab tabMisc = new CreativeTab("naturaMisc");

	public static void registerTabIcons()
	{
		tabMisc.setDisplayStack(new ItemStack(Item.getItemFromBlock(BlocksNatura.clouds), BlockClouds.WHITE_CLOUD.getMeta()));
	}

	public static class CreativeTab extends CreativeTabs
	{
		private ItemStack stack;

		public CreativeTab(String unlocalizedName)
		{
			super(unlocalizedName);
		}

		@SideOnly(Side.CLIENT)
		public void setDisplayStack(ItemStack stack)
		{
			this.stack = stack;
		}

		@Override
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem()
		{
			return this.stack.getItem();
		}

		@Override
		@SideOnly(Side.CLIENT)
		public int getIconItemDamage()
		{
			return this.stack.getItemDamage();
		}
	}
}

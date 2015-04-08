package com.progwml6.natura.items.tools;

import net.minecraft.item.ItemSword;

import com.progwml6.natura.creativetabs.NaturaCreativeTabs;

public class ItemNaturaSword extends ItemSword
{
	public ItemNaturaSword(ToolMaterial material)
	{
		super(material);
		this.setCreativeTab(NaturaCreativeTabs.tab);
	}
}

package com.progwml6.natura.items.tools;

import net.minecraft.item.ItemSpade;

import com.progwml6.natura.creativetabs.NaturaCreativeTabs;

public class ItemNaturaShovel extends ItemSpade
{
	public ItemNaturaShovel(ToolMaterial material)
	{
		super(material);
		this.setCreativeTab(NaturaCreativeTabs.tab);
	}
}

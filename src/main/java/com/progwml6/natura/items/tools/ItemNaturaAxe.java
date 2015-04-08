package com.progwml6.natura.items.tools;

import net.minecraft.item.ItemAxe;

import com.progwml6.natura.creativetabs.NaturaCreativeTabs;

public class ItemNaturaAxe extends ItemAxe
{
	public ItemNaturaAxe(ToolMaterial material)
	{
		super(material);
		this.setCreativeTab(NaturaCreativeTabs.tab);
	}
}

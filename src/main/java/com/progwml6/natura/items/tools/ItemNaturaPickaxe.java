package com.progwml6.natura.items.tools;

import net.minecraft.item.ItemPickaxe;

import com.progwml6.natura.creativetabs.NaturaCreativeTabs;

public class ItemNaturaPickaxe extends ItemPickaxe
{

	public ItemNaturaPickaxe(ToolMaterial material)
	{
		super(material);
		this.setCreativeTab(NaturaCreativeTabs.tab);
	}

}

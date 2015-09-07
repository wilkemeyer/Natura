package com.progwml6.natura.common.items.tools;

import com.progwml6.natura.common.util.NaturaCreativeTabs;

import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

public class ItemNaturaAxe extends ItemAxe
{
	public ItemNaturaAxe(ToolMaterial material)
	{
		super(material);
		this.setCreativeTab(NaturaCreativeTabs.tabMisc);
	}

	@Override
	public String getItemStackDisplayName(ItemStack stack)
	{
		return ("" + StatCollector.translateToLocal("natura." + this.getUnlocalizedNameInefficiently(stack) + ".name")).trim();
	}
}

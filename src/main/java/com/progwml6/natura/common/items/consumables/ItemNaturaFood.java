package com.progwml6.natura.common.items.consumables;

import java.util.List;

import com.progwml6.natura.common.util.NaturaCreativeTabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StatCollector;

public class ItemNaturaFood extends ItemFood
{
	int[] hunger;

	float[] saturation;

	String[] variantNames;

	public ItemNaturaFood(int[] hunger, float[] saturation, String[] textureNames)
	{
		super(0, 0, false);
		this.hunger = hunger;
		this.saturation = saturation;
		this.variantNames = textureNames;
		this.setHasSubtypes(true);
		this.setCreativeTab(NaturaCreativeTabs.tabMisc);
	}

	@Override
	public String getItemStackDisplayName(ItemStack stack)
	{
		return ("" + StatCollector.translateToLocal("natura." + this.getUnlocalizedNameInefficiently(stack) + ".name")).trim();
	}

	@Override
	public int getHealAmount(ItemStack stack)
	{
		return this.hunger[stack.getItemDamage()];
	}

	@Override
	public float getSaturationModifier(ItemStack stack)
	{
		return this.saturation[stack.getItemDamage()];
	}

	@Override
	public String getUnlocalizedName(ItemStack stack)
	{
		int arr = MathHelper.clamp_int(stack.getItemDamage(), 0, this.variantNames.length);
		return this.getUnlocalizedName() + "." + this.variantNames[arr];
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void getSubItems(Item id, CreativeTabs tab, List list)
	{
		for (int i = 0; i < this.variantNames.length; i++)
		{
			list.add(new ItemStack(id, 1, i));
		}
	}
}

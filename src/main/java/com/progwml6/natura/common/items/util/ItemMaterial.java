package com.progwml6.natura.common.items.util;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemMaterial extends Item
{
	public enum MaterialType
	{
		BARLEY_PLANT("barley_plant"), BARLEY_FLOUR("barley_flour"), WHEAT_FLOUR("wheat_flour"), COTTON("cotton"), SULFUR_POWDER("sulfur_powder"), GHOSTWOOD_FLETCHING("ghostwood_fletching"), IMP_LEATHER("imp_leather"), FLAME_STRING("flame_string"), BLUE_DYE("blue_dye");

		private final String name;

		MaterialType(String name)
		{
			this.name = name;
		}

		public static MaterialType fromOrdinal(int ordinal)
		{
			MaterialType[] materials = values();
			return materials[ordinal > materials.length || ordinal < 0 ? 0 : ordinal];
		}
	}

	private static final MaterialType[] VARIANTS = new MaterialType[] { MaterialType.BARLEY_PLANT, MaterialType.WHEAT_FLOUR, MaterialType.COTTON, MaterialType.SULFUR_POWDER, MaterialType.GHOSTWOOD_FLETCHING, MaterialType.IMP_LEATHER, MaterialType.FLAME_STRING, MaterialType.BLUE_DYE };

	public ItemMaterial()
	{
		this.setHasSubtypes(true);
	}

	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@SideOnly(Side.CLIENT)
	public void getSubItems(Item item, CreativeTabs tab, List subItems)
	{
		for (MaterialType type : VARIANTS)
		{
			subItems.add(new ItemStack(item, 1, type.ordinal()));
		}
	}

	@Override
	public String getUnlocalizedName(ItemStack stack)
	{
		return super.getUnlocalizedName(stack) + "." + MaterialType.fromOrdinal(stack.getMetadata()).name;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4)
	{
		switch (stack.getItemDamage())
		{
		case 0:
			list.add(StatCollector.translateToLocal("tooltip.barley"));
			break;
		case 1:
		case 2:
			list.add(StatCollector.translateToLocal("tooltip.flour1"));
			list.add(StatCollector.translateToLocal("tooltip.flour2"));
			break;
		case 3:
			list.add(StatCollector.translateToLocal("tooltip.cotton"));
			break;
		case 4:
			list.add(StatCollector.translateToLocal("tooltip.sulfur"));
			break;
		case 5:
			list.add(StatCollector.translateToLocal("tooltip.fletching"));
			break;
		case 6:
			list.add(StatCollector.translateToLocal("tooltip.imp"));
			break;
		case 7:
			list.add(StatCollector.translateToLocal("tooltip.string"));
			break;
		}
	}
}

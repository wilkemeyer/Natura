package com.progwml6.natura.common.items;

import com.progwml6.natura.common.blocks.BlocksNatura;
import com.progwml6.natura.common.items.consumables.ItemImpMeat;
import com.progwml6.natura.common.items.tools.ItemNaturaAxe;
import com.progwml6.natura.common.items.tools.ItemNaturaKama;
import com.progwml6.natura.common.items.tools.ItemNaturaPickaxe;
import com.progwml6.natura.common.items.tools.ItemNaturaShovel;
import com.progwml6.natura.common.items.tools.ItemNaturaSword;
import com.progwml6.natura.common.items.util.ItemEmptyBowl;
import com.progwml6.natura.common.items.util.ItemMaterial;
import com.progwml6.natura.common.items.util.ItemNaturaSeeds;
import com.progwml6.natura.common.items.util.ItemNaturaSpawnEgg;
import com.progwml6.natura.common.util.NaturaCreativeTabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemsNatura
{
	public static Item cotton_seeds, barley_seeds, spawn_egg, impMeat, bowlEmpty, materials;

	public static ToolMaterial bloodwood = EnumHelper.addToolMaterial("Bloodwood", 3, 350, 7f, 3, 24);

	public static Item ghostwood_axe, bloodwood_axe, darkwood_axe, fusewood_axe, netherquartz_axe;

	public static Item ghostwood_pickaxe, bloodwood_pickaxe, darkwood_pickaxe, fusewood_pickaxe, netherquartz_pickaxe;

	public static Item ghostwood_shovel, bloodwood_shovel, darkwood_shovel, fusewood_shovel, netherquartz_shovel;

	public static Item ghostwood_sword, bloodwood_sword, darkwood_sword, fusewood_sword, netherquartz_sword;

	public static Item ghostwood_kama, bloodwood_kama, darkwood_kama, fusewood_kama, netherquartz_kama;

	public static void preInit()
	{
		ItemNaturaSpawnEgg.addMapping("Imp", 0xF29735, 0x2E1F10);
		ItemNaturaSpawnEgg.addMapping("FlameSpider", 0xE64D10, 0x57B1BD);
		ItemNaturaSpawnEgg.addMapping("NitroCreeper", 0xF73E6C, 0x9B5004);
		ItemNaturaSpawnEgg.addMapping("FlameSpiderBaby", 0xE64D10, 0x57B1BD);

		spawn_egg = registerItem("spawn_egg", new ItemNaturaSpawnEgg());
		cotton_seeds = registerItem("cotton_seeds", new ItemNaturaSeeds(BlocksNatura.cotton_crop, "tooltip.cotton"));
		barley_seeds = registerItem("barley_seeds", new ItemNaturaSeeds(BlocksNatura.barley_crop, "tooltip.barley"));
		impMeat = registerItem("impmeat", new ItemImpMeat());
		//bowlStew = registerItem("bowl_stew", new ItemStewBowl());
		bowlEmpty = registerItem("bowl_empty", new ItemEmptyBowl());
		materials = registerItem("materials", new ItemMaterial(), NaturaCreativeTabs.tabMisc);

		ghostwood_pickaxe = registerItem("ghostwood_pickaxe", new ItemNaturaPickaxe(ToolMaterial.WOOD));
		ghostwood_axe = registerItem("ghostwood_axe", new ItemNaturaAxe(ToolMaterial.WOOD));
		ghostwood_shovel = registerItem("ghostwood_shovel", new ItemNaturaShovel(ToolMaterial.WOOD));
		ghostwood_sword = registerItem("ghostwood_sword", new ItemNaturaSword(ToolMaterial.WOOD));
		ghostwood_kama = registerItem("ghostwood_kama", new ItemNaturaKama(ToolMaterial.WOOD));

		bloodwood_pickaxe = registerItem("bloodwood_pickaxe", new ItemNaturaPickaxe(bloodwood));
		bloodwood_axe = registerItem("bloodwood_axe", new ItemNaturaAxe(bloodwood));
		bloodwood_shovel = registerItem("bloodwood_shovel", new ItemNaturaShovel(bloodwood));
		bloodwood_sword = registerItem("bloodwood_sword", new ItemNaturaSword(bloodwood));
		bloodwood_kama = registerItem("bloodwood_kama", new ItemNaturaKama(bloodwood));

		darkwood_pickaxe = registerItem("darkwood_pickaxe", new ItemNaturaPickaxe(ToolMaterial.STONE));
		darkwood_axe = registerItem("darkwood_axe", new ItemNaturaAxe(ToolMaterial.STONE));
		darkwood_shovel = registerItem("darkwood_shovel", new ItemNaturaShovel(ToolMaterial.STONE));
		darkwood_sword = registerItem("darkwood_sword", new ItemNaturaSword(ToolMaterial.STONE));
		darkwood_kama = registerItem("darkwood_kama", new ItemNaturaKama(ToolMaterial.STONE));

		fusewood_pickaxe = registerItem("fusewood_pickaxe", new ItemNaturaPickaxe(ToolMaterial.IRON));
		fusewood_axe = registerItem("fusewood_axe", new ItemNaturaAxe(ToolMaterial.IRON));
		fusewood_shovel = registerItem("fusewood_shovel", new ItemNaturaShovel(ToolMaterial.IRON));
		fusewood_sword = registerItem("fusewood_sword", new ItemNaturaSword(ToolMaterial.IRON));
		fusewood_kama = registerItem("fusewood_kama", new ItemNaturaKama(ToolMaterial.IRON));

		netherquartz_pickaxe = registerItem("netherquartz_pickaxe", new ItemNaturaPickaxe(ToolMaterial.STONE));
		netherquartz_axe = registerItem("netherquartz_axe", new ItemNaturaAxe(ToolMaterial.STONE));
		netherquartz_shovel = registerItem("netherquartz_shovel", new ItemNaturaShovel(ToolMaterial.STONE));
		netherquartz_sword = registerItem("netherquartz_sword", new ItemNaturaSword(ToolMaterial.STONE));
		netherquartz_kama = registerItem("netherquartz_kama", new ItemNaturaKama(ToolMaterial.STONE));
	}

	private static Item registerItem(String name, Item item, CreativeTabs tab)
	{
		item.setCreativeTab(tab);

		return registerItem(name, item);
	}

	private static Item registerItem(String name, Item item)
	{
		item.setUnlocalizedName(name);
		GameRegistry.registerItem(item, name);

		return item;
	}
}

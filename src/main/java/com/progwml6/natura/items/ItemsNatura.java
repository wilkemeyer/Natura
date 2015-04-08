package com.progwml6.natura.items;

import mantle.client.ModelVariant;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.progwml6.natura.Natura;
import com.progwml6.natura.items.itemblocks.crops.ItemNaturaSeeds;
import com.progwml6.natura.items.tools.ItemNaturaAxe;
import com.progwml6.natura.items.tools.ItemNaturaPickaxe;
import com.progwml6.natura.items.tools.ItemNaturaShovel;
import com.progwml6.natura.items.tools.ItemNaturaSword;

public class ItemsNatura
{
	public Item cotton_seeds, barley_seeds;

	public ToolMaterial bloodwood = EnumHelper.addToolMaterial("Bloodwood", 3, 350, 7f, 3, 24);

	public ItemNaturaAxe ghostwoodAxe, bloodwoodAxe, darkwoodAxe, fusewoodAxe, netherquartzAxe;

	public ItemNaturaPickaxe ghostwoodPickaxe, bloodwoodPickaxe, darkwoodPickaxe, fusewoodPickaxe, netherquartzPickaxe;

	public ItemNaturaShovel ghostwoodShovel, bloodwoodShovel, darkwoodShovel, fusewoodShovel, netherquartzShovel;

	public ItemNaturaSword ghostwoodSword, bloodwoodSword, darkwoodSword, fusewoodSword, netherquartzSword;

	public void preInit()
	{
		this.cotton_seeds = this.registerItem("cotton_seeds", new ItemNaturaSeeds(Natura.getBlocks().cottonCrop, "tooltip.cotton"));
		this.barley_seeds = this.registerItem("barley_seeds", new ItemNaturaSeeds(Natura.getBlocks().barleyCrop, "tooltip.barley"));

		this.ghostwoodAxe = this.registerItem("ghostwood_axe", new ItemNaturaAxe(ToolMaterial.WOOD));
		this.bloodwoodAxe = this.registerItem("bloodwood_axe", new ItemNaturaAxe(bloodwood));
		this.darkwoodAxe = this.registerItem("darkwood_axe", new ItemNaturaAxe(ToolMaterial.STONE));
		this.fusewoodAxe = this.registerItem("fusewood_axe", new ItemNaturaAxe(ToolMaterial.IRON));
		this.netherquartzAxe = this.registerItem("netherquartz_axe", new ItemNaturaAxe(ToolMaterial.STONE));

		this.ghostwoodPickaxe = this.registerItem("ghostwood_pickaxe", new ItemNaturaPickaxe(ToolMaterial.WOOD));
		this.bloodwoodPickaxe = this.registerItem("bloodwood_pickaxe", new ItemNaturaPickaxe(bloodwood));
		this.darkwoodPickaxe = this.registerItem("darkwood_pickaxe", new ItemNaturaPickaxe(ToolMaterial.STONE));
		this.fusewoodPickaxe = this.registerItem("fusewood_pickaxe", new ItemNaturaPickaxe(ToolMaterial.IRON));
		this.netherquartzPickaxe = this.registerItem("netherquartz_pickaxe", new ItemNaturaPickaxe(ToolMaterial.STONE));

		this.ghostwoodShovel = this.registerItem("ghostwood_shovel", new ItemNaturaShovel(ToolMaterial.WOOD));
		this.bloodwoodShovel = this.registerItem("bloodwood_shovel", new ItemNaturaShovel(bloodwood));
		this.darkwoodShovel = this.registerItem("darkwood_shovel", new ItemNaturaShovel(ToolMaterial.STONE));
		this.fusewoodShovel = this.registerItem("fusewood_shovel", new ItemNaturaShovel(ToolMaterial.IRON));
		this.netherquartzShovel = this.registerItem("netherquartz_shovel", new ItemNaturaShovel(ToolMaterial.STONE));

		this.ghostwoodSword = this.registerItem("ghostwood_sword", new ItemNaturaSword(ToolMaterial.WOOD));
		this.bloodwoodSword = this.registerItem("bloodwood_sword", new ItemNaturaSword(bloodwood));
		this.darkwoodSword = this.registerItem("darkwood_sword", new ItemNaturaSword(ToolMaterial.STONE));
		this.fusewoodSword = this.registerItem("fusewood_sword", new ItemNaturaSword(ToolMaterial.IRON));
		this.netherquartzSword = this.registerItem("netherquartz_sword", new ItemNaturaSword(ToolMaterial.STONE));
	}

	private <T extends Item> T registerItem(String name, T item)
	{
		item.setUnlocalizedName("natura." + name);
		GameRegistry.registerItem(item, name);

		return item;
	}

	public void init()
	{
		if (Natura.proxy.getModels() != null)
		{
			ModelVariant models = Natura.proxy.getModels();

			models.registerItemRenderers(0, this.barley_seeds, this.cotton_seeds);

			models.registerItemRenderers(0, this.ghostwoodAxe, this.bloodwoodAxe, this.darkwoodAxe, this.fusewoodAxe, this.netherquartzAxe);

			models.registerItemRenderers(0, this.ghostwoodPickaxe, this.bloodwoodPickaxe, this.darkwoodPickaxe, this.fusewoodPickaxe, this.netherquartzPickaxe);

			models.registerItemRenderers(0, this.ghostwoodShovel, this.bloodwoodShovel, this.darkwoodShovel, this.fusewoodShovel, this.netherquartzShovel);

			models.registerItemRenderers(0, this.ghostwoodSword, this.bloodwoodSword, this.darkwoodSword, this.fusewoodSword, this.netherquartzSword);
		}
	}
}

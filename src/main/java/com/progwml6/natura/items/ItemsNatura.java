package com.progwml6.natura.items;

import mantle.client.ModelVariant;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.progwml6.natura.Natura;
import com.progwml6.natura.items.itemblocks.crops.ItemNaturaSeeds;
import com.progwml6.natura.items.tools.ItemNaturaPickaxe;

public class ItemsNatura
{
	public Item cotton_seeds, barley_seeds;

	public ItemNaturaPickaxe ghostwoodPickaxe, bloodwoodPickaxe, darkwoodPickaxe, fusewoodPickaxe, netherquartzPickaxe;

	public void preInit()
	{
		this.cotton_seeds = this.registerItem("cotton_seeds", new ItemNaturaSeeds(Natura.getBlocks().cottonCrop, "tooltip.cotton"));
		this.barley_seeds = this.registerItem("barley_seeds", new ItemNaturaSeeds(Natura.getBlocks().barleyCrop, "tooltip.barley"));

		this.ghostwoodPickaxe = this.registerItem("ghostwood_pickaxe", new ItemNaturaPickaxe(ToolMaterial.WOOD));
		this.bloodwoodPickaxe = this.registerItem("bloodwood_pickaxe", new ItemNaturaPickaxe(ToolMaterial.WOOD));
		this.darkwoodPickaxe = this.registerItem("darkwood_pickaxe", new ItemNaturaPickaxe(ToolMaterial.WOOD));
		this.fusewoodPickaxe = this.registerItem("fusewood_pickaxe", new ItemNaturaPickaxe(ToolMaterial.WOOD));
		this.netherquartzPickaxe = this.registerItem("netherquartz_pickaxe", new ItemNaturaPickaxe(ToolMaterial.WOOD));

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
		}
	}
}

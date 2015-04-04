package com.progwml6.natura.items;

import mantle.client.ModelVariant;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.progwml6.natura.Natura;
import com.progwml6.natura.items.itemblocks.crops.ItemNaturaSeeds;

public class ItemsNatura
{
	public Item cotton_seeds, barley_seeds;

	public void preInit()
	{
		this.cotton_seeds = this.registerItem("cotton_seeds", new ItemNaturaSeeds(Natura.getBlocks().cottonCrop, "tooltip.cotton"));
		this.barley_seeds = this.registerItem("barley_seeds", new ItemNaturaSeeds(Natura.getBlocks().barleyCrop, "tooltip.barley"));
	}

	private <T extends Item> T registerItem(String name, T item)
	{
		item.setUnlocalizedName(name);
		GameRegistry.registerItem(item, name);

		return item;
	}

	public void init()
	{
		if (Natura.proxy.getModels() != null)
		{
			ModelVariant models = Natura.proxy.getModels();

			models.registerItemRenderer(this.cotton_seeds, 0);
			models.registerItemRenderer(this.barley_seeds, 0);
		}
	}
}

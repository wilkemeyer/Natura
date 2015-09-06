package com.progwml6.natura.common.blocks;

import com.progwml6.natura.common.blocks.construction.BlockNaturaWorkbench;
import com.progwml6.natura.common.blocks.natural.BlockClouds;
import com.progwml6.natura.common.blocks.natural.BlockNaturaLogs;
import com.progwml6.natura.common.blocks.natural.BlockNaturaPlanks;
import com.progwml6.natura.common.blocks.natural.plants.BlockNaturaBarleyCrop;
import com.progwml6.natura.common.blocks.natural.plants.BlockNaturaCottonCrop;
import com.progwml6.natura.common.blocks.util.CloudMaterial;
import com.progwml6.natura.common.items.itemblocks.ItemBlockClouds;
import com.progwml6.natura.common.items.itemblocks.ItemBlockCrops;
import com.progwml6.natura.common.items.itemblocks.ItemBlockNaturaLogs;
import com.progwml6.natura.common.items.itemblocks.ItemBlockNaturaPlanks;
import com.progwml6.natura.common.items.itemblocks.ItemBlockWorkbench;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlocksNatura
{
	public static Material cloud = new CloudMaterial();

	public static Block clouds, logs, planks, cotton_crop, barley_crop, fence, crafting_table;//, sapling;

	public static void preInit()
	{
		clouds = registerBlock("clouds", ItemBlockClouds.class, new BlockClouds());
		logs = registerBlock("logs", ItemBlockNaturaLogs.class, new BlockNaturaLogs());
		planks = registerBlock("planks", ItemBlockNaturaPlanks.class, new BlockNaturaPlanks());
		cotton_crop = registerBlock("cotton_crops", ItemBlockCrops.class, new BlockNaturaCottonCrop());
		barley_crop = registerBlock("barley_crops", ItemBlockCrops.class, new BlockNaturaBarleyCrop());
		crafting_table = registerBlock("crafting_table", ItemBlockWorkbench.class, new BlockNaturaWorkbench());
		// sapling = registerBlock("saplings", ItemBlockNaturaSaplings.class, new BlockNaturaSapling());
		// this.fence = this.registerBlock("fence", ItemBlockVariants.class, new BlockNaturaFence());
	}

	private Block registerBlock(String name, Block block)
	{
		block.setUnlocalizedName("natura." + name);
		GameRegistry.registerBlock(block, name);

		return block;
	}

	private static Block registerBlock(String name, Class<? extends ItemBlock> itemblock, Block block)
	{
		block.setUnlocalizedName(name);
		GameRegistry.registerBlock(block, itemblock, name);

		return block;
	}
}

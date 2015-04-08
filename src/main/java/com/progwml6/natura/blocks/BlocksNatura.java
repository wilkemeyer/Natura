package com.progwml6.natura.blocks;

import mantle.blocks.abstracts.ItemBlockVariants;
import mantle.client.ModelVariant;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.progwml6.natura.Natura;
import com.progwml6.natura.blocks.crops.BlockNaturaBarleyCrop;
import com.progwml6.natura.blocks.crops.BlockNaturaCottonCrop;
import com.progwml6.natura.blocks.material.CloudMaterial;
import com.progwml6.natura.blocks.misc.BlockNaturaFence;
import com.progwml6.natura.blocks.natural.BlockClouds;
import com.progwml6.natura.blocks.natural.BlockNaturaLogs;
import com.progwml6.natura.blocks.natural.BlockNaturaPlanks;
import com.progwml6.natura.items.itemblocks.natural.ItemBlockClouds;
import com.progwml6.natura.items.itemblocks.natural.ItemBlockNaturaLogs;
import com.progwml6.natura.items.itemblocks.natural.ItemBlockNaturaPlanks;

public class BlocksNatura
{
	public static Material cloud = new CloudMaterial();

	public BlockClouds clouds;

	public BlockNaturaLogs logs;

	public BlockNaturaPlanks planks;

	public BlockNaturaCottonCrop cottonCrop;

	public BlockNaturaBarleyCrop barleyCrop;

	public BlockNaturaFence fence;

	public void preInit()
	{
		this.clouds = this.registerBlock("clouds", ItemBlockClouds.class, new BlockClouds());
		this.logs = this.registerBlock("logs", ItemBlockNaturaLogs.class, new BlockNaturaLogs());
		this.planks = this.registerBlock("planks", ItemBlockNaturaPlanks.class, new BlockNaturaPlanks());
		this.cottonCrop = this.registerBlock("cotton_crops", ItemBlock.class, new BlockNaturaCottonCrop());
		this.barleyCrop = this.registerBlock("barley_crops", ItemBlock.class, new BlockNaturaBarleyCrop());
		this.fence = this.registerBlock("fence", ItemBlockVariants.class, new BlockNaturaFence());
	}

	private <T extends Block> T registerBlock(String name, Class<? extends ItemBlock> itemblock, T block)
	{
		block.setUnlocalizedName("natura." + name);
		GameRegistry.registerBlock(block, itemblock, name);

		return block;
	}

	public void init()
	{
		if (Natura.proxy.getModels() != null)
		{
			ModelVariant models = Natura.proxy.getModels();

			models.registerItemRenderer(this.clouds, BlockClouds.CLOUD_TYPE.getAllowedValues());
			models.registerItemRenderer(this.logs, BlockNaturaLogs.LOG_TYPE.getAllowedValues());
			models.registerItemRenderer(this.planks, BlockNaturaPlanks.PLANK_TYPE.getAllowedValues());
			models.registerItemRenderer(this.fence, BlockNaturaFence.FENCE_TYPE.getAllowedValues());

			models.registerBlockRenderers(0, this.cottonCrop, this.barleyCrop);
		}
	}
}

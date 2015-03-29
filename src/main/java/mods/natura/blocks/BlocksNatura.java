package mods.natura.blocks;

import mantle.client.ModelVariant;
import mods.natura.Natura;
import mods.natura.blocks.material.CloudMaterial;
import mods.natura.blocks.natural.BlockClouds;
import mods.natura.blocks.natural.BlockTrees;
import mods.natura.items.itemblocks.ItemBlockClouds;
import mods.natura.items.itemblocks.ItemBlockTrees;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlocksNatura
{
	public static Material cloud = new CloudMaterial();

	public BlockClouds clouds;

	public BlockTrees logs;

	public void preInit()
	{
		this.clouds = this.registerBlock("clouds", ItemBlockClouds.class, new BlockClouds());
		this.logs = this.registerBlock("logs", ItemBlockTrees.class, new BlockTrees());
	}

	private <T extends Block> T registerBlock(String name, Class<? extends ItemBlock> itemblock, T block)
	{
		block.setUnlocalizedName(name);
		GameRegistry.registerBlock(block, itemblock, name);

		return block;
	}

	public void init()
	{
		if (Natura.proxy.getModels() != null)
		{
			ModelVariant models = Natura.proxy.getModels();

			models.registerItemRenderer(this.clouds, BlockClouds.CloudVariant.values());
			models.registerItemRenderer(this.logs, BlockTrees.TreeVariant.values());
		}
	}

}

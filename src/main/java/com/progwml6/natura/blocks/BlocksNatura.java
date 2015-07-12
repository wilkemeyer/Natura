package com.progwml6.natura.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.progwml6.natura.blocks.construction.BlockNaturaWorkbench;
import com.progwml6.natura.blocks.natural.BlockClouds;
import com.progwml6.natura.blocks.natural.BlockNaturaBarleyCrop;
import com.progwml6.natura.blocks.natural.BlockNaturaCottonCrop;
import com.progwml6.natura.blocks.natural.BlockNaturaLogs;
import com.progwml6.natura.blocks.natural.BlockNaturaPlanks;
import com.progwml6.natura.blocks.util.CloudMaterial;
import com.progwml6.natura.items.itemblocks.ItemBlockClouds;
import com.progwml6.natura.items.itemblocks.ItemBlockNaturaLogs;
import com.progwml6.natura.items.itemblocks.ItemBlockNaturaPlanks;
import com.progwml6.natura.items.itemblocks.ItemBlockWorkbench;

public class BlocksNatura
{
    public static Material cloud = new CloudMaterial();

    public static Block clouds, logs, planks, cottonCrop, barleyCrop, fence, crafting_table;

    public static void preInit()
    {
        clouds = registerBlock("clouds", ItemBlockClouds.class, new BlockClouds());
        logs = registerBlock("logs", ItemBlockNaturaLogs.class, new BlockNaturaLogs());
        planks = registerBlock("planks", ItemBlockNaturaPlanks.class, new BlockNaturaPlanks());
        cottonCrop = registerBlock("cotton_crops", ItemBlock.class, new BlockNaturaCottonCrop());
        barleyCrop = registerBlock("barley_crops", ItemBlock.class, new BlockNaturaBarleyCrop());
        crafting_table = registerBlock("crafting_table", ItemBlockWorkbench.class, new BlockNaturaWorkbench());
        //this.fence = this.registerBlock("fence", ItemBlockVariants.class, new BlockNaturaFence());
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

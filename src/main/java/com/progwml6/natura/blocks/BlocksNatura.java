package com.progwml6.natura.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.progwml6.natura.blocks.crops.BlockNaturaBarleyCrop;
import com.progwml6.natura.blocks.crops.BlockNaturaCottonCrop;
import com.progwml6.natura.blocks.material.CloudMaterial;
import com.progwml6.natura.blocks.natural.BlockClouds;
import com.progwml6.natura.blocks.natural.BlockNaturaLogs;
import com.progwml6.natura.blocks.natural.BlockNaturaPlanks;
import com.progwml6.natura.items.itemblocks.natural.ItemBlockClouds;
import com.progwml6.natura.items.itemblocks.natural.ItemBlockNaturaLogs;
import com.progwml6.natura.items.itemblocks.natural.ItemBlockNaturaPlanks;

public class BlocksNatura
{
    public static Material cloud = new CloudMaterial();

    public Block clouds, logs, planks, cottonCrop, barleyCrop, fence;

    public void preInit()
    {
        this.clouds = this.registerBlock("clouds", ItemBlockClouds.class, new BlockClouds());
        this.logs = this.registerBlock("logs", ItemBlockNaturaLogs.class, new BlockNaturaLogs());
        this.planks = this.registerBlock("planks", ItemBlockNaturaPlanks.class, new BlockNaturaPlanks());
        this.cottonCrop = this.registerBlock("cotton_crops", ItemBlock.class, new BlockNaturaCottonCrop());
        this.barleyCrop = this.registerBlock("barley_crops", ItemBlock.class, new BlockNaturaBarleyCrop());
        //this.fence = this.registerBlock("fence", ItemBlockVariants.class, new BlockNaturaFence());
    }

    private Block registerBlock(String name, Block block)
    {
        block.setUnlocalizedName("natura." + name);
        GameRegistry.registerBlock(block, name);

        return block;
    }

    private Block registerBlock(String name, Class<? extends ItemBlock> itemblock, Block block)
    {
        block.setUnlocalizedName(name);
        GameRegistry.registerBlock(block, itemblock, name);

        return block;
    }
}

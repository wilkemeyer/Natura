package com.progwml6.natura.client.misc.models;

import mantle.client.ModelVariant;
import net.minecraft.client.Minecraft;

import com.progwml6.natura.Natura;
import com.progwml6.natura.blocks.BlocksNatura;
import com.progwml6.natura.blocks.natural.BlockClouds;
import com.progwml6.natura.blocks.natural.BlockNaturaLogs;
import com.progwml6.natura.blocks.natural.BlockNaturaPlanks;
import com.progwml6.natura.items.ItemsNatura;

public class ModelNatura extends ModelVariant
{
    public ModelNatura()
    {
        super(Natura.MOD_ID, Minecraft.getMinecraft());
    }

    public void registerModels()
    {
        this.registerBlockModels();
        this.registerItemModels();
    }

    private void registerBlockModels()
    {
        BlocksNatura blocks = Natura.INSTANCE.getBlocks();

        this.registerBlockModelVariants(blocks.clouds, BlockClouds.CLOUD_TYPE.getAllowedValues());
        this.registerBlockModelVariants(blocks.logs, BlockNaturaLogs.LOG_TYPE.getAllowedValues());
        this.registerBlockModelVariants(blocks.planks, BlockNaturaPlanks.PLANK_TYPE.getAllowedValues());
        this.registerBlockModel(blocks.cottonCrop);
        this.registerBlockModel(blocks.barleyCrop);
    }

    private void registerItemModels()
    {
        ItemsNatura items = Natura.INSTANCE.getItems();

        this.registerItemModel(items.cotton_seeds);
        this.registerItemModel(items.barley_seeds);
        this.registerItemModel(items.spawn_egg);

        this.registerItemModel(items.ghostwoodPickaxe);
        this.registerItemModel(items.ghostwoodAxe);
        this.registerItemModel(items.ghostwoodShovel);
        this.registerItemModel(items.ghostwoodSword);

        this.registerItemModel(items.bloodwoodPickaxe);
        this.registerItemModel(items.bloodwoodAxe);
        this.registerItemModel(items.bloodwoodShovel);
        this.registerItemModel(items.bloodwoodSword);

        this.registerItemModel(items.darkwoodPickaxe);
        this.registerItemModel(items.darkwoodAxe);
        this.registerItemModel(items.darkwoodShovel);
        this.registerItemModel(items.darkwoodSword);

        this.registerItemModel(items.fusewoodPickaxe);
        this.registerItemModel(items.fusewoodAxe);
        this.registerItemModel(items.fusewoodShovel);
        this.registerItemModel(items.fusewoodSword);

        this.registerItemModel(items.netherquartzPickaxe);
        this.registerItemModel(items.netherquartzAxe);
        this.registerItemModel(items.netherquartzShovel);
        this.registerItemModel(items.netherquartzSword);
    }

}

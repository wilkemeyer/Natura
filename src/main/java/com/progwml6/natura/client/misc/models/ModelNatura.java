package com.progwml6.natura.client.misc.models;

import mantle.client.ModelVariant;
import net.minecraft.client.Minecraft;

import com.progwml6.natura.Natura;
import com.progwml6.natura.NaturaCreativeTabs;
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

    public void preInit()
    {
        this.addVariantNames(BlocksNatura.clouds, "cloud_white", "cloud_gray", "cloud_dark", "cloud_sulfur");
        this.addVariantNames(BlocksNatura.logs, "eucalyptus_log", "sakura_log", "ghostwood_log", "hopseed_log");
        this.addVariantNames(BlocksNatura.planks, "eucalyptus_planks", "sakura_planks", "ghostwood_planks", "redwood_planks", "bloodwood_planks", "hopseed_planks", "maple_planks", "silverbell_planks", "purpleheart_planks", "tiger_planks", "willow_planks", "darkwood_planks", "fusewood_planks", "redwood_bark", "redwood_heart", "redwood_root");
        
        this.addVariantNames(ItemsNatura.materials, "materials_barley_plant", "materials_barley_flour", "materials_wheat_flour", "materials_cotton_plant", "materials_sulfur", "materials_ghostwood_fletching", "materials_leather_imp", "materials_flamestring", "materials_dye_blue");
        this.addVariantNames(ItemsNatura.impMeat, "impmeat_raw", "impmeat_cooked");
        this.addVariantNames(ItemsNatura.bowlEmpty, "bowl_empty_bowl", "bowl_empty_ghostwood", "bowl_empty_bloodwood", "bowl_empty_darkwood", "bowl_empty_fusewood");
    }

    public void init()
    {
        this.registerBlockModel(BlocksNatura.cottonCrop);
        this.registerBlockModel(BlocksNatura.barleyCrop);
        
        this.registerBlockModel(BlocksNatura.clouds, BlockClouds.WHITE.getMeta(), getResource("cloud_white"));
        this.registerBlockModel(BlocksNatura.clouds, BlockClouds.GREY.getMeta(), getResource("cloud_gray"));
        this.registerBlockModel(BlocksNatura.clouds, BlockClouds.DARK.getMeta(), getResource("cloud_dark"));
        this.registerBlockModel(BlocksNatura.clouds, BlockClouds.SULFER.getMeta(), getResource("cloud_sulfur"));
        
        this.registerBlockModel(BlocksNatura.logs, BlockNaturaLogs.EUCALYPTUS.getMeta(), getResource("eucalyptus_log"));
        this.registerBlockModel(BlocksNatura.logs, BlockNaturaLogs.SAKURA.getMeta(), getResource("sakura_log"));
        this.registerBlockModel(BlocksNatura.logs, BlockNaturaLogs.GHOSTWOOD.getMeta(), getResource("ghostwood_log"));
        this.registerBlockModel(BlocksNatura.logs, BlockNaturaLogs.HOPSEED.getMeta(), getResource("hopseed_log"));
        
        this.registerBlockModel(BlocksNatura.planks, BlockNaturaPlanks.EUCALYPTUS.getMeta(), getResource("eucalyptus_planks"));
        this.registerBlockModel(BlocksNatura.planks, BlockNaturaPlanks.SAKURA.getMeta(), getResource("sakura_planks"));
        this.registerBlockModel(BlocksNatura.planks, BlockNaturaPlanks.GHOSTWOOD.getMeta(), getResource("ghostwood_planks"));
        this.registerBlockModel(BlocksNatura.planks, BlockNaturaPlanks.REDWOOD.getMeta(), getResource("redwood_planks"));
        this.registerBlockModel(BlocksNatura.planks, BlockNaturaPlanks.BLOODWOOD.getMeta(), getResource("bloodwood_planks"));
        this.registerBlockModel(BlocksNatura.planks, BlockNaturaPlanks.HOPSEED.getMeta(), getResource("hopseed_planks"));
        this.registerBlockModel(BlocksNatura.planks, BlockNaturaPlanks.MAPLE.getMeta(), getResource("maple_planks"));
        this.registerBlockModel(BlocksNatura.planks, BlockNaturaPlanks.SILVERBELL.getMeta(), getResource("silverbell_planks"));
        this.registerBlockModel(BlocksNatura.planks, BlockNaturaPlanks.PURPLEHEART.getMeta(), getResource("purpleheart_planks"));
        this.registerBlockModel(BlocksNatura.planks, BlockNaturaPlanks.TIGER.getMeta(), getResource("tiger_planks"));
        this.registerBlockModel(BlocksNatura.planks, BlockNaturaPlanks.WILLOW.getMeta(), getResource("willow_planks"));
        this.registerBlockModel(BlocksNatura.planks, BlockNaturaPlanks.DARKWOOD.getMeta(), getResource("darkwood_planks"));
        this.registerBlockModel(BlocksNatura.planks, BlockNaturaPlanks.FUSEWOOD.getMeta(), getResource("fusewood_planks"));
        this.registerBlockModel(BlocksNatura.planks, BlockNaturaPlanks.REDWOOD_BARK.getMeta(), getResource("redwood_bark"));
        this.registerBlockModel(BlocksNatura.planks, BlockNaturaPlanks.REDWOOD_HEART.getMeta(), getResource("redwood_heart"));
        this.registerBlockModel(BlocksNatura.planks, BlockNaturaPlanks.REDWOOD_ROOT.getMeta(), getResource("redwood_root"));

        this.registerItemModel(ItemsNatura.cotton_seeds);
        this.registerItemModel(ItemsNatura.barley_seeds);
        
        this.registerItemModel(ItemsNatura.materials, 0, getResource("materials_barley_plant"));
        this.registerItemModel(ItemsNatura.materials, 1, getResource("materials_barley_flour"));
        this.registerItemModel(ItemsNatura.materials, 2, getResource("materials_wheat_flour"));
        this.registerItemModel(ItemsNatura.materials, 3, getResource("materials_cotton_plant"));
        this.registerItemModel(ItemsNatura.materials, 4, getResource("materials_sulfur"));
        this.registerItemModel(ItemsNatura.materials, 5, getResource("materials_ghostwood_fletching"));
        this.registerItemModel(ItemsNatura.materials, 6, getResource("materials_leather_imp"));
        this.registerItemModel(ItemsNatura.materials, 7, getResource("materials_flamestring"));
        this.registerItemModel(ItemsNatura.materials, 8, getResource("materials_dye_blue"));
        
        this.registerItemModel(ItemsNatura.impMeat, 0, getResource("impmeat_raw"));
        this.registerItemModel(ItemsNatura.impMeat, 1, getResource("impmeat_cooked"));
        
        this.registerItemModel(ItemsNatura.bowlEmpty, 0, getResource("bowl_empty_bowl"));
        this.registerItemModel(ItemsNatura.bowlEmpty, 1, getResource("bowl_empty_ghostwood"));
        this.registerItemModel(ItemsNatura.bowlEmpty, 2, getResource("bowl_empty_bloodwood"));
        this.registerItemModel(ItemsNatura.bowlEmpty, 3, getResource("bowl_empty_darkwood"));
        this.registerItemModel(ItemsNatura.bowlEmpty, 4, getResource("bowl_empty_fusewood"));

        //this.registerItemModelVariants(ItemsNatura.bowlEmpty);
        this.registerItemSubTypesModel(ItemsNatura.spawn_egg, NaturaCreativeTabs.tabMisc);

        this.registerItemModel(ItemsNatura.ghostwoodPickaxe);
        this.registerItemModel(ItemsNatura.ghostwoodAxe);
        this.registerItemModel(ItemsNatura.ghostwoodShovel);
        this.registerItemModel(ItemsNatura.ghostwoodSword);

        this.registerItemModel(ItemsNatura.bloodwoodPickaxe);
        this.registerItemModel(ItemsNatura.bloodwoodAxe);
        this.registerItemModel(ItemsNatura.bloodwoodShovel);
        this.registerItemModel(ItemsNatura.bloodwoodSword);

        this.registerItemModel(ItemsNatura.darkwoodPickaxe);
        this.registerItemModel(ItemsNatura.darkwoodAxe);
        this.registerItemModel(ItemsNatura.darkwoodShovel);
        this.registerItemModel(ItemsNatura.darkwoodSword);

        this.registerItemModel(ItemsNatura.fusewoodPickaxe);
        this.registerItemModel(ItemsNatura.fusewoodAxe);
        this.registerItemModel(ItemsNatura.fusewoodShovel);
        this.registerItemModel(ItemsNatura.fusewoodSword);

        this.registerItemModel(ItemsNatura.netherquartzPickaxe);
        this.registerItemModel(ItemsNatura.netherquartzAxe);
        this.registerItemModel(ItemsNatura.netherquartzShovel);
        this.registerItemModel(ItemsNatura.netherquartzSword);
    }

}

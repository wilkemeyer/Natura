package com.progwml6.natura.client.models.util;

public class ModelNatura
{

}
/**
public class ModelNatura extends ModelVariant
{
    public ModelNatura()
    {
        super(Natura.MOD_ID, Minecraft.getMinecraft());
    }

    public void preInit()
    {
        this.registerStateMappers();

        this.addVariantNames(BlocksNatura.clouds, "cloud_white", "cloud_gray", "cloud_dark", "cloud_sulfur");
        this.addVariantNames(BlocksNatura.logs, "eucalyptus_log", "sakura_log", "ghostwood_log", "hopseed_log");
        this.addVariantNames(BlocksNatura.planks, "eucalyptus_planks", "sakura_planks", "ghostwood_planks", "redwood_planks", "bloodwood_planks", "hopseed_planks", "maple_planks", "silverbell_planks", "purpleheart_planks", "tiger_planks", "willow_planks", "darkwood_planks", "fusewood_planks", "redwood_bark", "redwood_heart", "redwood_root");
        this.addVariantNames(BlocksNatura.crafting_table, "table_eucalyptus", "table_sakura", "table_ghostwood", "table_redwood", "table_bloodwood", "table_hopseed", "table_maple", "table_silverbell", "table_purpleheart", "table_tiger", "table_willow", "table_darkwood", "table_fusewood");
        this.addVariantNames(BlocksNatura.cotton_crop, "cotton_stage0");
        this.addVariantNames(BlocksNatura.barley_crop, "barley_stage0");

        this.addVariantNames(BlocksNatura.sapling, "eucalyptus_sapling", "sakura_sapling", "ghostwood_sapling", "redwood_sapling", "bloodwood_sapling", "hopseed_sapling", "maple_sapling", "silverbell_sapling", "purpleheart_sapling", "tiger_sapling", "willow_sapling", "darkwood_sapling", "fusewood_sapling");

        this.addVariantNames(ItemsNatura.materials, "materials_barley_plant", "materials_barley_flour", "materials_wheat_flour", "materials_cotton_plant", "materials_sulfur", "materials_ghostwood_fletching", "materials_leather_imp", "materials_flamestring", "materials_dye_blue");
        this.addVariantNames(ItemsNatura.impMeat, "impmeat_raw", "impmeat_cooked");
        this.addVariantNames(ItemsNatura.bowlEmpty, "bowl_empty_bowl", "bowl_empty_ghostwood", "bowl_empty_bloodwood", "bowl_empty_darkwood", "bowl_empty_fusewood");
    }

    private void registerStateMappers()
    {

    }

    public void init()
    {
        this.registerBlockModel(BlocksNatura.cotton_crop, 0, getResource("cotton_stage0"));

        this.registerBlockModel(BlocksNatura.barley_crop, 0, getResource("barley_stage0"));

        this.registerBlockModel(BlocksNatura.clouds, BlockClouds.WHITE_CLOUD.getMeta(), getResource("cloud_white"));
        this.registerBlockModel(BlocksNatura.clouds, BlockClouds.GREY_CLOUD.getMeta(), getResource("cloud_gray"));
        this.registerBlockModel(BlocksNatura.clouds, BlockClouds.DARK_CLOUD.getMeta(), getResource("cloud_dark"));
        this.registerBlockModel(BlocksNatura.clouds, BlockClouds.SULFER_CLOUD.getMeta(), getResource("cloud_sulfur"));

        this.registerBlockModel(BlocksNatura.logs, BlockNaturaLogs.EUCALYPTUS_LOG.getMeta(), getResource("eucalyptus_log"));
        this.registerBlockModel(BlocksNatura.logs, BlockNaturaLogs.SAKURA_LOG.getMeta(), getResource("sakura_log"));
        this.registerBlockModel(BlocksNatura.logs, BlockNaturaLogs.GHOSTWOOD_LOG.getMeta(), getResource("ghostwood_log"));
        this.registerBlockModel(BlocksNatura.logs, BlockNaturaLogs.HOPSEED_LOG.getMeta(), getResource("hopseed_log"));

        this.registerBlockModel(BlocksNatura.planks, BlockNaturaPlanks.EUCALYPTUS_PLANKS.getMeta(), getResource("eucalyptus_planks"));
        this.registerBlockModel(BlocksNatura.planks, BlockNaturaPlanks.SAKURA_PLANKS.getMeta(), getResource("sakura_planks"));
        this.registerBlockModel(BlocksNatura.planks, BlockNaturaPlanks.GHOSTWOOD_PLANKS.getMeta(), getResource("ghostwood_planks"));
        this.registerBlockModel(BlocksNatura.planks, BlockNaturaPlanks.REDWOOD_PLANKS.getMeta(), getResource("redwood_planks"));
        this.registerBlockModel(BlocksNatura.planks, BlockNaturaPlanks.BLOODWOOD_PLANKS.getMeta(), getResource("bloodwood_planks"));
        this.registerBlockModel(BlocksNatura.planks, BlockNaturaPlanks.HOPSEED_PLANKS.getMeta(), getResource("hopseed_planks"));
        this.registerBlockModel(BlocksNatura.planks, BlockNaturaPlanks.MAPLE_PLANKS.getMeta(), getResource("maple_planks"));
        this.registerBlockModel(BlocksNatura.planks, BlockNaturaPlanks.SILVERBELL_PLANKS.getMeta(), getResource("silverbell_planks"));
        this.registerBlockModel(BlocksNatura.planks, BlockNaturaPlanks.PURPLEHEART_PLANKS.getMeta(), getResource("purpleheart_planks"));
        this.registerBlockModel(BlocksNatura.planks, BlockNaturaPlanks.TIGER_PLANKS.getMeta(), getResource("tiger_planks"));
        this.registerBlockModel(BlocksNatura.planks, BlockNaturaPlanks.WILLOW_PLANKS.getMeta(), getResource("willow_planks"));
        this.registerBlockModel(BlocksNatura.planks, BlockNaturaPlanks.DARKWOOD_PLANKS.getMeta(), getResource("darkwood_planks"));
        this.registerBlockModel(BlocksNatura.planks, BlockNaturaPlanks.FUSEWOOD_PLANKS.getMeta(), getResource("fusewood_planks"));
        this.registerBlockModel(BlocksNatura.planks, BlockNaturaPlanks.REDWOOD_BARK_PLANKS.getMeta(), getResource("redwood_bark"));
        this.registerBlockModel(BlocksNatura.planks, BlockNaturaPlanks.REDWOOD_HEART_PLANKS.getMeta(), getResource("redwood_heart"));
        this.registerBlockModel(BlocksNatura.planks, BlockNaturaPlanks.REDWOOD_ROOT_PLANKS.getMeta(), getResource("redwood_root"));

        this.registerBlockModel(BlocksNatura.crafting_table, BlockNaturaWorkbench.EUCALYPTUS.getMeta(), getResource("table_eucalyptus"));
        this.registerBlockModel(BlocksNatura.crafting_table, BlockNaturaWorkbench.SAKURA.getMeta(), getResource("table_sakura"));
        this.registerBlockModel(BlocksNatura.crafting_table, BlockNaturaWorkbench.GHOSTWOOD.getMeta(), getResource("table_ghostwood"));
        this.registerBlockModel(BlocksNatura.crafting_table, BlockNaturaWorkbench.REDWOOD.getMeta(), getResource("table_redwood"));
        this.registerBlockModel(BlocksNatura.crafting_table, BlockNaturaWorkbench.BLOODWOOD.getMeta(), getResource("table_bloodwood"));
        this.registerBlockModel(BlocksNatura.crafting_table, BlockNaturaWorkbench.HOPSEED.getMeta(), getResource("table_hopseed"));
        this.registerBlockModel(BlocksNatura.crafting_table, BlockNaturaWorkbench.MAPLE.getMeta(), getResource("table_maple"));
        this.registerBlockModel(BlocksNatura.crafting_table, BlockNaturaWorkbench.SILVERBELL.getMeta(), getResource("table_silverbell"));
        this.registerBlockModel(BlocksNatura.crafting_table, BlockNaturaWorkbench.PURPLEHEART.getMeta(), getResource("table_purpleheart"));
        this.registerBlockModel(BlocksNatura.crafting_table, BlockNaturaWorkbench.TIGER.getMeta(), getResource("table_tiger"));
        this.registerBlockModel(BlocksNatura.crafting_table, BlockNaturaWorkbench.WILLOW.getMeta(), getResource("table_willow"));
        this.registerBlockModel(BlocksNatura.crafting_table, BlockNaturaWorkbench.DARKWOOD.getMeta(), getResource("table_darkwood"));
        this.registerBlockModel(BlocksNatura.crafting_table, BlockNaturaWorkbench.FUSEWOOD.getMeta(), getResource("table_fusewood"));

        this.registerBlockModel(BlocksNatura.sapling, BlockNaturaSapling.EUCALYPTUS_SAPLING.getMeta(), getResource("eucalyptus_sapling"));
        this.registerBlockModel(BlocksNatura.sapling, BlockNaturaSapling.SAKURA_SAPLING.getMeta(), getResource("sakura_sapling"));
        this.registerBlockModel(BlocksNatura.sapling, BlockNaturaSapling.GHOSTWOOD_SAPLING.getMeta(), getResource("ghostwood_sapling"));
        this.registerBlockModel(BlocksNatura.sapling, BlockNaturaSapling.REDWOOD_SAPLING.getMeta(), getResource("redwood_sapling"));
        this.registerBlockModel(BlocksNatura.sapling, BlockNaturaSapling.BLOODWOOD_SAPLING.getMeta(), getResource("bloodwood_sapling"));
        this.registerBlockModel(BlocksNatura.sapling, BlockNaturaSapling.HOPSEED_SAPLING.getMeta(), getResource("hopseed_sapling"));
        this.registerBlockModel(BlocksNatura.sapling, BlockNaturaSapling.MAPLE_SAPLING.getMeta(), getResource("maple_sapling"));
        this.registerBlockModel(BlocksNatura.sapling, BlockNaturaSapling.SILVERBELL_SAPLING.getMeta(), getResource("silverbell_sapling"));
        this.registerBlockModel(BlocksNatura.sapling, BlockNaturaSapling.PURPLEHEART_SAPLING.getMeta(), getResource("purpleheart_sapling"));
        this.registerBlockModel(BlocksNatura.sapling, BlockNaturaSapling.TIGER_SAPLING.getMeta(), getResource("tiger_sapling"));
        this.registerBlockModel(BlocksNatura.sapling, BlockNaturaSapling.WILLOW_SAPLING.getMeta(), getResource("willow_sapling"));
        this.registerBlockModel(BlocksNatura.sapling, BlockNaturaSapling.DARKWOOD_SAPLING.getMeta(), getResource("darkwood_sapling"));
        this.registerBlockModel(BlocksNatura.sapling, BlockNaturaSapling.FUSEWOOD_SAPLING.getMeta(), getResource("fusewood_sapling"));

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

        RenderingRegistry.registerEntityRenderingHandler(ImpEntity.class, new ImpRender(Minecraft.getMinecraft().getRenderManager(), new ImpModel(), 0f));
        RenderingRegistry.registerEntityRenderingHandler(HeatscarSpider.class, new FlameSpiderRender(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(NitroCreeper.class, new NitroCreeperRender(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(FusewoodArrow.class, new FusewoodArrowRender(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(BabyHeatscarSpider.class, new FlameSpiderBabyRender(Minecraft.getMinecraft().getRenderManager()));

        try
        {
            GrassColorizerAlternate.setBlueGrassBiomeColorizer(TextureUtil.readImageData(Minecraft.getMinecraft().getResourceManager(), new ResourceLocation("natura", "textures/misc/bluegrasscolor.png")));
            GrassColorizerAlternate.setOrangeGrassBiomeColorizer(TextureUtil.readImageData(Minecraft.getMinecraft().getResourceManager(), new ResourceLocation("natura", "textures/misc/orangegrasscolor.png")));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}*/

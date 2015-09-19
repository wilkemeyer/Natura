package com.progwml6.natura.client.models;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.progwml6.natura.client.models.util.ModelResourceList;
import com.progwml6.natura.common.blocks.BlocksNatura;
import com.progwml6.natura.common.blocks.construction.BlockNaturaWorkbench;
import com.progwml6.natura.common.blocks.natural.BlockClouds;
import com.progwml6.natura.common.blocks.natural.BlockNaturaLogs;
import com.progwml6.natura.common.blocks.natural.BlockNaturaPlanks;
import com.progwml6.natura.common.items.ItemsNatura;
import com.progwml6.natura.common.items.util.ItemMaterial;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;

public class ModelNatura
{
	private static HashMap<Item, ModelResourceList> models = new HashMap<Item, ModelResourceList>();

	public static void preInit()
	{
		registerStateMappers();
		defineModels();

		prepareModels();
	}

	public static void init()
	{
		registerModels();
	}

	/**
	 * Used to configure how blockstate files are read(?). Called during pre-initialization phase.
	 */
	private static void registerStateMappers()
	{
		//ModelLoader.setCustomStateMapper(BlocksNatura.sapling, new StateMap.Builder().ignore(BlockNaturaSapling.PROPERTY_STAGE).build());
	}

	private static void defineModels()
	{
		registerModelList(getItem(BlocksNatura.clouds), new ModelResourceList("clouds/")
				.add(BlockClouds.WHITE_CLOUD.getMeta(), "cloud_white")
				.add(BlockClouds.GREY_CLOUD.getMeta(), "cloud_gray")
				.add(BlockClouds.DARK_CLOUD.getMeta(), "cloud_dark")
				.add(BlockClouds.SULFER_CLOUD.getMeta(), "cloud_sulfur"));

		registerModelList(getItem(BlocksNatura.logs), new ModelResourceList("logs/")
				.add(BlockNaturaLogs.EUCALYPTUS_LOG.getMeta(), "eucalyptus_log")
				.add(BlockNaturaLogs.SAKURA_LOG.getMeta(), "sakura_log")
				.add(BlockNaturaLogs.GHOSTWOOD_LOG.getMeta(), "ghostwood_log")
				.add(BlockNaturaLogs.HOPSEED_LOG.getMeta(), "hopseed_log"));

		registerModelList(getItem(BlocksNatura.planks), new ModelResourceList("planks/")
				.add(BlockNaturaPlanks.EUCALYPTUS_PLANKS.getMeta(), "eucalyptus_planks")
				.add(BlockNaturaPlanks.SAKURA_PLANKS.getMeta(), "sakura_planks")
				.add(BlockNaturaPlanks.GHOSTWOOD_PLANKS.getMeta(), "ghostwood_planks")
				.add(BlockNaturaPlanks.REDWOOD_PLANKS.getMeta(), "redwood_planks")
				.add(BlockNaturaPlanks.BLOODWOOD_PLANKS.getMeta(), "bloodwood_planks")
				.add(BlockNaturaPlanks.HOPSEED_PLANKS.getMeta(), "hopseed_planks")
				.add(BlockNaturaPlanks.MAPLE_PLANKS.getMeta(), "maple_planks")
				.add(BlockNaturaPlanks.SILVERBELL_PLANKS.getMeta(), "silverbell_planks")
				.add(BlockNaturaPlanks.PURPLEHEART_PLANKS.getMeta(), "purpleheart_planks")
				.add(BlockNaturaPlanks.TIGER_PLANKS.getMeta(), "tiger_planks")
				.add(BlockNaturaPlanks.WILLOW_PLANKS.getMeta(), "willow_planks")
				.add(BlockNaturaPlanks.DARKWOOD_PLANKS.getMeta(), "darkwood_planks")
				.add(BlockNaturaPlanks.FUSEWOOD_PLANKS.getMeta(), "fusewood_planks")
				.add(BlockNaturaPlanks.REDWOOD_BARK_PLANKS.getMeta(), "redwood_bark")
				.add(BlockNaturaPlanks.REDWOOD_HEART_PLANKS.getMeta(), "redwood_heart")
				.add(BlockNaturaPlanks.REDWOOD_ROOT_PLANKS.getMeta(), "redwood_root"));

		registerModelList(getItem(BlocksNatura.crafting_table), new ModelResourceList("tables/")
				.add(BlockNaturaWorkbench.EUCALYPTUS.getMeta(), "table_eucalyptus")
				.add(BlockNaturaWorkbench.SAKURA.getMeta(), "table_sakura")
				.add(BlockNaturaWorkbench.GHOSTWOOD.getMeta(), "table_ghostwood")
				.add(BlockNaturaWorkbench.REDWOOD.getMeta(), "table_redwood")
				.add(BlockNaturaWorkbench.BLOODWOOD.getMeta(), "table_bloodwood")
				.add(BlockNaturaWorkbench.HOPSEED.getMeta(), "table_hopseed")
				.add(BlockNaturaWorkbench.MAPLE.getMeta(), "table_maple")
				.add(BlockNaturaWorkbench.SILVERBELL.getMeta(), "table_silverbell")
				.add(BlockNaturaWorkbench.PURPLEHEART.getMeta(), "table_purpleheart")
				.add(BlockNaturaWorkbench.TIGER.getMeta(), "table_tiger")
				.add(BlockNaturaWorkbench.WILLOW.getMeta(), "table_willow")
				.add(BlockNaturaWorkbench.DARKWOOD.getMeta(), "table_darkwood")
				.add(BlockNaturaWorkbench.FUSEWOOD.getMeta(), "table_fusewood"));

		registerModelList(getItem(BlocksNatura.cotton_crop), new ModelResourceList("crops/")
				.add(0, "cotton_stage0")
				.add(1, "cotton_stage1")
				.add(2, "cotton_stage2")
				.add(3, "cotton_stage3")
				.add(4, "cotton_stage4"));
		registerModelList(getItem(BlocksNatura.barley_crop), new ModelResourceList("crops/")
				.add(0, "barley_stage0")
				.add(1, "barley_stage1")
				.add(2, "barley_stage2")
				.add(3, "barley_stage3"));

		registerModelList(ItemsNatura.cotton_seeds, new ModelResourceList("seeds/").add(0, "cotton_seeds"));
		registerModelList(ItemsNatura.barley_seeds, new ModelResourceList("seeds/").add(0, "barley_seeds"));

		registerModelList(ItemsNatura.spawn_egg, new ModelResourceList()
				.add(0, "spawn_egg")
				.add(1, "spawn_egg")
				.add(2, "spawn_egg")
				.add(3, "spawn_egg"));

		registerModelList(ItemsNatura.impMeat, new ModelResourceList("consumables/")
				.add(0, "impmeat_raw")
				.add(1, "impmeat_cooked"));

		registerModelList(ItemsNatura.bowlEmpty, new ModelResourceList("bowls/")
				.add(0, "bowl_empty_bowl")
				.add(1, "bowl_empty_ghostwood")
				.add(2, "bowl_empty_bloodwood")
				.add(3, "bowl_empty_darkwood")
				.add(4, "bowl_empty_fusewood"));

		registerModelList(ItemsNatura.materials, new ModelResourceList("materials/")
				.add(ItemMaterial.MaterialType.BARLEY_PLANT.ordinal(), "materials_barley_plant")
				.add(ItemMaterial.MaterialType.BARLEY_FLOUR.ordinal(), "materials_barley_flour")
				.add(ItemMaterial.MaterialType.WHEAT_FLOUR.ordinal(), "materials_wheat_flour")
				.add(ItemMaterial.MaterialType.COTTON.ordinal(), "materials_cotton_plant")
				.add(ItemMaterial.MaterialType.SULFUR_POWDER.ordinal(), "materials_sulfur")
				.add(ItemMaterial.MaterialType.GHOSTWOOD_FLETCHING.ordinal(), "materials_ghostwood_fletching")
				.add(ItemMaterial.MaterialType.IMP_LEATHER.ordinal(), "materials_leather_imp")
				.add(ItemMaterial.MaterialType.FLAME_STRING.ordinal(), "materials_flamestring")
				.add(ItemMaterial.MaterialType.BLUE_DYE.ordinal(), "materials_dye_blue"));

		registerModelList(ItemsNatura.ghostwood_pickaxe, new ModelResourceList("tools/").add(0, "ghostwood_pickaxe"));
		registerModelList(ItemsNatura.ghostwood_axe, new ModelResourceList("tools/").add(0, "ghostwood_axe"));
		registerModelList(ItemsNatura.ghostwood_shovel, new ModelResourceList("tools/").add(0, "ghostwood_shovel"));
		registerModelList(ItemsNatura.ghostwood_sword, new ModelResourceList("weapons/").add(0, "ghostwood_sword"));
		registerModelList(ItemsNatura.ghostwood_kama, new ModelResourceList("weapons/").add(0, "ghostwood_kama"));

		registerModelList(ItemsNatura.bloodwood_pickaxe, new ModelResourceList("tools/").add(0, "bloodwood_pickaxe"));
		registerModelList(ItemsNatura.bloodwood_axe, new ModelResourceList("tools/").add(0, "bloodwood_axe"));
		registerModelList(ItemsNatura.bloodwood_shovel, new ModelResourceList("tools/").add(0, "bloodwood_shovel"));
		registerModelList(ItemsNatura.bloodwood_sword, new ModelResourceList("weapons/").add(0, "bloodwood_sword"));
		registerModelList(ItemsNatura.bloodwood_kama, new ModelResourceList("weapons/").add(0, "bloodwood_kama"));

		registerModelList(ItemsNatura.darkwood_pickaxe, new ModelResourceList("tools/").add(0, "darkwood_pickaxe"));
		registerModelList(ItemsNatura.darkwood_axe, new ModelResourceList("tools/").add(0, "darkwood_axe"));
		registerModelList(ItemsNatura.darkwood_shovel, new ModelResourceList("tools/").add(0, "darkwood_shovel"));
		registerModelList(ItemsNatura.darkwood_sword, new ModelResourceList("weapons/").add(0, "darkwood_sword"));
		registerModelList(ItemsNatura.darkwood_kama, new ModelResourceList("weapons/").add(0, "darkwood_kama"));

		registerModelList(ItemsNatura.fusewood_pickaxe, new ModelResourceList("tools/").add(0, "fusewood_pickaxe"));
		registerModelList(ItemsNatura.fusewood_axe, new ModelResourceList("tools/").add(0, "fusewood_axe"));
		registerModelList(ItemsNatura.fusewood_shovel, new ModelResourceList("tools/").add(0, "fusewood_shovel"));
		registerModelList(ItemsNatura.fusewood_sword, new ModelResourceList("weapons/").add(0, "fusewood_sword"));
		registerModelList(ItemsNatura.fusewood_kama, new ModelResourceList("weapons/").add(0, "fusewood_kama"));

		registerModelList(ItemsNatura.netherquartz_pickaxe, new ModelResourceList("tools/").add(0, "netherquartz_pickaxe"));
		registerModelList(ItemsNatura.netherquartz_axe, new ModelResourceList("tools/").add(0, "netherquartz_axe"));
		registerModelList(ItemsNatura.netherquartz_shovel, new ModelResourceList("tools/").add(0, "netherquartz_shovel"));
		registerModelList(ItemsNatura.netherquartz_sword, new ModelResourceList("weapons/").add(0, "netherquartz_sword"));
		registerModelList(ItemsNatura.netherquartz_kama, new ModelResourceList("weapons/").add(0, "netherquartz_kama"));
	}

	private static void registerModelList(Item item, ModelResourceList list)
	{
		models.put(item, list);
	}

	private static void prepareModels()
	{
		for (Map.Entry<Item, ModelResourceList> entry : models.entrySet())
		{
			Item item = entry.getKey();

			Collection<String> registrations = entry.getValue().getRegistrations().values();

			for (String registration : registrations)
			{
				ModelBakery.addVariantName(item, registration);
			}
		}
	}

	private static void registerModels()
	{
		for (HashMap.Entry<Item, ModelResourceList> entry : models.entrySet())
		{
			Item item = entry.getKey();

			HashMap<Integer, String> registrations = entry.getValue().getRegistrations();

			for (Map.Entry<Integer, String> registration : registrations.entrySet())
			{
				int meta = registration.getKey();
				String path = registration.getValue();

				ModelResourceLocation resource = new ModelResourceLocation(path, "inventory");

				Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, meta, resource);
			}
		}
	}

	/**
	 * Shorthand utility method for Item.getItemFromBlock(block).
	 */
	private static Item getItem(Block block)
	{
		return Item.getItemFromBlock(block);
	}
}

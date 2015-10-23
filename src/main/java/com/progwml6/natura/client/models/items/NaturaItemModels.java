package com.progwml6.natura.client.models.items;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.progwml6.natura.client.util.ItemModelList;
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

public class NaturaItemModels
{
	private static HashMap<Item, ItemModelList> models = new HashMap<Item, ItemModelList>();

	public static void preInit()
	{
		defineItemModels();
		prepareModels();
	}

	public static void init()
	{
		registerModels();
	}

	private static void defineItemModels()
	{
		registerItemModels(getItem(BlocksNatura.clouds), new ItemModelList("clouds/")
				.add(BlockClouds.WHITE_CLOUD.getMeta(), "cloud_white")
				.add(BlockClouds.GREY_CLOUD.getMeta(), "cloud_gray")
				.add(BlockClouds.DARK_CLOUD.getMeta(), "cloud_dark")
				.add(BlockClouds.SULFER_CLOUD.getMeta(), "cloud_sulfur"));

		registerItemModels(getItem(BlocksNatura.logs), new ItemModelList("logs/")
				.add(BlockNaturaLogs.EUCALYPTUS_LOG.getMeta(), "eucalyptus_log")
				.add(BlockNaturaLogs.SAKURA_LOG.getMeta(), "sakura_log")
				.add(BlockNaturaLogs.GHOSTWOOD_LOG.getMeta(), "ghostwood_log")
				.add(BlockNaturaLogs.HOPSEED_LOG.getMeta(), "hopseed_log"));

		registerItemModels(getItem(BlocksNatura.planks), new ItemModelList("planks/")
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

		registerItemModels(getItem(BlocksNatura.crafting_table), new ItemModelList("tables/")
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

		registerItemModels(getItem(BlocksNatura.cotton_crop), new ItemModelList("crops/")
				.add(0, "cotton_stage0")
				.add(1, "cotton_stage1")
				.add(2, "cotton_stage2")
				.add(3, "cotton_stage3")
				.add(4, "cotton_stage4"));
		registerItemModels(getItem(BlocksNatura.barley_crop), new ItemModelList("crops/")
				.add(0, "barley_stage0")
				.add(1, "barley_stage1")
				.add(2, "barley_stage2")
				.add(3, "barley_stage3"));

		registerItemModels(ItemsNatura.cotton_seeds, new ItemModelList("seeds/").add(0, "cotton_seeds"));
		registerItemModels(ItemsNatura.barley_seeds, new ItemModelList("seeds/").add(0, "barley_seeds"));

		registerItemModels(ItemsNatura.spawn_egg, new ItemModelList()
				.add(0, "spawn_egg")
				.add(1, "spawn_egg")
				.add(2, "spawn_egg")
				.add(3, "spawn_egg"));

		registerItemModels(ItemsNatura.impMeat, new ItemModelList("consumables/")
				.add(0, "impmeat_raw")
				.add(1, "impmeat_cooked"));

		registerItemModels(ItemsNatura.bowlEmpty, new ItemModelList("bowls/")
				.add(0, "bowl_empty_bowl")
				.add(1, "bowl_empty_ghostwood")
				.add(2, "bowl_empty_bloodwood")
				.add(3, "bowl_empty_darkwood")
				.add(4, "bowl_empty_fusewood"));

		registerItemModels(ItemsNatura.materials, new ItemModelList("materials/")
				.add(ItemMaterial.MaterialType.BARLEY_PLANT.ordinal(), "materials_barley_plant")
				.add(ItemMaterial.MaterialType.BARLEY_FLOUR.ordinal(), "materials_barley_flour")
				.add(ItemMaterial.MaterialType.WHEAT_FLOUR.ordinal(), "materials_wheat_flour")
				.add(ItemMaterial.MaterialType.COTTON.ordinal(), "materials_cotton_plant")
				.add(ItemMaterial.MaterialType.SULFUR_POWDER.ordinal(), "materials_sulfur")
				.add(ItemMaterial.MaterialType.GHOSTWOOD_FLETCHING.ordinal(), "materials_ghostwood_fletching")
				.add(ItemMaterial.MaterialType.IMP_LEATHER.ordinal(), "materials_leather_imp")
				.add(ItemMaterial.MaterialType.FLAME_STRING.ordinal(), "materials_flamestring")
				.add(ItemMaterial.MaterialType.BLUE_DYE.ordinal(), "materials_dye_blue"));

		registerItemModels(ItemsNatura.ghostwood_pickaxe, new ItemModelList("tools/").add(0, "ghostwood_pickaxe"));
		registerItemModels(ItemsNatura.ghostwood_axe, new ItemModelList("tools/").add(0, "ghostwood_axe"));
		registerItemModels(ItemsNatura.ghostwood_shovel, new ItemModelList("tools/").add(0, "ghostwood_shovel"));
		registerItemModels(ItemsNatura.ghostwood_sword, new ItemModelList("weapons/").add(0, "ghostwood_sword"));
		registerItemModels(ItemsNatura.ghostwood_kama, new ItemModelList("weapons/").add(0, "ghostwood_kama"));

		registerItemModels(ItemsNatura.bloodwood_pickaxe, new ItemModelList("tools/").add(0, "bloodwood_pickaxe"));
		registerItemModels(ItemsNatura.bloodwood_axe, new ItemModelList("tools/").add(0, "bloodwood_axe"));
		registerItemModels(ItemsNatura.bloodwood_shovel, new ItemModelList("tools/").add(0, "bloodwood_shovel"));
		registerItemModels(ItemsNatura.bloodwood_sword, new ItemModelList("weapons/").add(0, "bloodwood_sword"));
		registerItemModels(ItemsNatura.bloodwood_kama, new ItemModelList("weapons/").add(0, "bloodwood_kama"));

		registerItemModels(ItemsNatura.darkwood_pickaxe, new ItemModelList("tools/").add(0, "darkwood_pickaxe"));
		registerItemModels(ItemsNatura.darkwood_axe, new ItemModelList("tools/").add(0, "darkwood_axe"));
		registerItemModels(ItemsNatura.darkwood_shovel, new ItemModelList("tools/").add(0, "darkwood_shovel"));
		registerItemModels(ItemsNatura.darkwood_sword, new ItemModelList("weapons/").add(0, "darkwood_sword"));
		registerItemModels(ItemsNatura.darkwood_kama, new ItemModelList("weapons/").add(0, "darkwood_kama"));

		registerItemModels(ItemsNatura.fusewood_pickaxe, new ItemModelList("tools/").add(0, "fusewood_pickaxe"));
		registerItemModels(ItemsNatura.fusewood_axe, new ItemModelList("tools/").add(0, "fusewood_axe"));
		registerItemModels(ItemsNatura.fusewood_shovel, new ItemModelList("tools/").add(0, "fusewood_shovel"));
		registerItemModels(ItemsNatura.fusewood_sword, new ItemModelList("weapons/").add(0, "fusewood_sword"));
		registerItemModels(ItemsNatura.fusewood_kama, new ItemModelList("weapons/").add(0, "fusewood_kama"));

		registerItemModels(ItemsNatura.netherquartz_pickaxe, new ItemModelList("tools/").add(0, "netherquartz_pickaxe"));
		registerItemModels(ItemsNatura.netherquartz_axe, new ItemModelList("tools/").add(0, "netherquartz_axe"));
		registerItemModels(ItemsNatura.netherquartz_shovel, new ItemModelList("tools/").add(0, "netherquartz_shovel"));
		registerItemModels(ItemsNatura.netherquartz_sword, new ItemModelList("weapons/").add(0, "netherquartz_sword"));
		registerItemModels(ItemsNatura.netherquartz_kama, new ItemModelList("weapons/").add(0, "netherquartz_kama"));
	}

	private static void registerItemModels(Item item, ItemModelList list)
	{
		models.put(item, list);
	}

	private static void prepareModels()
	{
		for (Map.Entry<Item, ItemModelList> entry : models.entrySet())
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
		for (HashMap.Entry<Item, ItemModelList> entry : models.entrySet())
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

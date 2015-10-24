package com.progwml6.natura.common.entities;

import com.progwml6.natura.common.Natura;
import com.progwml6.natura.common.blocks.util.DispenserBehaviorSpawnEgg;
import com.progwml6.natura.common.entities.living.ImpEntity;
import com.progwml6.natura.common.entities.living.enemy.BabyHeatscarSpider;
import com.progwml6.natura.common.entities.living.enemy.HeatscarSpider;
import com.progwml6.natura.common.entities.living.enemy.NitroCreeper;
import com.progwml6.natura.common.entities.projectiles.FusewoodArrow;
import com.progwml6.natura.common.items.ItemsNatura;

import net.minecraft.block.BlockDispenser;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class EntitiesNatura
{
	private static int NEXT_ID = 0;

	public static void preInit()
	{
		registerEntity(ImpEntity.class, "Imp", 32, 5, true);

		registerEntity(HeatscarSpider.class, "FlameSpider", 32, 5, true);
		registerEntity(NitroCreeper.class, "NitroCreeper", 64, 5, true);
		registerEntity(BabyHeatscarSpider.class, "FlameSpiderBaby", 32, 5, true);

		EntityRegistry.registerModEntity(FusewoodArrow.class, "FusewoodArrow", NEXT_ID++, Natura.INSTANCE, 64, 3, true);
	}

	public static void postInit()
	{
		BiomeGenBase[] nether = BiomeDictionary.getBiomesForType(BiomeDictionary.Type.NETHER);

		EntityRegistry.addSpawn(ImpEntity.class, 10, 8, 12, EnumCreatureType.CREATURE, nether);
		EntityRegistry.addSpawn(HeatscarSpider.class, 10, 4, 4, EnumCreatureType.MONSTER, nether);
		EntityRegistry.addSpawn(NitroCreeper.class, 8, 4, 6, EnumCreatureType.MONSTER, nether);
		EntityRegistry.addSpawn(BabyHeatscarSpider.class, 7, 4, 4, EnumCreatureType.MONSTER, nether);

		BlockDispenser.dispenseBehaviorRegistry.putObject(ItemsNatura.spawn_egg, new DispenserBehaviorSpawnEgg());
	}

	private static void registerEntity(Class<? extends Entity> entity, String id, int trackingRange, int updateFrequency, boolean sendsVelocityUpdates)
	{
		EntityRegistry.registerModEntity(entity, id, NEXT_ID++, Natura.INSTANCE, trackingRange, updateFrequency, sendsVelocityUpdates);
	}
}

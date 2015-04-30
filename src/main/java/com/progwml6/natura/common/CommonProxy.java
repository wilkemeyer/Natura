package com.progwml6.natura.common;

import mantle.client.ModelVariant;
import net.minecraft.block.BlockDispenser;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.common.registry.EntityRegistry;

import com.progwml6.natura.Natura;
import com.progwml6.natura.entity.BabyHeatscarSpider;
import com.progwml6.natura.entity.FusewoodArrow;
import com.progwml6.natura.entity.HeatscarSpider;
import com.progwml6.natura.entity.ImpEntity;
import com.progwml6.natura.entity.NitroCreeper;

public class CommonProxy
{
    public void preInit()
    {
    }

    public void init()
    {

    }

    public void postInit()
    {
        EntityRegistry.registerModEntity(ImpEntity.class, "Imp", 0, Natura.INSTANCE, 32, 5, true);
        EntityRegistry.registerModEntity(HeatscarSpider.class, "FlameSpider", 1, Natura.INSTANCE, 32, 5, true);
        EntityRegistry.registerModEntity(NitroCreeper.class, "NitroCreeper", 2, Natura.INSTANCE, 64, 5, true);
        EntityRegistry.registerModEntity(FusewoodArrow.class, "FusewoodArrow", 3, Natura.INSTANCE, 64, 3, true);
        EntityRegistry.registerModEntity(BabyHeatscarSpider.class, "FlameSpiderBaby", 4, Natura.INSTANCE, 32, 5, true);

        BiomeGenBase[] nether = BiomeDictionary.getBiomesForType(BiomeDictionary.Type.NETHER);

        EntityRegistry.addSpawn(ImpEntity.class, 10, 8, 12, EnumCreatureType.CREATURE, nether);
        EntityRegistry.addSpawn(HeatscarSpider.class, 10, 4, 4, EnumCreatureType.MONSTER, nether);
        EntityRegistry.addSpawn(NitroCreeper.class, 8, 4, 6, EnumCreatureType.MONSTER, nether);
        EntityRegistry.addSpawn(BabyHeatscarSpider.class, 7, 4, 4, EnumCreatureType.MONSTER, nether);

        BlockDispenser.dispenseBehaviorRegistry.putObject(Natura.INSTANCE.getItems().spawn_egg, new DispenserBehaviorSpawnEgg());
    }

    public ModelVariant getModels()
    {
        return null;
    }

}

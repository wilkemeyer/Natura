package com.progwml6.natura.common;

import mantle.client.ModelVariant;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.common.registry.EntityRegistry;

import com.progwml6.natura.Natura;
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
        EntityRegistry.registerModEntity(NitroCreeper.class, "NitroCreeper", 2, Natura.INSTANCE, 64, 5, true);

        BiomeGenBase[] nether = BiomeDictionary.getBiomesForType(BiomeDictionary.Type.NETHER);

        EntityRegistry.addSpawn(NitroCreeper.class, 8, 4, 6, EnumCreatureType.MONSTER, nether);
    }

    public ModelVariant getModels()
    {
        return null;
    }

}

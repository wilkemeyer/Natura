package com.progwml6.natura;

import com.progwml6.natura.entity.NitroCreeper;
import mantle.client.ModelVariant;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class CommonProxy
{
    public void init()
    {

    }

    public void postInit()
    {
        EntityRegistry.registerModEntity(NitroCreeper.class, "NitroCreeper", 2, Natura.instance, 64, 5, true);

        BiomeGenBase[] nether = BiomeDictionary.getBiomesForType(BiomeDictionary.Type.NETHER);

        EntityRegistry.addSpawn(NitroCreeper.class, 8, 4, 6, EnumCreatureType.MONSTER, nether);
    }

    public ModelVariant getModels()
    {
        return null;
    }

}

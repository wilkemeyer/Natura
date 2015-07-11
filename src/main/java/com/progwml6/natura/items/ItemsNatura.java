package com.progwml6.natura.items;

import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.progwml6.natura.Natura;
import com.progwml6.natura.blocks.BlocksNatura;
import com.progwml6.natura.items.food.ItemEmptyBowl;
import com.progwml6.natura.items.food.ItemImpMeat;
import com.progwml6.natura.items.food.ItemStewBowl;
import com.progwml6.natura.items.itemblocks.crops.ItemNaturaSeeds;
import com.progwml6.natura.items.misc.ItemNaturaMaterial;
import com.progwml6.natura.items.misc.ItemNaturaSpawnEgg;
import com.progwml6.natura.items.tools.ItemNaturaAxe;
import com.progwml6.natura.items.tools.ItemNaturaPickaxe;
import com.progwml6.natura.items.tools.ItemNaturaShovel;
import com.progwml6.natura.items.tools.ItemNaturaSword;

public class ItemsNatura
{
    public static Item cotton_seeds, barley_seeds, spawn_egg, impMeat, bowlEmpty, materials;//, bowlStew, bowlEmpty, materials;

    public static ToolMaterial bloodwood = EnumHelper.addToolMaterial("Bloodwood", 3, 350, 7f, 3, 24);

    public static ItemNaturaAxe ghostwoodAxe, bloodwoodAxe, darkwoodAxe, fusewoodAxe, netherquartzAxe;

    public static ItemNaturaPickaxe ghostwoodPickaxe, bloodwoodPickaxe, darkwoodPickaxe, fusewoodPickaxe, netherquartzPickaxe;

    public static ItemNaturaShovel ghostwoodShovel, bloodwoodShovel, darkwoodShovel, fusewoodShovel, netherquartzShovel;

    public static ItemNaturaSword ghostwoodSword, bloodwoodSword, darkwoodSword, fusewoodSword, netherquartzSword;

    public static void preInit()
    {
        ItemNaturaSpawnEgg.addMapping("Imp", 0xF29735, 0x2E1F10);
        ItemNaturaSpawnEgg.addMapping("FlameSpider", 0xE64D10, 0x57B1BD);
        ItemNaturaSpawnEgg.addMapping("NitroCreeper", 0xF73E6C, 0x9B5004);
        ItemNaturaSpawnEgg.addMapping("FlameSpiderBaby", 0xE64D10, 0x57B1BD);

        spawn_egg = registerItem("spawn_egg", new ItemNaturaSpawnEgg());
        cotton_seeds = registerItem("cotton_seeds", new ItemNaturaSeeds(BlocksNatura.cottonCrop, "tooltip.cotton"));
        barley_seeds = registerItem("barley_seeds", new ItemNaturaSeeds(BlocksNatura.barleyCrop, "tooltip.barley"));
        impMeat = registerItem("impmeat", new ItemImpMeat());
        //bowlStew = registerItem("bowl_stew", new ItemStewBowl());
        bowlEmpty = registerItem("bowl_empty", new ItemEmptyBowl());
        materials = registerItem("materals", new ItemNaturaMaterial());

        ghostwoodPickaxe = registerItem("ghostwood_pickaxe", new ItemNaturaPickaxe(ToolMaterial.WOOD));
        ghostwoodAxe = registerItem("ghostwood_axe", new ItemNaturaAxe(ToolMaterial.WOOD));
        ghostwoodShovel = registerItem("ghostwood_shovel", new ItemNaturaShovel(ToolMaterial.WOOD));
        ghostwoodSword = registerItem("ghostwood_sword", new ItemNaturaSword(ToolMaterial.WOOD));

        bloodwoodPickaxe = registerItem("bloodwood_pickaxe", new ItemNaturaPickaxe(bloodwood));
        bloodwoodAxe = registerItem("bloodwood_axe", new ItemNaturaAxe(bloodwood));
        bloodwoodShovel = registerItem("bloodwood_shovel", new ItemNaturaShovel(bloodwood));
        bloodwoodSword = registerItem("bloodwood_sword", new ItemNaturaSword(bloodwood));

        darkwoodPickaxe = registerItem("darkwood_pickaxe", new ItemNaturaPickaxe(ToolMaterial.STONE));
        darkwoodAxe = registerItem("darkwood_axe", new ItemNaturaAxe(ToolMaterial.STONE));
        darkwoodShovel = registerItem("darkwood_shovel", new ItemNaturaShovel(ToolMaterial.STONE));
        darkwoodSword = registerItem("darkwood_sword", new ItemNaturaSword(ToolMaterial.STONE));

        fusewoodPickaxe = registerItem("fusewood_pickaxe", new ItemNaturaPickaxe(ToolMaterial.IRON));
        fusewoodAxe = registerItem("fusewood_axe", new ItemNaturaAxe(ToolMaterial.IRON));
        fusewoodShovel = registerItem("fusewood_shovel", new ItemNaturaShovel(ToolMaterial.IRON));
        fusewoodSword = registerItem("fusewood_sword", new ItemNaturaSword(ToolMaterial.IRON));

        netherquartzPickaxe = registerItem("netherquartz_pickaxe", new ItemNaturaPickaxe(ToolMaterial.STONE));
        netherquartzAxe = registerItem("netherquartz_axe", new ItemNaturaAxe(ToolMaterial.STONE));
        netherquartzShovel = registerItem("netherquartz_shovel", new ItemNaturaShovel(ToolMaterial.STONE));
        netherquartzSword = registerItem("netherquartz_sword", new ItemNaturaSword(ToolMaterial.STONE));
    }

    private static <T extends Item> T registerItem(String name, T item)
    {
        item.setUnlocalizedName(name);
        GameRegistry.registerItem(item, name);

        return item;
    }
}

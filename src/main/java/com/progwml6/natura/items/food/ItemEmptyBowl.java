package com.progwml6.natura.items.food;

import mantle.items.util.IItemWithVariants;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.progwml6.natura.Natura;

public class ItemEmptyBowl extends Item implements IItemWithVariants
{
    public static String[] variantNames = new String[] { "bowl", "ghostwood", "bloodwood", "darkwood", "fusewood" };

    public ItemEmptyBowl()
    {
        this.setCreativeTab(Natura.INSTANCE.getCreativeTabs().tabMisc);
    }

    @Override
    public String[] getVariantNames()
    {
        return variantNames;
    }

    @Override
    public String getUnlocalizedName(ItemStack stack)
    {
        return Items.bowl.getUnlocalizedName(stack);
    }

}

package com.progwml6.natura.common.items.util;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.List;

import com.progwml6.natura.common.util.NaturaCreativeTabs;

public class ItemEmptyBowl extends Item
{
    public static String[] variantNames = new String[] { "bowl", "ghostwood", "bloodwood", "darkwood", "fusewood" };

    public ItemEmptyBowl()
    {
        this.setCreativeTab(NaturaCreativeTabs.tabMisc);
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public void getSubItems(Item id, CreativeTabs tab, List list)
    {
        for (int i = 0; i < variantNames.length; i++)
            list.add(new ItemStack(id, 1, i));
    }

    @Override
    public String getUnlocalizedName(ItemStack stack)
    {
        return Items.bowl.getUnlocalizedName(stack);
    }

}

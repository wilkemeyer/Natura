package com.progwml6.natura.common.items.util;

import java.util.List;

import com.progwml6.natura.common.util.NaturaCreativeTabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;

public class ItemNaturaCrafting extends Item
{
    public String[] unlocalizedNames;

    public ItemNaturaCrafting(String[] names)
    {
        this.setCreativeTab(NaturaCreativeTabs.tabMisc);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
        this.unlocalizedNames = names;
    }

    @Override
    public String getUnlocalizedName(ItemStack stack)
    {
        int arr = MathHelper.clamp_int(stack.getItemDamage(), 0, unlocalizedNames.length);
        return getUnlocalizedName() + "." + unlocalizedNames[arr];
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public void getSubItems(Item id, CreativeTabs tab, List list)
    {
        for (int i = 0; i < unlocalizedNames.length; i++)
            list.add(new ItemStack(id, 1, i));
    }

}

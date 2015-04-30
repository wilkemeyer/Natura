package com.progwml6.natura.items.misc;

import java.util.List;

import mantle.items.util.IItemWithVariants;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;

import com.progwml6.natura.Natura;

public class ItemNaturaCrafting extends Item implements IItemWithVariants
{
    public String[] unlocalizedNames;

    public String[] variantNames;

    public ItemNaturaCrafting(String[] names, String[] variant)
    {
        this.setCreativeTab(Natura.INSTANCE.getCreativeTabs().tabMisc);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
        this.variantNames = variant;
        this.unlocalizedNames = names;
    }

    @Override
    public String[] getVariantNames()
    {
        return variantNames;
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

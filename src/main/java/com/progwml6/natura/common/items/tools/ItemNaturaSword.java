package com.progwml6.natura.common.items.tools;

import com.progwml6.natura.common.Natura;
import com.progwml6.natura.common.util.NaturaCreativeTabs;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.StatCollector;

public class ItemNaturaSword extends ItemSword
{
    public ItemNaturaSword(ToolMaterial material)
    {
        super(material);
        this.setCreativeTab(NaturaCreativeTabs.tabMisc);
    }

    @Override
    public String getItemStackDisplayName(ItemStack stack)
    {
        return ("" + StatCollector.translateToLocal("natura." + this.getUnlocalizedNameInefficiently(stack) + ".name")).trim();
    }
}

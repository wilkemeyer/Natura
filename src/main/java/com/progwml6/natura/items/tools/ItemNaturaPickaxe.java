package com.progwml6.natura.items.tools;

import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

import com.progwml6.natura.Natura;
import com.progwml6.natura.NaturaCreativeTabs;

public class ItemNaturaPickaxe extends ItemPickaxe
{
    public ItemNaturaPickaxe(ToolMaterial material)
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

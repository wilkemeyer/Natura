package com.progwml6.natura.items.tools;

import com.progwml6.natura.creativetabs.NaturaCreativeTabs;
import net.minecraft.item.ItemAxe;

public class ItemNaturaAxe extends ItemAxe
{
    public ItemNaturaAxe(ToolMaterial material)
    {
        super(material);
        this.setCreativeTab(NaturaCreativeTabs.tab);
    }
}

package com.progwml6.natura.items.tools;

import com.progwml6.natura.creativetabs.NaturaCreativeTabs;
import net.minecraft.item.ItemSpade;

public class ItemNaturaShovel extends ItemSpade
{
    public ItemNaturaShovel(ToolMaterial material)
    {
        super(material);
        this.setCreativeTab(NaturaCreativeTabs.tab);
    }
}

package com.progwml6.natura.items.tools;

import com.progwml6.natura.creativetabs.NaturaCreativeTabs;
import net.minecraft.item.ItemSword;

public class ItemNaturaSword extends ItemSword
{
    public ItemNaturaSword(ToolMaterial material)
    {
        super(material);
        this.setCreativeTab(NaturaCreativeTabs.tab);
    }
}

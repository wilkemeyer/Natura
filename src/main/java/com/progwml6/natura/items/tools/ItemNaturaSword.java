package com.progwml6.natura.items.tools;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.StatCollector;

import com.progwml6.natura.Natura;

public class ItemNaturaSword extends ItemSword
{
    public ItemNaturaSword(ToolMaterial material)
    {
        super(material);
        this.setCreativeTab(Natura.INSTANCE.getCreativeTabs().tabMisc);
    }

    @Override
    public String getItemStackDisplayName(ItemStack stack)
    {
        return ("" + StatCollector.translateToLocal("natura." + this.getUnlocalizedNameInefficiently(stack) + ".name")).trim();
    }
}

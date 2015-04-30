package com.progwml6.natura.items.misc;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.progwml6.natura.Natura;

public class ItemNaturaMaterial extends ItemNaturaCrafting
{
    public ItemNaturaMaterial()
    {
        super(new String[] { "barley.plant", "barley.flour", "wheat.flour", "cotton.plant", "powder.sulfur", "fletching.ghostwood", "leather.imp", "string.flame", "dye.blue" },
                new String[] { "barley_plant", "barley_flour", "wheat_flour", "cotton_plant", "sulfur", "ghostwood_fletching", "leather_imp", "flamestring", "dye_blue" });
        this.setCreativeTab(Natura.INSTANCE.getCreativeTabs().tabMisc);
    }

    @Override
    public String getUnlocalizedName(ItemStack itemstack)
    {
        return (new StringBuilder()).append("item.").append(unlocalizedNames[itemstack.getItemDamage()]).toString();
    }

    @Override
    public String getItemStackDisplayName(ItemStack stack)
    {
        return ("" + StatCollector.translateToLocal("natura." + this.getUnlocalizedNameInefficiently(stack) + ".name")).trim();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4)
    {
        switch (stack.getItemDamage())
        {
        case 0:
            list.add(StatCollector.translateToLocal("tooltip.barley"));
            break;
        case 1:
        case 2:
            list.add(StatCollector.translateToLocal("tooltip.flour1"));
            list.add(StatCollector.translateToLocal("tooltip.flour2"));
            break;
        case 3:
            list.add(StatCollector.translateToLocal("tooltip.cotton"));
            break;
        case 4:
            list.add(StatCollector.translateToLocal("tooltip.sulfur"));
            break;
        case 5:
            list.add(StatCollector.translateToLocal("tooltip.fletching"));
            break;
        case 6:
            list.add(StatCollector.translateToLocal("tooltip.imp"));
            break;
        case 7:
            list.add(StatCollector.translateToLocal("tooltip.string"));
            break;
        }
    }

}

package com.progwml6.natura;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.progwml6.natura.blocks.natural.BlockClouds;

public class NaturaCreativeTabs
{
    private class NaturaCreativeTab extends CreativeTabs
    {
        private Item item;

        private int metadata;

        public NaturaCreativeTab(String unlocalizedName)
        {
            super(unlocalizedName);
        }

        private void setItemToDisplay(Item item, int metadata)
        {
            this.item = item;
            this.metadata = metadata;
        }

        @Override
        public Item getTabIconItem()
        {
            return this.item;
        }

        @Override
        @SideOnly(Side.CLIENT)
        public int getIconItemDamage()
        {
            return this.metadata;
        }
    }

    public NaturaCreativeTab tabMisc = new NaturaCreativeTab("naturaMisc");

    public void preInit()
    {
        this.tabMisc.setItemToDisplay(Item.getItemFromBlock(Natura.INSTANCE.getBlocks().clouds), BlockClouds.WHITE.getMeta());
    }
}

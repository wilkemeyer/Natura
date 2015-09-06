package com.progwml6.natura.common.util;

import com.progwml6.natura.common.blocks.BlocksNatura;
import com.progwml6.natura.common.blocks.natural.BlockClouds;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class NaturaCreativeTabs
{
    private static class NaturaCreativeTab extends CreativeTabs
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

    public static NaturaCreativeTab tabMisc = new NaturaCreativeTab("naturaMisc");

    public static void registerTabIcons()
    {
        tabMisc.setItemToDisplay(Item.getItemFromBlock(BlocksNatura.clouds), BlockClouds.WHITE_CLOUD.getMeta());
    }
}

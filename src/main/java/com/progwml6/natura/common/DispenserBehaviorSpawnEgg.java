package com.progwml6.natura.common;

import net.minecraft.block.BlockDispenser;
import net.minecraft.dispenser.BehaviorDefaultDispenseItem;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;

import com.progwml6.natura.items.misc.ItemNaturaSpawnEgg;

public class DispenserBehaviorSpawnEgg extends BehaviorDefaultDispenseItem
{
    /**
     * Dispense the specified stack, play the dispense sound and spawn particles.
     */
    @Override
    public ItemStack dispenseStack(IBlockSource par1IBlockSource, ItemStack par2ItemStack)
    {
        EnumFacing enumfacing = BlockDispenser.getFacing(par1IBlockSource.getBlockMetadata());
        double d0 = par1IBlockSource.getX() + enumfacing.getFrontOffsetX();
        double d1 = par1IBlockSource.getY() + 0.2F;
        double d2 = par1IBlockSource.getZ() + enumfacing.getFrontOffsetZ();
        Entity entity = ItemNaturaSpawnEgg.spawnCreature(par1IBlockSource.getWorld(), par2ItemStack.getMetadata(), d0, d1, d2);

        if (par2ItemStack.hasDisplayName())
        {
            entity.setCustomNameTag(par2ItemStack.getDisplayName());
        }

        par2ItemStack.splitStack(1);
        return par2ItemStack;
    }
}

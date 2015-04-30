package com.progwml6.natura.blocks.misc;

import java.util.List;

import mantle.blocks.util.BlockVariant;
import mantle.blocks.util.IBlockWithVariants;
import mantle.blocks.util.PropertyVariant;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.StatCollector;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockNaturaFence extends BlockFence implements IBlockWithVariants
{
    public static final BlockVariant
            EUCALYPTUS = new BlockVariant(0, "eucalyptus"),
            SAKURA = new BlockVariant(1, "sakura"),
            GHOSTWOOD = new BlockVariant(2, "ghostwood"),
            REDWOOD = new BlockVariant(3, "redwood"),
            BLOODWOOD = new BlockVariant(4, "bloodwood"),
            HOPSEED = new BlockVariant(5, "hopseed"),
            MAPLE = new BlockVariant(6, "maple"),
            SILVERBELL = new BlockVariant(7, "silverbell"),
            PURPLEHEART = new BlockVariant(8, "purpleheart"),
            TIGER = new BlockVariant(9, "tiger"),
            WILLOW = new BlockVariant(10, "willow"),
            DARKWOOD = new BlockVariant(11, "darkwood"),
            FUSEWOOD = new BlockVariant(12, "fusewood");

    public static final PropertyVariant FENCE_TYPE = PropertyVariant.create("variant", EUCALYPTUS, SAKURA, GHOSTWOOD, REDWOOD, BLOODWOOD, HOPSEED, MAPLE, SILVERBELL, PURPLEHEART, TIGER, WILLOW, DARKWOOD, FUSEWOOD);

    public BlockNaturaFence()
    {
        super(Material.wood);
    }

    @Override
    public String getLocalizedName()
    {
        return StatCollector.translateToLocal("natura." + this.getUnlocalizedName() + ".name");
    }

    @Override
    public boolean canPlaceTorchOnTop(IBlockAccess world, BlockPos pos)
    {
        return true;
    }

    @Override
    public boolean canConnectTo(IBlockAccess worldIn, BlockPos pos)
    {
        Block block = worldIn.getBlockState(pos).getBlock();
        return block == Blocks.barrier ? false : ((!(block instanceof BlockFence) || block.getMaterial() != this.blockMaterial) && !(block instanceof BlockFenceGate) ? (block.getMaterial().isOpaque() && block.isFullCube() ? block.getMaterial() != Material.gourd : false) : true);
    }

    @Override
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item itemIn, CreativeTabs tab, List list)
    {
        for (BlockVariant variant : FENCE_TYPE.getAllowedValues())
        {
            list.add(new ItemStack(itemIn, 1, variant.getMeta()));
        }
    }

    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(FENCE_TYPE, FENCE_TYPE.getVariantFromMeta(meta));
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
        return ((BlockVariant) state.getValue(FENCE_TYPE)).getMeta();
    }

    @Override
    public int damageDropped(IBlockState state)
    {
        return ((BlockVariant) state.getValue(FENCE_TYPE)).getMeta();
    }

    @Override
    public String getVariantNameFromStack(ItemStack stack)
    {
        return FENCE_TYPE.getVariantFromMeta(stack.getMetadata()).getName();
    }

    @Override
    protected BlockState createBlockState()
    {
        return new BlockState(this, new IProperty[] { FENCE_TYPE, NORTH, EAST, WEST, SOUTH });
    }

}

package com.progwml6.natura.blocks.natural;

import com.progwml6.natura.creativetabs.NaturaCreativeTabs;
import mantle.blocks.util.BlockVariant;
import mantle.blocks.util.IBlockWithVariants;
import mantle.blocks.util.PropertyVariant;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class BlockNaturaPlanks extends Block implements IBlockWithVariants
{
    public static final BlockVariant
    EUCALYPTUS = new BlockVariant(0, "eucalyptus_planks"),
    SAKURA = new BlockVariant(1, "sakura_planks"),
    GHOSTWOOD = new BlockVariant(2, "ghostwood_planks"),
    REDWOOD = new BlockVariant(3, "redwood_planks"),
    BLOODWOOD = new BlockVariant(4, "bloodwood_planks"),
    HOPSEED = new BlockVariant(5, "hopseed_planks"),
    MAPLE = new BlockVariant(6, "maple_planks"),
    SILVERBELL = new BlockVariant(7, "silverbell_planks"),
    PURPLEHEART = new BlockVariant(8, "purpleheart_planks"),
    TIGER = new BlockVariant(9, "tiger_planks"),
    WILLOW = new BlockVariant(10, "willow_planks"),
    DARKWOOD = new BlockVariant(11, "darkwood_planks"),
    FUSEWOOD = new BlockVariant(12, "fusewood_planks"),
    REDWOOD_BARK = new BlockVariant(13, "redwood_bark"),
    REDWOOD_HEART = new BlockVariant(14, "redwood_heart"),
    REDWOOD_ROOT = new BlockVariant(15, "redwood_root");

    public static final PropertyVariant PLANK_TYPE = PropertyVariant.create("variant", EUCALYPTUS, SAKURA, GHOSTWOOD, REDWOOD, BLOODWOOD, HOPSEED, MAPLE, SILVERBELL, PURPLEHEART, TIGER, WILLOW, DARKWOOD, FUSEWOOD, REDWOOD_BARK, REDWOOD_HEART, REDWOOD_ROOT);

    public BlockNaturaPlanks()
    {
        super(Material.wood);
        Blocks.fire.setFireInfo(this, 5, 20);
        this.setHardness(2.0f);
        this.setStepSound(Block.soundTypeWood);

        this.setDefaultState(this.getBlockState().getBaseState().withProperty(PLANK_TYPE, EUCALYPTUS));
        this.setCreativeTab(NaturaCreativeTabs.tab);
    }

    @Override
    public int getFlammability(IBlockAccess world, BlockPos pos, EnumFacing face)
    {
        if (this.getMetaFromState(world.getBlockState(pos)) == 2 || this.getMetaFromState(world.getBlockState(pos)) == 4 || (this.getMetaFromState(world.getBlockState(pos)) > 10 && this.getMetaFromState(world.getBlockState(pos)) <= 12) || this.getMetaFromState(world.getBlockState(pos)) == 14)
            return 0;
        return this.getFlammability(world, pos, face);
    }

    @Override
    public int getFireSpreadSpeed(IBlockAccess world, BlockPos pos, EnumFacing face)
    {
        if (this.getMetaFromState(world.getBlockState(pos)) == 2 || this.getMetaFromState(world.getBlockState(pos)) == 4 || (this.getMetaFromState(world.getBlockState(pos)) > 10 && this.getMetaFromState(world.getBlockState(pos)) <= 12) || this.getMetaFromState(world.getBlockState(pos)) == 14)
            return 0;
        return this.getFireSpreadSpeed(world, pos, face);
    }

    @Override
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item itemIn, CreativeTabs tab, List list)
    {
        for (BlockVariant variant : PLANK_TYPE.getAllowedValues())
        {
            list.add(new ItemStack(itemIn, 1, variant.getMeta()));
        }
    }

    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(PLANK_TYPE, PLANK_TYPE.getVariantFromMeta(meta));
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
        return ((BlockVariant) state.getValue(PLANK_TYPE)).getMeta();
    }

    @Override
    protected BlockState createBlockState()
    {
        return new BlockState(this, new IProperty[] { PLANK_TYPE });
    }

    @Override
    public int damageDropped(IBlockState state)
    {
        return ((BlockVariant) state.getValue(PLANK_TYPE)).getMeta();
    }

    @Override
    public String getVariantNameFromStack(ItemStack stack)
    {
        return PLANK_TYPE.getVariantFromMeta(stack.getMetadata()).getName();
    }
}

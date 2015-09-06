package com.progwml6.natura.common.blocks.natural;

import java.util.List;

import com.progwml6.natura.common.blocks.util.variants.IBlockWithVariants;
import com.progwml6.natura.common.blocks.util.variants.blockstates.BlockVariant;
import com.progwml6.natura.common.blocks.util.variants.blockstates.PropertyVariant;
import com.progwml6.natura.common.util.NaturaCreativeTabs;

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
import net.minecraft.util.StatCollector;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockNaturaPlanks extends Block implements IBlockWithVariants
{
	public static final BlockVariant EUCALYPTUS_PLANKS = new BlockVariant(0, "eucalyptus_planks"),
			SAKURA_PLANKS = new BlockVariant(1, "sakura_planks"),
			GHOSTWOOD_PLANKS = new BlockVariant(2, "ghostwood_planks"),
			REDWOOD_PLANKS = new BlockVariant(3, "redwood_planks"),
			BLOODWOOD_PLANKS = new BlockVariant(4, "bloodwood_planks"),
			HOPSEED_PLANKS = new BlockVariant(5, "hopseed_planks"),
			MAPLE_PLANKS = new BlockVariant(6, "maple_planks"),
			SILVERBELL_PLANKS = new BlockVariant(7, "silverbell_planks"),
			PURPLEHEART_PLANKS = new BlockVariant(8, "purpleheart_planks"),
			TIGER_PLANKS = new BlockVariant(9, "tiger_planks"),
			WILLOW_PLANKS = new BlockVariant(10, "willow_planks"),
			DARKWOOD_PLANKS = new BlockVariant(11, "darkwood_planks"),
			FUSEWOOD_PLANKS = new BlockVariant(12, "fusewood_planks"),
			REDWOOD_BARK_PLANKS = new BlockVariant(13, "redwood_bark"),
			REDWOOD_HEART_PLANKS = new BlockVariant(14, "redwood_heart"),
			REDWOOD_ROOT_PLANKS = new BlockVariant(15, "redwood_root");

	public static final PropertyVariant PLANK_TYPE = PropertyVariant.create("variant", EUCALYPTUS_PLANKS, SAKURA_PLANKS, GHOSTWOOD_PLANKS, REDWOOD_PLANKS, BLOODWOOD_PLANKS, HOPSEED_PLANKS, MAPLE_PLANKS, SILVERBELL_PLANKS, PURPLEHEART_PLANKS, TIGER_PLANKS, WILLOW_PLANKS, DARKWOOD_PLANKS, FUSEWOOD_PLANKS, REDWOOD_BARK_PLANKS, REDWOOD_HEART_PLANKS, REDWOOD_ROOT_PLANKS);

	public BlockNaturaPlanks()
	{
		super(Material.wood);
		Blocks.fire.setFireInfo(this, 5, 20);
		this.setHardness(2.0f);
		this.setStepSound(Block.soundTypeWood);

		this.setDefaultState(this.getBlockState().getBaseState().withProperty(PLANK_TYPE, EUCALYPTUS_PLANKS));
		this.setCreativeTab(NaturaCreativeTabs.tabMisc);
	}

	@Override
	public String getLocalizedName()
	{
		return StatCollector.translateToLocal("natura." + this.getUnlocalizedName() + ".name");
	}

	@Override
	public int getFlammability(IBlockAccess world, BlockPos pos, EnumFacing face)
	{
		if (this.getMetaFromState(world.getBlockState(pos)) == 2 || this.getMetaFromState(world.getBlockState(pos)) == 4 || (this.getMetaFromState(world.getBlockState(pos)) > 10 && this.getMetaFromState(world.getBlockState(pos)) <= 12) || this.getMetaFromState(world.getBlockState(pos)) == 14)
		{
			return 0;
		}
		return this.getFlammability(world, pos, face);
	}

	@Override
	public int getFireSpreadSpeed(IBlockAccess world, BlockPos pos, EnumFacing face)
	{
		if (this.getMetaFromState(world.getBlockState(pos)) == 2 || this.getMetaFromState(world.getBlockState(pos)) == 4 || (this.getMetaFromState(world.getBlockState(pos)) > 10 && this.getMetaFromState(world.getBlockState(pos)) <= 12) || this.getMetaFromState(world.getBlockState(pos)) == 14)
		{
			return 0;
		}
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
		return this.getDefaultState().withProperty(PLANK_TYPE, PLANK_TYPE.fromMeta(meta));
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
	public String getVariantUnlocalizedName(ItemStack stack)
	{
		return PLANK_TYPE.fromMeta(stack.getMetadata()).getName();
	}
}

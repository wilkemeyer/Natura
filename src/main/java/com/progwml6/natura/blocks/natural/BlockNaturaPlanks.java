package com.progwml6.natura.blocks.natural;

import java.util.List;

import mantle.blocks.iface.IBlockVariant;
import mantle.blocks.iface.IBlockWithVariants;
import com.progwml6.natura.creativetabs.NaturaCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
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

public class BlockNaturaPlanks extends Block implements IBlockWithVariants
{
	public enum PlanksVariant implements IBlockVariant
	{
		EUCALYPTUS(0, "eucalyptus_planks"),
		SAKURA(1, "sakura_planks"),
		GHOSTWOOD(2, "ghostwood_planks"),
		REDWOOD(3, "redwood_planks"),
		BLOODWOOD(4, "bloodwood_planks"),
		HOPSEED(5, "hopseed_planks"),
		MAPLE(6, "maple_planks"),
		SILVERBELL(7, "silverbell_planks"),
		PURPLEHEART(8, "purpleheart_planks"),
		TIGER(9, "tiger_planks"),
		WILLOW(10, "willow_planks"),
		DARKWOOD(11, "darkwood_planks"),
		FUSEWOOD(12, "fusewood_planks"),
		REDWOOD_BARK(13, "redwood_bark"),
		REDWOOD_HEART(14, "redwood_heart"),
		REDWOOD_ROOT(15, "redwood_root");

		private static final PlanksVariant[] metaLookup = new PlanksVariant[PlanksVariant.values().length];

		static
		{
			for (PlanksVariant type : PlanksVariant.values())
			{
				metaLookup[type.getMetadata()] = type;
			}
		}

		private int metadata;

		private String name;

		PlanksVariant(int metadata, String name)
		{
			this.metadata = metadata;
			this.name = name;
		}

		@Override
		public String getName()
		{
			return this.name;
		}

		@Override
		public int getMetadata()
		{
			return this.metadata;
		}

		public static PlanksVariant getVariantFromMetadata(int meta)
		{
			return PlanksVariant.metaLookup[meta];
		}
	}

	public static final PropertyEnum PLANK_TYPE = PropertyEnum.create("variant", PlanksVariant.class);

	public BlockNaturaPlanks()
	{
		super(Material.wood);
		Blocks.fire.setFireInfo(this, 5, 20);
		this.setHardness(2.0f);
		this.setStepSound(Block.soundTypeWood);

		this.setDefaultState(this.getBlockState().getBaseState().withProperty(PLANK_TYPE, PlanksVariant.EUCALYPTUS));
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
		for (PlanksVariant type : PlanksVariant.values())
		{
			list.add(new ItemStack(itemIn, 1, type.getMetadata()));
		}
	}

	@Override
	public IBlockState getStateFromMeta(int meta)
	{
		return this.getDefaultState().withProperty(PLANK_TYPE, PlanksVariant.getVariantFromMetadata(meta));
	}

	@Override
	public int getMetaFromState(IBlockState state)
	{
		return ((PlanksVariant) state.getValue(PLANK_TYPE)).getMetadata();
	}

	@Override
	protected BlockState createBlockState()
	{
		return new BlockState(this, new IProperty[] { PLANK_TYPE });
	}

	@Override
	public int damageDropped(IBlockState state)
	{
		return ((PlanksVariant) state.getValue(PLANK_TYPE)).getMetadata();
	}

	@Override
	public String getVariantNameFromStack(ItemStack stack)
	{
		return PlanksVariant.getVariantFromMetadata(stack.getMetadata()).getName();
	}
}

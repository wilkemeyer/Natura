package com.progwml6.natura.blocks.crops;

import java.util.List;
import java.util.Random;

import mantle.blocks.iface.IBlockVariant;
import mantle.blocks.iface.IBlockWithVariants;
import com.progwml6.natura.creativetabs.NaturaCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.IGrowable;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockNaturaCrop extends BlockBush implements IGrowable, IBlockWithVariants
{
	public enum PlantVariant implements IBlockVariant
	{
		BARLEY(0, "barley_plant"),
		COTTON(1, "cotton_olant");

		private static final PlantVariant[] metaLookup = new PlantVariant[PlantVariant.values().length];

		static
		{
			for (PlantVariant type : PlantVariant.values())
			{
				metaLookup[type.getMetadata()] = type;
			}
		}

		private int metadata;

		private String name;

		PlantVariant(int metadata, String name)
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

		public static PlantVariant getVariantFromMetadata(int meta)
		{
			return PlantVariant.metaLookup[meta];
		}
	}

	public static final PropertyEnum PLANT_TYPE = PropertyEnum.create("variant", PlantVariant.class);

	public static final PropertyInteger AGE = PropertyInteger.create("age", 0, 5);

	public BlockNaturaCrop()
	{
		this.setDefaultState(this.blockState.getBaseState().withProperty(PLANT_TYPE, PlantVariant.BARLEY).withProperty(AGE, Integer.valueOf(0)));
		this.setTickRandomly(true);
		float f = 0.5F;
		this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.25F, 0.5F + f);
		this.setCreativeTab(NaturaCreativeTabs.tab);
		this.setHardness(0.0F);
		this.setStepSound(soundTypeGrass);
		this.disableStats();
	}

	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item itemIn, CreativeTabs tab, List list)
	{
		for (PlantVariant type : PlantVariant.values())
		{
			list.add(new ItemStack(itemIn, 1, type.getMetadata()));
		}
	}

	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
	{
		super.updateTick(worldIn, pos, state, rand);

		if (worldIn.getLightFromNeighbors(pos.up()) >= 9)
		{
			int i = ((Integer) state.getValue(AGE)).intValue();
			if (this.getMetaFromState(state) == 1)
			{
				if (i < 5)
				{
					float f = getGrowthChance(this, worldIn, pos);

					if (rand.nextInt((int) (25.0F / f) + 1) == 0)
					{
						worldIn.setBlockState(pos, state.withProperty(AGE, Integer.valueOf(i + 1)), 2);
					}
				}
			}
			else
			{
				if (i < 4)
				{
					float f = getGrowthChance(this, worldIn, pos);

					if (rand.nextInt((int) (25.0F / f) + 1) == 0)
					{
						worldIn.setBlockState(pos, state.withProperty(AGE, Integer.valueOf(i + 1)), 2);
					}
				}
			}
		}
	}

	protected static float getGrowthChance(Block blockIn, World worldIn, BlockPos pos)
	{
		float f = 1.0F;
		BlockPos blockpos1 = pos.down();

		for (int i = -1; i <= 1; ++i)
		{
			for (int j = -1; j <= 1; ++j)
			{
				float f1 = 0.0F;
				IBlockState iblockstate = worldIn.getBlockState(blockpos1.add(i, 0, j));

				if (iblockstate.getBlock().canSustainPlant(worldIn, blockpos1.add(i, 0, j), net.minecraft.util.EnumFacing.UP, (net.minecraftforge.common.IPlantable) blockIn))
				{
					f1 = 1.0F;

					if (iblockstate.getBlock().isFertile(worldIn, blockpos1.add(i, 0, j)))
					{
						f1 = 3.0F;
					}
				}

				if (i != 0 || j != 0)
				{
					f1 /= 4.0F;
				}

				f += f1;
			}
		}

		BlockPos blockpos2 = pos.north();
		BlockPos blockpos3 = pos.south();
		BlockPos blockpos4 = pos.west();
		BlockPos blockpos5 = pos.east();
		boolean flag = blockIn == worldIn.getBlockState(blockpos4).getBlock() || blockIn == worldIn.getBlockState(blockpos5).getBlock();
		boolean flag1 = blockIn == worldIn.getBlockState(blockpos2).getBlock() || blockIn == worldIn.getBlockState(blockpos3).getBlock();

		if (flag && flag1)
		{
			f /= 2.0F;
		}
		else
		{
			boolean flag2 = blockIn == worldIn.getBlockState(blockpos4.north()).getBlock() || blockIn == worldIn.getBlockState(blockpos5.north()).getBlock() || blockIn == worldIn.getBlockState(blockpos5.south()).getBlock() || blockIn == worldIn.getBlockState(blockpos4.south()).getBlock();

			if (flag2)
			{
				f /= 2.0F;
			}
		}

		return f;
	}

	/**
	 * Whether this IGrowable can grow
	 */
	@Override
	public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient)
	{
		if (this.getMetaFromState(state) == 1)
		{
			return ((Integer) state.getValue(AGE)).intValue() < 5;
		}
		return ((Integer) state.getValue(AGE)).intValue() < 4;
	}

	@Override
	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state)
	{
		return true;
	}

	@Override
	public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public IBlockState getStateFromMeta(int meta)
	{
		return this.getDefaultState().withProperty(PLANT_TYPE, PlantVariant.getVariantFromMetadata(meta));
	}

	@Override
	public int getMetaFromState(IBlockState state)
	{
		return ((PlantVariant) state.getValue(PLANT_TYPE)).getMetadata();
	}

	@Override
	protected BlockState createBlockState()
	{
		return new BlockState(this, new IProperty[] { PLANT_TYPE, AGE });
	}

	@Override
	public String getVariantNameFromStack(ItemStack stack)
	{
		return PlantVariant.getVariantFromMetadata(stack.getMetadata()).getName();
	}

}

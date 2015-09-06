package com.progwml6.natura.common.blocks.natural.plants;

import java.util.List;
import java.util.Random;

import com.progwml6.natura.common.blocks.util.variants.IBlockWithVariants;
import com.progwml6.natura.common.blocks.util.variants.blockstates.BlockVariant;
import com.progwml6.natura.common.blocks.util.variants.blockstates.PropertyVariant;

import net.minecraft.block.Block;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.event.terraingen.TerrainGen;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockNaturaSapling extends BlockNaturaPlant implements IGrowable, IBlockWithVariants
{
	public static final BlockVariant EUCALYPTUS_SAPLING = new BlockVariant(0, "eucalyptus_sapling"),
			SAKURA_SAPLING = new BlockVariant(1, "sakura_sapling"),
			GHOSTWOOD_SAPLING = new BlockVariant(2, "ghostwood_sapling"),
			REDWOOD_SAPLING = new BlockVariant(3, "redwood_sapling"),
			BLOODWOOD_SAPLING = new BlockVariant(4, "bloodwood_sapling"),
			HOPSEED_SAPLING = new BlockVariant(5, "hopseed_sapling"),
			MAPLE_SAPLING = new BlockVariant(6, "maple_sapling"),
			SILVERBELL_SAPLING = new BlockVariant(7, "silverbell_sapling"),
			PURPLEHEART_SAPLING = new BlockVariant(8, "purpleheart_sapling"),
			TIGER_SAPLING = new BlockVariant(9, "tiger_sapling"),
			WILLOW_SAPLING = new BlockVariant(10, "willow_sapling"),
			DARKWOOD_SAPLING = new BlockVariant(11, "darkwood_sapling"),
			FUSEWOOD_SAPLING = new BlockVariant(12, "fusewood_sapling");

	public static final PropertyVariant PROPERTY_VARIANT = PropertyVariant.create("variant", EUCALYPTUS_SAPLING, SAKURA_SAPLING, GHOSTWOOD_SAPLING, REDWOOD_SAPLING, BLOODWOOD_SAPLING, HOPSEED_SAPLING, MAPLE_SAPLING, SILVERBELL_SAPLING, PURPLEHEART_SAPLING, TIGER_SAPLING, WILLOW_SAPLING, DARKWOOD_SAPLING, FUSEWOOD_SAPLING);

	public static final PropertyInteger PROPERTY_STAGE = PropertyInteger.create("stage", 0, 1);

	public BlockNaturaSapling()
	{
		super(Material.plants);
		this.setStepSound(Block.soundTypeGrass);
		this.setBlockBounds(0.1f, 0.0F, 0.1f, 0.9f, 0.8f, 0.9f);
		this.setTickRandomly(true);
		this.setDefaultState(this.getBlockState().getBaseState().withProperty(PROPERTY_VARIANT, EUCALYPTUS_SAPLING).withProperty(PROPERTY_STAGE, 0));
	}

	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item item, CreativeTabs tab, List list)
	{
		for (BlockVariant variant : PROPERTY_VARIANT.getAllowedValues())
		{
			list.add(new ItemStack(item, 1, variant.getMeta()));
		}
	}

	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
	{
		if (!worldIn.isRemote)
		{
			super.updateTick(worldIn, pos, state, rand);

			if (worldIn.getLightFromNeighbors(pos.up()) >= 9 && rand.nextInt(7) == 0)
			{
				this.grow(worldIn, rand, pos, state);
			}
		}
	}

	public void generateTree(World world, BlockPos pos, IBlockState state, Random random)
	{
		if (TerrainGen.saplingGrowTree(world, random, pos))
		{
			int meta = ((BlockVariant) state.getValue(PROPERTY_VARIANT)).getMeta();

			WorldGenerator treeGenerator = null;
		}
	}

	@Override
	public IBlockState getStateFromMeta(int meta)
	{
		return this.getDefaultState().withProperty(PROPERTY_VARIANT, PROPERTY_VARIANT.fromMeta(meta & 7)).withProperty(PROPERTY_STAGE, (meta & 8) >> 3);
	}

	@Override
	public int getMetaFromState(IBlockState state)
	{
		return ((BlockVariant) state.getValue(PROPERTY_VARIANT)).getMeta() | ((Integer) state.getValue(PROPERTY_STAGE) << 3);
	}

	@Override
	protected BlockState createBlockState()
	{
		return new BlockState(this, PROPERTY_VARIANT, PROPERTY_STAGE);
	}

	@Override
	public boolean canGrow(World world, BlockPos pos, IBlockState state, boolean isClient)
	{
		return true;
	}

	@Override
	public boolean canUseBonemeal(World world, Random rand, BlockPos pos, IBlockState state)
	{
		return world.rand.nextFloat() < 0.45f;
	}

	@Override
	public void grow(World world, Random rand, BlockPos pos, IBlockState state)
	{
		if ((Integer) state.getValue(PROPERTY_STAGE) == 0)
		{
			world.setBlockState(pos, state.cycleProperty(PROPERTY_STAGE), 4);
		}
		else
		{
			this.generateTree(world, pos, state, rand);
		}
	}

	@Override
	public String getVariantUnlocalizedName(ItemStack stack)
	{
		return PROPERTY_VARIANT.fromMeta(stack.getMetadata()).getName();
	}
}

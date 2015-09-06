package com.progwml6.natura.common.blocks.natural.plants;

import java.util.Random;

import com.progwml6.natura.common.items.ItemsNatura;

import net.minecraft.block.Block;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockNaturaCottonCrop extends BlockNaturaPlant implements IGrowable
{
	public static final PropertyInteger AGE = PropertyInteger.create("age", 0, 4);

	public BlockNaturaCottonCrop()
	{
		super(Material.plants);
		this.setDefaultState(this.blockState.getBaseState().withProperty(AGE, Integer.valueOf(0)));
		this.setTickRandomly(true);

		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.25F, 1.0F);

		this.setCreativeTab(null);
		this.setHardness(0.0F);
		this.setStepSound(soundTypeGrass);
		this.disableStats();
	}

	@Override
	public void onBlockClicked(World world, BlockPos pos, EntityPlayer player)
	{
		if (!world.isRemote)
		{
			IBlockState state = world.getBlockState(pos);
			if (((Integer) state.getValue(AGE)).intValue() == 4)
			{
				world.setBlockState(pos, state.withProperty(AGE, 2), 3);
				EntityItem entityitem = new EntityItem(world, player.posX, player.posY - 1.0D, player.posZ, new ItemStack(ItemsNatura.materials, 1, 3));
				world.spawnEntityInWorld(entityitem);
				entityitem.onCollideWithPlayer(player);
			}
		}
	}

	/* Right-click harvests berries */
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
	{
		if (((Integer) state.getValue(AGE)).intValue() == 4)
		{
			if (worldIn.isRemote)
				return true;

			worldIn.setBlockState(pos, state.withProperty(AGE, 2), 3);
			EntityItem entityitem = new EntityItem(worldIn, playerIn.posX, playerIn.posY - 1.0D, playerIn.posZ, new ItemStack(ItemsNatura.materials, 1, 3));
			worldIn.spawnEntityInWorld(entityitem);
			entityitem.onCollideWithPlayer(playerIn);
			return true;
		}
		return false;
	}

	/**
	 * is the block grass, dirt or farmland
	 */
	@Override
	public boolean isSuitableSoilBlock(Block ground)
	{
		return ground == Blocks.farmland;
	}

	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
	{
		int i = ((Integer) state.getValue(AGE)).intValue();

		if (i < 4 && rand.nextInt(5) == 0)
		{
			state = state.withProperty(AGE, Integer.valueOf(i + 1));
			worldIn.setBlockState(pos, state, 2);
		}

		super.updateTick(worldIn, pos, state, rand);
	}

	public void grow(World worldIn, BlockPos pos, IBlockState state)
	{
		int i = ((Integer) state.getValue(AGE)).intValue() + MathHelper.getRandomIntegerInRange(worldIn.rand, 2, 5);

		if (i > 4)
		{
			i = 4;
		}

		worldIn.setBlockState(pos, state.withProperty(AGE, Integer.valueOf(i)), 2);
	}

	@Override
	public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient)
	{
		int stage = (Integer) state.getValue(AGE);

		return stage < 4;
	}

	@Override
	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state)
	{
		int stage = (Integer) state.getValue(AGE);

		return stage < 4;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Item getItem(World worldIn, BlockPos pos)
	{
		return ItemsNatura.cotton_seeds;
	}

	@Override
	public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state)
	{
		this.grow(worldIn, pos, state);
	}

	/**
	 * Convert the given metadata into a BlockState for this Block
	 */
	@Override
	public IBlockState getStateFromMeta(int meta)
	{
		return this.getDefaultState().withProperty(AGE, Integer.valueOf(meta));
	}

	/**
	 * Convert the BlockState into the correct metadata value
	 */
	@Override
	public int getMetaFromState(IBlockState state)
	{
		return ((Integer) state.getValue(AGE)).intValue();
	}

	@Override
	protected BlockState createBlockState()
	{
		return new BlockState(this, new IProperty[] { AGE });
	}

}

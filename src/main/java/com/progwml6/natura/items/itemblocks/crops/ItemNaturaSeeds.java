package com.progwml6.natura.items.itemblocks.crops;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.StatCollector;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.progwml6.natura.creativetabs.NaturaCreativeTabs;

public class ItemNaturaSeeds extends Item implements IPlantable
{
	private Block crops;

	private String tag;

	public ItemNaturaSeeds(Block crops, String tag)
	{
		this.crops = crops;
		this.tag = tag;
		this.setCreativeTab(NaturaCreativeTabs.tab);
	}

	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ)
	{
		if (side != EnumFacing.UP)
		{
			return false;
		}
		else if (!playerIn.canPlayerEdit(pos.offset(side), side, stack))
		{
			return false;
		}
		else if (worldIn.getBlockState(pos).getBlock().canSustainPlant(worldIn, pos, EnumFacing.UP, this) && worldIn.isAirBlock(pos.up()))
		{
			worldIn.setBlockState(pos.up(), this.crops.getDefaultState());
			--stack.stackSize;
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos)
	{
		return EnumPlantType.Crop;
	}

	@Override
	public IBlockState getPlant(IBlockAccess world, BlockPos pos)
	{
		return this.crops.getDefaultState();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4)
	{
		list.add(StatCollector.translateToLocal(tag));
	}

}
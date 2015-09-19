package com.progwml6.natura.common.items.tools;

import java.util.List;

import com.progwml6.natura.common.util.NaturaCreativeTabs;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.BlockPos;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemNaturaKama extends ItemSword
{
	public ItemNaturaKama(ToolMaterial material)
	{
		super(material);
		this.setCreativeTab(NaturaCreativeTabs.tabMisc);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4)
	{
		list.add(StatCollector.translateToLocal("tooltip.kama"));
	}

	@Override
	public String getItemStackDisplayName(ItemStack stack)
	{
		return ("" + StatCollector.translateToLocal("natura." + this.getUnlocalizedNameInefficiently(stack) + ".name")).trim();
	}

	/**
	 * Called when a Block is destroyed using this Item. Return true to trigger the "Use Item" statistic.
	 */
	@Override
	public boolean onBlockDestroyed(ItemStack stack, World worldIn, Block blockIn, BlockPos pos, EntityLivingBase playerIn)
	{
		if (blockIn.getMaterial() != Material.leaves && blockIn != Blocks.web && blockIn != Blocks.tallgrass && blockIn != Blocks.vine && blockIn != Blocks.tripwire && blockIn != Blocks.wool && !(blockIn instanceof net.minecraftforge.common.IShearable))
		{
			return super.onBlockDestroyed(stack, worldIn, blockIn, pos, playerIn);
		}
		else
		{
			return true;
		}
	}

	/**
	 * Check whether this Item can harvest the given Block
	 */
	@Override
	public boolean canHarvestBlock(Block blockIn)
	{
		return blockIn == Blocks.web || blockIn == Blocks.redstone_wire || blockIn == Blocks.tripwire;
	}

	@Override
	public float getStrVsBlock(ItemStack stack, Block block)
	{
		return block != Blocks.web && block.getMaterial() != Material.leaves ? (block == Blocks.wool ? 5.0F : super.getStrVsBlock(stack, block)) : 15.0F;
	}

	/**
	 * Returns true if the item can be used on the given entity, e.g. shears on sheep.
	 */
	@Override
	public boolean itemInteractionForEntity(ItemStack itemstack, net.minecraft.entity.player.EntityPlayer player, EntityLivingBase entity)
	{
		if (entity.worldObj.isRemote)
		{
			return false;
		}
		if (entity instanceof net.minecraftforge.common.IShearable)
		{
			net.minecraftforge.common.IShearable target = (net.minecraftforge.common.IShearable) entity;
			BlockPos pos = new BlockPos(entity.posX, entity.posY, entity.posZ);
			if (target.isShearable(itemstack, entity.worldObj, pos))
			{
				java.util.List<ItemStack> drops = target.onSheared(itemstack, entity.worldObj, pos,
						net.minecraft.enchantment.EnchantmentHelper.getEnchantmentLevel(net.minecraft.enchantment.Enchantment.fortune.effectId, itemstack));

				java.util.Random rand = new java.util.Random();
				for (ItemStack stack : drops)
				{
					net.minecraft.entity.item.EntityItem ent = entity.entityDropItem(stack, 1.0F);
					ent.motionY += rand.nextFloat() * 0.05F;
					ent.motionX += (rand.nextFloat() - rand.nextFloat()) * 0.1F;
					ent.motionZ += (rand.nextFloat() - rand.nextFloat()) * 0.1F;
				}
				itemstack.damageItem(1, entity);
			}
			return true;
		}
		return false;
	}

	@Override
	public boolean onBlockStartBreak(ItemStack itemstack, BlockPos pos, net.minecraft.entity.player.EntityPlayer player)
	{
		if (player.worldObj.isRemote || player.capabilities.isCreativeMode)
		{
			return false;
		}
		Block block = player.worldObj.getBlockState(pos).getBlock();
		if (block instanceof net.minecraftforge.common.IShearable)
		{
			net.minecraftforge.common.IShearable target = (net.minecraftforge.common.IShearable) block;
			if (target.isShearable(itemstack, player.worldObj, pos))
			{
				java.util.List<ItemStack> drops = target.onSheared(itemstack, player.worldObj, pos,
						net.minecraft.enchantment.EnchantmentHelper.getEnchantmentLevel(net.minecraft.enchantment.Enchantment.fortune.effectId, itemstack));
				java.util.Random rand = new java.util.Random();

				for (ItemStack stack : drops)
				{
					float f = 0.7F;
					double d = rand.nextFloat() * f + (1.0F - f) * 0.5D;
					double d1 = rand.nextFloat() * f + (1.0F - f) * 0.5D;
					double d2 = rand.nextFloat() * f + (1.0F - f) * 0.5D;
					net.minecraft.entity.item.EntityItem entityitem = new net.minecraft.entity.item.EntityItem(player.worldObj, pos.getX() + d, pos.getY() + d1, pos.getZ() + d2, stack);
					entityitem.setDefaultPickupDelay();
					player.worldObj.spawnEntityInWorld(entityitem);
				}

				itemstack.damageItem(1, player);
				player.addStat(net.minecraft.stats.StatList.mineBlockStatArray[Block.getIdFromBlock(block)], 1);
			}
		}
		return false;
	}
}

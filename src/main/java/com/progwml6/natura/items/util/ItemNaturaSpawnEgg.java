package com.progwml6.natura.items.util;

import java.util.ArrayList;
import java.util.List;

import com.progwml6.natura.Natura;
import com.progwml6.natura.util.NaturaCreativeTabs;

import net.minecraft.block.BlockFence;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.MobSpawnerBaseLogic;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemNaturaSpawnEgg extends Item
{
    static ArrayList<EntityEggStuff> spawnList = new ArrayList<EntityEggStuff>();

    static class EntityEggStuff
    {
        String name;

        int color1;

        int color2;

        public EntityEggStuff(String name, int color1, int color2)
        {
            this.name = name;
            this.color1 = color1;
            this.color2 = color2;
        }
    }

    public static void addMapping(String name, int c1, int c2)
    {
        spawnList.add(new EntityEggStuff("natura." + name, c1, c2));
    }

    public ItemNaturaSpawnEgg()
    {
        setHasSubtypes(true);
        this.setCreativeTab(NaturaCreativeTabs.tabMisc);
    }

    @Override
    public String getItemStackDisplayName(ItemStack par1ItemStack)
    {
        String s = ("" + StatCollector.translateToLocal("item.monsterPlacer.name")).trim();
        String s1 = spawnList.get(par1ItemStack.getItemDamage()).name;
        if (s1 != null)
        {
            s = s + " " + StatCollector.translateToLocal(new StringBuilder().append("entity.").append(s1).append(".name").toString());
        }
        return s;
    }

    @SuppressWarnings("null")
    @Override
    @SideOnly(Side.CLIENT)
    public int getColorFromItemStack(ItemStack stack, int layer)
    {
        EntityEggStuff entityegginfo = spawnList.get(stack.getItemDamage());
        return entityegginfo != null ? entityegginfo.color2 : layer == 0 ? entityegginfo.color1 : 16777215;
    }

    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        if (worldIn.isRemote)
        {
            return true;
        }
        if (!playerIn.canPlayerEdit(pos.offset(side), side, stack))
        {
            return false;
        }
        IBlockState iblockstate = worldIn.getBlockState(pos);
        if (iblockstate.getBlock() == Blocks.mob_spawner)
        {
            TileEntity tileentity = worldIn.getTileEntity(pos);
            if ((tileentity instanceof TileEntityMobSpawner))
            {
                MobSpawnerBaseLogic mobspawnerbaselogic = ((TileEntityMobSpawner) tileentity).getSpawnerBaseLogic();
                mobspawnerbaselogic.setEntityName(EntityList.getStringFromID(stack.getMetadata()));
                tileentity.markDirty();
                worldIn.markBlockForUpdate(pos);
                if (!playerIn.capabilities.isCreativeMode)
                {
                    stack.stackSize -= 1;
                }
                return true;
            }
        }
        pos = pos.offset(side);
        double d0 = 0.0D;
        if ((side == EnumFacing.UP) && ((iblockstate instanceof BlockFence)))
        {
            d0 = 0.5D;
        }
        Entity entity = spawnCreature(worldIn, stack.getMetadata(), pos.getX() + 0.5D, pos.getY() + d0, pos.getZ() + 0.5D);
        if (entity != null)
        {
            if (((entity instanceof EntityLivingBase)) && (stack.hasDisplayName()))
            {
                entity.setCustomNameTag(stack.getDisplayName());
            }
            if (!playerIn.capabilities.isCreativeMode)
            {
                stack.stackSize -= 1;
            }
        }
        return true;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
    {
        if (worldIn.isRemote)
        {
            return itemStackIn;
        }
        MovingObjectPosition movingobjectposition = getMovingObjectPositionFromPlayer(worldIn, playerIn, true);
        if (movingobjectposition == null)
        {
            return itemStackIn;
        }
        if (movingobjectposition.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK)
        {
            BlockPos blockpos = movingobjectposition.getBlockPos();
            if (!worldIn.isBlockModifiable(playerIn, blockpos))
            {
                return itemStackIn;
            }
            if (!playerIn.canPlayerEdit(blockpos, movingobjectposition.sideHit, itemStackIn))
            {
                return itemStackIn;
            }
            if ((worldIn.getBlockState(blockpos).getBlock() instanceof BlockLiquid))
            {
                Entity entity = spawnCreature(worldIn, itemStackIn.getMetadata(), blockpos.getX() + 0.5D, blockpos.getY() + 0.5D, blockpos.getZ() + 0.5D);
                if (entity != null)
                {
                    if (((entity instanceof EntityLivingBase)) && (itemStackIn.hasDisplayName()))
                    {
                        ((EntityLiving) entity).setCustomNameTag(itemStackIn.getDisplayName());
                    }
                    if (!playerIn.capabilities.isCreativeMode)
                    {
                        itemStackIn.stackSize -= 1;
                    }
                    playerIn.triggerAchievement(net.minecraft.stats.StatList.objectUseStats[Item.getIdFromItem(this)]);
                }
            }
        }
        return itemStackIn;
    }

    public static Entity spawnCreature(World worldIn, int entityID, double x, double y, double z)
    {
        if (spawnList.get(entityID) == null)
        {
            return null;
        }
        Entity entity = null;
        for (int j = 0; j < 1; j++)
        {
            entity = EntityList.createEntityByName(spawnList.get(entityID).name, worldIn);
            if (entity != null)
            {
                entity.setLocationAndAngles(x, y, z, MathHelper.wrapAngleTo180_float(worldIn.rand.nextFloat() * 360.0F), 0.0F);
                if ((entity instanceof EntityLiving))
                {
                    EntityLiving entityliving = (EntityLiving) entity;
                    entityliving.rotationYawHead = entityliving.rotationYaw;
                    entityliving.renderYawOffset = entityliving.rotationYaw;
                    entityliving.onInitialSpawn(worldIn.getDifficultyForLocation(new BlockPos(entityliving)), (IEntityLivingData) null);
                    entityliving.playLivingSound();
                }
                worldIn.spawnEntityInWorld(entity);
            }
        }
        return entity;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(Item item, CreativeTabs creativeTabs, List list)
    {
        for (int a = 0; a < spawnList.size(); a++)
        {
            list.add(new ItemStack(item, 1, a));
        }
    }
}

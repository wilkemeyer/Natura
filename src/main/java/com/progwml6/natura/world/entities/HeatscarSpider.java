package com.progwml6.natura.world.entities;

import net.minecraft.block.Block;
import net.minecraft.block.Block.SoundType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.progwml6.natura.Natura;
import com.progwml6.natura.items.ItemsNatura;
import com.progwml6.natura.move.PHNatura;

public class HeatscarSpider extends EntitySpider
{
    public HeatscarSpider(World par1World)
    {
        super(par1World);
        this.setSize(2.7F, 1.9F);
        this.isImmuneToFire = true;
        this.experienceValue = 25;
    }

    @SideOnly(Side.CLIENT)
    public float spiderScaleAmount()
    {
        return 2.0F;
    }

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(50.0D); //Health
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(24D); //Detection range
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.35); //Movespeed
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(4.0); //Base damage
    }

    @Override
    public void jump()
    {
        this.motionY = 0.62D;

        if (this.isPotionActive(Potion.jump))
        {
            this.motionY += (this.getActivePotionEffect(Potion.jump).getAmplifier() + 1) * 0.1F;
        }

        if (this.isSprinting())
        {
            float f = this.rotationYaw * 0.017453292F;
            this.motionX -= MathHelper.sin(f) * 0.2F;
            this.motionZ += MathHelper.cos(f) * 0.2F;
        }

        this.isAirBorne = true;
        ForgeHooks.onLivingJump(this);
    }

    @Override
    public void fall(float distance, float damageMultiplier)
    {
        float[] ret = ForgeHooks.onLivingFall(this, distance, damageMultiplier);
        if (ret == null)
        {
            return;
        }

        super.fall(distance, damageMultiplier);
        int i = MathHelper.ceiling_float_int(distance - 5.0F);

        if (i > 0)
        {
            if (i > 4)
            {
                this.playSound("damage.fallbig", 1.0F, 1.0F);
            }
            else
            {
                this.playSound("damage.fallsmall", 1.0F, 1.0F);
            }

            this.attackEntityFrom(DamageSource.fall, i);
            Block j = this.worldObj.getBlockState(new BlockPos(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY - 0.20000000298023224D), MathHelper.floor_double(this.posZ)))
                    .getBlock();

            if (j != null)
            {
                SoundType stepsound = j.stepSound;
                this.playSound(stepsound.soundName, stepsound.getVolume() * 0.5F, stepsound.getFrequency() * 0.75F);
            }
        }
    }

    @Override
    public boolean attackEntityAsMob(Entity par1Entity)
    {
        if (super.attackEntityAsMob(par1Entity))
        {
            if (par1Entity instanceof EntityLiving)
            {
                byte b0 = 0;

                if (this.worldObj.getDifficulty() != EnumDifficulty.PEACEFUL)
                {
                    if (this.worldObj.getDifficulty() == EnumDifficulty.NORMAL)
                    {
                        b0 = 5;
                    }
                    else if (this.worldObj.getDifficulty() == EnumDifficulty.HARD)
                    {
                        b0 = 10;
                    }
                }

                if (b0 > 0)
                {
                    par1Entity.setFire(b0);
                }
            }

            return true;
        }
        else
        {
            return false;
        }
    }

    public int getAttackStrength(Entity par1Entity)
    {
        return 4;
    }

    @Override
    protected Item getDropItem()
    {
        return ItemsNatura.materials;
    }

    @Override
    public EntityItem dropItemWithOffset(Item par1, int par2, float par3)
    {
        return this.entityDropItem(new ItemStack(par1, par2, 7), par3);
    }

    @Override
    protected void dropFewItems(boolean par1, int par2)
    {
        Item j = this.getDropItem();

        if (j != null)
        {
            int k = this.rand.nextInt(3) + 2;

            if (par2 > 0)
            {
                k += this.rand.nextInt(par2 + 1);
            }

            for (int l = 0; l < k; ++l)
            {
                this.dropItem(j, 1);
            }
        }
    }

    @Override
    public boolean getCanSpawnHere()
    {
        return this.worldObj.getDifficulty() != EnumDifficulty.PEACEFUL && this.worldObj.checkNoEntityCollision(this.getBoundingBox())
                && this.worldObj.getCollidingBoundingBoxes(this, this.getBoundingBox()).isEmpty() && !this.worldObj.isAnyLiquid(this.getBoundingBox());
    }

    protected BabyHeatscarSpider createBabyInstance()
    {
        return new BabyHeatscarSpider(this.worldObj);
    }

    @Override
    public void setDead()
    {

        if (!this.worldObj.isRemote)
        {
            int num = PHNatura.babyHeatscarMaximum - PHNatura.babyHeatscarMinimum + 1;
            int amount = rand.nextInt(num) + PHNatura.babyHeatscarMinimum;
            for (int i = 0; i < amount; i++)
            {
                double f = rand.nextDouble() * 2;
                double f1 = rand.nextDouble() * 2;
                BabyHeatscarSpider babyspider = this.createBabyInstance();
                babyspider.setLocationAndAngles(this.posX + f, this.posY + 0.5D, this.posZ + f1, this.rand.nextFloat() * 360.0F, 0.0F);
                this.worldObj.spawnEntityInWorld(babyspider);
            }
        }

        super.setDead();
    }
}

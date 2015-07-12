package com.progwml6.natura;

import com.progwml6.natura.items.ItemsNatura;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.player.BonemealEvent;
import net.minecraftforge.event.entity.player.EntityInteractEvent;
import net.minecraftforge.event.world.ChunkDataEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class CommonEvents
{
    @SubscribeEvent
    public void bonemealEvent(BonemealEvent event)
    {
        /**if (!event.world.isRemote && !event.isCanceled() && event.getResult() != Result.ALLOW)
         {
         if (event.block == NContent.glowshroom)
         {
         if (NContent.glowshroom.fertilizeMushroom(event.world, event.pos, event.world.rand))
         event.setResult(Result.ALLOW);
         }
         if (event.block == NContent.berryBush)
         {
         if (NContent.berryBush.boneFertilize(event.world, event.pos, event.world.rand))
         event.setResult(Result.ALLOW);
         }
         if (event.block == NContent.netherBerryBush)
         {
         if (NContent.netherBerryBush.boneFertilize(event.world, event.pos, event.world.rand))
         event.setResult(Result.ALLOW);
         }
         }*/
    }

    @SubscribeEvent
    public void interactEvent(EntityInteractEvent event)
    {
        if (event.target instanceof EntityCow || event.target instanceof EntitySheep)
        {
            ItemStack equipped = event.entityPlayer.getCurrentEquippedItem();
            EntityAnimal creature = (EntityAnimal) event.target;
            if (equipped != null && equipped.getItem() == ItemsNatura.barley_seeds && equipped.getItemDamage() == 0 && creature.getGrowingAge() == 0 && !creature.isInLove())
            {
                EntityPlayer player = event.entityPlayer;
                if (!player.capabilities.isCreativeMode)
                {
                    --equipped.stackSize;

                    if (equipped.stackSize <= 0)
                    {
                        player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
                    }
                }

                creature.setInLove(event.entityPlayer);
            }
        }
    }

    @SubscribeEvent
    public void spawnEvent(EntityJoinWorldEvent event)
    {
        //if (event.entity instanceof EntityCow || event.entity instanceof EntitySheep)
        //{
        //    ((EntityLiving) event.entity).tasks.addTask(3, new EntityAITempt((EntityCreature) event.entity, 0.25F, Natura.getItems().plantItem, false));
        //}

        if (event.entity instanceof EntityChicken)
        {
            ((EntityLiving) event.entity).tasks.addTask(3, new EntityAITempt((EntityCreature) event.entity, 0.25F, ItemsNatura.cotton_seeds, false));
            ((EntityLiving) event.entity).tasks.addTask(3, new EntityAITempt((EntityCreature) event.entity, 0.25F, ItemsNatura.barley_seeds, false));
        }
    }

    @SubscribeEvent
    public void chunkDataSave(ChunkDataEvent.Save event)
    {
        event.getData().setBoolean("Natura.Retrogen", true);
    }
}

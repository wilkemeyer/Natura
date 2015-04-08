package com.progwml6.natura;

import java.util.Random;

import mantle.pulsar.control.PulseManager;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.player.BonemealEvent;
import net.minecraftforge.event.entity.player.EntityInteractEvent;
import net.minecraftforge.event.world.ChunkDataEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.progwml6.natura.blocks.BlocksNatura;
import com.progwml6.natura.items.ItemsNatura;
import com.progwml6.natura.worldgen.CloudWorldgen;
import com.progwml6.natura.worldgen.CropWorldGen;

@Mod(modid = "natura", name = "Natura", version = "3.0.0", acceptedMinecraftVersions = "[1.8]", dependencies = "required-after:mantle@[0.3.1,)")
public class Natura
{
	/* Proxies for sides, used for graphics processing */
	@SidedProxy(clientSide = "com.progwml6.natura.client.ClientProxy", serverSide = "com.progwml6.natura.CommonProxy")
	public static CommonProxy proxy;

	public static final String modID = "natura";

	/* Instance of this mod, used for grabbing prototype fields */
	@Instance(modID)
	public static Natura instance;

	public static Logger logger = LogManager.getLogger(modID);

	public static final PulseManager pulsar = new PulseManager(modID);

	public static Random random = new Random();

	public static boolean retrogen;

	private BlocksNatura blocks = new BlocksNatura();

	private ItemsNatura items = new ItemsNatura();

	public static CloudWorldgen clouds;

	public static CropWorldGen crops;

	@EventHandler
	public void preInit(FMLPreInitializationEvent evt)
	{
		MinecraftForge.EVENT_BUS.register(this);
		PHNatura.initProps(evt.getSuggestedConfigurationFile());

		pulsar.preInit(evt);
		this.blocks.preInit();
		this.items.preInit();
	}

	@EventHandler
	public void init(FMLInitializationEvent evt)
	{
		proxy.init();

		random.setSeed(2 ^ 16 + 2 ^ 8 + (4 * 3 * 271));

		this.blocks.init();
		this.items.init();

		GameRegistry.registerWorldGenerator(clouds = new CloudWorldgen(), 20); // TODO 1.8 Find correct weight (param 2)
		GameRegistry.registerWorldGenerator(crops = new CropWorldGen(), 20); // TODO 1.8 Find correct weight (param 2)
	}

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
		//if (event.target == null)
		if (event.target instanceof EntityCow || event.target instanceof EntitySheep)
		{
			ItemStack equipped = event.entityPlayer.getCurrentEquippedItem();
			EntityAnimal creature = (EntityAnimal) event.target;
			if (equipped != null && equipped.getItem() == this.getItems().barley_seeds && equipped.getItemDamage() == 0 && creature.getGrowingAge() == 0 && !creature.isInLove())
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
		/**if (event.entity instanceof EntityCow || event.entity instanceof EntitySheep)
		{
			((EntityLiving) event.entity).tasks.addTask(3, new EntityAITempt((EntityCreature) event.entity, 0.25F, NContent.plantItem, false));
		}

		if (event.entity instanceof EntityChicken)
		{
			((EntityLiving) event.entity).tasks.addTask(3, new EntityAITempt((EntityCreature) event.entity, 0.25F, NContent.seeds, false));
		}*/
	}

	@SubscribeEvent
	public void chunkDataSave(ChunkDataEvent.Save event)
	{
		event.getData().setBoolean("Natura.Retrogen", true);
	}

	public static BlocksNatura getBlocks()
	{
		return Natura.instance.blocks;
	}

	public static ItemsNatura getItems()
	{
		return Natura.instance.items;
	}
}

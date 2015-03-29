package mods.natura;

import java.util.Random;

import mantle.pulsar.control.PulseManager;
import mods.natura.blocks.BlocksNatura;
import mods.natura.worldgen.CloudWorldgen;
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
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = "Natura", name = "Natura", version = "2.2.0", acceptedMinecraftVersions = "[1.8]", dependencies = "required-after:Mantle@[0.3.1,)")
public class Natura
{
	/* Proxies for sides, used for graphics processing */
	@SidedProxy(clientSide = "mods.natura.client.ClientProxy", serverSide = "mods.natura.CommonProxy")
	public static CommonProxy proxy;

	public static final String modID = "Natura";

	/* Instance of this mod, used for grabbing prototype fields */
	@Instance(modID)
	public static Natura instance;

	public static Logger logger = LogManager.getLogger(modID);

	public static final PulseManager pulsar = new PulseManager(modID, "Natura-Dynamic");

	public static Random random = new Random();

	public static boolean retrogen;

	private BlocksNatura blocks = new BlocksNatura();

	public static CloudWorldgen clouds;

	@EventHandler
	public void preInit(FMLPreInitializationEvent evt)
	{
		MinecraftForge.EVENT_BUS.register(this);
		PHNatura.initProps(evt.getSuggestedConfigurationFile());

		pulsar.preInit(evt);
		this.blocks.preInit();
	}

	@EventHandler
	public void init(FMLInitializationEvent evt)
	{
		proxy.init();

		random.setSeed(2 ^ 16 + 2 ^ 8 + (4 * 3 * 271));

		pulsar.init(evt);

		this.blocks.init();

		GameRegistry.registerWorldGenerator(clouds = new CloudWorldgen(), 20); // TODO 1.8 Find correct weight (param 2)
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent evt)
	{
		pulsar.postInit(evt);
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
		/**if (event.target instanceof EntityCow || event.target instanceof EntitySheep)
		{
			ItemStack equipped = event.entityPlayer.getCurrentEquippedItem();
			EntityAnimal creature = (EntityAnimal) event.target;
			if (equipped != null && equipped.getItem() == NContent.plantItem && equipped.getItemDamage() == 0 && creature.getGrowingAge() == 0 && !creature.isInLove())
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
		}*/
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
}

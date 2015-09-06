package com.progwml6.natura.common;

import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.progwml6.natura.common.move.PHNatura;
import com.progwml6.natura.common.world.CloudWorldgen;
import com.progwml6.natura.common.world.CropWorldGen;

//import mantle.pulsar.control.PulseManager;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = "natura", name = "Natura", version = "3.0.0", acceptedMinecraftVersions = "[1.8]") //, dependencies = "required-after:mantle@[0.3.1,)")
public class Natura
{
	@Instance(Natura.MOD_ID)
	public static Natura INSTANCE;

	public static final String MOD_ID = "natura";

	//public static final PulseManager pulsar = new PulseManager(MOD_ID);

	/* Proxies for sides, used for graphics processing */
	@SidedProxy(clientSide = "com.progwml6.natura.client.ClientProxy", serverSide = "com.progwml6.natura.CommonProxy")
	public static CommonProxy PROXY;

	public static Logger logger = LogManager.getLogger(MOD_ID);

	public static boolean retrogen;

	public static Random random = new Random();

	@EventHandler
	public void preInit(FMLPreInitializationEvent evt)
	{
		PHNatura.initProps(evt.getSuggestedConfigurationFile());
		//pulsar.preInit(evt);

		PROXY.preInit(evt);
	}

	@EventHandler
	public void init(FMLInitializationEvent evt)
	{
		PROXY.init(evt);

		GameRegistry.registerWorldGenerator(new CloudWorldgen(), 20); // TODO 1.8 Find correct weight (param 2)
		GameRegistry.registerWorldGenerator(new CropWorldGen(), 20); // TODO 1.8 Find correct weight (param 2)

		random.setSeed(2 ^ 16 + 2 ^ 8 + (4 * 3 * 271));
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent evt)
	{
		PROXY.postInit();
	}
}

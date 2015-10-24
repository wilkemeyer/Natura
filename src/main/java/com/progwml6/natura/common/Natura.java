package com.progwml6.natura.common;

import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.progwml6.natura.common.move.PHNatura;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import slimeknights.mantle.pulsar.control.PulseManager;

@Mod(name = "Natura", modid = Natura.MOD_ID, version = "3.0.0", dependencies = "required-after:mantle@[0.3.1,)")
public class Natura
{
	public static final String MOD_ID = "natura";

	@Instance(Natura.MOD_ID)
	public static Natura INSTANCE;

	public static final PulseManager pulsar = new PulseManager(MOD_ID);

	@SidedProxy(clientSide = "com.progwml6.natura.client.ClientProxy", serverSide = "com.progwml6.natura.CommonProxy")
	public static CommonProxy PROXY;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		PHNatura.initProps(event.getSuggestedConfigurationFile());
		pulsar.preInit(event);

		PROXY.preInit(event);
	}

	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		PROXY.init(event);

		//GameRegistry.registerWorldGenerator(new CloudWorldgen(), 20); // TODO 1.8 Find correct weight (param 2)
		//GameRegistry.registerWorldGenerator(new CropWorldGen(), 20); // TODO 1.8 Find correct weight (param 2)

		random.setSeed(2 ^ 16 + 2 ^ 8 + (4 * 3 * 271));
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		PROXY.postInit(event);
	}

	public static ResourceLocation getResource(String name)
	{
		return new ResourceLocation(Natura.MOD_ID, name);
	}

	public static String getResourcePath(String resource)
	{
		return (Natura.MOD_ID + ":") + resource;
	}

	public static Random random = new Random();

	public static Logger logger = LogManager.getLogger(MOD_ID);
}

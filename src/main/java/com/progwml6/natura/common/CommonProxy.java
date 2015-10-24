package com.progwml6.natura.common;

import com.progwml6.natura.common.blocks.BlocksNatura;
import com.progwml6.natura.common.entities.EntitiesNatura;
import com.progwml6.natura.common.items.ItemsNatura;
import com.progwml6.natura.common.network.NaturaGuiHandler;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class CommonProxy
{
	public void preInit(FMLPreInitializationEvent event)
	{
		NetworkRegistry.INSTANCE.registerGuiHandler(Natura.INSTANCE, new NaturaGuiHandler());

		BlocksNatura.preInit();
		ItemsNatura.preInit();
		EntitiesNatura.preInit();
	}

	public void init(FMLInitializationEvent event)
	{
		MinecraftForge.EVENT_BUS.register(new CommonEvents());
	}

	public void postInit(FMLPostInitializationEvent event)
	{
		EntitiesNatura.postInit();
	}

}

package com.progwml6.natura.client;

import com.progwml6.natura.client.models.ModelNatura;
import com.progwml6.natura.client.renderer.NCropsTickHandler;
import com.progwml6.natura.common.CommonProxy;
import com.progwml6.natura.common.util.NaturaCreativeTabs;

import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy
{

	@Override
	public void preInit(FMLPreInitializationEvent event)
	{
		super.preInit(event);

		ModelNatura.preInit();
		NaturaCreativeTabs.registerTabIcons();
	}

	@Override
	public void init(FMLInitializationEvent event)
	{
		super.init(event);

		ModelNatura.init();
		FMLCommonHandler.instance().bus().register(new NCropsTickHandler());
	}
}

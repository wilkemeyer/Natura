package com.progwml6.natura.client;

import com.progwml6.natura.client.models.blocks.NaturaBlockModels;
import com.progwml6.natura.client.models.items.NaturaItemModels;
import com.progwml6.natura.client.renderer.NCropsTickHandler;
import com.progwml6.natura.client.renderer.NaturaRenderers;
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

		NaturaBlockModels.preInit();
		NaturaItemModels.preInit();

		NaturaCreativeTabs.registerTabIcons();
	}

	@Override
	public void init(FMLInitializationEvent event)
	{
		super.init(event);

		NaturaItemModels.init();
		NaturaRenderers.init();

		FMLCommonHandler.instance().bus().register(new NCropsTickHandler());
	}
}

package com.progwml6.natura.common.util;

import com.progwml6.natura.common.Natura;

import net.minecraft.util.ResourceLocation;

public class NaturaUtils
{
	public static ResourceLocation getResource(String name)
	{
		return new ResourceLocation(Natura.MOD_ID, name);
	}

	public static String getResourcePath(String resource)
	{
		return (Natura.MOD_ID + ":") + resource;
	}
}

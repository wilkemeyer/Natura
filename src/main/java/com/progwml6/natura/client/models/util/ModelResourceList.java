package com.progwml6.natura.client.models.util;

import java.util.HashMap;

import com.progwml6.natura.common.Natura;

public class ModelResourceList
{
	private HashMap<Integer, String> registrations = new HashMap<Integer, String>();

	private final String prefixRoot;

	public ModelResourceList()
	{
		this(null);
	}

	public ModelResourceList(String rootPath)
	{
		this.prefixRoot = rootPath;
	}

	public ModelResourceList add(int meta, String path)
	{
		this.registrations.put(meta, getResourcePath((this.prefixRoot != null ? this.prefixRoot : "") + path));

		return this;
	}

	public static String getResourcePath(String resource)
	{
		return (Natura.MOD_ID + ":") + resource;
	}

	public HashMap<Integer, String> getRegistrations()
	{
		return this.registrations;
	}
}

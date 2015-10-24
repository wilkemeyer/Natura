package com.progwml6.natura.client.util;

import java.util.HashMap;

import com.progwml6.natura.common.Natura;

public class ItemModelList
{
	private final HashMap<Integer, String> registrations = new HashMap<Integer, String>();

	private final String rootDirectory;

	public ItemModelList()
	{
		this.rootDirectory = null;
	}

	public ItemModelList(String resourceRoot)
	{
		if (resourceRoot.charAt(resourceRoot.length() - 1) != '/')
		{
			throw new RuntimeException("Resource root path must be relative! (end with '/')");
		}

		this.rootDirectory = Natura.getResourcePath(resourceRoot);
	}

	public ItemModelList add(int meta, String path)
	{
		this.registrations.put(meta, this.rootDirectory != null ? this.rootDirectory + path : Natura.getResourcePath(path));

		return this;
	}

	public HashMap<Integer, String> getRegistrations()
	{
		return this.registrations;
	}
}

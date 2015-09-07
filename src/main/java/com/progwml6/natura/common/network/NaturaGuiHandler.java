package com.progwml6.natura.common.network;

import com.progwml6.natura.common.containers.ContainerNaturaWorkbench;

import net.minecraft.client.gui.inventory.GuiCrafting;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class NaturaGuiHandler implements IGuiHandler
{
	public static final int WORKBENCH_ID = 1;

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		switch (ID)
		{
		case WORKBENCH_ID:
			return new ContainerNaturaWorkbench(player.inventory, world, new BlockPos(x, y, z));
		default:
			return null;
		}
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		switch (ID)
		{
		case WORKBENCH_ID:
			return new GuiCrafting(player.inventory, world, new BlockPos(x, y, z));
		default:
			return null;
		}
	}

}

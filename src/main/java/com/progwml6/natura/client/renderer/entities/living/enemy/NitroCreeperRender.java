package com.progwml6.natura.client.renderer.entities.living.enemy;

import com.progwml6.natura.common.Natura;

import net.minecraft.client.renderer.entity.RenderCreeper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class NitroCreeperRender extends RenderCreeper
{
	private static final ResourceLocation texture = Natura.getResource("textures/entities/living/creeper/creeperunstable.png");

	public NitroCreeperRender(RenderManager renderManagerIn)
	{
		super(renderManagerIn);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return texture;
	}

}

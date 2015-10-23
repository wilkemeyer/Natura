package com.progwml6.natura.client.renderer.entities.living;

import com.progwml6.natura.common.util.NaturaUtils;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class ImpRender extends RenderLiving
{
	private static final ResourceLocation texture = NaturaUtils.getResource("textures/entities/living/imp/imp.png");

	public ImpRender(RenderManager renderManager, ModelBase modelBase, float shadowSize)
	{
		super(renderManager, modelBase, shadowSize);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return texture;
	}
}

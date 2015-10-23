package com.progwml6.natura.client.renderer.entities.living.enemy;

import org.lwjgl.opengl.GL11;

import com.progwml6.natura.common.util.NaturaUtils;
import com.progwml6.natura.common.world.entites.HeatscarSpider;

import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSpider;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

public class FlameSpiderRender extends RenderSpider
{
	private static final ResourceLocation texture = NaturaUtils.getResource("textures/entities/living/flamespider/flamespider.png");

	public FlameSpiderRender(RenderManager renderManagerIn)
	{
		super(renderManagerIn);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return texture;
	}

	protected void scaleSpider(HeatscarSpider entity, float par2)
	{
		GL11.glScalef(2.0F, 2.0F, 2.0F);
	}

	@Override
	protected void preRenderCallback(EntityLivingBase entity, float par2)
	{
		this.scaleSpider((HeatscarSpider) entity, par2);
	}

}

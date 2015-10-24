package com.progwml6.natura.client.renderer.entities.living.enemy;

import org.lwjgl.opengl.GL11;

import com.progwml6.natura.common.Natura;
import com.progwml6.natura.common.entities.living.enemy.BabyHeatscarSpider;

import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSpider;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

public class FlameSpiderBabyRender extends RenderSpider
{
	private static final ResourceLocation texture = Natura.getResource("textures/entities/living/flamespider/flamespider.png");

	public FlameSpiderBabyRender(RenderManager renderManagerIn)
	{
		super(renderManagerIn);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return texture;
	}

	protected void scaleSpider(BabyHeatscarSpider entity, float par2)
	{
		GL11.glScalef(0.85f, 0.85f, 0.85f);
	}

	@Override
	protected void preRenderCallback(EntityLivingBase entity, float par2)
	{
		this.scaleSpider((BabyHeatscarSpider) entity, par2);
	}

}

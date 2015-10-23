package com.progwml6.natura.client.renderer.entities.projectiles;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import com.progwml6.natura.common.world.entites.FusewoodArrow;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class FusewoodArrowRender extends Render
{
	private static final ResourceLocation field_110780_a = new ResourceLocation("textures/entity/arrow.png");

	public FusewoodArrowRender(RenderManager renderManagerIn)
	{
		super(renderManagerIn);
	}

	public void renderArrow(FusewoodArrow par1EntityArrow, double par2, double par4, double par6, float par8, float par9)
	{
		this.bindEntityTexture(par1EntityArrow);
		GL11.glPushMatrix();
		GL11.glTranslatef((float) par2, (float) par4, (float) par6);
		GL11.glRotatef(par1EntityArrow.prevRotationYaw + (par1EntityArrow.rotationYaw - par1EntityArrow.prevRotationYaw) * par9 - 90.0F, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(par1EntityArrow.prevRotationPitch + (par1EntityArrow.rotationPitch - par1EntityArrow.prevRotationPitch) * par9, 0.0F, 0.0F, 1.0F);
		Tessellator tessellator = Tessellator.getInstance();
		WorldRenderer worldrenderer = tessellator.getWorldRenderer();
		byte b0 = 0;
		float f2 = 0.0F;
		float f3 = 0.5F;
		float f4 = (0 + b0 * 10) / 32.0F;
		float f5 = (5 + b0 * 10) / 32.0F;
		float f6 = 0.0F;
		float f7 = 0.15625F;
		float f8 = (5 + b0 * 10) / 32.0F;
		float f9 = (10 + b0 * 10) / 32.0F;
		float f10 = 0.05625F;
		GL11.glEnable(GL12.GL_RESCALE_NORMAL);
		float f11 = par1EntityArrow.arrowShake - par9;

		if (f11 > 0.0F)
		{
			float f12 = -MathHelper.sin(f11 * 3.0F) * f11;
			GL11.glRotatef(f12, 0.0F, 0.0F, 1.0F);
		}

		GL11.glRotatef(45.0F, 1.0F, 0.0F, 0.0F);
		GL11.glScalef(f10, f10, f10);
		GL11.glTranslatef(-4.0F, 0.0F, 0.0F);
		GL11.glNormal3f(f10, 0.0F, 0.0F);
		worldrenderer.startDrawingQuads();
		worldrenderer.addVertexWithUV(-7.0D, -2.0D, -2.0D, f6, f8);
		worldrenderer.addVertexWithUV(-7.0D, -2.0D, 2.0D, f7, f8);
		worldrenderer.addVertexWithUV(-7.0D, 2.0D, 2.0D, f7, f9);
		worldrenderer.addVertexWithUV(-7.0D, 2.0D, -2.0D, f6, f9);
		tessellator.draw();
		GL11.glNormal3f(-f10, 0.0F, 0.0F);
		worldrenderer.startDrawingQuads();
		worldrenderer.addVertexWithUV(-7.0D, 2.0D, -2.0D, f6, f8);
		worldrenderer.addVertexWithUV(-7.0D, 2.0D, 2.0D, f7, f8);
		worldrenderer.addVertexWithUV(-7.0D, -2.0D, 2.0D, f7, f9);
		worldrenderer.addVertexWithUV(-7.0D, -2.0D, -2.0D, f6, f9);
		tessellator.draw();

		for (int i = 0; i < 4; ++i)
		{
			GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
			GL11.glNormal3f(0.0F, 0.0F, f10);
			worldrenderer.startDrawingQuads();
			worldrenderer.addVertexWithUV(-8.0D, -2.0D, 0.0D, f2, f4);
			worldrenderer.addVertexWithUV(8.0D, -2.0D, 0.0D, f3, f4);
			worldrenderer.addVertexWithUV(8.0D, 2.0D, 0.0D, f3, f5);
			worldrenderer.addVertexWithUV(-8.0D, 2.0D, 0.0D, f2, f5);
			tessellator.draw();
		}

		GL11.glDisable(GL12.GL_RESCALE_NORMAL);
		GL11.glPopMatrix();
	}

	protected ResourceLocation getEntityTexture(FusewoodArrow par1EntityArrow)
	{
		return field_110780_a;
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity par1Entity)
	{
		return this.getEntityTexture((FusewoodArrow) par1Entity);
	}

	/**
	 * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
	 * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
	 * (Render<T extends Entity) and this method has signature public void doRender(T entity, double d, double d1,
	 * double d2, float f, float f1). But JAD is pre 1.5 so doesn't do that.
	 */
	@Override
	public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
	{
		this.renderArrow((FusewoodArrow) par1Entity, par2, par4, par6, par8, par9);
	}
}

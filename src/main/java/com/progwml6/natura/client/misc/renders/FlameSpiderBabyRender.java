package com.progwml6.natura.client.misc.renders;

//import com.progwml6.natura.entity.BabyHeatscarSpider;

import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSpider;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class FlameSpiderBabyRender extends RenderSpider
{

    /**protected void scaleSpider (BabyHeatscarSpider par1EntityCaveSpider, float par2)
     {
     GL11.glScalef(0.85f, 0.85f, 0.85f);
     }

     @Override protected void preRenderCallback (EntityLivingBase par1EntityLivingBase, float par2)
     {
     this.scaleSpider((BabyHeatscarSpider) par1EntityLivingBase, par2);
     }*/

    static final ResourceLocation texture = new ResourceLocation("natura", "textures/mob/flamespider.png");

    public FlameSpiderBabyRender(RenderManager renderManagerIn)
    {
        super(renderManagerIn);
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity par1Entity)
    {
        return texture;
    }

}

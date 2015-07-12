package com.progwml6.natura.client.renderer.entity;

import net.minecraft.client.renderer.entity.RenderCreeper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class NitroCreeperRender extends RenderCreeper
{

    static final ResourceLocation texture = new ResourceLocation("natura", "textures/mob/creeperunstable.png");

    public NitroCreeperRender(RenderManager renderManagerIn)
    {
        super(renderManagerIn);
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity par1Entity)
    {
        return texture;
    }

}

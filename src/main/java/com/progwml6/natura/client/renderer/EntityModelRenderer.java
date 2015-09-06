package com.progwml6.natura.client.renderer;

import com.progwml6.natura.client.models.ImpModel;
import com.progwml6.natura.client.renderer.entity.FlameSpiderBabyRender;
import com.progwml6.natura.client.renderer.entity.FlameSpiderRender;
import com.progwml6.natura.client.renderer.entity.FusewoodArrowRender;
import com.progwml6.natura.client.renderer.entity.ImpRender;
import com.progwml6.natura.client.renderer.entity.NitroCreeperRender;
import com.progwml6.natura.common.world.entites.BabyHeatscarSpider;
import com.progwml6.natura.common.world.entites.FusewoodArrow;
import com.progwml6.natura.common.world.entites.HeatscarSpider;
import com.progwml6.natura.common.world.entites.ImpEntity;
import com.progwml6.natura.common.world.entites.NitroCreeper;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class EntityModelRenderer
{
	public static void init()
	{
		RenderingRegistry.registerEntityRenderingHandler(ImpEntity.class, new ImpRender(Minecraft.getMinecraft().getRenderManager(), new ImpModel(), 0f));
		RenderingRegistry.registerEntityRenderingHandler(HeatscarSpider.class, new FlameSpiderRender(Minecraft.getMinecraft().getRenderManager()));
		RenderingRegistry.registerEntityRenderingHandler(NitroCreeper.class, new NitroCreeperRender(Minecraft.getMinecraft().getRenderManager()));
		RenderingRegistry.registerEntityRenderingHandler(FusewoodArrow.class, new FusewoodArrowRender(Minecraft.getMinecraft().getRenderManager()));
		RenderingRegistry.registerEntityRenderingHandler(BabyHeatscarSpider.class, new FlameSpiderBabyRender(Minecraft.getMinecraft().getRenderManager()));

		try
		{
			GrassColorizerAlternate.setBlueGrassBiomeColorizer(TextureUtil.readImageData(Minecraft.getMinecraft().getResourceManager(), new ResourceLocation("natura", "textures/misc/bluegrasscolor.png")));
			GrassColorizerAlternate.setOrangeGrassBiomeColorizer(TextureUtil.readImageData(Minecraft.getMinecraft().getResourceManager(), new ResourceLocation("natura", "textures/misc/orangegrasscolor.png")));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}

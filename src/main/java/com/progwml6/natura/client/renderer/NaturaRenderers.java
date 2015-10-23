package com.progwml6.natura.client.renderer;

import com.progwml6.natura.client.models.entities.living.ImpModel;
import com.progwml6.natura.client.renderer.blocks.GrassColorizerAlternate;
import com.progwml6.natura.client.renderer.entities.living.ImpRender;
import com.progwml6.natura.client.renderer.entities.living.enemy.FlameSpiderBabyRender;
import com.progwml6.natura.client.renderer.entities.living.enemy.FlameSpiderRender;
import com.progwml6.natura.client.renderer.entities.living.enemy.NitroCreeperRender;
import com.progwml6.natura.client.renderer.entities.projectiles.FusewoodArrowRender;
import com.progwml6.natura.common.world.entites.BabyHeatscarSpider;
import com.progwml6.natura.common.world.entites.FusewoodArrow;
import com.progwml6.natura.common.world.entites.HeatscarSpider;
import com.progwml6.natura.common.world.entites.ImpEntity;
import com.progwml6.natura.common.world.entites.NitroCreeper;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class NaturaRenderers
{
	public static void init()
	{
		registerEntityRenderers();
		registerGrass();
	}

	private static void registerEntityRenderers()
	{
		RenderManager renderManager = Minecraft.getMinecraft().getRenderManager();

		RenderingRegistry.registerEntityRenderingHandler(FusewoodArrow.class, new FusewoodArrowRender(renderManager));

		RenderingRegistry.registerEntityRenderingHandler(ImpEntity.class, new ImpRender(renderManager, new ImpModel(), 0.7f));
		RenderingRegistry.registerEntityRenderingHandler(HeatscarSpider.class, new FlameSpiderRender(renderManager));
		RenderingRegistry.registerEntityRenderingHandler(NitroCreeper.class, new NitroCreeperRender(renderManager));
		RenderingRegistry.registerEntityRenderingHandler(BabyHeatscarSpider.class, new FlameSpiderBabyRender(renderManager));
	}

	private static void registerGrass()
	{
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

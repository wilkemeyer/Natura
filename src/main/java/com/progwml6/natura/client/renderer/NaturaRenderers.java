package com.progwml6.natura.client.renderer;

import com.progwml6.natura.client.models.entities.living.ImpModel;
import com.progwml6.natura.client.renderer.blocks.GrassColorizerAlternate;
import com.progwml6.natura.client.renderer.entities.living.ImpRender;
import com.progwml6.natura.client.renderer.entities.living.enemy.FlameSpiderBabyRender;
import com.progwml6.natura.client.renderer.entities.living.enemy.FlameSpiderRender;
import com.progwml6.natura.client.renderer.entities.living.enemy.NitroCreeperRender;
import com.progwml6.natura.client.renderer.entities.projectiles.FusewoodArrowRender;
import com.progwml6.natura.common.Natura;
import com.progwml6.natura.common.entities.living.ImpEntity;
import com.progwml6.natura.common.entities.living.enemy.BabyHeatscarSpider;
import com.progwml6.natura.common.entities.living.enemy.HeatscarSpider;
import com.progwml6.natura.common.entities.living.enemy.NitroCreeper;
import com.progwml6.natura.common.entities.projectiles.FusewoodArrow;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.client.resources.IResourceManager;
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
		IResourceManager resourceManager = Minecraft.getMinecraft().getResourceManager();
		try
		{
			GrassColorizerAlternate.setBlueGrassBiomeColorizer(TextureUtil.readImageData(resourceManager, Natura.getResource("textures/blocks/effects/bluegrasscolor.png")));
			GrassColorizerAlternate.setOrangeGrassBiomeColorizer(TextureUtil.readImageData(resourceManager, Natura.getResource("textures/blocks/effects/orangegrasscolor.png")));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}

package com.progwml6.natura.client;

import com.progwml6.natura.CommonProxy;
import com.progwml6.natura.Natura;
import com.progwml6.natura.client.renders.NitroCreeperRender;
import com.progwml6.natura.entity.NitroCreeper;
import mantle.client.ModelVariant;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.FMLCommonHandler;

public class ClientProxy extends CommonProxy
{
    private static final ResourceLocation bluegrass = new ResourceLocation("natura", "textures/misc/bluegrasscolor.png");

    private static final ResourceLocation orangegrass = new ResourceLocation("natura", "textures/misc/orangegrasscolor.png");

    private ModelVariant models;

    @Override
    public void init()
    {
        this.models = new ModelVariant(Natura.modID);

        FMLCommonHandler.instance().bus().register(new NCropsTickHandler());

        //RenderingRegistry.registerEntityRenderingHandler(ImpEntity.class, new ImpRender(Minecraft.getMinecraft().getRenderManager(), new ImpModel(), 0f));
        //RenderingRegistry.registerEntityRenderingHandler(HeatscarSpider.class, new FlameSpiderRender(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(NitroCreeper.class, new NitroCreeperRender(Minecraft.getMinecraft().getRenderManager()));
        //RenderingRegistry.registerEntityRenderingHandler(FusewoodArrow.class, new FusewoodArrowRender(Minecraft.getMinecraft().getRenderManager()));
        //RenderingRegistry.registerEntityRenderingHandler(BabyHeatscarSpider.class, new FlameSpiderBabyRender(Minecraft.getMinecraft().getRenderManager()));

        Minecraft mc = Minecraft.getMinecraft();
        try
        {
            GrassColorizerAlternate.setBlueGrassBiomeColorizer(TextureUtil.readImageData(mc.getResourceManager(), bluegrass));
            GrassColorizerAlternate.setOrangeGrassBiomeColorizer(TextureUtil.readImageData(mc.getResourceManager(), orangegrass));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public ModelVariant getModels()
    {
        return this.models;
    }
}

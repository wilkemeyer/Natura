package com.progwml6.natura.client;

import mantle.client.ModelVariant;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import com.progwml6.natura.CommonProxy;
import com.progwml6.natura.client.models.ImpModel;
import com.progwml6.natura.client.models.ModelNatura;
import com.progwml6.natura.client.renderer.GrassColorizerAlternate;
import com.progwml6.natura.client.renderer.NCropsTickHandler;
import com.progwml6.natura.client.renderer.entity.FlameSpiderBabyRender;
import com.progwml6.natura.client.renderer.entity.FlameSpiderRender;
import com.progwml6.natura.client.renderer.entity.FusewoodArrowRender;
import com.progwml6.natura.client.renderer.entity.ImpRender;
import com.progwml6.natura.client.renderer.entity.NitroCreeperRender;
import com.progwml6.natura.util.NaturaCreativeTabs;
import com.progwml6.natura.world.entities.BabyHeatscarSpider;
import com.progwml6.natura.world.entities.FusewoodArrow;
import com.progwml6.natura.world.entities.HeatscarSpider;
import com.progwml6.natura.world.entities.ImpEntity;
import com.progwml6.natura.world.entities.NitroCreeper;

public class ClientProxy extends CommonProxy
{
    private static final ResourceLocation bluegrass = new ResourceLocation("natura", "textures/misc/bluegrasscolor.png");

    private static final ResourceLocation orangegrass = new ResourceLocation("natura", "textures/misc/orangegrasscolor.png");

    private ModelNatura models;

    @Override
    public void preInit(FMLPreInitializationEvent event)
    {
        super.preInit(event);

        NaturaCreativeTabs.registerTabIcons();
        this.models = new ModelNatura();

        this.models.preInit();
    }

    @Override
    public void init(FMLInitializationEvent event)
    {
        super.init(event);
        
        this.models.init();
        FMLCommonHandler.instance().bus().register(new NCropsTickHandler());

        RenderingRegistry.registerEntityRenderingHandler(ImpEntity.class, new ImpRender(Minecraft.getMinecraft().getRenderManager(), new ImpModel(), 0f));
        RenderingRegistry.registerEntityRenderingHandler(HeatscarSpider.class, new FlameSpiderRender(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(NitroCreeper.class, new NitroCreeperRender(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(FusewoodArrow.class, new FusewoodArrowRender(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(BabyHeatscarSpider.class, new FlameSpiderBabyRender(Minecraft.getMinecraft().getRenderManager()));

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

package com.progwml6.natura;

import com.progwml6.natura.blocks.BlocksNatura;
import com.progwml6.natura.items.ItemsNatura;
import com.progwml6.natura.worldgen.CloudWorldgen;
import com.progwml6.natura.worldgen.CropWorldGen;
import mantle.pulsar.control.PulseManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

@Mod(modid = "natura", name = "Natura", version = "3.0.0", acceptedMinecraftVersions = "[1.8]", dependencies = "required-after:mantle@[0.3.1,)")
public class Natura
{
    public static final String modID = "natura";

    public static final PulseManager pulsar = new PulseManager(modID);

    /* Proxies for sides, used for graphics processing */
    @SidedProxy(clientSide = "com.progwml6.natura.client.ClientProxy", serverSide = "com.progwml6.natura.CommonProxy")
    public static CommonProxy proxy;

    /* Instance of this mod, used for grabbing prototype fields */
    @Instance(modID)
    public static Natura instance;

    public static Logger logger = LogManager.getLogger(modID);

    public static Random random = new Random();

    public static boolean retrogen;

    public static CloudWorldgen clouds;

    public static CropWorldGen crops;

    private BlocksNatura blocks = new BlocksNatura();

    private ItemsNatura items = new ItemsNatura();

    public static BlocksNatura getBlocks()
    {
        return Natura.instance.blocks;
    }

    public static ItemsNatura getItems()
    {
        return Natura.instance.items;
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent evt)
    {
        MinecraftForge.EVENT_BUS.register(new NaturaEvents());
        PHNatura.initProps(evt.getSuggestedConfigurationFile());

        pulsar.preInit(evt);
        this.blocks.preInit();
        this.items.preInit();
    }

    @EventHandler
    public void init(FMLInitializationEvent evt)
    {
        proxy.init();

        random.setSeed(2 ^ 16 + 2 ^ 8 + (4 * 3 * 271));

        this.blocks.init();
        this.items.init();

        GameRegistry.registerWorldGenerator(clouds = new CloudWorldgen(), 20); // TODO 1.8 Find correct weight (param 2)
        GameRegistry.registerWorldGenerator(crops = new CropWorldGen(), 20); // TODO 1.8 Find correct weight (param 2)
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent evt)
    {
        this.proxy.postInit();
    }
}

package com.github.dawnflyc.taoistart;


import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;


@Mod(modid = TaoistArt.MODID, name = TaoistArt.NAME, version = TaoistArt.VERSION, dependencies = TaoistArt.DEPEND, acceptedMinecraftVersions = "[1.12]")
public class TaoistArt {
    /**
     * id
     */
    public static final String MODID = "taoistart";
    /**
     * name
     */
    public static final String NAME = "Taoist Art";
    /**
     * 版本
     */
    public static final String VERSION = "0.0.1";
    /**
     * 前置
     */
    public static final String DEPEND = "";

    public static final SimpleNetworkWrapper NETWORK = new SimpleNetworkWrapper(MODID);

    //@SidedProxy(clientSide = "lifetech.client.proxy.ClientProxy", serverSide = "lifetech.common.proxy.CommonProxy")
    //public static CommonProxy PROXY;

    @Mod.Instance
    public static TaoistArt instance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        //PROXY.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        //PROXY.init(event);
    }
    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        //PROXY.postInit(event);
    }
}

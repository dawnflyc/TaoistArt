package com.github.dawnflyc.taoistart.common.event;

import com.github.dawnflyc.taoistart.TaoistArt;
import com.github.dawnflyc.taoistart.common.capability.ModCapability;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = TaoistArt.MODID,bus = Mod.EventBusSubscriber.Bus.MOD)
public class CommonSetupEvent {

    @SubscribeEvent
    public static void onSetupEvent(FMLCommonSetupEvent event) {
        ModCapability.register();
    }
}

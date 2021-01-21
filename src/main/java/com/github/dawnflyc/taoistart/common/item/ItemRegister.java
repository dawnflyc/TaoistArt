package com.github.dawnflyc.taoistart.common.item;

import com.github.dawnflyc.processtree.IScanResultHandler;
import com.github.dawnflyc.processtree.Result;
import com.github.dawnflyc.processtree.ScanNode;
import com.github.dawnflyc.taoistart.TaoistArt;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.HashSet;
import java.util.Set;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
@ScanNode(target = IItemRegistered.class)
public class ItemRegister implements IScanResultHandler<IItemRegistered> {

    private static final Set<Item> REG_ITEMS = new HashSet<>();

    @SubscribeEvent
    public static void registerItem(RegistryEvent.Register<Item> event) {
        REG_ITEMS.forEach(item -> event.getRegistry().register(item));
    }

    @Override
    public void handle(Result<IItemRegistered> result) {
        result.build().forEach(iItemRegistered -> REG_ITEMS.add(iItemRegistered.getItem()));
    }
}

package com.github.dawnflyc.taoistart.common.network;

import com.github.dawnflyc.processtree.IScanResultHandler;
import com.github.dawnflyc.processtree.Result;
import com.github.dawnflyc.processtree.ScanNode;
import com.github.dawnflyc.taoistart.TaoistArt;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;

@ScanNode(target = AbstractNetworkPack.class)
public class ModNetwork implements IScanResultHandler<AbstractNetworkPack> {

    public static final String VERSION = "1.0";
    public static final ResourceLocation name = new ResourceLocation(TaoistArt.MODID, "network");
    public static SimpleChannel INSTANCE;
    private static int ID = 0;

    @Override
    public void handle(Result<AbstractNetworkPack> result) {
        SimpleChannel simpleChannel = getChannel();
        result.getClassSet().forEach(abstractNetworkPackClass -> {
            simpleChannel.registerMessage(
                    nextID(),
                    abstractNetworkPackClass,
                    (pack, buffer) ->
                            pack.toBytes(buffer)
                    ,
                    (buffer) ->
                            result.buildParamInstance(abstractNetworkPackClass, new Class[]{PacketBuffer.class}, new Object[]{buffer})
                    ,
                    (pack, ctx) ->
                            pack.handler(ctx)

            );
        });
    }

    public int nextID() {
        return ID++;
    }

    public SimpleChannel getChannel() {
        if (INSTANCE == null) {
            INSTANCE = NetworkRegistry.newSimpleChannel(
                    name,
                    () -> VERSION,
                    s -> s.equals(VERSION),
                    s -> s.equals(VERSION));
        }
        return INSTANCE;
    }
}

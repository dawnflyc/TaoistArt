package com.github.dawnflyc.taoistart.common.network;

import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;

public abstract class AbstractNetworkPack {

    public AbstractNetworkPack(PacketBuffer buffer) {
    }

    public AbstractNetworkPack() {

    }

    public abstract void toBytes(PacketBuffer buf);

    public abstract void handler(Supplier<NetworkEvent.Context> ctx);
}

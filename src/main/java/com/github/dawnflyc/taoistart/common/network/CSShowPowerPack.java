package com.github.dawnflyc.taoistart.common.network;

import com.github.dawnflyc.taoistart.common.capability.ModCapability;
import com.github.dawnflyc.taoistart.common.capability.power.IPowerCapability;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fml.network.NetworkEvent;
import net.minecraftforge.fml.server.ServerLifecycleHooks;

import java.util.UUID;
import java.util.function.Supplier;

public class CSShowPowerPack extends AbstractNetworkPack {

    private UUID playerId;


    public CSShowPowerPack(PacketBuffer buffer) {
        super(buffer);
        this.playerId=buffer.readUniqueId();
    }

    public CSShowPowerPack(UUID playerId) {
        this.playerId = playerId;
    }

    @Override
    public void toBytes(PacketBuffer buf) {
        buf.writeUniqueId(this.playerId);
    }

    @Override
    public void handler(Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            MinecraftServer server = ServerLifecycleHooks.getCurrentServer();
            PlayerEntity player= server.getPlayerList().getPlayerByUUID(this.playerId);
            if (player!=null){
               LazyOptional<IPowerCapability> lazyOptional= player.getCapability(ModCapability.POWER);
               lazyOptional.ifPresent(iPowerCapability -> {
                   int power=iPowerCapability.getPower();
                   player.sendMessage(new StringTextComponent("你的能量还有:"+player));
               });
            }

        });
        ctx.get().setPacketHandled(true);
    }
}

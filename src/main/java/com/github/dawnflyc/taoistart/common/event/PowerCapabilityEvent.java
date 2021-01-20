package com.github.dawnflyc.taoistart.common.event;

import com.github.dawnflyc.taoistart.common.capability.ModCapability;
import com.github.dawnflyc.taoistart.common.capability.power.IPowerCapability;
import com.github.dawnflyc.taoistart.common.capability.provider.PowerCapabilityProvider;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class PowerCapabilityEvent {

    @SubscribeEvent
    public static void onAttachCapabilityEvent(AttachCapabilitiesEvent<Entity> event) {
        Entity entity = event.getObject();
        if (entity instanceof PlayerEntity) {
            event.addCapability(PowerCapabilityProvider.id, new PowerCapabilityProvider());
        }
    }

    @SubscribeEvent
    public static void onPlayerCloned(PlayerEvent.Clone event) {
        if (!event.isWasDeath()){
            LazyOptional<IPowerCapability> oldPower=event.getOriginal().getCapability(ModCapability.POWER);
            LazyOptional<IPowerCapability> newPower=event.getPlayer().getCapability(ModCapability.POWER);
            if (oldPower.isPresent() && newPower.isPresent()){
                newPower.ifPresent(newp -> oldPower.ifPresent(oldp -> newp.deserializeNBT(oldp.serializeNBT())));
            }
        }
    }
}

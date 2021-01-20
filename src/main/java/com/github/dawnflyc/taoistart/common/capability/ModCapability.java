package com.github.dawnflyc.taoistart.common.capability;

import com.github.dawnflyc.taoistart.common.capability.power.IPowerCapability;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;

import javax.annotation.Nullable;

public class ModCapability {


    @CapabilityInject(IPowerCapability.class)
    public static Capability<IPowerCapability> POWER;


    public static void register(){
        registerCapability(IPowerCapability.class);
    }

    private  static <T> void registerCapability(Class<T> type){
        CapabilityManager.INSTANCE.register(type, new Capability.IStorage<T>() {
            @Nullable
            @Override
            public INBT writeNBT(Capability<T> capability, T instance, Direction side) {
                return null;
            }
            @Override
            public void readNBT(Capability<T> capability, T instance, Direction side, INBT nbt) {
            }
        },() -> null);
    }

}

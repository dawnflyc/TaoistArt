package com.github.dawnflyc.taoistart.common.capability.provider;

import com.github.dawnflyc.taoistart.TaoistArt;
import com.github.dawnflyc.taoistart.common.capability.ModCapability;
import com.github.dawnflyc.taoistart.common.capability.power.IPowerCapability;
import com.github.dawnflyc.taoistart.common.capability.power.PowerCapability;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class PowerCapabilityProvider implements ICapabilityProvider, INBTSerializable<CompoundNBT> {

    private IPowerCapability powerCapability;

    public static final ResourceLocation name=new ResourceLocation(TaoistArt.MODID,"power");

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        return getCapability(cap);
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap) {
        return cap == ModCapability.POWER ? LazyOptional.of(() -> this.getOrCreateCapability()).cast() : LazyOptional.empty();
    }

    @Nonnull
    IPowerCapability getOrCreateCapability() {
        if (powerCapability == null) {
            powerCapability= new PowerCapability();
        }
        return this.powerCapability;
    }

    @Override
    public CompoundNBT serializeNBT() {
        return getOrCreateCapability().serializeNBT();
    }

    @Override
    public void deserializeNBT(CompoundNBT nbt) {
        getOrCreateCapability().deserializeNBT(nbt);
    }
}

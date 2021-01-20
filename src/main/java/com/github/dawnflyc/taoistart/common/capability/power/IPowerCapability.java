package com.github.dawnflyc.taoistart.common.capability.power;

import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.common.util.INBTSerializable;

public interface IPowerCapability extends INBTSerializable<CompoundNBT> {

    int getPower();

    void setPower(int power);

    void addPower(int value);
}

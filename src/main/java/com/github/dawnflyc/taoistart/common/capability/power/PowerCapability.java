package com.github.dawnflyc.taoistart.common.capability.power;

import net.minecraft.nbt.CompoundNBT;

public class PowerCapability implements IPowerCapability{

    private int power;

    @Override
    public int getPower() {
        return this.power;
    }

    @Override
    public void setPower(int power) {
        this.power=power;
    }

    @Override
    public void addPower(int value) {
        this.power+=value;
    }

    @Override
    public CompoundNBT serializeNBT() {
        CompoundNBT compoundNBT=new CompoundNBT();
        compoundNBT.putInt("power",power);
        return compoundNBT;
    }

    @Override
    public void deserializeNBT(CompoundNBT nbt) {
        if (nbt!=null){
            this.power=nbt.getInt("power");
        }
    }
}

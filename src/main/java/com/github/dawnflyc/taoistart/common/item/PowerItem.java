package com.github.dawnflyc.taoistart.common.item;

import com.github.dawnflyc.taoistart.TaoistArt;
import com.github.dawnflyc.taoistart.common.capability.ModCapability;
import com.github.dawnflyc.taoistart.common.capability.power.IPowerCapability;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.common.util.LazyOptional;

public class PowerItem extends Item implements IItemRegistered {

    public PowerItem() {
        super(new Properties().group(ItemGroup.MISC));
        this.setRegistryName(TaoistArt.MODID,"power");
    }

    @Override
    public Item getItem() {
        return this;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        if (!worldIn.isRemote){

            LazyOptional<IPowerCapability> power=playerIn.getCapability(ModCapability.POWER);

            if (playerIn.isSneaking()){
                power.ifPresent(iPowerCapability -> iPowerCapability.addPower(1));
            }else {
                power.ifPresent(iPowerCapability -> iPowerCapability.addPower(-1));
            }
            power.ifPresent(iPowerCapability -> playerIn.sendMessage(new StringTextComponent("你的能力还有:"+iPowerCapability.getPower())));

        }
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}

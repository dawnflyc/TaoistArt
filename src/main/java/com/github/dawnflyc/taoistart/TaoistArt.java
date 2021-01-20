package com.github.dawnflyc.taoistart;


import com.github.dawnflyc.processtree.ProcessTree;
import net.minecraftforge.fml.common.Mod;


@Mod(TaoistArt.MODID)
public class TaoistArt {

    public static final String MODID = "taoistart";

    public TaoistArt() {
        ProcessTree tree=new ProcessTree(this.getClass().getPackage().getName());
        tree.start();
    }
}

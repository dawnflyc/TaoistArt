package com.github.dawnflyc.taoistart;


import com.github.dawnflyc.processtree.Tree;
import com.github.dawnflyc.processtree.TreeScan;
import net.minecraftforge.fml.common.Mod;


@Mod(TaoistArt.MODID)
public class TaoistArt {
    /**
     * id
     */
    public static final String MODID = "taoistart";

    public TaoistArt() {
        Tree tree=new Tree(this.getClass().getPackage().getName());
        tree.run();
    }
}

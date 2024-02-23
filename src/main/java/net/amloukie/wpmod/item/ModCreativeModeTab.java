package net.amloukie.wpmod.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab
{
    public static final CreativeModeTab TUTORIAL_TAB = new CreativeModeTab("wpmodtab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.ENHANCED_BOW.get());
        }
    };
}

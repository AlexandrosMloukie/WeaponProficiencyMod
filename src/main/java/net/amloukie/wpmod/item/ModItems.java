package net.amloukie.wpmod.item;

import net.amloukie.wpmod.WeaponProficiencyMod;
import net.amloukie.wpmod.block.ModBlocks;
import net.amloukie.wpmod.item.custom.*;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, WeaponProficiencyMod.MOD_ID);

    public static final RegistryObject<Item> ZIRCON = ITEMS.register("zircon",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)));
    public static final RegistryObject<Item> RAW_ZIRCON = ITEMS.register("raw_zircon",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)));

    public static final RegistryObject<Item> EIGHT_BALL = ITEMS.register("eight_ball",
            () -> new EightBallItem(new Item.Properties()
                    .tab(ModCreativeModeTab.TUTORIAL_TAB)
                    .stacksTo(1)));

    public static final RegistryObject<Item> BLUEBERRY_SEEDS = ITEMS.register("blueberry_seeds",
            () -> new ItemNameBlockItem(ModBlocks.BLUEBERRY_CROP.get(),
                    new Item.Properties()
                    .tab(ModCreativeModeTab.TUTORIAL_TAB)));

    public static final RegistryObject<Item> BLUEBERRY = ITEMS.register("blueberry",
            () -> new Item(new Item.Properties()
                    .tab(ModCreativeModeTab.TUTORIAL_TAB)
                    .food(new FoodProperties.Builder()
                            .nutrition(2)
                            .saturationMod(2f)
                            .build())));

    public static final RegistryObject<Item> RUBY_ARROW = ITEMS.register("ruby_arrow",
            () -> new RubyArrowItem(new Item.Properties()
                    .tab(ModCreativeModeTab.TUTORIAL_TAB), 1.5f));
    public static final RegistryObject<Item> ENHANCED_BOW = ITEMS.register("enhanced_bow",
            () -> new EnhancedBow(new Item.Properties().durability(500)
                    .tab(ModCreativeModeTab.TUTORIAL_TAB)));
    public static final RegistryObject<Item> GUILLOTINE_AXE = ITEMS.register("guillotine_axe",
            () -> new GuillotineAxe(Tiers.IRON, 6.0F, -3.1F, new Item.Properties()
                    .tab(ModCreativeModeTab.TUTORIAL_TAB)));
    public static final RegistryObject<Item> HARPOON_ARROW = ITEMS.register("harpoon_arrow",
            () -> new HarpoonArrowItem(new Item.Properties()
                    .tab(ModCreativeModeTab.TUTORIAL_TAB)));
    public static final RegistryObject<Item> FENCING_SWORD = ITEMS.register("fencing_sword",
            () -> new FencingSword(Tiers.IRON, 3, -2.4F, new Item.Properties()
                    .tab(ModCreativeModeTab.TUTORIAL_TAB)));

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}

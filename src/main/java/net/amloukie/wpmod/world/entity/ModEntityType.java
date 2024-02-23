package net.amloukie.wpmod.world.entity;

import net.amloukie.wpmod.WeaponProficiencyMod;
import net.amloukie.wpmod.world.entity.projectile.HarpoonArrow;
import net.amloukie.wpmod.world.entity.projectile.PoisonArrow;
import net.amloukie.wpmod.world.entity.projectile.RubyArrow;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntityType {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, WeaponProficiencyMod.MOD_ID);

    public static final RegistryObject<EntityType<RubyArrow>> RUBY_ARROW = ENTITY_TYPES.register("ruby_arrow",
            () -> EntityType.Builder.<RubyArrow>of(RubyArrow::new, MobCategory.MISC)
                    .sized(0.5f, 0.5f)
                    .clientTrackingRange(4)
                    .updateInterval(20)
                    .build(new ResourceLocation(WeaponProficiencyMod.MOD_ID, "ruby_arrow").toString()));
    public static final RegistryObject<EntityType<HarpoonArrow>> HARPOON_ARROW = ENTITY_TYPES.register("harpoon_arrow",
            () -> EntityType.Builder.<HarpoonArrow>of(HarpoonArrow::new, MobCategory.MISC)
                    .sized(0.5f, 0.5f)
                    .clientTrackingRange(4)
                    .updateInterval(20)
                    .build(new ResourceLocation(WeaponProficiencyMod.MOD_ID, "harpoon_arrow").toString()));
    public static final RegistryObject<EntityType<PoisonArrow>> POISON_ARROW = ENTITY_TYPES.register("poison_arrow",
            () -> EntityType.Builder.<PoisonArrow>of(PoisonArrow::new, MobCategory.MISC)
                    .sized(0.5F, 0.5F)
                    .clientTrackingRange(4)
                    .updateInterval(20)
                    .build(new ResourceLocation(WeaponProficiencyMod.MOD_ID, "poison_arrow").toString()));

    public static void register(IEventBus eventBus)
    {
        ENTITY_TYPES.register(eventBus);
    }
}

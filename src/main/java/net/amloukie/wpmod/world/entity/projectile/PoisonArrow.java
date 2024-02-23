package net.amloukie.wpmod.world.entity.projectile;

import net.amloukie.wpmod.item.ModItems;
import net.amloukie.wpmod.world.entity.ModEntityType;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;

public class PoisonArrow extends AbstractArrow {
    private final Item referenceItem;

    public PoisonArrow(EntityType<? extends AbstractArrow> type, Level level) {
        super(type, level);
        this.referenceItem = ModItems.POISON_ARROW.get();
    }

    public PoisonArrow(LivingEntity pShooter, Level level, Item referenceItem)
    {
        super(ModEntityType.POISON_ARROW.get(), pShooter, level);
        this.referenceItem = referenceItem;
    }

    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        if (pResult.getEntity() instanceof LivingEntity livingEntity) {
            if (livingEntity.hasEffect(MobEffects.POISON)) {
                MobEffectInstance current = livingEntity.getActiveEffectsMap().get(MobEffects.POISON);

                livingEntity.addEffect(new MobEffectInstance(MobEffects.POISON, 160, current.getAmplifier() + 1), this);
            } else {
                livingEntity.addEffect(new MobEffectInstance(MobEffects.POISON, 160), this);
            }
        }
        super.onHitEntity(pResult);
    }

    @Override
    public ItemStack getPickupItem() { return new ItemStack(this.referenceItem); }
}

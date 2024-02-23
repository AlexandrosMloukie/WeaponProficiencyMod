package net.amloukie.wpmod.item.custom;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;

public class GuillotineAxe extends AxeItem {
    public GuillotineAxe(Tier p_40521_, float p_40522_, float p_40523_, Properties p_40524_) {
        super(p_40521_, p_40522_, p_40523_, p_40524_);
    }

    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        pTarget.causeFallDamage(pAttacker.fallDistance + 3.0F, 1.0F, DamageSource.playerAttack((Player)pAttacker));
        pAttacker.resetFallDistance();
        return super.hurtEnemy(pStack, pTarget, pAttacker);
    }
}

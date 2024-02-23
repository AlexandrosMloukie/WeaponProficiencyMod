package net.amloukie.wpmod.item.custom;

import net.amloukie.wpmod.item.ModItems;
import net.amloukie.wpmod.world.entity.projectile.PoisonArrow;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class PoisonArrowItem extends ArrowItem {
    public PoisonArrowItem(Properties pProperties) { super(pProperties); }

    @Override
    public AbstractArrow createArrow(Level pLevel, ItemStack pStack, LivingEntity pShooter) {
        PoisonArrow arrow = new PoisonArrow(pShooter, pLevel, ModItems.POISON_ARROW.get());
        return arrow;
    }
}

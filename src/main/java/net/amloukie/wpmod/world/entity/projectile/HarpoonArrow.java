package net.amloukie.wpmod.world.entity.projectile;

import net.amloukie.wpmod.item.ModItems;
import net.amloukie.wpmod.world.entity.ModEntityType;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class HarpoonArrow extends AbstractArrow {
    private final Item referenceItem;

    public HarpoonArrow(EntityType<? extends AbstractArrow> type, Level level) {
        super(type, level);
        this.referenceItem = ModItems.HARPOON_ARROW.get();
    }

    public HarpoonArrow(LivingEntity pShooter, Level level, Item referenceItem)
    {
        super(ModEntityType.HARPOON_ARROW.get(), pShooter, level);
        this.referenceItem = referenceItem;
    }

    @Override
    public void shoot(double pX, double pY, double pZ, float pVelocity, float pInaccuracy) {
        super.shoot(pX, pY, pZ, pVelocity, pInaccuracy);

        float f = pVelocity / 3.0F;
        if (f > 0.8)
        {
            this.setPierceLevel((byte)3);
        } else {
            this.setPierceLevel((byte)1);
        }
    }

    @Override
    protected float getWaterInertia() {
        return 1.0F;
    }

    @Override
    public ItemStack getPickupItem() { return new ItemStack(this.referenceItem); }
}

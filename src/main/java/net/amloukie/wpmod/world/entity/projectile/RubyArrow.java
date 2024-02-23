package net.amloukie.wpmod.world.entity.projectile;

import net.amloukie.wpmod.item.ModItems;
import net.amloukie.wpmod.world.entity.ModEntityType;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

public class RubyArrow extends AbstractArrow {
    private final Item referenceItem;

    public RubyArrow(EntityType<? extends AbstractArrow> type, Level level) {
        super(type, level);
        this.referenceItem = ModItems.RUBY_ARROW.get();
    }

    public RubyArrow(LivingEntity shooter, Level level, Item referenceItem) {
        super(ModEntityType.RUBY_ARROW.get(), shooter, level);
        this.referenceItem = referenceItem;
    }

    @Override
    public void clearFire() {}

    @Override
    public ItemStack getPickupItem() {
        return new ItemStack(this.referenceItem);
    }
}

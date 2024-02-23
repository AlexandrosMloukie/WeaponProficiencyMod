package net.amloukie.wpmod.item.custom;

import net.amloukie.wpmod.item.ModItems;
import net.amloukie.wpmod.world.entity.projectile.RubyArrow;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class RubyArrowItem extends ArrowItem {

    public RubyArrowItem(Properties properties, float damage) {
        super(properties);
    }

    @Override
    public AbstractArrow createArrow(Level level, ItemStack itemStack, LivingEntity shooter) {
        RubyArrow arrow = new RubyArrow(shooter, level, ModItems.RUBY_ARROW.get());
        arrow.setSecondsOnFire(100);
        //arrow.setPierceLevel((byte) 2);
        return arrow;
    }

    @Override
    public boolean isInfinite(ItemStack stack, ItemStack bow, net.minecraft.world.entity.player.Player player) {
        int enchant = net.minecraft.world.item.enchantment.EnchantmentHelper.getItemEnchantmentLevel(net.minecraft.world.item.enchantment.Enchantments.INFINITY_ARROWS, bow);
        return enchant <= 0 ? false : this.getClass() == RubyArrowItem.class;
    }
}
package net.amloukie.wpmod.item.custom;

import net.amloukie.wpmod.item.ModItems;
import net.amloukie.wpmod.world.entity.projectile.HarpoonArrow;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class HarpoonArrowItem extends ArrowItem {
    public HarpoonArrowItem(Properties pProperties) { super(pProperties); }

    @Override
    public AbstractArrow createArrow(Level level, ItemStack itemStack, LivingEntity shooter) {
        HarpoonArrow arrow = new HarpoonArrow(shooter, level, ModItems.HARPOON_ARROW.get());
        return arrow;
    }

    @Override
    public boolean isInfinite(ItemStack stack, ItemStack bow, net.minecraft.world.entity.player.Player player) {
        int enchant = net.minecraft.world.item.enchantment.EnchantmentHelper.getItemEnchantmentLevel(net.minecraft.world.item.enchantment.Enchantments.INFINITY_ARROWS, bow);
        return enchant <= 0 ? false : this.getClass() == HarpoonArrowItem.class;
    }
}

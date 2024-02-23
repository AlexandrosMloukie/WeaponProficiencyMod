package net.amloukie.wpmod.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;

import java.util.List;
import java.util.Timer;

public class FencingSword extends SwordItem {
    public FencingSword(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    @Override
    public InteractionResult interactLivingEntity(ItemStack pStack, Player pPlayer, LivingEntity pInteractionTarget, InteractionHand pUsedHand) {
        //pPlayer.sendSystemMessage(Component.literal("Interacted with: " + pInteractionTarget.getName()));

        return super.interactLivingEntity(pStack, pPlayer, pInteractionTarget, pUsedHand);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {

        if(!pLevel.isClientSide() && pUsedHand == InteractionHand.MAIN_HAND) {
            //pPlayer.sendSystemMessage(Component.literal("Used Sword! "));
            Timer parryTimer = new Timer();

            AABB testBox = pPlayer.getBoundingBox().inflate(2.0D, 2.0D, 2.0D);
            List<Entity> overlappingEntities = pLevel.getEntities(pPlayer,testBox);
            for (Entity entity : overlappingEntities) {
                //pPlayer.sendSystemMessage(Component.literal("Overlapping with: " + entity.getName()));

                if (entity instanceof AbstractArrow customarrow) {
                    //pPlayer.sendSystemMessage(Component.literal("Arrow Detected"));
                    customarrow.setDeltaMovement(pPlayer.getForward().scale(customarrow.getDeltaMovement().length()));
                    customarrow.setCritArrow(true);
                }
            }

            pPlayer.getCooldowns().addCooldown(this,40);
        }

        return super.use(pLevel, pPlayer, pUsedHand);
    }
}

package net.amloukie.wpmod.client.renderer.entity;

import net.amloukie.wpmod.WeaponProficiencyMod;
import net.amloukie.wpmod.world.entity.projectile.HarpoonArrow;
import net.amloukie.wpmod.world.entity.projectile.PoisonArrow;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class PoisonArrowRenderer extends ArrowRenderer<PoisonArrow> {
    public PoisonArrowRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public ResourceLocation getTextureLocation(PoisonArrow pEntity) {
        Item referenceItem = pEntity.getPickupItem().getItem();
        return new ResourceLocation(WeaponProficiencyMod.MOD_ID, "textures/entity/projectiles/poison_arrow.png");
    }
}

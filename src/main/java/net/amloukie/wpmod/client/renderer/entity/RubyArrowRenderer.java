package net.amloukie.wpmod.client.renderer.entity;

import net.amloukie.wpmod.WeaponProficiencyMod;
import net.amloukie.wpmod.world.entity.projectile.RubyArrow;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RubyArrowRenderer extends ArrowRenderer<RubyArrow> {
    public RubyArrowRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public ResourceLocation getTextureLocation(RubyArrow pEntity) {
        Item referenceItem = pEntity.getPickupItem().getItem();
        return new ResourceLocation(WeaponProficiencyMod.MOD_ID, "textures/entity/projectiles/ruby_arrow.png");
    }
}

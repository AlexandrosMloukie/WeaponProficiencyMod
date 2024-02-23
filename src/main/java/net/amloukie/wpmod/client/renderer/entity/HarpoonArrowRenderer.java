package net.amloukie.wpmod.client.renderer.entity;

import net.amloukie.wpmod.WeaponProficiencyMod;
import net.amloukie.wpmod.world.entity.projectile.HarpoonArrow;
import net.amloukie.wpmod.world.entity.projectile.RubyArrow;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class HarpoonArrowRenderer extends ArrowRenderer<HarpoonArrow> {
    public HarpoonArrowRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public ResourceLocation getTextureLocation(HarpoonArrow pEntity) {
        Item referenceItem = pEntity.getPickupItem().getItem();
        return new ResourceLocation(WeaponProficiencyMod.MOD_ID, "textures/entity/projectiles/harpoon_arrow.png");
    }
}

package net.amloukie.wpmod.client;

import com.mojang.blaze3d.systems.RenderSystem;
import net.amloukie.wpmod.WeaponProficiencyMod;
import net.amloukie.wpmod.item.ModItemProperties;
import net.amloukie.wpmod.item.ModItems;
import net.amloukie.wpmod.item.custom.EnhancedBow;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;

public class BowHudOverlay {
    private static final ResourceLocation BOWHUD_0 = new ResourceLocation(WeaponProficiencyMod.MOD_ID,
            "textures/bowhud/bowhud_0.png");
    private static final ResourceLocation BOWHUD_1 = new ResourceLocation(WeaponProficiencyMod.MOD_ID,
            "textures/bowhud/bowhud_1.png");
    private static final ResourceLocation BOWHUD_2 = new ResourceLocation(WeaponProficiencyMod.MOD_ID,
            "textures/bowhud/bowhud_2.png");

    public static final IGuiOverlay HUD_BOWHUD = ((gui, poseStack, partialTick, screenWidth, screenHeight) -> {
        int x = screenWidth / 2;
        int y = screenHeight;

        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, BOWHUD_0);

        /*if (EnhancedBow.getUsing()){
            GuiComponent.blit(poseStack, x / 2, y / 2, 0, 0, 32, 15, 32, 15);
        }

        if (gui.getMinecraft().player.getMainHandItem().getItem() instanceof EnhancedBow enhancedBow) {
            if (EnhancedBow.getCustomPowerFromTime(enhancedBow.getUseDuration(new ItemStack(enhancedBow))) >= 0.8D) {
                RenderSystem.setShaderTexture(0, BOWHUD_2);
                GuiComponent.blit(poseStack, x / 2, y / 2, 0, 0, 32, 15, 32, 15);
            } else if (EnhancedBow.getCustomPowerFromTime(enhancedBow.getUseDuration(new ItemStack(enhancedBow))) >= 0.2D) {
                RenderSystem.setShaderTexture(0, BOWHUD_1);
                GuiComponent.blit(poseStack, x / 2, y / 2, 0, 0, 32, 15, 32, 15);
            }
        }
         */
    });
}

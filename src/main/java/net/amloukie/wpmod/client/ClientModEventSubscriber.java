package net.amloukie.wpmod.client;

import net.amloukie.wpmod.WeaponProficiencyMod;
import net.amloukie.wpmod.client.renderer.entity.HarpoonArrowRenderer;
import net.amloukie.wpmod.client.renderer.entity.PoisonArrowRenderer;
import net.amloukie.wpmod.client.renderer.entity.RubyArrowRenderer;
import net.amloukie.wpmod.world.entity.ModEntityType;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = WeaponProficiencyMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModEventSubscriber {

    @SubscribeEvent
    public static void onClientSetup(EntityRenderersEvent.RegisterRenderers event)
    {
        event.registerEntityRenderer(ModEntityType.RUBY_ARROW.get(), RubyArrowRenderer::new);
        event.registerEntityRenderer(ModEntityType.HARPOON_ARROW.get(), HarpoonArrowRenderer::new);
        event.registerEntityRenderer(ModEntityType.POISON_ARROW.get(), PoisonArrowRenderer::new);
    }
}

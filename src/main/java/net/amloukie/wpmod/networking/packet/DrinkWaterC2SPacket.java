package net.amloukie.wpmod.networking.packet;

import net.amloukie.wpmod.thirst.PlayerThirstProvider;
import net.minecraft.ChatFormatting;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class DrinkWaterC2SPacket {
    private static final String MESSAGE_DRINK_WATER = "message.wpmod.drink_water";
    private static final String MESSAGE_NO_WATER = "message.wpmod.no_water";

    public DrinkWaterC2SPacket()
    {}

    public DrinkWaterC2SPacket(FriendlyByteBuf buf)
    {}

    public void toBytes(FriendlyByteBuf buf)
    {}

    public boolean handle(Supplier<NetworkEvent.Context> supplier)
    {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() ->
        {
            ServerPlayer player = context.getSender();
            ServerLevel level = player.getLevel();

            if(hasWaterAroundThem(player, level, 2))
            {
                // Notify player that they drank water
                player.sendSystemMessage(Component.translatable(MESSAGE_DRINK_WATER).withStyle(ChatFormatting.DARK_AQUA));

                // Play drinking sound
                level.playSound(null, player.getOnPos(), SoundEvents.GENERIC_DRINK, SoundSource.PLAYERS,
                        0.5F, level.random.nextFloat() * 0.1F + 0.9F);

                // Increase the Thrist level of player & Output Thrist level
                player.getCapability(PlayerThirstProvider.PLAYER_THIRST).ifPresent(thirst ->
                {
                    thirst.addThirst(1);
                    player.sendSystemMessage(Component.literal("Current thirst " + thirst.getThirst())
                            .withStyle(ChatFormatting.AQUA));
                });
            }
            else
            {
                // Notify player there is no water around
                player.sendSystemMessage(Component.translatable(MESSAGE_NO_WATER).withStyle(ChatFormatting.RED));

                // Output the Thrist level
                player.getCapability(PlayerThirstProvider.PLAYER_THIRST).ifPresent(thirst ->
                {
                    player.sendSystemMessage(Component.literal("Current thirst " + thirst.getThirst())
                            .withStyle(ChatFormatting.AQUA));
                });
            }
            // Check if player is near water

        });

        return true;
    }

    private boolean hasWaterAroundThem(ServerPlayer player, ServerLevel level, int size)
    {
        return level.getBlockStates(player.getBoundingBox().inflate(size))
                .filter(state -> state.is(Blocks.WATER)).toArray().length > 0;
    }
}

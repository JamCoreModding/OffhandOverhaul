package com.jamalam360.mixin;

import com.jamalam360.config.ModConfig;
import me.shedaniel.autoconfig.AutoConfig;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerInteractionManager;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * @author Jamalam360
 */

@Mixin(ClientPlayerInteractionManager.class)
public class ClientPlayerInteractionManagerMixin {
    @Inject(cancellable = true, at = @At("HEAD"), method = "interactBlock(Lnet/minecraft/client/network/ClientPlayerEntity;Lnet/minecraft/client/world/ClientWorld;Lnet/minecraft/util/Hand;Lnet/minecraft/util/hit/BlockHitResult;)Lnet/minecraft/util/ActionResult;")
    public void interactBlock(ClientPlayerEntity player, ClientWorld world, Hand hand, BlockHitResult hitResult, CallbackInfoReturnable<ActionResult> cir) {
        ModConfig config = AutoConfig.getConfigHolder(ModConfig.class).getConfig();

        switch (config.offhandPlacementType) {
            case SNEAKING:
                if (hand == Hand.OFF_HAND && !player.isSneaking()) {
                    cir.setReturnValue(ActionResult.FAIL);
                }

                break;
            case NOT_SNEAKING:
                if (hand == Hand.OFF_HAND && player.isSneaking()) {
                    cir.setReturnValue(ActionResult.FAIL);
                }

                break;
            case VANILLA:
                break;
        }
    }
}


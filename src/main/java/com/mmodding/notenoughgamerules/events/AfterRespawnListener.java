package com.mmodding.notenoughgamerules.events;

import com.mmodding.notenoughgamerules.Gamerules;
import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.server.network.ServerPlayerEntity;

public class AfterRespawnListener implements ServerPlayerEvents.AfterRespawn {

    @Override
    public void afterRespawn(ServerPlayerEntity oldPlayer, ServerPlayerEntity newPlayer, boolean alive) {
        if (newPlayer.getEntityWorld().getGameRules().getBoolean(Gamerules.KEEP_EFFECTS)) {
            for (int i = 0; i < oldPlayer.getStatusEffects().size(); i++) {
                StatusEffectInstance statusEffectInstance = oldPlayer.getStatusEffects().stream().toList().get(i);
                newPlayer.addStatusEffect(statusEffectInstance, oldPlayer);
            }
        }
    }
}

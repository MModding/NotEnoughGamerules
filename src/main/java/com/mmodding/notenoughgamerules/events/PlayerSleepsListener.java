package com.mmodding.notenoughgamerules.events;

import com.mmodding.notenoughgamerules.Gamerules;
import net.fabricmc.fabric.api.entity.event.v1.EntitySleepEvents;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

public class PlayerSleepsListener implements EntitySleepEvents.AllowSleeping {

    @Override
    public PlayerEntity.@Nullable SleepFailureReason allowSleep(PlayerEntity player, BlockPos sleepingPos) {
        if (!player.getWorld().getGameRules().getBoolean(Gamerules.CAN_PLAYER_SLEEP)) {
            return PlayerEntity.SleepFailureReason.NOT_POSSIBLE_NOW;
        }
        return null;
    }
}

package com.mmodding.notenoughgamerules.mixin.entities;

import com.mmodding.notenoughgamerules.Gamerules;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.server.world.ServerWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PigEntity.class)
public abstract class PigMixin extends EntityMixin {

	@Inject(method = "onStruckByLightning", at = @At("HEAD"), cancellable = true)
	private void onStruckByLightning(ServerWorld world, LightningEntity lightning, CallbackInfo ci) {
		if (!world.getGameRules().getBoolean(Gamerules.DO_TRANSFORMATIONS)) {
			super.onStruckByLightning(world, lightning);
			ci.cancel();
		}
	}
}

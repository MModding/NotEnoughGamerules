package com.mmodding.notenoughgamerules.mixin.entities;

import com.mmodding.notenoughgamerules.Gamerules;
import net.minecraft.entity.mob.ZombieVillagerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ZombieVillagerEntity.class)
public abstract class ZombieVillagerMixin extends MobEntityMixin {

	@Inject(method = "tick", at = @At("HEAD"), cancellable = true)
	private void tick(CallbackInfo ci) {
		if (!this.getWorld().getGameRules().getBoolean(Gamerules.DO_TRANSFORMATIONS)) {
			super.tick();
			ci.cancel();
		}
	}
}

package com.mmodding.notenoughgamerules.mixin.entities;

import com.mmodding.notenoughgamerules.Gamerules;
import net.minecraft.entity.TntEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TntEntity.class)
public abstract class TntEntityMixin extends EntityMixin {

	@Inject(method = "explode", at = @At("HEAD"), cancellable = true)
	private void explode(CallbackInfo ci) {
		if (!this.getWorld().getGameRules().getBoolean(Gamerules.TNT_EXPLODES)) ci.cancel();
	}
}

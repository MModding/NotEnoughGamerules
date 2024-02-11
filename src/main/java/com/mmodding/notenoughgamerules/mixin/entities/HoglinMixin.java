package com.mmodding.notenoughgamerules.mixin.entities;

import com.mmodding.notenoughgamerules.Gamerules;
import net.minecraft.entity.mob.HoglinEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(HoglinEntity.class)
public abstract class HoglinMixin extends EntityMixin {

	@Inject(method = "canConvert", at = @At("RETURN"), cancellable = true)
	private void canConvert(CallbackInfoReturnable<Boolean> cir) {
		if (!this.getWorld().getGameRules().getBoolean(Gamerules.DO_TRANSFORMATIONS)) cir.setReturnValue(false);
	}
}

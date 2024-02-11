package com.mmodding.notenoughgamerules.mixin.entities;

import com.mmodding.notenoughgamerules.Gamerules;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.vehicle.TntMinecartEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TntMinecartEntity.class)
public abstract class TntMinecartEntityMixin extends EntityMixin {

	@Inject(method = "explode(Lnet/minecraft/entity/damage/DamageSource;D)V", at = @At("HEAD"), cancellable = true)
	private void explode(DamageSource damageSource, double power, CallbackInfo ci) {
		if (!this.getWorld().getGameRules().getBoolean(Gamerules.TNT_EXPLODES)) ci.cancel();
	}
}

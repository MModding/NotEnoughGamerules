package com.mmodding.notenoughgamerules.mixin.entities;

import com.mmodding.notenoughgamerules.Gamerules;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.server.world.ServerWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AnimalEntity.class)
public class AnimalMixin {

	@Inject(method = "breed(Lnet/minecraft/server/world/ServerWorld;Lnet/minecraft/entity/passive/AnimalEntity;)V", at = @At("HEAD"), cancellable = true)
	private void breed(ServerWorld world, AnimalEntity other, CallbackInfo ci) {
		if (!world.getGameRules().getBoolean(Gamerules.DO_BABIES_SPAWN)) ci.cancel();
	}
}

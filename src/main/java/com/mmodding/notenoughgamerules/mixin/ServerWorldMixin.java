package com.mmodding.notenoughgamerules.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.mmodding.notenoughgamerules.Gamerules;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldView;
import net.minecraft.world.biome.Biome;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(ServerWorld.class)
public abstract class ServerWorldMixin {

	@Shadow
	public abstract MinecraftServer getServer();

	@ModifyExpressionValue(method = "tickIceAndSnow", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/biome/Biome;canSetIce(Lnet/minecraft/world/WorldView;Lnet/minecraft/util/math/BlockPos;)Z"))
	private boolean tickChunkIceRedirection(boolean original) {
		return original && this.getServer().getGameRules().getBoolean(Gamerules.DO_ICE_FORM);
	}

	@ModifyExpressionValue(method = "tickIceAndSnow", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/biome/Biome;canSetSnow(Lnet/minecraft/world/WorldView;Lnet/minecraft/util/math/BlockPos;)Z"))
	private boolean tickChunkSnowRedirection(boolean original) {
		return original && this.getServer().getGameRules().getBoolean(Gamerules.DO_SNOW_MELT);
	}
}

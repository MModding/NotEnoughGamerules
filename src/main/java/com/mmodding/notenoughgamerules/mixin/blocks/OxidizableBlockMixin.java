package com.mmodding.notenoughgamerules.mixin.blocks;

import com.mmodding.notenoughgamerules.Gamerules;
import net.minecraft.block.BlockState;
import net.minecraft.block.OxidizableBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(OxidizableBlock.class)
public class OxidizableBlockMixin {

	@Inject(method = "randomTick", at = @At("HEAD"), cancellable = true)
	private void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random, CallbackInfo ci) {
		if (!world.getGameRules().getBoolean(Gamerules.CAN_COPPER_OXIDE)) ci.cancel();
	}
}

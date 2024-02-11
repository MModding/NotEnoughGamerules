package com.mmodding.notenoughgamerules.events;

import com.mmodding.notenoughgamerules.NEGDamageTypes;
import net.fabricmc.fabric.api.event.registry.DynamicRegistrySetupCallback;
import net.fabricmc.fabric.api.event.registry.DynamicRegistryView;
import net.minecraft.registry.RegistryKeys;

public class DynamicRegistrySetupListener implements DynamicRegistrySetupCallback {

	@Override
	public void onRegistrySetup(DynamicRegistryView registryView) {
		registryView.getOptional(RegistryKeys.DAMAGE_TYPE).ifPresent(NEGDamageTypes::register);
	}
}

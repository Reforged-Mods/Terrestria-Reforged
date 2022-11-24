package com.terraformersmc.terrestria;

import com.terraformersmc.terrestria.biomegen.TerrestriaTerraBlenderGeneration;
import com.terraformersmc.terrestria.surfacebuilders.TerrestriaSurfaceBuilders;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;

@Mod("terrestria_worldgen")
public class TerrestriaWorldgen {

	public TerrestriaWorldgen(){
		onInitialize();
	}

	public void onInitialize() {
		Terrestria.callbackWhenInitialized(TerrestriaSurfaceBuilders::init);

		if (ModList.get().isLoaded("terrablender")) {
			Terrestria.LOGGER.info("Enabling Terrestria's TerraBlender worldgen module.");
			TerrestriaTerraBlenderGeneration.onTerraBlenderInitialized();
		} else {
			Terrestria.LOGGER.warn("Terrestria world generation disabled; TerraBlender is not present.");
		}
	}
}

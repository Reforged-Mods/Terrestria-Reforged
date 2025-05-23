package com.terraformersmc.terrestria.worldgen;

import com.terraformersmc.terrestria.Terrestria;
import com.terraformersmc.terrestria.biomegen.TerrestriaBiolithGeneration;
import com.terraformersmc.terrestria.biomegen.TerrestriaTerraBlenderGeneration;
import com.terraformersmc.terrestria.surfacebuilders.TerrestriaSurfaceBuilders;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;

public class TerrestriaWorldgen {

	public TerrestriaWorldgen(){
		onInitialize();
	}

	public void onInitialize() {
		Terrestria.callbackWhenInitialized(TerrestriaSurfaceBuilders::init);

		if (ModList.get().isLoaded("biolith")) {
			Terrestria.LOGGER.info("Enabling Terrestria's Biolith worldgen module.");
			Terrestria.callbackWhenInitialized(new TerrestriaBiolithGeneration());
		} else {
			Terrestria.LOGGER.warn("Terrestria world generation disabled; Biolith is not present.");
		}
	}
}

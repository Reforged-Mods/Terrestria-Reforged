package com.terraformersmc.terrestria.compat;

import com.terraformersmc.terraform.config.BiomeConfigNode;
import net.fabricmc.fabric.api.biome.v1.OverworldBiomes;
import net.fabricmc.fabric.api.biome.v1.OverworldClimate;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;

/** Adds Traverse biomes to Fabric Biomes Api reforged Biome spawn system. */
public class TraverseCompat {
	private static void addContinentalBiome(RegistryKey<Biome> biome, OverworldClimate climate, double defaultWeight) {
		boolean enable =  true; //!config.isFrozen();

		//BiomeConfigNode.Continental continental = config.continental(biome.getValue().getPath(), new BiomeConfigNode.Continental(enable, defaultWeight));
		//enable =  continental.isEnabled();

		double weight = defaultWeight; //continental.getWeight();
		if (enable && weight > 0.0) {
			OverworldBiomes.addContinentalBiome(biome, climate, weight);
		}
	}
}

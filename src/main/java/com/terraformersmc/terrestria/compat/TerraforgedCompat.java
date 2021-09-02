package com.terraformersmc.terrestria.compat;

import net.fabricmc.fabric.api.biome.v1.OverworldBiomes;
import net.fabricmc.fabric.api.biome.v1.OverworldClimate;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.BiomeKeys;

public class TerraforgedCompat {
	public static void initBiomesAdd(){
		OverworldBiomes.addContinentalBiome(RegistryKey.of(Registry.BIOME_KEY, new Identifier("terraforged", "bryce")), OverworldClimate.DRY, 1);
		OverworldBiomes.addContinentalBiome(RegistryKey.of(Registry.BIOME_KEY, new Identifier("terraforged", "cold_steppe")), OverworldClimate.COOL, 0.4);
		OverworldBiomes.addContinentalBiome(RegistryKey.of(Registry.BIOME_KEY, new Identifier("terraforged", "cold_marshland")), OverworldClimate.SNOWY, 1);
		OverworldBiomes.addContinentalBiome(RegistryKey.of(Registry.BIOME_KEY, new Identifier("terraforged", "fir_forest")), OverworldClimate.COOL, 1);
		OverworldBiomes.addContinentalBiome(RegistryKey.of(Registry.BIOME_KEY, new Identifier("terraforged", "flower_plains")), OverworldClimate.COOL, 0.4);
		OverworldBiomes.addContinentalBiome(RegistryKey.of(Registry.BIOME_KEY, new Identifier("terraforged", "frozen_lake")), OverworldClimate.SNOWY, 2);
		OverworldBiomes.addContinentalBiome(RegistryKey.of(Registry.BIOME_KEY, new Identifier("terraforged", "frozen_marsh")), OverworldClimate.SNOWY, 1);
		OverworldBiomes.addContinentalBiome(RegistryKey.of(Registry.BIOME_KEY, new Identifier("terraforged", "lake")), OverworldClimate.COOL, 2);
		OverworldBiomes.addContinentalBiome(RegistryKey.of(Registry.BIOME_KEY, new Identifier("terraforged", "marshland")), OverworldClimate.COOL, 2);
		OverworldBiomes.addContinentalBiome(RegistryKey.of(Registry.BIOME_KEY, new Identifier("terraforged", "savanna_scrub")), OverworldClimate.TEMPERATE, 2);
		OverworldBiomes.addContinentalBiome(RegistryKey.of(Registry.BIOME_KEY, new Identifier("terraforged", "shattered_savanna_scrub")), OverworldClimate.TEMPERATE, 0.4);
		OverworldBiomes.addContinentalBiome(RegistryKey.of(Registry.BIOME_KEY, new Identifier("terraforged", "snowy_fir_forest")), OverworldClimate.SNOWY, 1);
		OverworldBiomes.addContinentalBiome(RegistryKey.of(Registry.BIOME_KEY, new Identifier("terraforged", "snowy_tiaga_scrub")), OverworldClimate.SNOWY, 1);
		OverworldBiomes.addContinentalBiome(RegistryKey.of(Registry.BIOME_KEY, new Identifier("terraforged", "steppe")), OverworldClimate.TEMPERATE, 0.4);
		OverworldBiomes.addContinentalBiome(RegistryKey.of(Registry.BIOME_KEY, new Identifier("terraforged", "stone_forest")), OverworldClimate.TEMPERATE, 0.4);
		OverworldBiomes.addContinentalBiome(RegistryKey.of(Registry.BIOME_KEY, new Identifier("terraforged", "tiaga_scrub")), OverworldClimate.COOL, 1);
		OverworldBiomes.addBiomeVariant(BiomeKeys.BEACH, RegistryKey.of(Registry.BIOME_KEY, new Identifier("terraforged", "warm_beach")), 0.33, OverworldClimate.TEMPERATE);
	}
}

package com.terraformersmc.terrestria.init;

import com.terraformersmc.terrestria.Terrestria;
import com.terraformersmc.terrestria.mixin.VillagerTypeAccessor;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.village.VillagerType;
import net.minecraft.world.biome.Biome;


import java.util.Objects;

import static com.terraformersmc.terrestria.init.TerrestriaBiomes.*;

public class TerrestriaVillagerTypes {
	public static void init() {
		register(VillagerType.TAIGA, CALDERA, CALDERA_BEACH, CALDERA_FOOTHILLS, CALDERA_RIDGE);
		// Plains: Cypress Forest
		register(VillagerType.SWAMP, CYPRESS_SWAMP);
		// Plains: Dense Woodlands
		// Plains: Hemlock Rainforest
		// Plains: Japanese Maple Forest
		// Plains: Lush Redwood Forest
		register(VillagerType.JUNGLE, RAINBOW_RAINFOREST, RAINBOW_RAINFOREST_LAKE, RAINBOW_RAINFOREST_MOUNTAINS);
		// Plains: Redwood Forest
		// Plains: Sakura Forest
		register(VillagerType.TAIGA, SNOWY_HEMLOCK_CLEARING, SNOWY_HEMLOCK_FOREST);
		register(VillagerType.DESERT, VOLCANIC_ISLAND, VOLCANIC_ISLAND_BEACH, VOLCANIC_ISLAND_SHORE);
		register(VillagerType.DESERT, CANYON_ARCHES, CANYON_CLIFFS, CANYON_EDGE);
		register(VillagerType.DESERT, DUNES);
		register(VillagerType.DESERT, LUSH_DESERT);
		register(VillagerType.DESERT, OASIS);
		register(VillagerType.DESERT, OUTBACK, OUTBACK_BUSHLAND, OUTBACK_ULURU);
	}

	@SafeVarargs
	private static void register(VillagerType type, RegistryKey<Biome>... biomes) {
		for (RegistryKey<Biome> biome : biomes) {
			addVillagerTypeToBiome(biome, type);
		}
	}

	public static void addVillagerTypeToBiome(RegistryKey<Biome> biomeKey, VillagerType villagerType) {
		Objects.requireNonNull(biomeKey, "Biome registry key cannot be null");
		Objects.requireNonNull(villagerType, "Villager type cannot be null");

		if (VillagerTypeAccessor.getBiomeTypeToIdMap().put(biomeKey, villagerType) != null) {
			Terrestria.LOGGER.debug("Overriding existing Biome -> VillagerType registration for Biome {}", biomeKey.getValue().toString());
		}
	}

}

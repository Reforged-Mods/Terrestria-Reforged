package com.terraformersmc.terrestria.data;

import com.terraformersmc.terrestria.Terrestria;
import com.terraformersmc.terrestria.init.TerrestriaBiomes;
import com.terraformersmc.terrestria.tag.TerrestriaBiomeTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.server.BiomeTagProvider;
import net.minecraft.tag.BiomeTags;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class TerrestriaBiomeTagProvider extends BiomeTagProvider {
	public TerrestriaBiomeTagProvider(DataGenerator dataGenerator, ExistingFileHelper helper) {
		super(dataGenerator, Terrestria.MOD_ID, helper);
	}

	@Override
	protected void configure() {
		/*
		 * Vanilla biome categories
		 */
		getOrCreateTagBuilder(TagKey.of(RegistryKeys.BIOME, BiomeTags.ALLOWS_SURFACE_SLIME_SPAWNS.id()))
			.addOptional(TerrestriaBiomes.CYPRESS_SWAMP);

		getOrCreateTagBuilder(TagKey.of(RegistryKeys.BIOME, BiomeTags.IS_BEACH.id()))
			.addOptional(TerrestriaBiomes.VOLCANIC_ISLAND);

		getOrCreateTagBuilder(TagKey.of(RegistryKeys.BIOME, BiomeTags.IS_FOREST.id()))
			.addOptional(TerrestriaBiomes.CYPRESS_FOREST)
			.addOptional(TerrestriaBiomes.JAPANESE_MAPLE_FOREST)
			.addOptional(TerrestriaBiomes.SAKURA_FOREST);

		getOrCreateTagBuilder(TagKey.of(RegistryKeys.BIOME, BiomeTags.IS_HILL.id()))
			.addOptional(TerrestriaBiomes.VOLCANIC_ISLAND);

		getOrCreateTagBuilder(TagKey.of(RegistryKeys.BIOME, BiomeTags.IS_JUNGLE.id()))
			.addOptional(TerrestriaBiomes.RAINBOW_RAINFOREST);

		getOrCreateTagBuilder(TagKey.of(RegistryKeys.BIOME, BiomeTags.IS_MOUNTAIN.id()))
			.addOptional(TerrestriaBiomes.CALDERA);

		getOrCreateTagBuilder(TagKey.of(RegistryKeys.BIOME, BiomeTags.IS_SAVANNA.id()))
			.addOptional(TerrestriaBiomes.OUTBACK);

		getOrCreateTagBuilder(TagKey.of(RegistryKeys.BIOME, BiomeTags.IS_TAIGA.id()))
			.addOptional(TerrestriaBiomes.DENSE_WOODLANDS)
			.addOptional(TerrestriaBiomes.HEMLOCK_RAINFOREST)
			.addOptional(TerrestriaBiomes.HEMLOCK_TREELINE)
			.addOptional(TerrestriaBiomes.LUSH_REDWOOD_FOREST)
			.addOptional(TerrestriaBiomes.REDWOOD_FOREST)
			.addOptional(TerrestriaBiomes.SNOWY_HEMLOCK_FOREST)
			.addOptional(TerrestriaBiomes.SNOWY_HEMLOCK_TREELINE)
			.addOptional(TerrestriaBiomes.WINDSWEPT_REDWOOD_FOREST);

		getOrCreateTagBuilder(TagKey.of(RegistryKeys.BIOME, BiomeTags.SPAWNS_COLD_VARIANT_FROGS.id()))
			.addOptional(TerrestriaBiomes.CALDERA)
			.addOptional(TerrestriaBiomes.SNOWY_HEMLOCK_FOREST)
			.addOptional(TerrestriaBiomes.SNOWY_HEMLOCK_TREELINE);

		getOrCreateTagBuilder(TagKey.of(RegistryKeys.BIOME, BiomeTags.SPAWNS_WARM_VARIANT_FROGS.id()))
			.addOptional(TerrestriaBiomes.CANYON)
			.addOptional(TerrestriaBiomes.DUNES)
			.addOptional(TerrestriaBiomes.LUSH_DESERT)
			.addOptional(TerrestriaBiomes.OASIS)
			.addOptional(TerrestriaBiomes.VOLCANIC_ISLAND);

		getOrCreateTagBuilder(TagKey.of(RegistryKeys.BIOME, BiomeTags.WATER_ON_MAP_OUTLINES.id()))
			.addOptional(TerrestriaBiomes.CYPRESS_SWAMP);



		/*
		 * Common biome categories
		 */
		this.getOrCreateTagBuilder(TagKey.of(this.registry.getKey(), new Identifier("forge", "is_temperate")))
			.add(TerrestriaBiomes.CYPRESS_FOREST)
			.add(TerrestriaBiomes.CYPRESS_SWAMP)
			.add(TerrestriaBiomes.DENSE_WOODLANDS)
			.add(TerrestriaBiomes.HEMLOCK_RAINFOREST)
			.add(TerrestriaBiomes.JAPANESE_MAPLE_FOREST)
			.add(TerrestriaBiomes.LUSH_REDWOOD_FOREST)
			.add(TerrestriaBiomes.REDWOOD_FOREST)
			.add(TerrestriaBiomes.SAKURA_FOREST);

		this.getOrCreateTagBuilder(TagKey.of(this.registry.getKey(), Tags.Biomes.IS_DEAD.id()))
			.add(TerrestriaBiomes.DUNES);

		this.getOrCreateTagBuilder(TagKey.of(this.registry.getKey(), Tags.Biomes.IS_SANDY.id()))
			.add(TerrestriaBiomes.CANYON)
			.add(TerrestriaBiomes.DUNES)
			.add(TerrestriaBiomes.LUSH_DESERT)
			.add(TerrestriaBiomes.OASIS);

		this.getOrCreateTagBuilder(TagKey.of(this.registry.getKey(), Tags.Biomes.IS_SLOPE.id()))
			.add(TerrestriaBiomes.WINDSWEPT_REDWOOD_FOREST);

		this.getOrCreateTagBuilder(TagKey.of(this.registry.getKey(), BiomeTags.IS_OVERWORLD.id()))
			.add(TerrestriaBiomes.CALDERA)
			.add(TerrestriaBiomes.CANYON)
			.add(TerrestriaBiomes.CYPRESS_FOREST)
			.add(TerrestriaBiomes.CYPRESS_SWAMP)
			.add(TerrestriaBiomes.DENSE_WOODLANDS)
			.add(TerrestriaBiomes.DUNES)
			.add(TerrestriaBiomes.HEMLOCK_RAINFOREST)
			.add(TerrestriaBiomes.HEMLOCK_TREELINE)
			.add(TerrestriaBiomes.JAPANESE_MAPLE_FOREST)
			.add(TerrestriaBiomes.LUSH_DESERT)
			.add(TerrestriaBiomes.LUSH_REDWOOD_FOREST)
			.add(TerrestriaBiomes.OASIS)
			.add(TerrestriaBiomes.OUTBACK)
			.add(TerrestriaBiomes.RAINBOW_RAINFOREST)
			.add(TerrestriaBiomes.REDWOOD_FOREST)
			.add(TerrestriaBiomes.SAKURA_FOREST)
			.add(TerrestriaBiomes.SNOWY_HEMLOCK_FOREST)
			.add(TerrestriaBiomes.SNOWY_HEMLOCK_TREELINE)
			.add(TerrestriaBiomes.VOLCANIC_ISLAND)
			.add(TerrestriaBiomes.WINDSWEPT_REDWOOD_FOREST);

		this.getOrCreateTagBuilder(TagKey.of(this.registry.getKey(), new Identifier("forge", "is_mesa")))
			.add(TerrestriaBiomes.CANYON);

		this.getOrCreateTagBuilder(TagKey.of(this.registry.getKey(), BiomeTags.IS_SAVANNA.id()))
			.add(TerrestriaBiomes.OUTBACK);

		this.getOrCreateTagBuilder(TagKey.of(this.registry.getKey(), Tags.Biomes.IS_SNOWY.id()))
			.add(TerrestriaBiomes.CALDERA)
			.add(TerrestriaBiomes.SNOWY_HEMLOCK_FOREST)
			.add(TerrestriaBiomes.SNOWY_HEMLOCK_TREELINE);

		this.getOrCreateTagBuilder(TagKey.of(this.registry.getKey(), Tags.Biomes.IS_SWAMP.id()))
			.add(TerrestriaBiomes.CYPRESS_SWAMP);

		this.getOrCreateTagBuilder(TagKey.of(this.registry.getKey(), Tags.Biomes.IS_CONIFEROUS.id()))
			.add(TerrestriaBiomes.CALDERA)
			.add(TerrestriaBiomes.CYPRESS_FOREST);

		this.getOrCreateTagBuilder(TagKey.of(this.registry.getKey(), new Identifier("forge", "is_deciduous")))
			.add(TerrestriaBiomes.DENSE_WOODLANDS)
			.add(TerrestriaBiomes.JAPANESE_MAPLE_FOREST)
			.add(TerrestriaBiomes.RAINBOW_RAINFOREST)
			.add(TerrestriaBiomes.SAKURA_FOREST);


		/*
		 * Biome structure generation tags
		 */
		getOrCreateTagBuilder(TagKey.of(RegistryKeys.BIOME, BiomeTags.DESERT_PYRAMID_HAS_STRUCTURE.id()))
			.addOptional(TerrestriaBiomes.LUSH_DESERT)
			.addOptional(TerrestriaBiomes.OASIS);

		getOrCreateTagBuilder(TagKey.of(RegistryKeys.BIOME, BiomeTags.IGLOO_HAS_STRUCTURE.id()))
			.addOptional(TerrestriaBiomes.SNOWY_HEMLOCK_FOREST);

		getOrCreateTagBuilder(TagKey.of(RegistryKeys.BIOME, BiomeTags.JUNGLE_TEMPLE_HAS_STRUCTURE.id()))
			.addOptional(TerrestriaBiomes.RAINBOW_RAINFOREST);

		getOrCreateTagBuilder(TagKey.of(RegistryKeys.BIOME, BiomeTags.MINESHAFT_HAS_STRUCTURE.id()))
			.addOptional(TerrestriaBiomes.CALDERA)
			.addOptional(TerrestriaBiomes.CANYON)
			.addOptional(TerrestriaBiomes.CYPRESS_FOREST)
			.addOptional(TerrestriaBiomes.CYPRESS_SWAMP)
			.addOptional(TerrestriaBiomes.DENSE_WOODLANDS)
			.addOptional(TerrestriaBiomes.DUNES)
			.addOptional(TerrestriaBiomes.HEMLOCK_RAINFOREST)
			.addOptional(TerrestriaBiomes.HEMLOCK_TREELINE)
			.addOptional(TerrestriaBiomes.JAPANESE_MAPLE_FOREST)
			.addOptional(TerrestriaBiomes.LUSH_DESERT)
			.addOptional(TerrestriaBiomes.LUSH_REDWOOD_FOREST)
			.addOptional(TerrestriaBiomes.OASIS)
			.addOptional(TerrestriaBiomes.OUTBACK)
			.addOptional(TerrestriaBiomes.RAINBOW_RAINFOREST)
			.addOptional(TerrestriaBiomes.REDWOOD_FOREST)
			.addOptional(TerrestriaBiomes.SAKURA_FOREST)
			.addOptional(TerrestriaBiomes.SNOWY_HEMLOCK_FOREST)
			.addOptional(TerrestriaBiomes.SNOWY_HEMLOCK_TREELINE)
			.addOptional(TerrestriaBiomes.VOLCANIC_ISLAND)
			.addOptional(TerrestriaBiomes.WINDSWEPT_REDWOOD_FOREST);

		getOrCreateTagBuilder(TagKey.of(RegistryKeys.BIOME, BiomeTags.RUINED_PORTAL_DESERT_HAS_STRUCTURE.id()))
			.addOptional(TerrestriaBiomes.LUSH_DESERT)
			.addOptional(TerrestriaBiomes.OASIS)
			.addOptional(TerrestriaBiomes.OUTBACK);

		getOrCreateTagBuilder(TagKey.of(RegistryKeys.BIOME, BiomeTags.RUINED_PORTAL_JUNGLE_HAS_STRUCTURE.id()))
			.addOptional(TerrestriaBiomes.RAINBOW_RAINFOREST)
			.addOptional(TerrestriaBiomes.VOLCANIC_ISLAND);

		getOrCreateTagBuilder(TagKey.of(RegistryKeys.BIOME, BiomeTags.RUINED_PORTAL_MOUNTAIN_HAS_STRUCTURE.id()))
			.addOptional(TerrestriaBiomes.HEMLOCK_TREELINE)
			.addOptional(TerrestriaBiomes.SNOWY_HEMLOCK_TREELINE)
			.addOptional(TerrestriaBiomes.WINDSWEPT_REDWOOD_FOREST);

		getOrCreateTagBuilder(TagKey.of(RegistryKeys.BIOME, BiomeTags.RUINED_PORTAL_STANDARD_HAS_STRUCTURE.id()))
			.addOptional(TerrestriaBiomes.CYPRESS_FOREST)
			.addOptional(TerrestriaBiomes.HEMLOCK_RAINFOREST)
			.addOptional(TerrestriaBiomes.JAPANESE_MAPLE_FOREST)
			.addOptional(TerrestriaBiomes.LUSH_REDWOOD_FOREST)
			.addOptional(TerrestriaBiomes.REDWOOD_FOREST)
			.addOptional(TerrestriaBiomes.SAKURA_FOREST)
			.addOptional(TerrestriaBiomes.SNOWY_HEMLOCK_FOREST);

		getOrCreateTagBuilder(TagKey.of(RegistryKeys.BIOME, BiomeTags.SWAMP_HUT_HAS_STRUCTURE.id()))
			.addOptional(TerrestriaBiomes.CYPRESS_SWAMP);

		getOrCreateTagBuilder(TagKey.of(RegistryKeys.BIOME, BiomeTags.SHIPWRECK_BEACHED_HAS_STRUCTURE.id()))
			.addTag(BiomeTags.IS_BEACH);

		getOrCreateTagBuilder(TagKey.of(RegistryKeys.BIOME, BiomeTags.STRONGHOLD_HAS_STRUCTURE.id()))
			.addOptional(TerrestriaBiomes.CALDERA)
			.addOptional(TerrestriaBiomes.CANYON)
			.addOptional(TerrestriaBiomes.CYPRESS_FOREST)
			.addOptional(TerrestriaBiomes.CYPRESS_SWAMP)
			.addOptional(TerrestriaBiomes.DENSE_WOODLANDS)
			.addOptional(TerrestriaBiomes.DUNES)
			.addOptional(TerrestriaBiomes.HEMLOCK_RAINFOREST)
			.addOptional(TerrestriaBiomes.HEMLOCK_TREELINE)
			.addOptional(TerrestriaBiomes.JAPANESE_MAPLE_FOREST)
			.addOptional(TerrestriaBiomes.LUSH_DESERT)
			.addOptional(TerrestriaBiomes.LUSH_REDWOOD_FOREST)
			.addOptional(TerrestriaBiomes.OASIS)
			.addOptional(TerrestriaBiomes.OUTBACK)
			.addOptional(TerrestriaBiomes.RAINBOW_RAINFOREST)
			.addOptional(TerrestriaBiomes.REDWOOD_FOREST)
			.addOptional(TerrestriaBiomes.SAKURA_FOREST)
			.addOptional(TerrestriaBiomes.SNOWY_HEMLOCK_FOREST)
			.addOptional(TerrestriaBiomes.SNOWY_HEMLOCK_TREELINE)
			.addOptional(TerrestriaBiomes.VOLCANIC_ISLAND)
			.addOptional(TerrestriaBiomes.WINDSWEPT_REDWOOD_FOREST);

		getOrCreateTagBuilder(TagKey.of(RegistryKeys.BIOME, BiomeTags.VILLAGE_DESERT_HAS_STRUCTURE.id()))
			.addOptional(TerrestriaBiomes.LUSH_DESERT)
			.addOptional(TerrestriaBiomes.OASIS)
			.addOptional(TerrestriaBiomes.VOLCANIC_ISLAND);

		getOrCreateTagBuilder(TagKey.of(RegistryKeys.BIOME, BiomeTags.VILLAGE_PLAINS_HAS_STRUCTURE.id()))
			.addOptional(TerrestriaBiomes.HEMLOCK_RAINFOREST)
			.addOptional(TerrestriaBiomes.JAPANESE_MAPLE_FOREST)
			.addOptional(TerrestriaBiomes.LUSH_REDWOOD_FOREST)
			.addOptional(TerrestriaBiomes.REDWOOD_FOREST)
			.addOptional(TerrestriaBiomes.SAKURA_FOREST);

		getOrCreateTagBuilder(TagKey.of(RegistryKeys.BIOME, BiomeTags.VILLAGE_SAVANNA_HAS_STRUCTURE.id()))
			.addOptional(TerrestriaBiomes.OUTBACK);

		getOrCreateTagBuilder(TagKey.of(RegistryKeys.BIOME, BiomeTags.VILLAGE_SNOWY_HAS_STRUCTURE.id()))
			.addOptional(TerrestriaBiomes.SNOWY_HEMLOCK_FOREST)
			.addOptional(TerrestriaBiomes.SNOWY_HEMLOCK_TREELINE);

		getOrCreateTagBuilder(TagKey.of(RegistryKeys.BIOME, BiomeTags.VILLAGE_TAIGA_HAS_STRUCTURE.id()))
			.addOptional(TerrestriaBiomes.HEMLOCK_TREELINE)
			.addOptional(TerrestriaBiomes.WINDSWEPT_REDWOOD_FOREST);

		getOrCreateTagBuilder(TagKey.of(RegistryKeys.BIOME, TerrestriaBiomeTags.CANYON_ARCH_HAS_STRUCTURE.id()))
			.addOptional(TerrestriaBiomes.CANYON);

		getOrCreateTagBuilder(TagKey.of(RegistryKeys.BIOME, TerrestriaBiomeTags.OCEAN_VOLCANO_HAS_STRUCTURE.id()))
			.add(BiomeKeys.DEEP_FROZEN_OCEAN)
			.add(BiomeKeys.DEEP_COLD_OCEAN)
			.add(BiomeKeys.DEEP_OCEAN)
			.add(BiomeKeys.DEEP_LUKEWARM_OCEAN);

		getOrCreateTagBuilder(TagKey.of(RegistryKeys.BIOME, TerrestriaBiomeTags.VOLCANO_HAS_STRUCTURE.id()))
			.addOptional(TerrestriaBiomes.VOLCANIC_ISLAND);
	}
}

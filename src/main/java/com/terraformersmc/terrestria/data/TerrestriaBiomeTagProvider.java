package com.terraformersmc.terrestria.data;

import com.terraformersmc.terrestria.Terrestria;
import com.terraformersmc.terrestria.init.TerrestriaBiomes;
import com.terraformersmc.terrestria.tag.TerrestriaBiomeTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataOutput;
import net.minecraft.data.server.tag.vanilla.VanillaBiomeTagProvider;
import net.minecraft.registry.RegistryWrapper.WrapperLookup;
import net.minecraft.registry.tag.BiomeTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

public class TerrestriaBiomeTagProvider extends VanillaBiomeTagProvider {
	public TerrestriaBiomeTagProvider(DataOutput dataOutput, CompletableFuture<WrapperLookup> completableFuture, ExistingFileHelper helper) {
		super(dataOutput, completableFuture, Terrestria.MOD_ID, helper);
	}

	@Override
	protected void configure(WrapperLookup lookup) {
		/*
		 * Vanilla biome categories
		 */
		getOrCreateTagBuilder(BiomeTags.ALLOWS_SURFACE_SLIME_SPAWNS)
			.addOptional(TerrestriaBiomes.CYPRESS_SWAMP.getValue());

		getOrCreateTagBuilder(BiomeTags.IS_BEACH)
			.addOptional(TerrestriaBiomes.VOLCANIC_ISLAND.getValue());

		getOrCreateTagBuilder(BiomeTags.IS_FOREST)
			.addOptional(TerrestriaBiomes.CYPRESS_FOREST.getValue())
			.addOptional(TerrestriaBiomes.JAPANESE_MAPLE_FOREST.getValue())
			.addOptional(TerrestriaBiomes.SAKURA_FOREST.getValue());

		getOrCreateTagBuilder(BiomeTags.IS_HILL)
			.addOptional(TerrestriaBiomes.VOLCANIC_ISLAND.getValue());

		getOrCreateTagBuilder(BiomeTags.IS_JUNGLE)
			.addOptional(TerrestriaBiomes.RAINBOW_RAINFOREST.getValue());

		getOrCreateTagBuilder(BiomeTags.IS_MOUNTAIN)
			.addOptional(TerrestriaBiomes.CALDERA.getValue());

		getOrCreateTagBuilder(BiomeTags.IS_SAVANNA)
			.addOptional(TerrestriaBiomes.OUTBACK.getValue());

		getOrCreateTagBuilder(BiomeTags.IS_TAIGA)
			.addOptional(TerrestriaBiomes.DENSE_WOODLANDS.getValue())
			.addOptional(TerrestriaBiomes.HEMLOCK_RAINFOREST.getValue())
			.addOptional(TerrestriaBiomes.HEMLOCK_TREELINE.getValue())
			.addOptional(TerrestriaBiomes.LUSH_REDWOOD_FOREST.getValue())
			.addOptional(TerrestriaBiomes.REDWOOD_FOREST.getValue())
			.addOptional(TerrestriaBiomes.SNOWY_HEMLOCK_FOREST.getValue())
			.addOptional(TerrestriaBiomes.SNOWY_HEMLOCK_TREELINE.getValue())
			.addOptional(TerrestriaBiomes.WINDSWEPT_REDWOOD_FOREST.getValue());

		getOrCreateTagBuilder(BiomeTags.SPAWNS_COLD_VARIANT_FROGS)
			.addOptional(TerrestriaBiomes.CALDERA.getValue())
			.addOptional(TerrestriaBiomes.SNOWY_HEMLOCK_FOREST.getValue())
			.addOptional(TerrestriaBiomes.SNOWY_HEMLOCK_TREELINE.getValue());

		getOrCreateTagBuilder(BiomeTags.SPAWNS_WARM_VARIANT_FROGS)
			.addOptional(TerrestriaBiomes.CANYON.getValue())
			.addOptional(TerrestriaBiomes.DUNES.getValue())
			.addOptional(TerrestriaBiomes.LUSH_DESERT.getValue())
			.addOptional(TerrestriaBiomes.OASIS.getValue())
			.addOptional(TerrestriaBiomes.VOLCANIC_ISLAND.getValue());

		getOrCreateTagBuilder(BiomeTags.WATER_ON_MAP_OUTLINES)
			.addOptional(TerrestriaBiomes.CYPRESS_SWAMP.getValue());



		/*
		 * Common biome categories
		 */
		this.getOrCreateTagBuilder(TagKey.of(this.registryRef, new Identifier("forge", "is_temperate")))
			.addOptional(TerrestriaBiomes.CYPRESS_FOREST.getValue())
			.addOptional(TerrestriaBiomes.CYPRESS_SWAMP.getValue())
			.addOptional(TerrestriaBiomes.DENSE_WOODLANDS.getValue())
			.addOptional(TerrestriaBiomes.HEMLOCK_RAINFOREST.getValue())
			.addOptional(TerrestriaBiomes.JAPANESE_MAPLE_FOREST.getValue())
			.addOptional(TerrestriaBiomes.LUSH_REDWOOD_FOREST.getValue())
			.addOptional(TerrestriaBiomes.REDWOOD_FOREST.getValue())
			.addOptional(TerrestriaBiomes.SAKURA_FOREST.getValue());

		this.getOrCreateTagBuilder(Tags.Biomes.IS_DEAD)
			.addOptional(TerrestriaBiomes.DUNES.getValue());

		this.getOrCreateTagBuilder(Tags.Biomes.IS_SANDY)
			.addOptional(TerrestriaBiomes.CANYON.getValue())
			.addOptional(TerrestriaBiomes.DUNES.getValue())
			.addOptional(TerrestriaBiomes.LUSH_DESERT.getValue())
			.addOptional(TerrestriaBiomes.OASIS.getValue());

		this.getOrCreateTagBuilder(Tags.Biomes.IS_SLOPE)
			.addOptional(TerrestriaBiomes.WINDSWEPT_REDWOOD_FOREST.getValue());

		this.getOrCreateTagBuilder(BiomeTags.IS_OVERWORLD)
			.addOptional(TerrestriaBiomes.CALDERA.getValue())
			.addOptional(TerrestriaBiomes.CANYON.getValue())
			.addOptional(TerrestriaBiomes.CYPRESS_FOREST.getValue())
			.addOptional(TerrestriaBiomes.CYPRESS_SWAMP.getValue())
			.addOptional(TerrestriaBiomes.DENSE_WOODLANDS.getValue())
			.addOptional(TerrestriaBiomes.DUNES.getValue())
			.addOptional(TerrestriaBiomes.HEMLOCK_RAINFOREST.getValue())
			.addOptional(TerrestriaBiomes.HEMLOCK_TREELINE.getValue())
			.addOptional(TerrestriaBiomes.JAPANESE_MAPLE_FOREST.getValue())
			.addOptional(TerrestriaBiomes.LUSH_DESERT.getValue())
			.addOptional(TerrestriaBiomes.LUSH_REDWOOD_FOREST.getValue())
			.addOptional(TerrestriaBiomes.OASIS.getValue())
			.addOptional(TerrestriaBiomes.OUTBACK.getValue())
			.addOptional(TerrestriaBiomes.RAINBOW_RAINFOREST.getValue())
			.addOptional(TerrestriaBiomes.REDWOOD_FOREST.getValue())
			.addOptional(TerrestriaBiomes.SAKURA_FOREST.getValue())
			.addOptional(TerrestriaBiomes.SNOWY_HEMLOCK_FOREST.getValue())
			.addOptional(TerrestriaBiomes.SNOWY_HEMLOCK_TREELINE.getValue())
			.addOptional(TerrestriaBiomes.VOLCANIC_ISLAND.getValue())
			.addOptional(TerrestriaBiomes.WINDSWEPT_REDWOOD_FOREST.getValue());

		this.getOrCreateTagBuilder(TagKey.of(this.registryRef, new Identifier("forge", "is_mesa")))
			.addOptional(TerrestriaBiomes.CANYON.getValue());

		this.getOrCreateTagBuilder(BiomeTags.IS_SAVANNA)
			.addOptional(TerrestriaBiomes.OUTBACK.getValue());

		this.getOrCreateTagBuilder(Tags.Biomes.IS_SNOWY)
			.addOptional(TerrestriaBiomes.CALDERA.getValue())
			.addOptional(TerrestriaBiomes.SNOWY_HEMLOCK_FOREST.getValue())
			.addOptional(TerrestriaBiomes.SNOWY_HEMLOCK_TREELINE.getValue());

		this.getOrCreateTagBuilder(Tags.Biomes.IS_SWAMP)
			.addOptional(TerrestriaBiomes.CYPRESS_SWAMP.getValue());

		this.getOrCreateTagBuilder(Tags.Biomes.IS_CONIFEROUS)
			.addOptional(TerrestriaBiomes.CALDERA.getValue())
			.addOptional(TerrestriaBiomes.CYPRESS_FOREST.getValue());

		this.getOrCreateTagBuilder(TagKey.of(this.registryRef, new Identifier("forge", "is_deciduous")))
			.addOptional(TerrestriaBiomes.DENSE_WOODLANDS.getValue())
			.addOptional(TerrestriaBiomes.JAPANESE_MAPLE_FOREST.getValue())
			.addOptional(TerrestriaBiomes.RAINBOW_RAINFOREST.getValue())
			.addOptional(TerrestriaBiomes.SAKURA_FOREST.getValue());


		/*
		 * Biome structure generation tags
		 */
		getOrCreateTagBuilder(BiomeTags.DESERT_PYRAMID_HAS_STRUCTURE)
			.addOptional(TerrestriaBiomes.LUSH_DESERT.getValue())
			.addOptional(TerrestriaBiomes.OASIS.getValue());

		getOrCreateTagBuilder(BiomeTags.IGLOO_HAS_STRUCTURE)
			.addOptional(TerrestriaBiomes.SNOWY_HEMLOCK_FOREST.getValue());

		getOrCreateTagBuilder(BiomeTags.JUNGLE_TEMPLE_HAS_STRUCTURE)
			.addOptional(TerrestriaBiomes.RAINBOW_RAINFOREST.getValue());

		getOrCreateTagBuilder(BiomeTags.MINESHAFT_HAS_STRUCTURE)
			.addOptional(TerrestriaBiomes.CALDERA.getValue())
			.addOptional(TerrestriaBiomes.CANYON.getValue())
			.addOptional(TerrestriaBiomes.CYPRESS_FOREST.getValue())
			.addOptional(TerrestriaBiomes.CYPRESS_SWAMP.getValue())
			.addOptional(TerrestriaBiomes.DENSE_WOODLANDS.getValue())
			.addOptional(TerrestriaBiomes.DUNES.getValue())
			.addOptional(TerrestriaBiomes.HEMLOCK_RAINFOREST.getValue())
			.addOptional(TerrestriaBiomes.HEMLOCK_TREELINE.getValue())
			.addOptional(TerrestriaBiomes.JAPANESE_MAPLE_FOREST.getValue())
			.addOptional(TerrestriaBiomes.LUSH_DESERT.getValue())
			.addOptional(TerrestriaBiomes.LUSH_REDWOOD_FOREST.getValue())
			.addOptional(TerrestriaBiomes.OASIS.getValue())
			.addOptional(TerrestriaBiomes.OUTBACK.getValue())
			.addOptional(TerrestriaBiomes.RAINBOW_RAINFOREST.getValue())
			.addOptional(TerrestriaBiomes.REDWOOD_FOREST.getValue())
			.addOptional(TerrestriaBiomes.SAKURA_FOREST.getValue())
			.addOptional(TerrestriaBiomes.SNOWY_HEMLOCK_FOREST.getValue())
			.addOptional(TerrestriaBiomes.SNOWY_HEMLOCK_TREELINE.getValue())
			.addOptional(TerrestriaBiomes.VOLCANIC_ISLAND.getValue())
			.addOptional(TerrestriaBiomes.WINDSWEPT_REDWOOD_FOREST.getValue());

		getOrCreateTagBuilder(BiomeTags.RUINED_PORTAL_DESERT_HAS_STRUCTURE)
			.addOptional(TerrestriaBiomes.LUSH_DESERT.getValue())
			.addOptional(TerrestriaBiomes.OASIS.getValue())
			.addOptional(TerrestriaBiomes.OUTBACK.getValue());

		getOrCreateTagBuilder(BiomeTags.RUINED_PORTAL_JUNGLE_HAS_STRUCTURE)
			.addOptional(TerrestriaBiomes.RAINBOW_RAINFOREST.getValue())
			.addOptional(TerrestriaBiomes.VOLCANIC_ISLAND.getValue());

		getOrCreateTagBuilder(BiomeTags.RUINED_PORTAL_MOUNTAIN_HAS_STRUCTURE)
			.addOptional(TerrestriaBiomes.HEMLOCK_TREELINE.getValue())
			.addOptional(TerrestriaBiomes.SNOWY_HEMLOCK_TREELINE.getValue())
			.addOptional(TerrestriaBiomes.WINDSWEPT_REDWOOD_FOREST.getValue());

		getOrCreateTagBuilder(BiomeTags.RUINED_PORTAL_STANDARD_HAS_STRUCTURE)
			.addOptional(TerrestriaBiomes.CYPRESS_FOREST.getValue())
			.addOptional(TerrestriaBiomes.HEMLOCK_RAINFOREST.getValue())
			.addOptional(TerrestriaBiomes.JAPANESE_MAPLE_FOREST.getValue())
			.addOptional(TerrestriaBiomes.LUSH_REDWOOD_FOREST.getValue())
			.addOptional(TerrestriaBiomes.REDWOOD_FOREST.getValue())
			.addOptional(TerrestriaBiomes.SAKURA_FOREST.getValue())
			.addOptional(TerrestriaBiomes.SNOWY_HEMLOCK_FOREST.getValue());

		getOrCreateTagBuilder(BiomeTags.SWAMP_HUT_HAS_STRUCTURE)
			.addOptional(TerrestriaBiomes.CYPRESS_SWAMP.getValue());

		getOrCreateTagBuilder(BiomeTags.SHIPWRECK_BEACHED_HAS_STRUCTURE)
			.addTag(BiomeTags.IS_BEACH);

		getOrCreateTagBuilder(BiomeTags.STRONGHOLD_HAS_STRUCTURE)
			.addOptional(TerrestriaBiomes.CALDERA.getValue())
			.addOptional(TerrestriaBiomes.CANYON.getValue())
			.addOptional(TerrestriaBiomes.CYPRESS_FOREST.getValue())
			.addOptional(TerrestriaBiomes.CYPRESS_SWAMP.getValue())
			.addOptional(TerrestriaBiomes.DENSE_WOODLANDS.getValue())
			.addOptional(TerrestriaBiomes.DUNES.getValue())
			.addOptional(TerrestriaBiomes.HEMLOCK_RAINFOREST.getValue())
			.addOptional(TerrestriaBiomes.HEMLOCK_TREELINE.getValue())
			.addOptional(TerrestriaBiomes.JAPANESE_MAPLE_FOREST.getValue())
			.addOptional(TerrestriaBiomes.LUSH_DESERT.getValue())
			.addOptional(TerrestriaBiomes.LUSH_REDWOOD_FOREST.getValue())
			.addOptional(TerrestriaBiomes.OASIS.getValue())
			.addOptional(TerrestriaBiomes.OUTBACK.getValue())
			.addOptional(TerrestriaBiomes.RAINBOW_RAINFOREST.getValue())
			.addOptional(TerrestriaBiomes.REDWOOD_FOREST.getValue())
			.addOptional(TerrestriaBiomes.SAKURA_FOREST.getValue())
			.addOptional(TerrestriaBiomes.SNOWY_HEMLOCK_FOREST.getValue())
			.addOptional(TerrestriaBiomes.SNOWY_HEMLOCK_TREELINE.getValue())
			.addOptional(TerrestriaBiomes.VOLCANIC_ISLAND.getValue())
			.addOptional(TerrestriaBiomes.WINDSWEPT_REDWOOD_FOREST.getValue());

		getOrCreateTagBuilder(BiomeTags.VILLAGE_DESERT_HAS_STRUCTURE)
			.addOptional(TerrestriaBiomes.LUSH_DESERT.getValue())
			.addOptional(TerrestriaBiomes.OASIS.getValue())
			.addOptional(TerrestriaBiomes.VOLCANIC_ISLAND.getValue());

		getOrCreateTagBuilder(BiomeTags.VILLAGE_PLAINS_HAS_STRUCTURE)
			.addOptional(TerrestriaBiomes.HEMLOCK_RAINFOREST.getValue())
			.addOptional(TerrestriaBiomes.JAPANESE_MAPLE_FOREST.getValue())
			.addOptional(TerrestriaBiomes.LUSH_REDWOOD_FOREST.getValue())
			.addOptional(TerrestriaBiomes.REDWOOD_FOREST.getValue())
			.addOptional(TerrestriaBiomes.SAKURA_FOREST.getValue());

		getOrCreateTagBuilder(BiomeTags.VILLAGE_SAVANNA_HAS_STRUCTURE)
			.addOptional(TerrestriaBiomes.OUTBACK.getValue());

		getOrCreateTagBuilder(BiomeTags.VILLAGE_SNOWY_HAS_STRUCTURE)
			.addOptional(TerrestriaBiomes.SNOWY_HEMLOCK_FOREST.getValue())
			.addOptional(TerrestriaBiomes.SNOWY_HEMLOCK_TREELINE.getValue());

		getOrCreateTagBuilder(BiomeTags.VILLAGE_TAIGA_HAS_STRUCTURE)
			.addOptional(TerrestriaBiomes.HEMLOCK_TREELINE.getValue())
			.addOptional(TerrestriaBiomes.WINDSWEPT_REDWOOD_FOREST.getValue());

		getOrCreateTagBuilder(TerrestriaBiomeTags.CANYON_ARCH_HAS_STRUCTURE)
			.addOptional(TerrestriaBiomes.CANYON.getValue());

		getOrCreateTagBuilder(TerrestriaBiomeTags.OCEAN_VOLCANO_HAS_STRUCTURE)
			.addOptional(BiomeKeys.DEEP_FROZEN_OCEAN.getValue())
			.addOptional(BiomeKeys.DEEP_COLD_OCEAN.getValue())
			.addOptional(BiomeKeys.DEEP_OCEAN.getValue())
			.addOptional(BiomeKeys.DEEP_LUKEWARM_OCEAN.getValue());

		getOrCreateTagBuilder(TerrestriaBiomeTags.VOLCANO_HAS_STRUCTURE)
			.addOptional(TerrestriaBiomes.VOLCANIC_ISLAND.getValue());
	}
}

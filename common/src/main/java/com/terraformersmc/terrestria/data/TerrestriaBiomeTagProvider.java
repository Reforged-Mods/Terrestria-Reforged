package com.terraformersmc.terrestria.data;

import com.terraformersmc.terrestria.init.TerrestriaBiomes;
import net.devtech.arrp.json.tags.JTag;
import net.minecraft.tag.BiomeTags;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.Tags;

import static com.terraformersmc.terrestria.data.TerrestriaDatagen.RUNTIME_RESOURCE_PACK;

public class TerrestriaBiomeTagProvider {

	public static void init() {
		/*
		 * Vanilla biome categories
		 */
		RUNTIME_RESOURCE_PACK.addTag(TerrestriaDatagen.tagID(BiomeTags.IS_BEACH), JTag.tag()
			.add(TerrestriaBiomes.VOLCANIC_ISLAND.getValue()));

		RUNTIME_RESOURCE_PACK.addTag(TerrestriaDatagen.tagID(BiomeTags.IS_FOREST), JTag.tag()
			.add(TerrestriaBiomes.CYPRESS_FOREST.getValue())
			.add(TerrestriaBiomes.JAPANESE_MAPLE_FOREST.getValue())
			.add(TerrestriaBiomes.SAKURA_FOREST.getValue()));

		RUNTIME_RESOURCE_PACK.addTag(TerrestriaDatagen.tagID(BiomeTags.IS_HILL), JTag.tag()
			.add(TerrestriaBiomes.VOLCANIC_ISLAND.getValue()));

		RUNTIME_RESOURCE_PACK.addTag(TerrestriaDatagen.tagID(BiomeTags.IS_JUNGLE), JTag.tag()
			.add(TerrestriaBiomes.RAINBOW_RAINFOREST.getValue()));

		RUNTIME_RESOURCE_PACK.addTag(TerrestriaDatagen.tagID(BiomeTags.IS_MOUNTAIN), JTag.tag()
			.add(TerrestriaBiomes.CALDERA.getValue()));

		RUNTIME_RESOURCE_PACK.addTag(TerrestriaDatagen.tagID(BiomeTags.IS_TAIGA), JTag.tag()
			.add(TerrestriaBiomes.DENSE_WOODLANDS.getValue())
			.add(TerrestriaBiomes.HEMLOCK_RAINFOREST.getValue())
			.add(TerrestriaBiomes.HEMLOCK_TREELINE.getValue())
			.add(TerrestriaBiomes.LUSH_REDWOOD_FOREST.getValue())
			.add(TerrestriaBiomes.REDWOOD_FOREST.getValue())
			.add(TerrestriaBiomes.SNOWY_HEMLOCK_FOREST.getValue())
			.add(TerrestriaBiomes.SNOWY_HEMLOCK_TREELINE.getValue())
			.add(TerrestriaBiomes.WINDSWEPT_REDWOOD_FOREST.getValue()));

		/*
		 * Common biome categories
		 */
		RUNTIME_RESOURCE_PACK.addTag(new Identifier("forge", "worldgen/biome/is_temperate"), JTag.tag()
			.add(TerrestriaBiomes.CYPRESS_FOREST.getValue())
			.add(TerrestriaBiomes.CYPRESS_SWAMP.getValue())
			.add(TerrestriaBiomes.DENSE_WOODLANDS.getValue())
			.add(TerrestriaBiomes.HEMLOCK_RAINFOREST.getValue())
			.add(TerrestriaBiomes.JAPANESE_MAPLE_FOREST.getValue())
			.add(TerrestriaBiomes.LUSH_REDWOOD_FOREST.getValue())
			.add(TerrestriaBiomes.REDWOOD_FOREST.getValue())
			.add(TerrestriaBiomes.SAKURA_FOREST.getValue()));

		RUNTIME_RESOURCE_PACK.addTag(TerrestriaDatagen.tagID(Tags.Biomes.IS_DEAD), JTag.tag()
			.add(TerrestriaBiomes.DUNES.getValue()));

		RUNTIME_RESOURCE_PACK.addTag(TerrestriaDatagen.tagID(Tags.Biomes.IS_SANDY), JTag.tag()
			.add(TerrestriaBiomes.CANYON.getValue())
			.add(TerrestriaBiomes.DUNES.getValue())
			.add(TerrestriaBiomes.LUSH_DESERT.getValue())
			.add(TerrestriaBiomes.OASIS.getValue()));

		RUNTIME_RESOURCE_PACK.addTag(TerrestriaDatagen.tagID(Tags.Biomes.IS_SLOPE), JTag.tag()
			.add(TerrestriaBiomes.WINDSWEPT_REDWOOD_FOREST.getValue()));

		RUNTIME_RESOURCE_PACK.addTag(TerrestriaDatagen.tagID(Tags.Biomes.IS_OVERWORLD), JTag.tag()
			.add(TerrestriaBiomes.CALDERA.getValue())
			.add(TerrestriaBiomes.CANYON.getValue())
			.add(TerrestriaBiomes.CYPRESS_FOREST.getValue())
			.add(TerrestriaBiomes.CYPRESS_SWAMP.getValue())
			.add(TerrestriaBiomes.DENSE_WOODLANDS.getValue())
			.add(TerrestriaBiomes.DUNES.getValue())
			.add(TerrestriaBiomes.HEMLOCK_RAINFOREST.getValue())
			.add(TerrestriaBiomes.HEMLOCK_TREELINE.getValue())
			.add(TerrestriaBiomes.JAPANESE_MAPLE_FOREST.getValue())
			.add(TerrestriaBiomes.LUSH_DESERT.getValue())
			.add(TerrestriaBiomes.LUSH_REDWOOD_FOREST.getValue())
			.add(TerrestriaBiomes.OASIS.getValue())
			.add(TerrestriaBiomes.OUTBACK.getValue())
			.add(TerrestriaBiomes.RAINBOW_RAINFOREST.getValue())
			.add(TerrestriaBiomes.REDWOOD_FOREST.getValue())
			.add(TerrestriaBiomes.SAKURA_FOREST.getValue())
			.add(TerrestriaBiomes.SNOWY_HEMLOCK_FOREST.getValue())
			.add(TerrestriaBiomes.SNOWY_HEMLOCK_TREELINE.getValue())
			.add(TerrestriaBiomes.VOLCANIC_ISLAND.getValue())
			.add(TerrestriaBiomes.WINDSWEPT_REDWOOD_FOREST.getValue()));

		RUNTIME_RESOURCE_PACK.addTag(new Identifier("forge", "worldgen/biome/is_mesa"), JTag.tag()
			.add(TerrestriaBiomes.CANYON.getValue()));

		RUNTIME_RESOURCE_PACK.addTag(TerrestriaDatagen.tagID(Tags.Biomes.IS_SAVANNA),  JTag.tag()
			.add(TerrestriaBiomes.OUTBACK.getValue()));

		RUNTIME_RESOURCE_PACK.addTag(TerrestriaDatagen.tagID(Tags.Biomes.IS_SNOWY),  JTag.tag()
			.add(TerrestriaBiomes.CALDERA.getValue())
			.add(TerrestriaBiomes.SNOWY_HEMLOCK_FOREST.getValue())
			.add(TerrestriaBiomes.SNOWY_HEMLOCK_TREELINE.getValue()));

		RUNTIME_RESOURCE_PACK.addTag(TerrestriaDatagen.tagID(Tags.Biomes.IS_SWAMP),  JTag.tag()
			.add(TerrestriaBiomes.CYPRESS_SWAMP.getValue()));

		RUNTIME_RESOURCE_PACK.addTag(TerrestriaDatagen.tagID(Tags.Biomes.IS_CONIFEROUS),  JTag.tag()
			.add(TerrestriaBiomes.CALDERA.getValue())
			.add(TerrestriaBiomes.CYPRESS_FOREST.getValue()));

		/*RUNTIME_RESOURCE_PACK.addTag(TerrestriaDatagen.tagID(ConventionalBiomeTags.TREE_DECIDUOUS), JTag.tag()
			.add(TerrestriaBiomes.DENSE_WOODLANDS.getValue())
			.add(TerrestriaBiomes.JAPANESE_MAPLE_FOREST.getValue())
			.add(TerrestriaBiomes.RAINBOW_RAINFOREST.getValue())
			.add(TerrestriaBiomes.SAKURA_FOREST.getValue()));*/


		/*
		 * Biome structure generation tags
		 */
		RUNTIME_RESOURCE_PACK.addTag(TerrestriaDatagen.tagID(BiomeTags.DESERT_PYRAMID_HAS_STRUCTURE),  JTag.tag()
			.add(TerrestriaBiomes.LUSH_DESERT.getValue())
			.add(TerrestriaBiomes.OASIS.getValue()));

		RUNTIME_RESOURCE_PACK.addTag(TerrestriaDatagen.tagID(BiomeTags.IGLOO_HAS_STRUCTURE),  JTag.tag()
			.add(TerrestriaBiomes.SNOWY_HEMLOCK_FOREST.getValue()));

		RUNTIME_RESOURCE_PACK.addTag(TerrestriaDatagen.tagID(BiomeTags.JUNGLE_TEMPLE_HAS_STRUCTURE),  JTag.tag()
			.add(TerrestriaBiomes.RAINBOW_RAINFOREST.getValue()));

		RUNTIME_RESOURCE_PACK.addTag(TerrestriaDatagen.tagID(BiomeTags.MINESHAFT_HAS_STRUCTURE),  JTag.tag()
			.add(TerrestriaBiomes.CALDERA.getValue())
			.add(TerrestriaBiomes.CANYON.getValue())
			.add(TerrestriaBiomes.CYPRESS_FOREST.getValue())
			.add(TerrestriaBiomes.CYPRESS_SWAMP.getValue())
			.add(TerrestriaBiomes.DENSE_WOODLANDS.getValue())
			.add(TerrestriaBiomes.DUNES.getValue())
			.add(TerrestriaBiomes.HEMLOCK_RAINFOREST.getValue())
			.add(TerrestriaBiomes.HEMLOCK_TREELINE.getValue())
			.add(TerrestriaBiomes.JAPANESE_MAPLE_FOREST.getValue())
			.add(TerrestriaBiomes.LUSH_DESERT.getValue())
			.add(TerrestriaBiomes.LUSH_REDWOOD_FOREST.getValue())
			.add(TerrestriaBiomes.OASIS.getValue())
			.add(TerrestriaBiomes.OUTBACK.getValue())
			.add(TerrestriaBiomes.RAINBOW_RAINFOREST.getValue())
			.add(TerrestriaBiomes.REDWOOD_FOREST.getValue())
			.add(TerrestriaBiomes.SAKURA_FOREST.getValue())
			.add(TerrestriaBiomes.SNOWY_HEMLOCK_FOREST.getValue())
			.add(TerrestriaBiomes.SNOWY_HEMLOCK_TREELINE.getValue())
			.add(TerrestriaBiomes.VOLCANIC_ISLAND.getValue())
			.add(TerrestriaBiomes.WINDSWEPT_REDWOOD_FOREST.getValue()));

		RUNTIME_RESOURCE_PACK.addTag(TerrestriaDatagen.tagID(BiomeTags.RUINED_PORTAL_DESERT_HAS_STRUCTURE),  JTag.tag()
			.add(TerrestriaBiomes.LUSH_DESERT.getValue())
			.add(TerrestriaBiomes.OASIS.getValue())
			.add(TerrestriaBiomes.OUTBACK.getValue()));

		RUNTIME_RESOURCE_PACK.addTag(TerrestriaDatagen.tagID(BiomeTags.RUINED_PORTAL_JUNGLE_HAS_STRUCTURE),  JTag.tag()
			.add(TerrestriaBiomes.RAINBOW_RAINFOREST.getValue())
			.add(TerrestriaBiomes.VOLCANIC_ISLAND.getValue()));

		RUNTIME_RESOURCE_PACK.addTag(TerrestriaDatagen.tagID(BiomeTags.RUINED_PORTAL_MOUNTAIN_HAS_STRUCTURE),  JTag.tag()
			.add(TerrestriaBiomes.HEMLOCK_TREELINE.getValue())
			.add(TerrestriaBiomes.SNOWY_HEMLOCK_TREELINE.getValue())
			.add(TerrestriaBiomes.WINDSWEPT_REDWOOD_FOREST.getValue()));

		RUNTIME_RESOURCE_PACK.addTag(TerrestriaDatagen.tagID(BiomeTags.RUINED_PORTAL_STANDARD_HAS_STRUCTURE),  JTag.tag()
			.add(TerrestriaBiomes.CYPRESS_FOREST.getValue())
			.add(TerrestriaBiomes.HEMLOCK_RAINFOREST.getValue())
			.add(TerrestriaBiomes.JAPANESE_MAPLE_FOREST.getValue())
			.add(TerrestriaBiomes.LUSH_REDWOOD_FOREST.getValue())
			.add(TerrestriaBiomes.REDWOOD_FOREST.getValue())
			.add(TerrestriaBiomes.SAKURA_FOREST.getValue())
			.add(TerrestriaBiomes.SNOWY_HEMLOCK_FOREST.getValue()));

		RUNTIME_RESOURCE_PACK.addTag(TerrestriaDatagen.tagID(BiomeTags.SWAMP_HUT_HAS_STRUCTURE),  JTag.tag()
			.add(TerrestriaBiomes.CYPRESS_SWAMP.getValue()));

		RUNTIME_RESOURCE_PACK.addTag(TerrestriaDatagen.tagID(BiomeTags.SHIPWRECK_BEACHED_HAS_STRUCTURE),  JTag.tag()
				.tag(BiomeTags.IS_BEACH.id()));

		RUNTIME_RESOURCE_PACK.addTag(TerrestriaDatagen.tagID(BiomeTags.STRONGHOLD_HAS_STRUCTURE),  JTag.tag()
			.add(TerrestriaBiomes.CALDERA.getValue())
			.add(TerrestriaBiomes.CANYON.getValue())
			.add(TerrestriaBiomes.CYPRESS_FOREST.getValue())
			.add(TerrestriaBiomes.CYPRESS_SWAMP.getValue())
			.add(TerrestriaBiomes.DENSE_WOODLANDS.getValue())
			.add(TerrestriaBiomes.DUNES.getValue())
			.add(TerrestriaBiomes.HEMLOCK_RAINFOREST.getValue())
			.add(TerrestriaBiomes.HEMLOCK_TREELINE.getValue())
			.add(TerrestriaBiomes.JAPANESE_MAPLE_FOREST.getValue())
			.add(TerrestriaBiomes.LUSH_DESERT.getValue())
			.add(TerrestriaBiomes.LUSH_REDWOOD_FOREST.getValue())
			.add(TerrestriaBiomes.OASIS.getValue())
			.add(TerrestriaBiomes.OUTBACK.getValue())
			.add(TerrestriaBiomes.RAINBOW_RAINFOREST.getValue())
			.add(TerrestriaBiomes.REDWOOD_FOREST.getValue())
			.add(TerrestriaBiomes.SAKURA_FOREST.getValue())
			.add(TerrestriaBiomes.SNOWY_HEMLOCK_FOREST.getValue())
			.add(TerrestriaBiomes.SNOWY_HEMLOCK_TREELINE.getValue())
			.add(TerrestriaBiomes.VOLCANIC_ISLAND.getValue())
			.add(TerrestriaBiomes.WINDSWEPT_REDWOOD_FOREST.getValue()));

		RUNTIME_RESOURCE_PACK.addTag(TerrestriaDatagen.tagID(BiomeTags.VILLAGE_DESERT_HAS_STRUCTURE),  JTag.tag()
			.add(TerrestriaBiomes.LUSH_DESERT.getValue())
			.add(TerrestriaBiomes.OASIS.getValue())
			.add(TerrestriaBiomes.VOLCANIC_ISLAND.getValue()));

		RUNTIME_RESOURCE_PACK.addTag(TerrestriaDatagen.tagID(BiomeTags.VILLAGE_PLAINS_HAS_STRUCTURE),  JTag.tag()
			.add(TerrestriaBiomes.HEMLOCK_RAINFOREST.getValue())
			.add(TerrestriaBiomes.JAPANESE_MAPLE_FOREST.getValue())
			.add(TerrestriaBiomes.LUSH_REDWOOD_FOREST.getValue())
			.add(TerrestriaBiomes.REDWOOD_FOREST.getValue())
			.add(TerrestriaBiomes.SAKURA_FOREST.getValue()));

		RUNTIME_RESOURCE_PACK.addTag(TerrestriaDatagen.tagID(BiomeTags.VILLAGE_SAVANNA_HAS_STRUCTURE),  JTag.tag()
			.add(TerrestriaBiomes.OUTBACK.getValue()));

		RUNTIME_RESOURCE_PACK.addTag(TerrestriaDatagen.tagID(BiomeTags.VILLAGE_SNOWY_HAS_STRUCTURE),  JTag.tag()
			.add(TerrestriaBiomes.SNOWY_HEMLOCK_FOREST.getValue())
			.add(TerrestriaBiomes.SNOWY_HEMLOCK_TREELINE.getValue()));

		RUNTIME_RESOURCE_PACK.addTag(TerrestriaDatagen.tagID(BiomeTags.VILLAGE_TAIGA_HAS_STRUCTURE),  JTag.tag()
			.add(TerrestriaBiomes.HEMLOCK_TREELINE.getValue())
			.add(TerrestriaBiomes.WINDSWEPT_REDWOOD_FOREST.getValue()));
	}
}

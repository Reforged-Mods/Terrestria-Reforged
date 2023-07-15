package com.terraformersmc.terrestria.data;

import com.terraformersmc.terrestria.Terrestria;
import com.terraformersmc.terrestria.init.TerrestriaBiomes;
import com.terraformersmc.terrestria.tag.TerrestriaBiomeTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.server.BiomeTagProvider;
import net.minecraft.tag.BiomeTags;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.world.biome.Biome;
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
		this.getOrCreateTagBuilder(TagKey.of(this.registry.getKey(), BiomeTags.ALLOWS_SURFACE_SLIME_SPAWNS.id()))
			.add(TerrestriaBiomes.CYPRESS_SWAMP);

		this.getOrCreateTagBuilder(TagKey.of(this.registry.getKey(), BiomeTags.IS_BEACH.id()))
			.add(TerrestriaBiomes.VOLCANIC_ISLAND);

		this.getOrCreateTagBuilder(TagKey.of(this.registry.getKey(), BiomeTags.IS_FOREST.id()))
			.add(TerrestriaBiomes.CYPRESS_FOREST)
			.add(TerrestriaBiomes.JAPANESE_MAPLE_FOREST)
			.add(TerrestriaBiomes.SAKURA_FOREST);

		this.getOrCreateTagBuilder(TagKey.of(this.registry.getKey(), BiomeTags.IS_HILL.id()))
			.add(TerrestriaBiomes.VOLCANIC_ISLAND);

		this.getOrCreateTagBuilder(TagKey.of(this.registry.getKey(), BiomeTags.IS_JUNGLE.id()))
			.add(TerrestriaBiomes.RAINBOW_RAINFOREST);

		this.getOrCreateTagBuilder(TagKey.of(this.registry.getKey(), BiomeTags.IS_MOUNTAIN.id()))
			.add(TerrestriaBiomes.CALDERA);

		this.getOrCreateTagBuilder(TagKey.of(this.registry.getKey(), BiomeTags.IS_SAVANNA.id()))
			.add(TerrestriaBiomes.OUTBACK);

		this.getOrCreateTagBuilder(TagKey.of(this.registry.getKey(), BiomeTags.IS_TAIGA.id()))
			.add(TerrestriaBiomes.DENSE_WOODLANDS)
			.add(TerrestriaBiomes.HEMLOCK_RAINFOREST)
			.add(TerrestriaBiomes.HEMLOCK_TREELINE)
			.add(TerrestriaBiomes.LUSH_REDWOOD_FOREST)
			.add(TerrestriaBiomes.REDWOOD_FOREST)
			.add(TerrestriaBiomes.SNOWY_HEMLOCK_FOREST)
			.add(TerrestriaBiomes.SNOWY_HEMLOCK_TREELINE)
			.add(TerrestriaBiomes.WINDSWEPT_REDWOOD_FOREST);

		this.getOrCreateTagBuilder(TagKey.of(this.registry.getKey(), BiomeTags.SPAWNS_COLD_VARIANT_FROGS.id()))
			.add(TerrestriaBiomes.CALDERA)
			.add(TerrestriaBiomes.SNOWY_HEMLOCK_FOREST)
			.add(TerrestriaBiomes.SNOWY_HEMLOCK_TREELINE);

		this.getOrCreateTagBuilder(TagKey.of(this.registry.getKey(), BiomeTags.SPAWNS_WARM_VARIANT_FROGS.id()))
			.add(TerrestriaBiomes.CANYON)
			.add(TerrestriaBiomes.DUNES)
			.add(TerrestriaBiomes.LUSH_DESERT)
			.add(TerrestriaBiomes.OASIS)
			.add(TerrestriaBiomes.VOLCANIC_ISLAND);

		this.getOrCreateTagBuilder(TagKey.of(this.registry.getKey(), BiomeTags.WATER_ON_MAP_OUTLINES.id()))
			.add(TerrestriaBiomes.CYPRESS_SWAMP);



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
		this.getOrCreateTagBuilder(TagKey.of(this.registry.getKey(), BiomeTags.DESERT_PYRAMID_HAS_STRUCTURE.id()))
			.add(TerrestriaBiomes.LUSH_DESERT)
			.add(TerrestriaBiomes.OASIS);

		this.getOrCreateTagBuilder(TagKey.of(this.registry.getKey(), BiomeTags.IGLOO_HAS_STRUCTURE.id()))
			.add(TerrestriaBiomes.SNOWY_HEMLOCK_FOREST);

		this.getOrCreateTagBuilder(TagKey.of(this.registry.getKey(), BiomeTags.JUNGLE_TEMPLE_HAS_STRUCTURE.id()))
			.add(TerrestriaBiomes.RAINBOW_RAINFOREST);

		this.getOrCreateTagBuilder(TagKey.of(this.registry.getKey(), BiomeTags.MINESHAFT_HAS_STRUCTURE.id()))
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

		this.getOrCreateTagBuilder(TagKey.of(this.registry.getKey(), BiomeTags.RUINED_PORTAL_DESERT_HAS_STRUCTURE.id()))
			.add(TerrestriaBiomes.LUSH_DESERT)
			.add(TerrestriaBiomes.OASIS)
			.add(TerrestriaBiomes.OUTBACK);

		this.getOrCreateTagBuilder(TagKey.of(this.registry.getKey(), BiomeTags.RUINED_PORTAL_JUNGLE_HAS_STRUCTURE.id()))
			.add(TerrestriaBiomes.RAINBOW_RAINFOREST)
			.add(TerrestriaBiomes.VOLCANIC_ISLAND);

		this.getOrCreateTagBuilder(TagKey.of(this.registry.getKey(), BiomeTags.RUINED_PORTAL_MOUNTAIN_HAS_STRUCTURE.id()))
			.add(TerrestriaBiomes.HEMLOCK_TREELINE)
			.add(TerrestriaBiomes.SNOWY_HEMLOCK_TREELINE)
			.add(TerrestriaBiomes.WINDSWEPT_REDWOOD_FOREST);

		this.getOrCreateTagBuilder(TagKey.of(this.registry.getKey(), BiomeTags.RUINED_PORTAL_STANDARD_HAS_STRUCTURE.id()))
			.add(TerrestriaBiomes.CYPRESS_FOREST)
			.add(TerrestriaBiomes.HEMLOCK_RAINFOREST)
			.add(TerrestriaBiomes.JAPANESE_MAPLE_FOREST)
			.add(TerrestriaBiomes.LUSH_REDWOOD_FOREST)
			.add(TerrestriaBiomes.REDWOOD_FOREST)
			.add(TerrestriaBiomes.SAKURA_FOREST)
			.add(TerrestriaBiomes.SNOWY_HEMLOCK_FOREST);

		this.getOrCreateTagBuilder(TagKey.of(this.registry.getKey(), BiomeTags.SWAMP_HUT_HAS_STRUCTURE.id()))
			.add(TerrestriaBiomes.CYPRESS_SWAMP);

		this.getOrCreateTagBuilder(TagKey.of(this.registry.getKey(), BiomeTags.SHIPWRECK_BEACHED_HAS_STRUCTURE.id()))
			.addTag(BiomeTags.IS_BEACH);

		this.getOrCreateTagBuilder(TagKey.of(this.registry.getKey(), BiomeTags.STRONGHOLD_HAS_STRUCTURE.id()))
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

		this.getOrCreateTagBuilder(TagKey.of(this.registry.getKey(), BiomeTags.VILLAGE_DESERT_HAS_STRUCTURE.id()))
			.add(TerrestriaBiomes.LUSH_DESERT)
			.add(TerrestriaBiomes.OASIS)
			.add(TerrestriaBiomes.VOLCANIC_ISLAND);

		this.getOrCreateTagBuilder(TagKey.of(this.registry.getKey(), BiomeTags.VILLAGE_PLAINS_HAS_STRUCTURE.id()))
			.add(TerrestriaBiomes.HEMLOCK_RAINFOREST)
			.add(TerrestriaBiomes.JAPANESE_MAPLE_FOREST)
			.add(TerrestriaBiomes.LUSH_REDWOOD_FOREST)
			.add(TerrestriaBiomes.REDWOOD_FOREST)
			.add(TerrestriaBiomes.SAKURA_FOREST);

		this.getOrCreateTagBuilder(TagKey.of(this.registry.getKey(), BiomeTags.VILLAGE_SAVANNA_HAS_STRUCTURE.id()))
			.add(TerrestriaBiomes.OUTBACK);

		this.getOrCreateTagBuilder(TagKey.of(this.registry.getKey(), BiomeTags.VILLAGE_SNOWY_HAS_STRUCTURE.id()))
			.add(TerrestriaBiomes.SNOWY_HEMLOCK_FOREST)
			.add(TerrestriaBiomes.SNOWY_HEMLOCK_TREELINE);

		this.getOrCreateTagBuilder(TagKey.of(this.registry.getKey(), BiomeTags.VILLAGE_TAIGA_HAS_STRUCTURE.id()))
			.add(TerrestriaBiomes.HEMLOCK_TREELINE)
			.add(TerrestriaBiomes.WINDSWEPT_REDWOOD_FOREST);

		this.getOrCreateTagBuilder(TagKey.of(this.registry.getKey(), TerrestriaBiomeTags.CANYON_ARCH_HAS_STRUCTURE.id()))
			.add(TerrestriaBiomes.CANYON);

		this.getOrCreateTagBuilder(TagKey.of(this.registry.getKey(), TerrestriaBiomeTags.OCEAN_VOLCANO_HAS_STRUCTURE.id()))
			.add(BiomeKeys.DEEP_FROZEN_OCEAN)
			.add(BiomeKeys.DEEP_COLD_OCEAN)
			.add(BiomeKeys.DEEP_OCEAN)
			.add(BiomeKeys.DEEP_LUKEWARM_OCEAN);

		this.getOrCreateTagBuilder(TagKey.of(this.registry.getKey(), TerrestriaBiomeTags.VOLCANO_HAS_STRUCTURE.id()))
			.add(TerrestriaBiomes.VOLCANIC_ISLAND);
	}
}

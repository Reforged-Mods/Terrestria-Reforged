package com.terraformersmc.terrestria.biome;

import com.terraformersmc.terraform.biomebuilder.BiomeTemplate;
import com.terraformersmc.terraform.biomebuilder.TerraformBiomeBuilder;
import com.terraformersmc.terrestria.init.*;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.*;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;

import static com.terraformersmc.terraform.biomebuilder.DefaultFeature.*;

public class CanyonBiomes {

	public static void register() {
		BiomeTemplate template = new BiomeTemplate(TerraformBiomeBuilder.create()
			.precipitation(Biome.Precipitation.NONE).category(Biome.Category.DESERT)
			.depth(0.2F)
			.scale(0.1F)
			.temperature(0.9F)
			.downfall(0.1F)
			.effects(TerrestriaBiomes.createDefaultBiomeEffects()
				.waterColor(0x4da5e3)
				.waterFogColor(0x24a0b0)
				.foliageColor(0xbdea62)
			)
			.addDefaultFeatures(LAND_CARVERS, DEFAULT_UNDERGROUND_STRUCTURES, DESERT_LAKES, DUNGEONS, MINEABLES, ORES, DISKS, DESERT_DEAD_BUSHES,
				DEFAULT_GRASS, DEFAULT_MUSHROOMS, DESERT_VEGETATION, FROZEN_TOP_LAYER)
			.addStructureFeature(ConfiguredStructureFeatures.STRONGHOLD)
			.addStructureFeature(ConfiguredStructureFeatures.MINESHAFT)
			.addDefaultSpawnEntries()
		);

		TerrestriaBiomes.CANYON_ARCHES = TerrestriaBiomes.register("canyon_arches", template.builder()
			.configureSurfaceBuilder(TerrestriaSurfaces.SANDSTONE_CLIFF, TerrestriaSurfaces.SANDSTONE_CONFIG)
			.addStructureFeature(TerrestriaStructures.CANYON_ARCH)
			.build(), Type.OVERWORLD, Type.DRY, Type.HOT, Type.SANDY);

		TerrestriaBiomes.CANYON_CLIFFS = TerrestriaBiomes.register("canyon_cliffs", template.builder()
			.configureSurfaceBuilder(TerrestriaSurfaces.CANYON_CLIFF, TerrestriaSurfaces.SANDSTONE_CLIFF_CONFIG)
			.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, TerrestriaDecoratedFeatures.RARE_BRYCE_TREES)
			.build(), Type.OVERWORLD, Type.DRY, Type.HOT, Type.SANDY, Type.HILLS);

		TerrestriaBiomes.CANYON_EDGE = TerrestriaBiomes.register("canyon_edge", template.builder()
			.configureSurfaceBuilder(TerrestriaSurfaces.SANDSTONE_CLIFF, TerrestriaSurfaces.SANDSTONE_CONFIG)
			.build(), Type.OVERWORLD, Type.DRY, Type.HOT, Type.SANDY, Type.HILLS);
	}
}

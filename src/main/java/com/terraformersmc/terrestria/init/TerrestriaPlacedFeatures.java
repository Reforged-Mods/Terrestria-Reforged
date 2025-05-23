package com.terraformersmc.terrestria.init;

import com.google.common.collect.ImmutableList;
import com.terraformersmc.terrestria.Terrestria;
import com.terraformersmc.terrestria.init.helpers.SurfaceLevelFilterPlacementModifier;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DataPool;
import net.minecraft.util.math.Direction;
import net.minecraft.world.Heightmap;
import net.minecraft.world.gen.blockpredicate.BlockPredicate;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.feature.RandomFeatureConfig;
import net.minecraft.world.gen.feature.RandomFeatureEntry;
import net.minecraft.world.gen.feature.RandomPatchFeatureConfig;
import net.minecraft.world.gen.feature.SimpleBlockFeatureConfig;
import net.minecraft.world.gen.feature.TreeConfiguredFeatures;
import net.minecraft.world.gen.feature.TreePlacedFeatures;
import net.minecraft.world.gen.feature.VegetationConfiguredFeatures;
import net.minecraft.world.gen.placementmodifier.BiomePlacementModifier;
import net.minecraft.world.gen.placementmodifier.BlockFilterPlacementModifier;
import net.minecraft.world.gen.placementmodifier.CountPlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;
import net.minecraft.world.gen.placementmodifier.RarityFilterPlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;
import net.minecraft.world.gen.placementmodifier.SurfaceWaterDepthFilterPlacementModifier;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("UnstableApiUsage")
public class TerrestriaPlacedFeatures {
	public static final RegistryKey<PlacedFeature> CATTAILS_WARM = createRegistryKey("cattails_warm");
	public static final RegistryKey<PlacedFeature> SPARSE_OAK_SHRUBS = createRegistryKey("sparse_oak_shrubs");
	public static final RegistryKey<PlacedFeature> PATCH_LUSH_FERNS = createRegistryKey("patch_lush_ferns");
	private static final RegistryKey<ConfiguredFeature<?, ?>> PATCH_VOLCANIC_ISLAND_GRASS_CONFIGURED = TerrestriaConfiguredFeatures.createRegistryKey("patch_volcanic_island_grass");
	public static final RegistryKey<PlacedFeature> PATCH_VOLCANIC_ISLAND_GRASS = createRegistryKey("patch_volcanic_island_grass");
	private static final RegistryKey<ConfiguredFeature<?, ?>> PATCH_DEAD_GRASS_CONFIGURED = TerrestriaConfiguredFeatures.createRegistryKey("patch_dead_grass");
	public static final RegistryKey<PlacedFeature> PATCH_DEAD_GRASS = createRegistryKey("patch_dead_grass");
	private static final RegistryKey<ConfiguredFeature<?, ?>> PATCH_OUTBACK_BUSHLAND_GRASS_CONFIGURED = TerrestriaConfiguredFeatures.createRegistryKey("patch_outback_bushland_grass");
	public static final RegistryKey<PlacedFeature> PATCH_OUTBACK_BUSHLAND_GRASS = createRegistryKey("patch_outback_bushland_grass");
	private static final RegistryKey<ConfiguredFeature<?, ?>> PATCH_OASIS_VEGETATION_CONFIGURED = TerrestriaConfiguredFeatures.createRegistryKey("patch_oasis_vegetation");
	public static final RegistryKey<PlacedFeature> PATCH_OASIS_VEGETATION = createRegistryKey("patch_oasis_vegetation");
	private static final RegistryKey<ConfiguredFeature<?, ?>> PATCH_LUSH_DESERT_VEGETATION_CONFIGURED = TerrestriaConfiguredFeatures.createRegistryKey("patch_lush_desert_vegetation");
	public static final RegistryKey<PlacedFeature> PATCH_LUSH_DESERT_VEGETATION = createRegistryKey("patch_lush_desert_vegetation");
	public static final RegistryKey<PlacedFeature> SPARSE_FALLEN_HEMLOCK_LOGS = createRegistryKey("sparse_fallen_hemlock_logs");
	public static final RegistryKey<PlacedFeature> SPARSE_FALLEN_REDWOOD_LOGS = createRegistryKey("sparse_fallen_redwood_logs");
	public static final RegistryKey<PlacedFeature> FALLEN_HEMLOCK_LOGS = createRegistryKey("fallen_hemlock_logs");
	public static final RegistryKey<PlacedFeature> FALLEN_REDWOOD_LOGS = createRegistryKey("fallen_redwood_logs");
	public static final RegistryKey<PlacedFeature> DENSE_FALLEN_HEMLOCK_LOGS = createRegistryKey("dense_fallen_hemlock_logs");
	public static final RegistryKey<PlacedFeature> DENSE_FALLEN_REDWOOD_LOGS = createRegistryKey("dense_fallen_redwood_logs");
	public static final RegistryKey<PlacedFeature> SPARSE_SMALL_HEMLOCK_TREES = createRegistryKey("sparse_small_hemlock_trees");
	public static final RegistryKey<PlacedFeature> SPARSE_SMALL_REDWOOD_TREES = createRegistryKey("sparse_small_redwood_trees");
	public static final RegistryKey<PlacedFeature> CALDERA_SMALL_HEMLOCK_TREES = createRegistryKey("caldera_small_hemlock_trees");
	public static final RegistryKey<PlacedFeature> CALDERA_SMALL_REDWOOD_TREES = createRegistryKey("caldera_small_redwood_trees");
	public static final RegistryKey<PlacedFeature> SMALL_HEMLOCK_TREES = createRegistryKey("small_hemlock_trees");
	public static final RegistryKey<PlacedFeature> SMALL_REDWOOD_TREES = createRegistryKey("small_redwood_trees");
	public static final RegistryKey<PlacedFeature> SPARSE_HEMLOCK_TREES = createRegistryKey("sparse_hemlock_trees");
	public static final RegistryKey<PlacedFeature> SPARSE_REDWOOD_TREES = createRegistryKey("sparse_redwood_trees");
	public static final RegistryKey<PlacedFeature> CALDERA_HEMLOCK_TREES = createRegistryKey("caldera_hemlock_trees");
	public static final RegistryKey<PlacedFeature> CALDERA_REDWOOD_TREES = createRegistryKey("caldera_redwood_trees");
	public static final RegistryKey<PlacedFeature> HEMLOCK_TREES = createRegistryKey("hemlock_trees");
	public static final RegistryKey<PlacedFeature> REDWOOD_TREES = createRegistryKey("redwood_trees");
	public static final RegistryKey<PlacedFeature> DENSE_HEMLOCK_TREES = createRegistryKey("dense_hemlock_trees");
	public static final RegistryKey<PlacedFeature> DENSE_REDWOOD_TREES = createRegistryKey("dense_redwood_trees");
	public static final RegistryKey<PlacedFeature> DENSEST_HEMLOCK_TREES = createRegistryKey("densest_hemlock_trees");
	public static final RegistryKey<PlacedFeature> DENSEST_REDWOOD_TREES = createRegistryKey("densest_redwood_trees");
	public static final RegistryKey<PlacedFeature> SPARSE_MEGA_HEMLOCK_TREES = createRegistryKey("sparse_mega_hemlock_trees");
	public static final RegistryKey<PlacedFeature> SPARSE_MEGA_REDWOOD_TREES = createRegistryKey("sparse_mega_redwood_trees");
	public static final RegistryKey<PlacedFeature> MEGA_HEMLOCK_TREES = createRegistryKey("mega_hemlock_trees");
	public static final RegistryKey<PlacedFeature> MEGA_REDWOOD_TREES = createRegistryKey("mega_redwood_trees");
	public static final RegistryKey<PlacedFeature> DENSEST_MEGA_HEMLOCK_TREES = createRegistryKey("densest_mega_hemlock_trees");
	public static final RegistryKey<PlacedFeature> DENSEST_MEGA_REDWOOD_TREES = createRegistryKey("densest_mega_redwood_trees");
	public static final RegistryKey<PlacedFeature> DENSE_FANCY_OAK_TREES = createRegistryKey("dense_fancy_oak_trees");
	public static final RegistryKey<PlacedFeature> DENSER_FANCY_OAK_TREES = createRegistryKey("denser_fancy_oak_trees");
	public static final RegistryKey<PlacedFeature> DENSEST_FANCY_OAK_TREES = createRegistryKey("densest_fancy_oak_trees");
	public static final RegistryKey<PlacedFeature> JUNGLE_PALM_TREES = createRegistryKey("jungle_palm_trees");
	public static final RegistryKey<PlacedFeature> DENSER_JUNGLE_PALM_TREES = createRegistryKey("denser_jungle_palm_trees");
	public static final RegistryKey<PlacedFeature> RARE_DUM_DUM_HEADS = createRegistryKey("rare_dum_dum_heads");
	public static final RegistryKey<PlacedFeature> DENSE_JAPANESE_MAPLE_TREES = createRegistryKey("dense_japanese_maple_trees");
	public static final RegistryKey<PlacedFeature> DENSE_DARK_JAPANESE_MAPLE_TREES = createRegistryKey("dense_dark_japanese_maple_trees");
	public static final RegistryKey<PlacedFeature> DENSE_JAPANESE_MAPLE_SHRUBS = createRegistryKey("dense_japanese_maple_shrubs");
	public static final RegistryKey<PlacedFeature> DENSER_SAKURA_TREES = createRegistryKey("denser_sakura_trees");
	public static final RegistryKey<PlacedFeature> DENSEST_CYPRESS_TREES = createRegistryKey("densest_cypress_trees");
	public static final RegistryKey<PlacedFeature> DENSER_RAINBOW_EUCALYPTUS_TREES = createRegistryKey("denser_rainbow_eucalyptus_trees");
	public static final RegistryKey<PlacedFeature> DENSE_RUBBER_TREES = createRegistryKey("dense_rubber_trees");
	public static final RegistryKey<PlacedFeature> MEGA_CYPRESS_TREES = createRegistryKey("mega_cypress_trees");
	public static final RegistryKey<PlacedFeature> SPARSE_WILLOW_TREES = createRegistryKey("sparse_willow_trees");
	static final RegistryKey<PlacedFeature> OUTBACK_YUCCA_PALM = createRegistryKey("outback_yucca_palm");
	static final RegistryKey<ConfiguredFeature<?, ?>> OUTBACK_BUSHLAND_TREES_CONFIGURED = TerrestriaConfiguredFeatures.createRegistryKey("outback_bushland_trees");
	public static final RegistryKey<PlacedFeature> OUTBACK_BUSHLAND_TREES = createRegistryKey("outback_bushland_trees");
	public static final RegistryKey<PlacedFeature> RARE_YUCCA_PALM_TREES = createRegistryKey("yucca_palm_trees");
	public static final RegistryKey<PlacedFeature> ACACIA_DOT_SHRUBS = createRegistryKey("acacia_dot_shrubs");
	public static final RegistryKey<PlacedFeature> OAK_DOT_SHRUBS = createRegistryKey("oak_dot_shrubs");
	public static final RegistryKey<PlacedFeature> SAGUARO_CACTUSES = createRegistryKey("saguaro_cactuses");
	public static final RegistryKey<PlacedFeature> RARE_BRYCE_TREES = createRegistryKey("rare_bryce_trees");

	public static void populate(Registerable<PlacedFeature> entries) {
		final BlockPredicate ON_DIRT = BlockPredicate.matchingBlockTag(Direction.DOWN.getVector(), BlockTags.DIRT);
		final BlockPredicate ON_SAND = BlockPredicate.matchingBlockTag(Direction.DOWN.getVector(), BlockTags.SAND);
		final BlockPredicate ON_DIRT_OR_SAND = BlockPredicate.eitherOf(ON_DIRT, ON_SAND);

		// Terrestria Decorated Features

		entries.register(CATTAILS_WARM, placeFeature(entries, TerrestriaConfiguredFeatures.CATTAIL,
			CountPlacementModifier.of(80),
			SquarePlacementModifier.of(),
			PlacedFeatures.OCEAN_FLOOR_HEIGHTMAP,
			BlockFilterPlacementModifier.of(ON_DIRT_OR_SAND)));

		entries.register(SPARSE_OAK_SHRUBS, placeFeatureWithoutBiomeFilter(entries, TerrestriaConfiguredFeatures.OAK_SHRUB,
			PlacedFeatures.createCountExtraModifier(1, 0.1f, 1),
			SquarePlacementModifier.of(),
			PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
			BlockFilterPlacementModifier.of(ON_DIRT)));

		entries.register(PATCH_LUSH_FERNS, placeFeature(entries, VegetationConfiguredFeatures.PATCH_TAIGA_GRASS,
			CountPlacementModifier.of(16),
			SquarePlacementModifier.of(),
			PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
			BlockFilterPlacementModifier.of(ON_DIRT)));

		entries.add(PATCH_VOLCANIC_ISLAND_GRASS_CONFIGURED, TerrestriaConfiguredFeatures.configureFeature(Feature.RANDOM_PATCH,
			new RandomPatchFeatureConfig(32, 15, 3, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(
					new WeightedBlockStateProvider(createStatePoolBuilder()
							.add(Blocks.GRASS.getDefaultState(), 1)
							.add(Blocks.FERN.getDefaultState(), 1)
							.add(TerrestriaBlocks.INDIAN_PAINTBRUSH.getDefaultState(), 1)
							.add(TerrestriaBlocks.MONSTERAS.getDefaultState(), 4)
							.build())),
					BlockPredicate.IS_AIR))));
		entries.register(PATCH_VOLCANIC_ISLAND_GRASS, placeFeature(entries, PATCH_VOLCANIC_ISLAND_GRASS_CONFIGURED,
			CountPlacementModifier.of(12),
			SquarePlacementModifier.of(),
			PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
			BlockFilterPlacementModifier.of(ON_DIRT)));

		entries.add(PATCH_DEAD_GRASS_CONFIGURED, TerrestriaConfiguredFeatures.configureFeature(Feature.RANDOM_PATCH,
			new RandomPatchFeatureConfig(4, 15, 3, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(
					BlockStateProvider.of(TerrestriaBlocks.DEAD_GRASS.getDefaultState())),
					BlockPredicate.IS_AIR))));
		entries.register(PATCH_DEAD_GRASS, placeFeature(entries, PATCH_DEAD_GRASS_CONFIGURED,
			CountPlacementModifier.of(12),
			SquarePlacementModifier.of(),
			PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
			BlockFilterPlacementModifier.of(ON_DIRT_OR_SAND)));

		entries.add(PATCH_OUTBACK_BUSHLAND_GRASS_CONFIGURED, TerrestriaConfiguredFeatures.configureFeature(Feature.RANDOM_PATCH,
			new RandomPatchFeatureConfig(4, 15, 3, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(
							new WeightedBlockStateProvider(createStatePoolBuilder()
									.add(TerrestriaBlocks.DEAD_GRASS.getDefaultState(), 3)
									.add(TerrestriaBlocks.AGAVE.getDefaultState(), 1)
									.build())),
					BlockPredicate.IS_AIR))));
		entries.register(PATCH_OUTBACK_BUSHLAND_GRASS, placeFeature(entries, PATCH_OUTBACK_BUSHLAND_GRASS_CONFIGURED,
			CountPlacementModifier.of(12),
			SquarePlacementModifier.of(),
			PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
			BlockFilterPlacementModifier.of(ON_DIRT_OR_SAND)));

		entries.add(PATCH_OASIS_VEGETATION_CONFIGURED, TerrestriaConfiguredFeatures.configureFeature(Feature.RANDOM_PATCH,
			new RandomPatchFeatureConfig(32, 15, 3, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(
							new WeightedBlockStateProvider(createStatePoolBuilder()
									.add(Blocks.FERN.getDefaultState(), 1)
									.add(Blocks.GRASS.getDefaultState(), 2)
									.add(TerrestriaBlocks.TINY_CACTUS.getDefaultState(), 1)
									.add(TerrestriaBlocks.AGAVE.getDefaultState(), 1)
									.add(TerrestriaBlocks.ALOE_VERA.getDefaultState(), 1)
									.build())),
					BlockPredicate.IS_AIR))));
		entries.register(PATCH_OASIS_VEGETATION, placeFeature(entries, PATCH_OASIS_VEGETATION_CONFIGURED,
			CountPlacementModifier.of(6),
			SquarePlacementModifier.of(),
			PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
			BlockFilterPlacementModifier.of(ON_DIRT_OR_SAND)));

		entries.add(PATCH_LUSH_DESERT_VEGETATION_CONFIGURED, TerrestriaConfiguredFeatures.configureFeature(Feature.RANDOM_PATCH,
			new RandomPatchFeatureConfig(32, 15, 3, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(
							new WeightedBlockStateProvider(createStatePoolBuilder()
									.add(TerrestriaBlocks.DEAD_GRASS.getDefaultState(), 2)
									.add(Blocks.DEAD_BUSH.getDefaultState(), 1)
									.add(TerrestriaBlocks.TINY_CACTUS.getDefaultState(), 1)
									.build())),
					BlockPredicate.IS_AIR))));
		entries.register(PATCH_LUSH_DESERT_VEGETATION, placeFeature(entries, PATCH_LUSH_DESERT_VEGETATION_CONFIGURED,
			CountPlacementModifier.of(4),
			SquarePlacementModifier.of(),
			PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
			BlockFilterPlacementModifier.of(ON_DIRT_OR_SAND)));

		entries.register(SPARSE_FALLEN_HEMLOCK_LOGS, placeTreeFeature(entries, 1, ON_DIRT, TerrestriaConfiguredFeatures.FALLEN_HEMLOCK_LOG));

		entries.register(SPARSE_FALLEN_REDWOOD_LOGS, placeTreeFeature(entries, 1, ON_DIRT, TerrestriaConfiguredFeatures.FALLEN_REDWOOD_LOG));

		entries.register(FALLEN_HEMLOCK_LOGS, placeTreeFeature(entries, 2, ON_DIRT, TerrestriaConfiguredFeatures.FALLEN_HEMLOCK_LOG));

		entries.register(FALLEN_REDWOOD_LOGS, placeTreeFeature(entries, 2, ON_DIRT, TerrestriaConfiguredFeatures.FALLEN_REDWOOD_LOG));

		entries.register(DENSE_FALLEN_HEMLOCK_LOGS, placeTreeFeature(entries, 4, ON_DIRT, TerrestriaConfiguredFeatures.FALLEN_HEMLOCK_LOG));

		entries.register(DENSE_FALLEN_REDWOOD_LOGS, placeTreeFeature(entries, 4, ON_DIRT, TerrestriaConfiguredFeatures.FALLEN_REDWOOD_LOG));

		entries.register(SPARSE_SMALL_HEMLOCK_TREES, placeTreeFeature(entries, 1, ON_DIRT, TerrestriaConfiguredFeatures.SMALL_HEMLOCK_TREE));

		entries.register(SPARSE_SMALL_REDWOOD_TREES, placeTreeFeature(entries, 1, ON_DIRT, TerrestriaConfiguredFeatures.SMALL_REDWOOD_TREE));

		entries.register(CALDERA_SMALL_HEMLOCK_TREES, placeFeature(entries, TerrestriaConfiguredFeatures.SMALL_HEMLOCK_TREE,
			PlacedFeatures.createCountExtraModifier(1, 0.1f, 1),
			SquarePlacementModifier.of(),
			SurfaceLevelFilterPlacementModifier.of(Heightmap.Type.WORLD_SURFACE_WG, 80, 320),
			PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
			BlockFilterPlacementModifier.of(ON_DIRT)));

		entries.register(CALDERA_SMALL_REDWOOD_TREES, placeFeature(entries, TerrestriaConfiguredFeatures.SMALL_REDWOOD_TREE,
			PlacedFeatures.createCountExtraModifier(1, 0.1f, 1),
			SquarePlacementModifier.of(),
			SurfaceLevelFilterPlacementModifier.of(Heightmap.Type.WORLD_SURFACE_WG, 80, 320),
			PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
			BlockFilterPlacementModifier.of(ON_DIRT)));

		entries.register(SMALL_HEMLOCK_TREES, placeTreeFeature(entries, 2, ON_DIRT, TerrestriaConfiguredFeatures.SMALL_HEMLOCK_TREE));

		entries.register(SMALL_REDWOOD_TREES, placeTreeFeature(entries, 2, ON_DIRT, TerrestriaConfiguredFeatures.SMALL_REDWOOD_TREE));

		entries.register(SPARSE_HEMLOCK_TREES, placeTreeFeature(entries, 1, ON_DIRT, TerrestriaConfiguredFeatures.HEMLOCK_TREE));

		entries.register(SPARSE_REDWOOD_TREES, placeTreeFeature(entries, 1, ON_DIRT, TerrestriaConfiguredFeatures.REDWOOD_TREE));

		entries.register(CALDERA_HEMLOCK_TREES, placeFeature(entries, TerrestriaConfiguredFeatures.HEMLOCK_TREE,
			PlacedFeatures.createCountExtraModifier(1, 0.1f, 1),
			SquarePlacementModifier.of(),
			SurfaceLevelFilterPlacementModifier.of(Heightmap.Type.WORLD_SURFACE_WG, 64, 100),
			PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
			BlockFilterPlacementModifier.of(ON_DIRT)));

		entries.register(CALDERA_REDWOOD_TREES, placeFeature(entries, TerrestriaConfiguredFeatures.REDWOOD_TREE,
			PlacedFeatures.createCountExtraModifier(1, 0.1f, 1),
			SquarePlacementModifier.of(),
			SurfaceLevelFilterPlacementModifier.of(Heightmap.Type.WORLD_SURFACE_WG, 64, 100),
			PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
			BlockFilterPlacementModifier.of(ON_DIRT)));

		entries.register(HEMLOCK_TREES, placeTreeFeature(entries, 2, ON_DIRT, TerrestriaConfiguredFeatures.HEMLOCK_TREE));

		entries.register(REDWOOD_TREES, placeTreeFeature(entries, 2, ON_DIRT, TerrestriaConfiguredFeatures.REDWOOD_TREE));

		entries.register(DENSE_HEMLOCK_TREES, placeTreeFeature(entries, 4, ON_DIRT, TerrestriaConfiguredFeatures.HEMLOCK_TREE));

		entries.register(DENSE_REDWOOD_TREES, placeTreeFeature(entries, 3, ON_DIRT, TerrestriaConfiguredFeatures.REDWOOD_TREE));

		entries.register(DENSEST_HEMLOCK_TREES, placeTreeFeature(entries, 8, ON_DIRT, TerrestriaConfiguredFeatures.HEMLOCK_TREE));

		entries.register(DENSEST_REDWOOD_TREES, placeTreeFeature(entries, 6, ON_DIRT, TerrestriaConfiguredFeatures.REDWOOD_TREE));

		entries.register(SPARSE_MEGA_HEMLOCK_TREES, placeTreeFeature(entries, 1, ON_DIRT, TerrestriaConfiguredFeatures.MEGA_HEMLOCK_TREE));

		entries.register(SPARSE_MEGA_REDWOOD_TREES, placeTreeFeature(entries, 1, ON_DIRT, TerrestriaConfiguredFeatures.MEGA_REDWOOD_TREE));

		entries.register(MEGA_HEMLOCK_TREES, placeTreeFeature(entries, 4, ON_DIRT, TerrestriaConfiguredFeatures.MEGA_HEMLOCK_TREE));

		entries.register(MEGA_REDWOOD_TREES, placeTreeFeature(entries, 4, ON_DIRT, TerrestriaConfiguredFeatures.MEGA_REDWOOD_TREE));

		entries.register(DENSEST_MEGA_HEMLOCK_TREES, placeTreeFeature(entries, 8, ON_DIRT, TerrestriaConfiguredFeatures.MEGA_HEMLOCK_TREE));

		entries.register(DENSEST_MEGA_REDWOOD_TREES, placeTreeFeature(entries, 7, ON_DIRT, TerrestriaConfiguredFeatures.MEGA_REDWOOD_TREE));

		entries.register(DENSE_FANCY_OAK_TREES, placeTreeFeature(entries, 3, ON_DIRT, TreeConfiguredFeatures.FANCY_OAK));

		entries.register(DENSER_FANCY_OAK_TREES, placeTreeFeature(entries, 5, ON_DIRT, TreeConfiguredFeatures.FANCY_OAK));

		entries.register(DENSEST_FANCY_OAK_TREES, placeTreeFeature(entries, 7, ON_DIRT, TreeConfiguredFeatures.FANCY_OAK));

		entries.register(JUNGLE_PALM_TREES, placeFeature(entries, TerrestriaConfiguredFeatures.JUNGLE_PALM_TREE,
			PlacedFeatures.createCountExtraModifier(2, 0.1f, 1),
			SquarePlacementModifier.of(),
			SurfaceLevelFilterPlacementModifier.of(Heightmap.Type.WORLD_SURFACE_WG, 62, 71),
			PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
			BlockFilterPlacementModifier.of(ON_DIRT_OR_SAND)));

		entries.register(DENSER_JUNGLE_PALM_TREES, placeFeature(entries, TerrestriaConfiguredFeatures.JUNGLE_PALM_TREE,
			PlacedFeatures.createCountExtraModifier(5, 0.1f, 1),
			SquarePlacementModifier.of(),
			SurfaceLevelFilterPlacementModifier.of(Heightmap.Type.WORLD_SURFACE_WG, 72, 320),
			PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
			BlockFilterPlacementModifier.of(ON_DIRT_OR_SAND)));

		entries.register(RARE_DUM_DUM_HEADS, placeFeature(entries, TerrestriaConfiguredFeatures.DUM_DUM_HEAD,
			PlacedFeatures.createCountExtraModifier(0, 0.1f, 1),
			SquarePlacementModifier.of(),
			SurfaceLevelFilterPlacementModifier.of(Heightmap.Type.WORLD_SURFACE_WG, 62, 64),
			PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
			BlockFilterPlacementModifier.of(ON_DIRT_OR_SAND)));

		entries.register(DENSE_JAPANESE_MAPLE_TREES, placeTreeFeature(entries, 3, ON_DIRT, TerrestriaConfiguredFeatures.JAPANESE_MAPLE_TREE));

		entries.register(DENSE_DARK_JAPANESE_MAPLE_TREES, placeTreeFeature(entries, 3, ON_DIRT, TerrestriaConfiguredFeatures.DARK_JAPANESE_MAPLE_TREE));

		entries.register(DENSE_JAPANESE_MAPLE_SHRUBS, placeTreeFeature(entries, 3, ON_DIRT, TerrestriaConfiguredFeatures.JAPANESE_MAPLE_SHRUB));

		entries.register(DENSER_SAKURA_TREES, placeTreeFeature(entries, 6, ON_DIRT, TerrestriaConfiguredFeatures.SAKURA_TREE));

		entries.register(DENSEST_CYPRESS_TREES, placeTreeFeature(entries, 9, ON_DIRT, TerrestriaConfiguredFeatures.CYPRESS_TREE));

		entries.register(DENSER_RAINBOW_EUCALYPTUS_TREES, placeTreeFeature(entries, 5, 3, ON_DIRT, TerrestriaConfiguredFeatures.RAINBOW_EUCALYPTUS_TREE));

		entries.register(DENSE_RUBBER_TREES, placeTreeFeature(entries, 3, ON_DIRT, TerrestriaConfiguredFeatures.RUBBER_TREE));

		entries.register(MEGA_CYPRESS_TREES, placeTreeFeature(entries, 2, 6, ON_DIRT, TerrestriaConfiguredFeatures.MEGA_CYPRESS_TREE));

		entries.register(SPARSE_WILLOW_TREES, placeTreeFeature(entries, 1, ON_DIRT_OR_SAND, TerrestriaConfiguredFeatures.WILLOW_TREE));

		entries.register(OUTBACK_YUCCA_PALM, placeFeatureWithoutBiomeFilter(entries, TerrestriaConfiguredFeatures.YUCCA_PALM_TREE));

		entries.register(OUTBACK_BUSHLAND_TREES, placeTreeFeature(entries, 2, ON_DIRT_OR_SAND, OUTBACK_BUSHLAND_TREES_CONFIGURED));

		entries.register(RARE_YUCCA_PALM_TREES, placeTreeFeature(entries, 0, ON_DIRT_OR_SAND, TerrestriaConfiguredFeatures.YUCCA_PALM_TREE));

		entries.register(ACACIA_DOT_SHRUBS, placeTreeFeature(entries, 2, ON_DIRT_OR_SAND, TerrestriaConfiguredFeatures.ACACIA_DOT_SHRUB));

		entries.register(OAK_DOT_SHRUBS, placeTreeFeature(entries, 2, ON_DIRT_OR_SAND, TerrestriaConfiguredFeatures.OAK_DOT_SHRUB));

		entries.register(SAGUARO_CACTUSES, placeTreeFeature(entries, 2, ON_SAND, TerrestriaConfiguredFeatures.SAGUARO_CACTUS));

		entries.register(RARE_BRYCE_TREES, placeFeature(entries, TerrestriaConfiguredFeatures.BRYCE_TREE,
			RarityFilterPlacementModifier.of(2),
			SquarePlacementModifier.of(),
			SurfaceLevelFilterPlacementModifier.of(Heightmap.Type.WORLD_SURFACE_WG, 80, 320),
			PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
			BlockFilterPlacementModifier.of(ON_DIRT_OR_SAND)));
	}

	private static DataPool.Builder<BlockState> createStatePoolBuilder() {
		return DataPool.builder();
	}

	public static RegistryKey<PlacedFeature> createRegistryKey(String name) {
		return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(Terrestria.MOD_ID, name));
	}

	public static PlacedFeature placeTreeFeature(Registerable<PlacedFeature> entries, int count, BlockPredicate predicate, RegistryKey<ConfiguredFeature<?, ?>> feature) {
		return placeFeature(entries, feature,
				PlacedFeatures.createCountExtraModifier(count, 0.1f, 1),
				SquarePlacementModifier.of(),
				PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
				BlockFilterPlacementModifier.of(predicate));
	}

	public static PlacedFeature placeTreeFeature(Registerable<PlacedFeature> entries, int count, int maxWaterDepth, BlockPredicate predicate, RegistryKey<ConfiguredFeature<?, ?>> feature) {
		return placeFeature(entries, feature,
				PlacedFeatures.createCountExtraModifier(count, 0.1f, 1),
				SquarePlacementModifier.of(),
				PlacedFeatures.OCEAN_FLOOR_HEIGHTMAP,
				SurfaceWaterDepthFilterPlacementModifier.of(maxWaterDepth),
				BlockFilterPlacementModifier.of(predicate));
	}

	private static PlacedFeature placeFeature(Registerable<PlacedFeature> entries, RegistryKey<ConfiguredFeature<?, ?>> feature, PlacementModifier... placementModifiers) {
		List<PlacementModifier> list = new ArrayList<>(List.of(placementModifiers));
		list.add(BiomePlacementModifier.of());
		return placeFeature(entries, feature, list);
	}

	private static PlacedFeature placeFeatureWithoutBiomeFilter(Registerable<PlacedFeature> entries, RegistryKey<ConfiguredFeature<?, ?>> feature, PlacementModifier... placementModifiers) {
		List<PlacementModifier> list = new ArrayList<>(List.of(placementModifiers));
		return placeFeature(entries, feature, list);
	}

	private static PlacedFeature placeFeature(Registerable<PlacedFeature> entries, RegistryKey<ConfiguredFeature<?, ?>> feature, List<PlacementModifier> list) {
		return new PlacedFeature(entries.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE).getOrThrow(feature), list);
	}

	public static void init() {
		// This just creates the registry keys.  Placed Features are requested and consumed by datagen now.
	}
}

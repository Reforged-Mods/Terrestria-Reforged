package com.terraformersmc.terrestria.init;

import com.terraformersmc.terraform.dirt.block.TerraformDirtPathBlock;
import com.terraformersmc.terraform.utils.TerraformBlockSettings;
import com.terraformersmc.terraform.utils.TerraformFlammableBlockRegistry;
import com.terraformersmc.terraform.wood.block.BareSmallLogBlock;
import com.terraformersmc.terraform.leaves.block.LeafPileBlock;
import com.terraformersmc.terraform.wood.block.SmallLogBlock;
import com.terraformersmc.terraform.tree.block.TerraformDesertSaplingBlock;
import com.terraformersmc.terraform.tree.block.TerraformSaplingBlock;
import com.terraformersmc.terraform.dirt.DirtBlocks;
import com.terraformersmc.terraform.dirt.TerraformDirtRegistry;
import com.terraformersmc.terraform.dirt.block.TerraformFarmlandBlock;
import com.terraformersmc.terraform.dirt.block.TerraformSnowyBlock;
import com.terraformersmc.terrestria.block.BasaltFlowerBlock;
import com.terraformersmc.terrestria.block.BasaltGrassBlock;
import com.terraformersmc.terrestria.block.PricklyDesertPlantBlock;
import com.terraformersmc.terrestria.block.SaguaroCactusBlock;
import com.terraformersmc.terrestria.block.TallCattailBlock;
import com.terraformersmc.terrestria.block.TerraformDesertPlantBlock;
import com.terraformersmc.terrestria.block.TerraformSeagrassBlock;
import com.terraformersmc.terrestria.block.sapling.TerrestriaLargeSaplingGenerator;
import com.terraformersmc.terrestria.block.sapling.TerrestriaSaplingGenerator;
import com.terraformersmc.terrestria.init.helpers.QuarteredWoodBlocks;
import com.terraformersmc.terrestria.init.helpers.StoneBlocks;
import com.terraformersmc.terrestria.init.helpers.TerrestriaRegistry;
import com.terraformersmc.terrestria.init.helpers.WoodBlocks;
import com.terraformersmc.terrestria.init.helpers.WoodColors;

import net.minecraft.block.*;
import net.minecraft.block.AbstractBlock.Settings;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.sound.BlockSoundGroup;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

import java.util.ArrayList;
import java.util.List;

// This class exports public block constants, these fields have to be public
@SuppressWarnings("WeakerAccess")
public class TerrestriaBlocks {

	public static QuarteredWoodBlocks REDWOOD;
	public static QuarteredWoodBlocks HEMLOCK;
	public static WoodBlocks RUBBER;
	public static QuarteredWoodBlocks CYPRESS;
	public static WoodBlocks WILLOW;
	public static WoodBlocks JAPANESE_MAPLE;
	public static QuarteredWoodBlocks RAINBOW_EUCALYPTUS;
	public static WoodBlocks SAKURA;
	public static WoodBlocks YUCCA_PALM;

	public static SmallLogBlock SMALL_OAK_LOG;
	public static SmallLogBlock STRIPPED_SMALL_OAK_LOG;
	public static BareSmallLogBlock SAGUARO_CACTUS;

	public static LeavesBlock JAPANESE_MAPLE_SHRUB_LEAVES;
	public static LeavesBlock DARK_JAPANESE_MAPLE_LEAVES;
	public static LeavesBlock JUNGLE_PALM_LEAVES;
	public static LeafPileBlock SAKURA_LEAF_PILE;

	public static SeagrassBlock CATTAIL;
	public static TallSeagrassBlock TALL_CATTAIL;

	public static TerraformSaplingBlock BRYCE_SAPLING;
	public static TerraformSaplingBlock REDWOOD_SAPLING;
	public static TerraformSaplingBlock HEMLOCK_SAPLING;
	public static TerraformSaplingBlock RUBBER_SAPLING;
	public static TerraformSaplingBlock CYPRESS_SAPLING;
	public static TerraformSaplingBlock WILLOW_SAPLING;
	public static TerraformSaplingBlock JAPANESE_MAPLE_SAPLING;
	public static TerraformSaplingBlock JAPANESE_MAPLE_SHRUB_SAPLING;
	public static TerraformSaplingBlock DARK_JAPANESE_MAPLE_SAPLING;
	public static TerraformSaplingBlock RAINBOW_EUCALYPTUS_SAPLING;
	public static TerraformSaplingBlock SAKURA_SAPLING;
	public static TerraformSaplingBlock JUNGLE_PALM_SAPLING;
	public static TerraformSaplingBlock SAGUARO_CACTUS_SAPLING;
	public static TerraformSaplingBlock YUCCA_PALM_SAPLING;

	public static FlowerPotBlock POTTED_BRYCE_SAPLING;
	public static FlowerPotBlock POTTED_REDWOOD_SAPLING;
	public static FlowerPotBlock POTTED_HEMLOCK_SAPLING;
	public static FlowerPotBlock POTTED_JUNGLE_PALM_SAPLING;
	public static FlowerPotBlock POTTED_RUBBER_SAPLING;
	public static FlowerPotBlock POTTED_CYPRESS_SAPLING;
	public static FlowerPotBlock POTTED_WILLOW_SAPLING;
	public static FlowerPotBlock POTTED_JAPANESE_MAPLE_SAPLING;
	public static FlowerPotBlock POTTED_JAPANESE_MAPLE_SHRUB_SAPLING;
	public static FlowerPotBlock POTTED_DARK_JAPANESE_MAPLE_SAPLING;
	public static FlowerPotBlock POTTED_RAINBOW_EUCALYPTUS_SAPLING;
	public static FlowerPotBlock POTTED_SAKURA_SAPLING;
	public static FlowerPotBlock POTTED_SAGUARO_CACTUS_SAPLING;
	public static FlowerPotBlock POTTED_YUCCA_PALM_SAPLING;

	// Volcanic Island blocks
	public static SandBlock BLACK_SAND;
	public static DirtBlocks ANDISOL;
	public static StoneBlocks VOLCANIC_ROCK;
	public static PlantBlock INDIAN_PAINTBRUSH;
	public static PlantBlock MONSTERAS;
	public static FlowerPotBlock POTTED_INDIAN_PAINTBRUSH;
	public static FlowerPotBlock POTTED_MONSTERAS;

	// Desert Plants
	public static PlantBlock TINY_CACTUS;
	public static PlantBlock AGAVE;
	public static PlantBlock ALOE_VERA;
	public static PlantBlock DEAD_GRASS;
	public static FlowerPotBlock POTTED_TINY_CACTUS;
	public static FlowerPotBlock POTTED_AGAVE;
	public static FlowerPotBlock POTTED_ALOE_VERA;

	public static void init() {

		REDWOOD = QuarteredWoodBlocks.register("redwood", WoodColors.REDWOOD, true);
		HEMLOCK = QuarteredWoodBlocks.register("hemlock", WoodColors.HEMLOCK, true);
		RUBBER = WoodBlocks.register("rubber", WoodColors.RUBBER);
		CYPRESS = QuarteredWoodBlocks.register("cypress", WoodColors.CYPRESS);
		WILLOW = WoodBlocks.register("willow", WoodColors.WILLOW);
		JAPANESE_MAPLE = WoodBlocks.register("japanese_maple", WoodColors.JAPANESE_MAPLE);
		RAINBOW_EUCALYPTUS = QuarteredWoodBlocks.register("rainbow_eucalyptus", WoodColors.RAINBOW_EUCALYPTUS);
		SAKURA = WoodBlocks.register("sakura", WoodColors.SAKURA, WoodBlocks.LogSize.SMALL);
		YUCCA_PALM = WoodBlocks.register("yucca_palm", WoodColors.YUCCA_PALM, WoodBlocks.LogSize.SMALL);

		STRIPPED_SMALL_OAK_LOG = TerrestriaRegistry.register("stripped_small_oak_log", new SmallLogBlock(Blocks.OAK_LEAVES, null, Settings.copy(Blocks.OAK_PLANKS)));
		SMALL_OAK_LOG = TerrestriaRegistry.register("small_oak_log", new SmallLogBlock(Blocks.OAK_LEAVES, () -> STRIPPED_SMALL_OAK_LOG, Settings.copy(Blocks.OAK_PLANKS)));
		SAGUARO_CACTUS = TerrestriaRegistry.register("saguaro_cactus", new SaguaroCactusBlock(null, Settings.copy(Blocks.CACTUS)));

		add(SMALL_OAK_LOG, 5, 5);
		add(STRIPPED_SMALL_OAK_LOG, 5, 5);

		JAPANESE_MAPLE_SHRUB_LEAVES = TerrestriaRegistry.register("japanese_maple_shrub_leaves", new LeavesBlock(TerraformBlockSettings.copy(Blocks.OAK_LEAVES).allowsSpawning(TerrestriaBlocks::canSpawnOnLeaves).suffocates(TerrestriaBlocks::never).blockVision(TerrestriaBlocks::never)));

		DARK_JAPANESE_MAPLE_LEAVES = TerrestriaRegistry.register("dark_japanese_maple_leaves",
				new LeavesBlock(TerraformBlockSettings.copy(Blocks.OAK_LEAVES).mapColor(MapColor.TERRACOTTA_RED).allowsSpawning(TerrestriaBlocks::canSpawnOnLeaves).suffocates(TerrestriaBlocks::never).blockVision(TerrestriaBlocks::never))
		);

		JUNGLE_PALM_LEAVES = TerrestriaRegistry.register("jungle_palm_leaves", new LeavesBlock(TerraformBlockSettings.copy(Blocks.OAK_LEAVES).allowsSpawning(TerrestriaBlocks::canSpawnOnLeaves).suffocates(TerrestriaBlocks::never).blockVision(TerrestriaBlocks::never)));

		SAKURA_LEAF_PILE = TerrestriaRegistry.register("sakura_leaf_pile", new LeafPileBlock(TerraformBlockSettings.of(Material.REPLACEABLE_PLANT).strength(0.025f, 0.1f).noCollision().sounds(BlockSoundGroup.GRASS).mapColor(MapColor.PINK)));

		add(JAPANESE_MAPLE_SHRUB_LEAVES, 30, 60);
		add(DARK_JAPANESE_MAPLE_LEAVES, 30, 60);
		add(JUNGLE_PALM_LEAVES, 30, 60);
		add(SAKURA_LEAF_PILE, 30, 60);

		TALL_CATTAIL = TerrestriaRegistry.register("tall_cattail", new TallCattailBlock(() -> TerrestriaItems.CATTAIL, Settings.copy(Blocks.SEAGRASS)));
		CATTAIL = TerrestriaRegistry.register("cattail", new TerraformSeagrassBlock(TALL_CATTAIL, Settings.copy(Blocks.SEAGRASS)));

		// Saplings
		Settings saplingSettings = Settings.of(Material.PLANT).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS);

		BRYCE_SAPLING = TerrestriaRegistry.register("bryce_sapling", new TerraformDesertSaplingBlock(new TerrestriaSaplingGenerator(() -> TerrestriaConfiguredFeatures.BRYCE_TREE), saplingSettings));
		REDWOOD_SAPLING = TerrestriaRegistry.register("redwood_sapling", new TerraformSaplingBlock(new TerrestriaLargeSaplingGenerator(() -> TerrestriaConfiguredFeatures.REDWOOD_TREE, () -> TerrestriaConfiguredFeatures.MEGA_REDWOOD_TREE), saplingSettings));
		HEMLOCK_SAPLING = TerrestriaRegistry.register("hemlock_sapling", new TerraformSaplingBlock(new TerrestriaLargeSaplingGenerator(() -> TerrestriaConfiguredFeatures.HEMLOCK_TREE, () -> TerrestriaConfiguredFeatures.MEGA_HEMLOCK_TREE), saplingSettings));
		RUBBER_SAPLING = TerrestriaRegistry.register("rubber_sapling", new TerraformSaplingBlock(new TerrestriaSaplingGenerator(() -> TerrestriaConfiguredFeatures.RUBBER_TREE), saplingSettings));
		CYPRESS_SAPLING = TerrestriaRegistry.register("cypress_sapling", new TerraformSaplingBlock(new TerrestriaLargeSaplingGenerator(() -> TerrestriaConfiguredFeatures.CYPRESS_TREE, () -> TerrestriaConfiguredFeatures.MEGA_CYPRESS_TREE), saplingSettings));
		WILLOW_SAPLING = TerrestriaRegistry.register("willow_sapling", new TerraformSaplingBlock(new TerrestriaSaplingGenerator(() -> TerrestriaConfiguredFeatures.WILLOW_TREE), saplingSettings));
		JAPANESE_MAPLE_SAPLING = TerrestriaRegistry.register("japanese_maple_sapling", new TerraformSaplingBlock(new TerrestriaSaplingGenerator(() -> TerrestriaConfiguredFeatures.JAPANESE_MAPLE_TREE), saplingSettings));
		JAPANESE_MAPLE_SHRUB_SAPLING = TerrestriaRegistry.register("japanese_maple_shrub_sapling", new TerraformSaplingBlock(new TerrestriaSaplingGenerator(() -> TerrestriaConfiguredFeatures.JAPANESE_MAPLE_SHRUB), saplingSettings));
		DARK_JAPANESE_MAPLE_SAPLING = TerrestriaRegistry.register("dark_japanese_maple_sapling", new TerraformSaplingBlock(new TerrestriaSaplingGenerator(() -> TerrestriaConfiguredFeatures.DARK_JAPANESE_MAPLE_TREE), saplingSettings));
		RAINBOW_EUCALYPTUS_SAPLING = TerrestriaRegistry.register("rainbow_eucalyptus_sapling", new TerraformSaplingBlock(new TerrestriaLargeSaplingGenerator(() -> TerrestriaConfiguredFeatures.SMALL_RAINBOW_EUCALYPTUS_SAPLING_TREE, () -> TerrestriaConfiguredFeatures.RAINBOW_EUCALYPTUS_TREE), saplingSettings));
		SAKURA_SAPLING = TerrestriaRegistry.register("sakura_sapling", new TerraformSaplingBlock(new TerrestriaSaplingGenerator(() -> TerrestriaConfiguredFeatures.SAKURA_TREE), saplingSettings));
		JUNGLE_PALM_SAPLING = TerrestriaRegistry.register("jungle_palm_sapling", new TerraformDesertSaplingBlock(new TerrestriaSaplingGenerator(() -> TerrestriaConfiguredFeatures.JUNGLE_PALM_TREE), saplingSettings));
		SAGUARO_CACTUS_SAPLING = TerrestriaRegistry.register("saguaro_cactus_sapling", new TerraformDesertSaplingBlock(new TerrestriaSaplingGenerator(() -> TerrestriaConfiguredFeatures.SAGUARO_CACTUS_FEATURE), saplingSettings, true));
		YUCCA_PALM_SAPLING = TerrestriaRegistry.register("yucca_palm_sapling", new TerraformDesertSaplingBlock(new TerrestriaSaplingGenerator(() -> TerrestriaConfiguredFeatures.YUCCA_PALM_TREE), saplingSettings));

		// Volcanic Island Blocks

		BLACK_SAND = TerrestriaRegistry.register("basalt_sand", new SandBlock(0x202020, TerraformBlockSettings.copy(Blocks.SAND).mapColor(MapColor.BLACK)));

		Block andisolDirt = TerrestriaRegistry.register("basalt_dirt", new Block(TerraformBlockSettings.copy(Blocks.DIRT).mapColor(MapColor.BLACK)));
		ANDISOL = TerraformDirtRegistry.register(new DirtBlocks (
			andisolDirt,
			TerrestriaRegistry.register("basalt_grass_block", new BasaltGrassBlock(andisolDirt, () -> ANDISOL.getDirtPath(), TerraformBlockSettings.copy(Blocks.GRASS_BLOCK))),
			TerrestriaRegistry.register("basalt_grass_path", new TerraformDirtPathBlock(andisolDirt, TerraformBlockSettings.copy(Blocks.DIRT_PATH))),
			TerrestriaRegistry.register("basalt_podzol", new TerraformSnowyBlock(TerraformBlockSettings.copy(Blocks.PODZOL))),
			TerrestriaRegistry.register("andisol_farmland", new TerraformFarmlandBlock(TerraformBlockSettings.copy(Blocks.FARMLAND).mapColor(MapColor.BLACK)))
		));
		VOLCANIC_ROCK = StoneBlocks.register("basalt", MapColor.BLACK);

		INDIAN_PAINTBRUSH = TerrestriaRegistry.register("indian_paintbrush", new BasaltFlowerBlock(StatusEffects.SATURATION, 4, Settings.copy(Blocks.POPPY)));
		MONSTERAS = TerrestriaRegistry.register("monsteras", new BasaltFlowerBlock(StatusEffects.REGENERATION, 2, Settings.copy(Blocks.TALL_GRASS)));

		POTTED_INDIAN_PAINTBRUSH = TerrestriaRegistry.register("potted_indian_paintbrush", new FlowerPotBlock(INDIAN_PAINTBRUSH, Settings.copy(Blocks.POTTED_POPPY)));
		POTTED_MONSTERAS = TerrestriaRegistry.register("potted_monsteras", new FlowerPotBlock(MONSTERAS, Settings.copy(Blocks.POTTED_POPPY)));

		POTTED_BRYCE_SAPLING = TerrestriaRegistry.register("potted_bryce_sapling", new FlowerPotBlock(BRYCE_SAPLING, Settings.copy(Blocks.POTTED_POPPY)));
		POTTED_REDWOOD_SAPLING = TerrestriaRegistry.register("potted_redwood_sapling", new FlowerPotBlock(REDWOOD_SAPLING, Settings.copy(Blocks.POTTED_POPPY)));
		POTTED_HEMLOCK_SAPLING = TerrestriaRegistry.register("potted_hemlock_sapling", new FlowerPotBlock(HEMLOCK_SAPLING, Settings.copy(Blocks.POTTED_POPPY)));
		POTTED_RUBBER_SAPLING = TerrestriaRegistry.register("potted_rubber_sapling", new FlowerPotBlock(RUBBER_SAPLING, Settings.copy(Blocks.POTTED_POPPY)));
		POTTED_CYPRESS_SAPLING = TerrestriaRegistry.register("potted_cypress_sapling", new FlowerPotBlock(CYPRESS_SAPLING, Settings.copy(Blocks.POTTED_POPPY)));
		POTTED_WILLOW_SAPLING = TerrestriaRegistry.register("potted_willow_sapling", new FlowerPotBlock(WILLOW_SAPLING, Settings.copy(Blocks.POTTED_POPPY)));
		POTTED_JAPANESE_MAPLE_SAPLING = TerrestriaRegistry.register("potted_japanese_maple_sapling", new FlowerPotBlock(JAPANESE_MAPLE_SAPLING, Settings.copy(Blocks.POTTED_POPPY)));
		POTTED_JAPANESE_MAPLE_SHRUB_SAPLING = TerrestriaRegistry.register("potted_japanese_maple_shrub_sapling", new FlowerPotBlock(JAPANESE_MAPLE_SHRUB_SAPLING, Settings.copy(Blocks.POTTED_POPPY)));
		POTTED_DARK_JAPANESE_MAPLE_SAPLING = TerrestriaRegistry.register("potted_dark_japanese_maple_sapling", new FlowerPotBlock(DARK_JAPANESE_MAPLE_SAPLING, Settings.copy(Blocks.POTTED_POPPY)));
		POTTED_RAINBOW_EUCALYPTUS_SAPLING = TerrestriaRegistry.register("potted_rainbow_eucalyptus_sapling", new FlowerPotBlock(RAINBOW_EUCALYPTUS_SAPLING, Settings.copy(Blocks.POTTED_POPPY)));
		POTTED_SAKURA_SAPLING = TerrestriaRegistry.register("potted_sakura_sapling", new FlowerPotBlock(SAKURA_SAPLING, Settings.copy(Blocks.POTTED_POPPY)));
		POTTED_JUNGLE_PALM_SAPLING = TerrestriaRegistry.register("potted_jungle_palm_sapling", new FlowerPotBlock(JUNGLE_PALM_SAPLING, Settings.copy(Blocks.POTTED_POPPY)));
		POTTED_SAGUARO_CACTUS_SAPLING = TerrestriaRegistry.register("potted_saguaro_cactus_sapling", new FlowerPotBlock(SAGUARO_CACTUS_SAPLING, Settings.copy(Blocks.POTTED_POPPY)));
		POTTED_YUCCA_PALM_SAPLING = TerrestriaRegistry.register("potted_yucca_palm_sapling", new FlowerPotBlock(YUCCA_PALM_SAPLING, Settings.copy(Blocks.POTTED_POPPY)));

		TINY_CACTUS = TerrestriaRegistry.register("tiny_cactus", new PricklyDesertPlantBlock(Settings.copy(Blocks.POPPY), true));
		AGAVE = TerrestriaRegistry.register("agave", new TerraformDesertPlantBlock(Settings.copy(Blocks.POPPY)));
		ALOE_VERA = TerrestriaRegistry.register("aloe_vera", new TerraformDesertPlantBlock(Settings.copy(Blocks.POPPY)));
		DEAD_GRASS = TerrestriaRegistry.register("dead_grass", new TerraformDesertPlantBlock(Settings.copy(Blocks.POPPY), true));
		POTTED_TINY_CACTUS = TerrestriaRegistry.register("potted_tiny_cactus", new FlowerPotBlock(TINY_CACTUS,Settings.copy(Blocks.POTTED_POPPY)));
		POTTED_AGAVE = TerrestriaRegistry.register("potted_agave", new FlowerPotBlock(AGAVE, Settings.copy(Blocks.POTTED_POPPY)));
		POTTED_ALOE_VERA = TerrestriaRegistry.register("potted_aloe_vera", new FlowerPotBlock(ALOE_VERA, Settings.copy(Blocks.POTTED_POPPY)));
	}

	public static boolean never(BlockState state, BlockView world, BlockPos pos) {
		return false;
	}
	public static Boolean canSpawnOnLeaves(BlockState state, BlockView world, BlockPos pos, EntityType<?> type) {
		return type == EntityType.OCELOT || type == EntityType.PARROT;
	}

	public static void add(Block block, int burn, int spread){
		TerraformFlammableBlockRegistry.addFlammableBlock(block, burn, spread);
	}
}

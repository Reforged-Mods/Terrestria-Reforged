package com.terraformersmc.terrestria.init;

import com.terraformersmc.terraform.utils.TerraformFuelRegistry;
import com.terraformersmc.terrestria.init.helpers.StoneItems;
import com.terraformersmc.terrestria.init.helpers.TerrestriaRegistry;
import com.terraformersmc.terrestria.init.helpers.WoodItems;
import com.terraformersmc.terrestria.item.LogTurnerItem;
import net.minecraft.block.ComposterBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;

// This class exports public item constants, these fields have to be public
@SuppressWarnings("WeakerAccess")
public class TerrestriaItems {
	public static WoodItems REDWOOD;
	public static WoodItems HEMLOCK;
	public static WoodItems RUBBER;
	public static WoodItems CYPRESS;
	public static WoodItems WILLOW;
	public static WoodItems JAPANESE_MAPLE;
	public static WoodItems RAINBOW_EUCALYPTUS;
	public static WoodItems SAKURA;
	public static WoodItems YUCCA_PALM;

	public static BlockItem SMALL_OAK_LOG;
	public static BlockItem STRIPPED_SMALL_OAK_LOG;
	public static BlockItem SAGUARO_CACTUS;

	public static BlockItem JAPANESE_MAPLE_SHRUB_LEAVES;
	public static BlockItem DARK_JAPANESE_MAPLE_LEAVES;
	public static BlockItem JUNGLE_PALM_LEAVES;

	public static BlockItem CATTAIL;

	public static BlockItem BRYCE_SAPLING;
	public static BlockItem REDWOOD_SAPLING;
	public static BlockItem HEMLOCK_SAPLING;
	public static BlockItem RUBBER_SAPLING;
	public static BlockItem CYPRESS_SAPLING;
	public static BlockItem WILLOW_SAPLING;
	public static BlockItem JAPANESE_MAPLE_SAPLING;
	public static BlockItem JAPANESE_MAPLE_SHRUB_SAPLING;
	public static BlockItem DARK_JAPANESE_MAPLE_SAPLING;
	public static BlockItem RAINBOW_EUCALYPTUS_SAPLING;
	public static BlockItem SAKURA_SAPLING;
	public static BlockItem JUNGLE_PALM_SAPLING;
	public static BlockItem SAGUARO_CACTUS_SAPLING;
	public static BlockItem YUCCA_PALM_SAPLING;

	public static StoneItems VOLCANIC_ROCK;
	public static BlockItem BLACK_SAND;
	public static BlockItem ANDISOL;
	public static BlockItem ANDISOL_GRASS_BLOCK;
	public static BlockItem ANDISOL_GRASS_PATH;
	public static BlockItem ANDISOL_PODZOL;
	public static BlockItem ANDISOL_FARMLAND;
	public static BlockItem INDIAN_PAINTBRUSH;
	public static BlockItem MONSTERAS;

	public static BlockItem TINY_CACTUS;
	public static BlockItem AGAVE;
	public static BlockItem ALOE_VERA;
	public static BlockItem DEAD_GRASS;

	public static LogTurnerItem LOG_TURNER;

	public static void init() {

		REDWOOD = WoodItems.register("redwood", TerrestriaBlocks.REDWOOD);
		HEMLOCK = WoodItems.register("hemlock", TerrestriaBlocks.HEMLOCK);
		RUBBER = WoodItems.register("rubber", TerrestriaBlocks.RUBBER);
		CYPRESS = WoodItems.register("cypress", TerrestriaBlocks.CYPRESS);
		WILLOW = WoodItems.register("willow", TerrestriaBlocks.WILLOW);
		JAPANESE_MAPLE = WoodItems.register("japanese_maple", TerrestriaBlocks.JAPANESE_MAPLE);
		RAINBOW_EUCALYPTUS = WoodItems.register("rainbow_eucalyptus", TerrestriaBlocks.RAINBOW_EUCALYPTUS);
		SAKURA = WoodItems.register("sakura", TerrestriaBlocks.SAKURA);
		YUCCA_PALM = WoodItems.register("yucca_palm", TerrestriaBlocks.YUCCA_PALM);

		SMALL_OAK_LOG = TerrestriaRegistry.registerBlockItem("small_oak_log", TerrestriaBlocks.SMALL_OAK_LOG);
		STRIPPED_SMALL_OAK_LOG = TerrestriaRegistry.registerBlockItem("stripped_small_oak_log", TerrestriaBlocks.STRIPPED_SMALL_OAK_LOG);
		SAGUARO_CACTUS = TerrestriaRegistry.registerBlockItem("saguaro_cactus", TerrestriaBlocks.SAGUARO_CACTUS);

		JAPANESE_MAPLE_SHRUB_LEAVES = TerrestriaRegistry.registerBlockItem("japanese_maple_shrub_leaves", TerrestriaBlocks.JAPANESE_MAPLE_SHRUB_LEAVES);
		DARK_JAPANESE_MAPLE_LEAVES = TerrestriaRegistry.registerBlockItem("dark_japanese_maple_leaves", TerrestriaBlocks.DARK_JAPANESE_MAPLE_LEAVES);
		JUNGLE_PALM_LEAVES = TerrestriaRegistry.registerBlockItem("jungle_palm_leaves", TerrestriaBlocks.JUNGLE_PALM_LEAVES);

		CATTAIL = TerrestriaRegistry.registerBlockItem("cattail", TerrestriaBlocks.CATTAIL);

		BRYCE_SAPLING = TerrestriaRegistry.registerBlockItem("bryce_sapling", TerrestriaBlocks.BRYCE_SAPLING);
		REDWOOD_SAPLING = TerrestriaRegistry.registerBlockItem("redwood_sapling", TerrestriaBlocks.REDWOOD_SAPLING);
		HEMLOCK_SAPLING = TerrestriaRegistry.registerBlockItem("hemlock_sapling", TerrestriaBlocks.HEMLOCK_SAPLING);
		RUBBER_SAPLING = TerrestriaRegistry.registerBlockItem("rubber_sapling", TerrestriaBlocks.RUBBER_SAPLING);
		CYPRESS_SAPLING = TerrestriaRegistry.registerBlockItem("cypress_sapling", TerrestriaBlocks.CYPRESS_SAPLING);
		WILLOW_SAPLING = TerrestriaRegistry.registerBlockItem("willow_sapling", TerrestriaBlocks.WILLOW_SAPLING);
		JAPANESE_MAPLE_SAPLING = TerrestriaRegistry.registerBlockItem("japanese_maple_sapling", TerrestriaBlocks.JAPANESE_MAPLE_SAPLING);
		JAPANESE_MAPLE_SHRUB_SAPLING = TerrestriaRegistry.registerBlockItem("japanese_maple_shrub_sapling", TerrestriaBlocks.JAPANESE_MAPLE_SHRUB_SAPLING);
		DARK_JAPANESE_MAPLE_SAPLING = TerrestriaRegistry.registerBlockItem("dark_japanese_maple_sapling", TerrestriaBlocks.DARK_JAPANESE_MAPLE_SAPLING);
		RAINBOW_EUCALYPTUS_SAPLING = TerrestriaRegistry.registerBlockItem("rainbow_eucalyptus_sapling", TerrestriaBlocks.RAINBOW_EUCALYPTUS_SAPLING);
		SAKURA_SAPLING = TerrestriaRegistry.registerBlockItem("sakura_sapling", TerrestriaBlocks.SAKURA_SAPLING);
		JUNGLE_PALM_SAPLING = TerrestriaRegistry.registerBlockItem("jungle_palm_sapling", TerrestriaBlocks.JUNGLE_PALM_SAPLING);
		SAGUARO_CACTUS_SAPLING = TerrestriaRegistry.registerBlockItem("saguaro_cactus_sapling", TerrestriaBlocks.SAGUARO_CACTUS_SAPLING);
		YUCCA_PALM_SAPLING = TerrestriaRegistry.registerBlockItem("yucca_palm_sapling", TerrestriaBlocks.YUCCA_PALM_SAPLING);

		VOLCANIC_ROCK = StoneItems.register("basalt", TerrestriaBlocks.VOLCANIC_ROCK);
		BLACK_SAND = TerrestriaRegistry.registerBlockItem("basalt_sand", TerrestriaBlocks.BLACK_SAND);
		ANDISOL = TerrestriaRegistry.registerBlockItem("basalt_dirt", TerrestriaBlocks.ANDISOL.getDirt());
		ANDISOL_FARMLAND = TerrestriaRegistry.registerBlockItem("andisol_farmland", TerrestriaBlocks.ANDISOL.getFarmland());
		ANDISOL_GRASS_BLOCK = TerrestriaRegistry.registerBlockItem("basalt_grass_block", TerrestriaBlocks.ANDISOL.getGrassBlock());
		ANDISOL_GRASS_PATH = TerrestriaRegistry.registerBlockItem("andisol_grass_path", TerrestriaBlocks.ANDISOL.getDirtPath());
		ANDISOL_PODZOL = TerrestriaRegistry.registerBlockItem("basalt_podzol", TerrestriaBlocks.ANDISOL.getPodzol());
		INDIAN_PAINTBRUSH = TerrestriaRegistry.registerBlockItem("indian_paintbrush", TerrestriaBlocks.INDIAN_PAINTBRUSH);
		MONSTERAS = TerrestriaRegistry.registerBlockItem("monsteras", TerrestriaBlocks.MONSTERAS);

		TINY_CACTUS = TerrestriaRegistry.registerBlockItem("tiny_cactus", TerrestriaBlocks.TINY_CACTUS);
		AGAVE = TerrestriaRegistry.registerBlockItem("agave", TerrestriaBlocks.AGAVE);
		ALOE_VERA = TerrestriaRegistry.registerBlockItem("aloe_vera", TerrestriaBlocks.ALOE_VERA);
		DEAD_GRASS = TerrestriaRegistry.registerBlockItem("dead_grass", TerrestriaBlocks.DEAD_GRASS);

		LOG_TURNER = TerrestriaRegistry.register("log_turner", new LogTurnerItem(new Item.Settings()));

		addCompostables();
		addFuels();
	}

	private static void addCompostables() {
		float CACTUS_CHANCE = ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.getFloat(Items.CACTUS);
		float FERN_CHANCE = ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.getFloat(Items.FERN);
		float FLOWER_CHANCE = ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.getFloat(Items.POPPY);
		float GRASS_CHANCE = ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.getFloat(Items.GRASS);
		float LEAVES_CHANCE = ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.getFloat(Items.OAK_LEAVES);
		float SAPLING_CHANCE = ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.getFloat(Items.OAK_SAPLING);
		float SEAGRASS_CHANCE = ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.getFloat(Items.SEAGRASS);

		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(DARK_JAPANESE_MAPLE_LEAVES, LEAVES_CHANCE);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(JAPANESE_MAPLE_SHRUB_LEAVES, LEAVES_CHANCE);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(JUNGLE_PALM_LEAVES, LEAVES_CHANCE);

		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(SAGUARO_CACTUS, CACTUS_CHANCE);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(TINY_CACTUS, CACTUS_CHANCE);

		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(CATTAIL, SEAGRASS_CHANCE);

		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(AGAVE, FLOWER_CHANCE);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ALOE_VERA, FLOWER_CHANCE);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(DEAD_GRASS, GRASS_CHANCE);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(INDIAN_PAINTBRUSH, FLOWER_CHANCE);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(MONSTERAS, FERN_CHANCE);

		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(BRYCE_SAPLING, SAPLING_CHANCE);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(CYPRESS_SAPLING, SAPLING_CHANCE);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(DARK_JAPANESE_MAPLE_SAPLING, SAPLING_CHANCE);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(HEMLOCK_SAPLING, SAPLING_CHANCE);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(JAPANESE_MAPLE_SAPLING, SAPLING_CHANCE);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(JAPANESE_MAPLE_SHRUB_SAPLING, SAPLING_CHANCE);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(JUNGLE_PALM_SAPLING, SAPLING_CHANCE);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(RAINBOW_EUCALYPTUS_SAPLING, SAPLING_CHANCE);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(REDWOOD_SAPLING, SAPLING_CHANCE);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(RUBBER_SAPLING, SAPLING_CHANCE);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(SAGUARO_CACTUS_SAPLING, SAPLING_CHANCE);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(SAKURA_SAPLING, SAPLING_CHANCE);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(WILLOW_SAPLING, SAPLING_CHANCE);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(YUCCA_PALM_SAPLING, SAPLING_CHANCE);
	}

	private static void addFuels() {
		TerraformFuelRegistry.addFuel(DEAD_GRASS, 100);
		TerraformFuelRegistry.addFuel(LOG_TURNER, 300);
	}
}

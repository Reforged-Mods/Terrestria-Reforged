package com.terraformersmc.terrestria.data;

import com.terraformersmc.terraform.dirt.DirtBlocks;
import com.terraformersmc.terrestria.init.TerrestriaBlocks;
import com.terraformersmc.terrestria.init.helpers.QuarteredWoodBlocks;
import com.terraformersmc.terrestria.init.helpers.StoneBlocks;
import com.terraformersmc.terrestria.init.helpers.StoneVariantBlocks;
import com.terraformersmc.terrestria.init.helpers.WoodBlocks;
import com.terraformersmc.terrestria.tag.TerrestriaBlockTags;
import net.devtech.arrp.json.tags.JTag;
import net.minecraft.block.Block;
import net.minecraft.block.SandBlock;
import net.minecraft.tag.BlockTags;
import net.minecraft.tag.TagKey;

import static com.terraformersmc.terrestria.data.TerrestriaDatagen.RUNTIME_RESOURCE_PACK;

public class TerrestriaBlockTagProvider {

	public static void init() {
		// basic block tags
		RUNTIME_RESOURCE_PACK.addTag(TerrestriaDatagen.tagID(BlockTags.HOE_MINEABLE), JTag.tag()
			.add(TerrestriaBlocks.DARK_JAPANESE_MAPLE_LEAVES.getRegistryName())
			.add(TerrestriaBlocks.JAPANESE_MAPLE_SHRUB_LEAVES.getRegistryName())
			.add(TerrestriaBlocks.JUNGLE_PALM_LEAVES.getRegistryName())
			.add(TerrestriaBlocks.SAKURA_LEAF_PILE.getRegistryName()));

		RUNTIME_RESOURCE_PACK.addTag(TerrestriaDatagen.tagID(BlockTags.FLOWER_POTS), JTag.tag()
			.add(TerrestriaBlocks.POTTED_AGAVE.getRegistryName())
			.add(TerrestriaBlocks.POTTED_ALOE_VERA.getRegistryName())
			.add(TerrestriaBlocks.POTTED_BRYCE_SAPLING.getRegistryName())
			.add(TerrestriaBlocks.POTTED_CYPRESS_SAPLING.getRegistryName())
			.add(TerrestriaBlocks.POTTED_DARK_JAPANESE_MAPLE_SAPLING.getRegistryName())
			.add(TerrestriaBlocks.POTTED_HEMLOCK_SAPLING.getRegistryName())
			.add(TerrestriaBlocks.POTTED_INDIAN_PAINTBRUSH.getRegistryName())
			.add(TerrestriaBlocks.POTTED_JAPANESE_MAPLE_SAPLING.getRegistryName())
			.add(TerrestriaBlocks.POTTED_JAPANESE_MAPLE_SHRUB_SAPLING.getRegistryName())
			.add(TerrestriaBlocks.POTTED_JUNGLE_PALM_SAPLING.getRegistryName())
			.add(TerrestriaBlocks.POTTED_MONSTERAS.getRegistryName())
			.add(TerrestriaBlocks.POTTED_RAINBOW_EUCALYPTUS_SAPLING.getRegistryName())
			.add(TerrestriaBlocks.POTTED_REDWOOD_SAPLING.getRegistryName())
			.add(TerrestriaBlocks.POTTED_RUBBER_SAPLING.getRegistryName())
			.add(TerrestriaBlocks.POTTED_SAGUARO_CACTUS_SAPLING.getRegistryName())
			.add(TerrestriaBlocks.POTTED_SAKURA_SAPLING.getRegistryName())
			.add(TerrestriaBlocks.POTTED_TINY_CACTUS.getRegistryName())
			.add(TerrestriaBlocks.POTTED_WILLOW_SAPLING.getRegistryName())
			.add(TerrestriaBlocks.POTTED_YUCCA_PALM_SAPLING.getRegistryName()));

		RUNTIME_RESOURCE_PACK.addTag(TerrestriaDatagen.tagID(BlockTags.LEAVES), JTag.tag()
			.add(TerrestriaBlocks.DARK_JAPANESE_MAPLE_LEAVES.getRegistryName())
			.add(TerrestriaBlocks.JAPANESE_MAPLE_SHRUB_LEAVES.getRegistryName())
			.add(TerrestriaBlocks.JUNGLE_PALM_LEAVES.getRegistryName()));

		RUNTIME_RESOURCE_PACK.addTag(TerrestriaDatagen.tagID(BlockTags.OAK_LOGS), JTag.tag()
			.tag(TerrestriaBlockTags.SMALL_OAK_LOGS.id()));

		RUNTIME_RESOURCE_PACK.addTag(TerrestriaDatagen.tagID(BlockTags.SAPLINGS), JTag.tag()
			.add(TerrestriaBlocks.BRYCE_SAPLING.getRegistryName())
			.add(TerrestriaBlocks.CYPRESS_SAPLING.getRegistryName())
			.add(TerrestriaBlocks.DARK_JAPANESE_MAPLE_SAPLING.getRegistryName())
			.add(TerrestriaBlocks.HEMLOCK_SAPLING.getRegistryName())
			.add(TerrestriaBlocks.JAPANESE_MAPLE_SAPLING.getRegistryName())
			.add(TerrestriaBlocks.JAPANESE_MAPLE_SHRUB_SAPLING.getRegistryName())
			.add(TerrestriaBlocks.JUNGLE_PALM_SAPLING.getRegistryName())
			.add(TerrestriaBlocks.RAINBOW_EUCALYPTUS_SAPLING.getRegistryName())
			.add(TerrestriaBlocks.REDWOOD_SAPLING.getRegistryName())
			.add(TerrestriaBlocks.RUBBER_SAPLING.getRegistryName())
			.add(TerrestriaBlocks.SAKURA_SAPLING.getRegistryName())
			.add(TerrestriaBlocks.SAGUARO_CACTUS_SAPLING.getRegistryName())
			.add(TerrestriaBlocks.WILLOW_SAPLING.getRegistryName())
			.add(TerrestriaBlocks.YUCCA_PALM_SAPLING.getRegistryName()));

		RUNTIME_RESOURCE_PACK.addTag(TerrestriaDatagen.tagID(BlockTags.SMALL_FLOWERS), JTag.tag()
			.add(TerrestriaBlocks.INDIAN_PAINTBRUSH.getRegistryName())
			.add(TerrestriaBlocks.MONSTERAS.getRegistryName()));


		RUNTIME_RESOURCE_PACK.addTag(TerrestriaDatagen.tagID(TerrestriaBlockTags.BLACK_SAND), JTag.tag()
			.add(TerrestriaBlocks.BLACK_SAND.getRegistryName()));

		RUNTIME_RESOURCE_PACK.addTag(TerrestriaDatagen.tagID(TerrestriaBlockTags.SMALL_OAK_LOGS), JTag.tag()
			.add(TerrestriaBlocks.SMALL_OAK_LOG.getRegistryName())
			.add(TerrestriaBlocks.STRIPPED_SMALL_OAK_LOG.getRegistryName()));


		// custom dirt block tags
		addDirt(TerrestriaBlocks.ANDISOL);

		// custom sand block tags
		addSand(TerrestriaBlocks.BLACK_SAND);

		// stone building block tags
		addStone(TerrestriaBlockTags.BASALT, TerrestriaBlocks.VOLCANIC_ROCK);

		// wood building block tags
		addWood(TerrestriaBlockTags.CYPRESS_LOGS, TerrestriaBlocks.CYPRESS);
		addWood(TerrestriaBlockTags.HEMLOCK_LOGS, TerrestriaBlocks.HEMLOCK);
		addWood(TerrestriaBlockTags.JAPANESE_MAPLE_LOGS, TerrestriaBlocks.JAPANESE_MAPLE);
		addWood(TerrestriaBlockTags.RAINBOW_EUCALYPTUS_LOGS, TerrestriaBlocks.RAINBOW_EUCALYPTUS);
		addWood(TerrestriaBlockTags.REDWOOD_LOGS, TerrestriaBlocks.REDWOOD);
		addWood(TerrestriaBlockTags.RUBBER_LOGS, TerrestriaBlocks.RUBBER);
		addWood(TerrestriaBlockTags.SAKURA_LOGS, TerrestriaBlocks.SAKURA);
		addWood(TerrestriaBlockTags.WILLOW_LOGS, TerrestriaBlocks.WILLOW);
		addWood(TerrestriaBlockTags.YUCCA_PALM_LOGS, TerrestriaBlocks.YUCCA_PALM);

		RUNTIME_RESOURCE_PACK.addTag(TerrestriaDatagen.tagID(BlockTags.LOGS_THAT_BURN), JTag.tag()
			.tag(TerrestriaBlockTags.CYPRESS_LOGS.id())
			.tag(TerrestriaBlockTags.HEMLOCK_LOGS.id())
			.tag(TerrestriaBlockTags.JAPANESE_MAPLE_LOGS.id())
			.tag(TerrestriaBlockTags.RAINBOW_EUCALYPTUS_LOGS.id())
			.tag(TerrestriaBlockTags.REDWOOD_LOGS.id())
			.tag(TerrestriaBlockTags.RUBBER_LOGS.id())
			.tag(TerrestriaBlockTags.SAKURA_LOGS.id())
			.tag(TerrestriaBlockTags.SMALL_OAK_LOGS.id())
			.tag(TerrestriaBlockTags.WILLOW_LOGS.id())
			.tag(TerrestriaBlockTags.YUCCA_PALM_LOGS.id()));
	}

	private static void addDirt(DirtBlocks dirtBlock) {
		RUNTIME_RESOURCE_PACK.addTag(TerrestriaDatagen.tagID(BlockTags.DIRT), JTag.tag()
			.add(dirtBlock.getDirt().getRegistryName())
			.add(dirtBlock.getGrassBlock().getRegistryName())
			.add(dirtBlock.getPodzol().getRegistryName()));

		RUNTIME_RESOURCE_PACK.addTag(TerrestriaDatagen.tagID(BlockTags.ENDERMAN_HOLDABLE), JTag.tag()
			.add(dirtBlock.getDirt().getRegistryName())
			.add(dirtBlock.getGrassBlock().getRegistryName())
			.add(dirtBlock.getPodzol().getRegistryName()));

		RUNTIME_RESOURCE_PACK.addTag(TerrestriaDatagen.tagID(BlockTags.MUSHROOM_GROW_BLOCK), JTag.tag()
			.add(dirtBlock.getPodzol().getRegistryName()));

		RUNTIME_RESOURCE_PACK.addTag(TerrestriaDatagen.tagID(BlockTags.SHOVEL_MINEABLE), JTag.tag()
			.add(dirtBlock.getDirt().getRegistryName())
			.add(dirtBlock.getDirtPath().getRegistryName())
			.add(dirtBlock.getFarmland().getRegistryName())
			.add(dirtBlock.getGrassBlock().getRegistryName())
			.add(dirtBlock.getPodzol().getRegistryName()));

		RUNTIME_RESOURCE_PACK.addTag(TerrestriaDatagen.tagID(BlockTags.VALID_SPAWN), JTag.tag()
			.add(dirtBlock.getGrassBlock().getRegistryName())
			.add(dirtBlock.getPodzol().getRegistryName()));


		RUNTIME_RESOURCE_PACK.addTag(TerrestriaDatagen.tagID(TerrestriaBlockTags.FARMLAND), JTag.tag()
			.add(dirtBlock.getFarmland().getRegistryName()));

		RUNTIME_RESOURCE_PACK.addTag(TerrestriaDatagen.tagID(TerrestriaBlockTags.GRASS_BLOCKS), JTag.tag()
			.add(dirtBlock.getGrassBlock().getRegistryName()));

		RUNTIME_RESOURCE_PACK.addTag(TerrestriaDatagen.tagID(TerrestriaBlockTags.PODZOL), JTag.tag()
			.add(dirtBlock.getPodzol().getRegistryName()));

		RUNTIME_RESOURCE_PACK.addTag(TerrestriaDatagen.tagID(TerrestriaBlockTags.SOIL), JTag.tag()
			.add(dirtBlock.getDirt().getRegistryName())
			.add(dirtBlock.getGrassBlock().getRegistryName())
			.add(dirtBlock.getPodzol().getRegistryName()));
	}

	private static void addSand(SandBlock sandBlock) {
		RUNTIME_RESOURCE_PACK.addTag(TerrestriaDatagen.tagID(BlockTags.ENDERMAN_HOLDABLE), JTag.tag().add(sandBlock.getRegistryName()));
		RUNTIME_RESOURCE_PACK.addTag(TerrestriaDatagen.tagID(BlockTags.SAND), JTag.tag().add(sandBlock.getRegistryName()));
		RUNTIME_RESOURCE_PACK.addTag(TerrestriaDatagen.tagID(BlockTags.SHOVEL_MINEABLE), JTag.tag().add(sandBlock.getRegistryName()));
	}

	private static void addStone(TagKey<Block> stoneTag, StoneBlocks stoneBlock) {

		JTag stoneBuilder = JTag.tag();
		if (stoneBlock.bricks != null) {
			stoneBuilder.add(stoneBlock.bricks.full.getRegistryName());
			addStoneVariant(stoneBlock.bricks);

			stoneBuilder.add(stoneBlock.chiseledBricks.getRegistryName());
			RUNTIME_RESOURCE_PACK.addTag(TerrestriaDatagen.tagID(BlockTags.PICKAXE_MINEABLE), JTag.tag().add(stoneBlock.chiseledBricks.getRegistryName()));

			stoneBuilder.add(stoneBlock.crackedBricks.getRegistryName());
			RUNTIME_RESOURCE_PACK.addTag(TerrestriaDatagen.tagID(BlockTags.PICKAXE_MINEABLE), JTag.tag().add(stoneBlock.crackedBricks.getRegistryName()));
		}
		if (stoneBlock.cobblestone != null) {
			stoneBuilder.add(stoneBlock.cobblestone.full.getRegistryName());
			addStoneVariant(stoneBlock.cobblestone);
		}
		if (stoneBlock.mossyBricks != null) {
			stoneBuilder.add(stoneBlock.mossyBricks.full.getRegistryName());
			addStoneVariant(stoneBlock.mossyBricks);
		}
		if (stoneBlock.mossyCobblestone != null) {
			stoneBuilder.add(stoneBlock.mossyCobblestone.full.getRegistryName());
			addStoneVariant(stoneBlock.mossyCobblestone);
		}
		if (stoneBlock.plain != null) {
			stoneBuilder.add(stoneBlock.plain.full.getRegistryName());
			addStoneVariant(stoneBlock.plain);
		}
		if (stoneBlock.smooth != null) {
			stoneBuilder.add(stoneBlock.smooth.full.getRegistryName());
			addStoneVariant(stoneBlock.smooth);
		}
		RUNTIME_RESOURCE_PACK.addTag(TerrestriaDatagen.tagID(stoneTag), stoneBuilder);

		RUNTIME_RESOURCE_PACK.addTag(TerrestriaDatagen.tagID(BlockTags.BUTTONS), JTag.tag().add(stoneBlock.button.getRegistryName()));
		RUNTIME_RESOURCE_PACK.addTag(TerrestriaDatagen.tagID(BlockTags.PRESSURE_PLATES), JTag.tag().add(stoneBlock.pressurePlate.getRegistryName()));
	}

	private static void addStoneVariant(StoneVariantBlocks stoneVariantBlock) {
		RUNTIME_RESOURCE_PACK.addTag(TerrestriaDatagen.tagID(BlockTags.SLABS), JTag.tag().add(stoneVariantBlock.slab.getRegistryName()));
		RUNTIME_RESOURCE_PACK.addTag(TerrestriaDatagen.tagID(BlockTags.STAIRS), JTag.tag().add(stoneVariantBlock.stairs.getRegistryName()));
		RUNTIME_RESOURCE_PACK.addTag(TerrestriaDatagen.tagID(BlockTags.WALLS), JTag.tag().add(stoneVariantBlock.wall.getRegistryName()));

		RUNTIME_RESOURCE_PACK.addTag(TerrestriaDatagen.tagID(BlockTags.PICKAXE_MINEABLE), JTag.tag()
				.add(stoneVariantBlock.full.getRegistryName())
				.add(stoneVariantBlock.slab.getRegistryName())
				.add(stoneVariantBlock.stairs.getRegistryName()));
				// Adding to WALLS does this for PICKAXE_MINEABLE.
	}

	private static void addWood(TagKey<Block> logTag, WoodBlocks woodBlock) {
		JTag woodBuilder = JTag.tag();
		woodBuilder
			.add(woodBlock.log.getRegistryName())
			.add(woodBlock.strippedLog.getRegistryName());
		if (woodBlock.strippedWood != null) {
			woodBuilder.add(woodBlock.strippedWood.getRegistryName());
		}
		if (woodBlock.wood != null) {
			woodBuilder.add(woodBlock.wood.getRegistryName());
		}
		if(woodBlock instanceof QuarteredWoodBlocks) {
			woodBuilder
				.add(((QuarteredWoodBlocks) woodBlock).quarterLog.getRegistryName())
				.add(((QuarteredWoodBlocks) woodBlock).strippedQuarterLog.getRegistryName());
		}
		RUNTIME_RESOURCE_PACK.addTag(TerrestriaDatagen.tagID(logTag), woodBuilder);

		RUNTIME_RESOURCE_PACK.addTag(TerrestriaDatagen.tagID(BlockTags.FENCE_GATES), JTag.tag().add(woodBlock.fenceGate.getRegistryName()));
		RUNTIME_RESOURCE_PACK.addTag(TerrestriaDatagen.tagID(BlockTags.LEAVES), JTag.tag().add(woodBlock.leaves.getRegistryName()));
		RUNTIME_RESOURCE_PACK.addTag(TerrestriaDatagen.tagID(BlockTags.PLANKS), JTag.tag().add(woodBlock.planks.getRegistryName()));
		RUNTIME_RESOURCE_PACK.addTag(TerrestriaDatagen.tagID(BlockTags.SLABS), JTag.tag().add(woodBlock.slab.getRegistryName()));
		RUNTIME_RESOURCE_PACK.addTag(TerrestriaDatagen.tagID(BlockTags.STAIRS), JTag.tag().add(woodBlock.stairs.getRegistryName()));
		RUNTIME_RESOURCE_PACK.addTag(TerrestriaDatagen.tagID(BlockTags.STANDING_SIGNS), JTag.tag().add(woodBlock.sign.getRegistryName()));
		RUNTIME_RESOURCE_PACK.addTag(TerrestriaDatagen.tagID(BlockTags.WALL_SIGNS), JTag.tag().add(woodBlock.wallSign.getRegistryName()));
		RUNTIME_RESOURCE_PACK.addTag(TerrestriaDatagen.tagID(BlockTags.WOODEN_BUTTONS), JTag.tag().add(woodBlock.button.getRegistryName()));
		RUNTIME_RESOURCE_PACK.addTag(TerrestriaDatagen.tagID(BlockTags.WOODEN_DOORS), JTag.tag().add(woodBlock.door.getRegistryName()));
		RUNTIME_RESOURCE_PACK.addTag(TerrestriaDatagen.tagID(BlockTags.WOODEN_FENCES), JTag.tag().add(woodBlock.fence.getRegistryName()));
		RUNTIME_RESOURCE_PACK.addTag(TerrestriaDatagen.tagID(BlockTags.WOODEN_PRESSURE_PLATES), JTag.tag().add(woodBlock.pressurePlate.getRegistryName()));
		RUNTIME_RESOURCE_PACK.addTag(TerrestriaDatagen.tagID(BlockTags.WOODEN_SLABS), JTag.tag().add(woodBlock.slab.getRegistryName()));
		RUNTIME_RESOURCE_PACK.addTag(TerrestriaDatagen.tagID(BlockTags.WOODEN_STAIRS), JTag.tag().add(woodBlock.stairs.getRegistryName()));
		RUNTIME_RESOURCE_PACK.addTag(TerrestriaDatagen.tagID(BlockTags.WOODEN_TRAPDOORS), JTag.tag().add(woodBlock.trapdoor.getRegistryName()));

		// Adding to FENCE_GATES or any WOODEN tag does this for AXE_MINEABLE.
		RUNTIME_RESOURCE_PACK.addTag(TerrestriaDatagen.tagID(BlockTags.HOE_MINEABLE), JTag.tag().add(woodBlock.leaves.getRegistryName()));
	}
}

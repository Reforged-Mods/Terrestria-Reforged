package com.terraformersmc.terrestria.data;

import com.terraformersmc.terraform.dirt.DirtBlocks;
import com.terraformersmc.terrestria.init.TerrestriaBlocks;
import com.terraformersmc.terrestria.init.TerrestriaBoats;
import com.terraformersmc.terrestria.init.TerrestriaItems;
import com.terraformersmc.terrestria.init.helpers.*;
import com.terraformersmc.terrestria.tag.TerrestriaItemTags;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.devtech.arrp.json.tags.JTag;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.tag.ItemTags;
import net.minecraft.tag.TagKey;

import java.util.Map;

import static com.terraformersmc.terrestria.data.TerrestriaDatagen.RUNTIME_RESOURCE_PACK;

public class TerrestriaItemTagProvider {
	private static Map<TagKey<Item>, JTag> TAG_MAP = new Object2ObjectOpenHashMap<>();


	public static void init() {
		RUNTIME_RESOURCE_PACK.addTag(TerrestriaDatagen.tagID(ItemTags.BOATS), JTag.tag()
			.add(TerrestriaBoats.CYPRESS_BOAT_TYPE.item().getRegistryName())
			.add(TerrestriaBoats.HEMLOCK_BOAT_TYPE.item().getRegistryName())
			.add(TerrestriaBoats.JAPANESE_MAPLE_BOAT_TYPE.item().getRegistryName())
			.add(TerrestriaBoats.RAINBOW_EUCALYPTUS_BOAT_TYPE.item().getRegistryName())
			.add(TerrestriaBoats.REDWOOD_BOAT_TYPE.item().getRegistryName())
			.add(TerrestriaBoats.RUBBER_BOAT_TYPE.item().getRegistryName())
			.add(TerrestriaBoats.SAKURA_BOAT_TYPE.item().getRegistryName())
			.add(TerrestriaBoats.WILLOW_BOAT_TYPE.item().getRegistryName())
			.add(TerrestriaBoats.YUCCA_PALM_BOAT_TYPE.item().getRegistryName()));

		RUNTIME_RESOURCE_PACK.addTag(TerrestriaDatagen.tagID(ItemTags.LEAVES), JTag.tag()
			.add(TerrestriaItems.DARK_JAPANESE_MAPLE_LEAVES.getRegistryName())
			.add(TerrestriaItems.JAPANESE_MAPLE_SHRUB_LEAVES.getRegistryName())
			.add(TerrestriaItems.JUNGLE_PALM_LEAVES.getRegistryName()));

		RUNTIME_RESOURCE_PACK.addTag(TerrestriaDatagen.tagID(ItemTags.OAK_LOGS), JTag.tag()
			.tag(TerrestriaItemTags.SMALL_OAK_LOGS.id()));

		RUNTIME_RESOURCE_PACK.addTag(TerrestriaDatagen.tagID(ItemTags.SAPLINGS), JTag.tag()
			.add(TerrestriaItems.BRYCE_SAPLING.getRegistryName())
			.add(TerrestriaItems.CYPRESS_SAPLING.getRegistryName())
			.add(TerrestriaItems.DARK_JAPANESE_MAPLE_SAPLING.getRegistryName())
			.add(TerrestriaItems.HEMLOCK_SAPLING.getRegistryName())
			.add(TerrestriaItems.JAPANESE_MAPLE_SAPLING.getRegistryName())
			.add(TerrestriaItems.JAPANESE_MAPLE_SHRUB_SAPLING.getRegistryName())
			.add(TerrestriaItems.JUNGLE_PALM_SAPLING.getRegistryName())
			.add(TerrestriaItems.RAINBOW_EUCALYPTUS_SAPLING.getRegistryName())
			.add(TerrestriaItems.REDWOOD_SAPLING.getRegistryName())
			.add(TerrestriaItems.RUBBER_SAPLING.getRegistryName())
			.add(TerrestriaItems.SAKURA_SAPLING.getRegistryName())
			.add(TerrestriaItems.SAGUARO_CACTUS_SAPLING.getRegistryName())
			.add(TerrestriaItems.WILLOW_SAPLING.getRegistryName())
			.add(TerrestriaItems.YUCCA_PALM_SAPLING.getRegistryName()));

		RUNTIME_RESOURCE_PACK.addTag(TerrestriaDatagen.tagID(ItemTags.SMALL_FLOWERS), JTag.tag()
			.add(TerrestriaItems.INDIAN_PAINTBRUSH.getRegistryName())
			.add(TerrestriaItems.MONSTERAS.getRegistryName()));


		RUNTIME_RESOURCE_PACK.addTag(TerrestriaDatagen.tagID(TerrestriaItemTags.BLACK_SAND), JTag.tag()
			.add(TerrestriaItems.BLACK_SAND.getRegistryName()));

		RUNTIME_RESOURCE_PACK.addTag(TerrestriaDatagen.tagID(TerrestriaItemTags.PLANKS_THAT_BURN), JTag.tag()
			.add(TerrestriaItems.CYPRESS.planks.getRegistryName())
			.add(TerrestriaItems.HEMLOCK.planks.getRegistryName())
			.add(TerrestriaItems.JAPANESE_MAPLE.planks.getRegistryName())
			.add(TerrestriaItems.RAINBOW_EUCALYPTUS.planks.getRegistryName())
			.add(TerrestriaItems.REDWOOD.planks.getRegistryName())
			.add(TerrestriaItems.RUBBER.planks.getRegistryName())
			.add(TerrestriaItems.SAKURA.planks.getRegistryName())
			.add(TerrestriaItems.WILLOW.planks.getRegistryName())
			.add(TerrestriaItems.YUCCA_PALM.planks.getRegistryName()));

		RUNTIME_RESOURCE_PACK.addTag(TerrestriaDatagen.tagID(TerrestriaItemTags.SMALL_OAK_LOGS), JTag.tag()
			.add(TerrestriaItems.SMALL_OAK_LOG.getRegistryName())
			.add(TerrestriaItems.STRIPPED_SMALL_OAK_LOG.getRegistryName()));


		// custom dirt item tags (no nice convenient item container?)
		addDirt(TerrestriaBlocks.ANDISOL);

		// custom sand item tags
		addSand(TerrestriaItems.BLACK_SAND);

		// stone building item tags
		addStone(TerrestriaItemTags.BASALT, TerrestriaItems.VOLCANIC_ROCK);

		// wood building item tags (sadly no QuarteredWoodItems available)
		addWood(TerrestriaItemTags.CYPRESS_LOGS, TerrestriaItems.CYPRESS, TerrestriaItems.CYPRESS_QUARTER_LOG, TerrestriaItems.STRIPPED_CYPRESS_QUARTER_LOG);
		addWood(TerrestriaItemTags.HEMLOCK_LOGS, TerrestriaItems.HEMLOCK, TerrestriaItems.HEMLOCK_QUARTER_LOG, TerrestriaItems.STRIPPED_HEMLOCK_QUARTER_LOG);
		addWood(TerrestriaItemTags.JAPANESE_MAPLE_LOGS, TerrestriaItems.JAPANESE_MAPLE);
		addWood(TerrestriaItemTags.RAINBOW_EUCALYPTUS_LOGS, TerrestriaItems.RAINBOW_EUCALYPTUS, TerrestriaItems.RAINBOW_EUCALYPTUS_QUARTER_LOG, TerrestriaItems.STRIPPED_RAINBOW_EUCALYPTUS_QUARTER_LOG);
		addWood(TerrestriaItemTags.REDWOOD_LOGS, TerrestriaItems.REDWOOD, TerrestriaItems.REDWOOD_QUARTER_LOG, TerrestriaItems.STRIPPED_REDWOOD_QUARTER_LOG);
		addWood(TerrestriaItemTags.RUBBER_LOGS, TerrestriaItems.RUBBER);
		addWood(TerrestriaItemTags.SAKURA_LOGS, TerrestriaItems.SAKURA);
		addWood(TerrestriaItemTags.WILLOW_LOGS, TerrestriaItems.WILLOW);
		addWood(TerrestriaItemTags.YUCCA_PALM_LOGS, TerrestriaItems.YUCCA_PALM);

		RUNTIME_RESOURCE_PACK.addTag(TerrestriaDatagen.tagID(ItemTags.LOGS_THAT_BURN), JTag.tag()
			.tag(TerrestriaItemTags.CYPRESS_LOGS.id())
			.tag(TerrestriaItemTags.HEMLOCK_LOGS.id())
			.tag(TerrestriaItemTags.JAPANESE_MAPLE_LOGS.id())
			.tag(TerrestriaItemTags.RAINBOW_EUCALYPTUS_LOGS.id())
			.tag(TerrestriaItemTags.REDWOOD_LOGS.id())
			.tag(TerrestriaItemTags.RUBBER_LOGS.id())
			.tag(TerrestriaItemTags.SAKURA_LOGS.id())
			.tag(TerrestriaItemTags.SMALL_OAK_LOGS.id())
			.tag(TerrestriaItemTags.WILLOW_LOGS.id())
			.tag(TerrestriaItemTags.YUCCA_PALM_LOGS.id()));
	}

	private static void addDirt(DirtBlocks dirtBlock) {
		RUNTIME_RESOURCE_PACK.addTag(TerrestriaDatagen.tagID(ItemTags.DIRT), JTag.tag()
				.add(dirtBlock.getDirt().getRegistryName())
				.add(dirtBlock.getGrassBlock().getRegistryName())
				.add(dirtBlock.getPodzol().getRegistryName()));
	}

	private static void addSand(BlockItem sandItem) {
		RUNTIME_RESOURCE_PACK.addTag(TerrestriaDatagen.tagID(ItemTags.SAND), JTag.tag().add(sandItem.getRegistryName()));
	}

	private static void addStone(TagKey<Item> stoneTag, StoneItems stoneItem) {
		JTag stoneBuilder = JTag.tag();
		if (stoneItem.bricks != null) {
			stoneBuilder
					.add(stoneItem.bricks.full.getRegistryName())

					.add(stoneItem.chiseledBricks.getRegistryName())
					.add(stoneItem.crackedBricks.getRegistryName());

			addStoneVariant(stoneItem.bricks);
		}
		if (stoneItem.cobblestone != null) {
			stoneBuilder.add(stoneItem.cobblestone.full.getRegistryName());
			addStoneVariant(stoneItem.cobblestone);
		}
		if (stoneItem.mossyBricks != null) {
			stoneBuilder.add(stoneItem.mossyBricks.full.getRegistryName());
			addStoneVariant(stoneItem.mossyBricks);
		}
		if (stoneItem.mossyCobblestone != null) {
			stoneBuilder.add(stoneItem.mossyCobblestone.full.getRegistryName());
			addStoneVariant(stoneItem.mossyCobblestone);
		}
		if (stoneItem.plain != null) {
			stoneBuilder.add(stoneItem.plain.full.getRegistryName());
			addStoneVariant(stoneItem.plain);
		}
		if (stoneItem.smooth != null) {
			stoneBuilder.add(stoneItem.smooth.full.getRegistryName());
			addStoneVariant(stoneItem.smooth);
		}
		RUNTIME_RESOURCE_PACK.addTag(TerrestriaDatagen.tagID(stoneTag), stoneBuilder);

		RUNTIME_RESOURCE_PACK.addTag(TerrestriaDatagen.tagID(ItemTags.BUTTONS), JTag.tag().add(stoneItem.button.getRegistryName()));
		// There is no item tag for stone pressure plates...
	}

	private static void addStoneVariant(StoneVariantItems stoneVariantItem) {
		RUNTIME_RESOURCE_PACK.addTag(TerrestriaDatagen.tagID(ItemTags.SLABS), JTag.tag().add(stoneVariantItem.slab.getRegistryName()));
		RUNTIME_RESOURCE_PACK.addTag(TerrestriaDatagen.tagID(ItemTags.STAIRS), JTag.tag().add(stoneVariantItem.stairs.getRegistryName()));
		RUNTIME_RESOURCE_PACK.addTag(TerrestriaDatagen.tagID(ItemTags.WALLS), JTag.tag().add(stoneVariantItem.wall.getRegistryName()));
	}

	private static void addWood(TagKey<Item> logTag, WoodItems woodItem, Item... extra) {
		JTag woodBuilder = JTag.tag();
		woodBuilder
				.add(woodItem.log.getRegistryName())
				.add(woodItem.strippedLog.getRegistryName());
		if (woodItem.strippedWood != null) {
			woodBuilder.add(woodItem.strippedWood.getRegistryName());
		}
		if (woodItem.wood != null) {
			woodBuilder.add(woodItem.wood.getRegistryName());
		}
		for (Item item : extra) {
			woodBuilder.add(item.getRegistryName());
		}
		RUNTIME_RESOURCE_PACK.addTag(TerrestriaDatagen.tagID(logTag), woodBuilder);


		RUNTIME_RESOURCE_PACK.addTag(TerrestriaDatagen.tagID(ItemTags.LEAVES), JTag.tag().add(woodItem.leaves.getRegistryName()));
		RUNTIME_RESOURCE_PACK.addTag(TerrestriaDatagen.tagID(ItemTags.PLANKS), JTag.tag().add(woodItem.planks.getRegistryName()));
		RUNTIME_RESOURCE_PACK.addTag(TerrestriaDatagen.tagID(ItemTags.SLABS), JTag.tag().add(woodItem.slab.getRegistryName()));
		RUNTIME_RESOURCE_PACK.addTag(TerrestriaDatagen.tagID(ItemTags.STAIRS), JTag.tag().add(woodItem.stairs.getRegistryName()));
		RUNTIME_RESOURCE_PACK.addTag(TerrestriaDatagen.tagID(ItemTags.SIGNS), JTag.tag().add(woodItem.sign.getRegistryName()));
		RUNTIME_RESOURCE_PACK.addTag(TerrestriaDatagen.tagID(ItemTags.WOODEN_BUTTONS), JTag.tag().add(woodItem.button.getRegistryName()));
		RUNTIME_RESOURCE_PACK.addTag(TerrestriaDatagen.tagID(ItemTags.WOODEN_DOORS), JTag.tag().add(woodItem.door.getRegistryName()));
		RUNTIME_RESOURCE_PACK.addTag(TerrestriaDatagen.tagID(ItemTags.WOODEN_FENCES), JTag.tag().add(woodItem.fence.getRegistryName()));
		RUNTIME_RESOURCE_PACK.addTag(TerrestriaDatagen.tagID(ItemTags.WOODEN_PRESSURE_PLATES), JTag.tag().add(woodItem.pressurePlate.getRegistryName()));
		RUNTIME_RESOURCE_PACK.addTag(TerrestriaDatagen.tagID(ItemTags.WOODEN_SLABS), JTag.tag().add(woodItem.slab.getRegistryName()));
		RUNTIME_RESOURCE_PACK.addTag(TerrestriaDatagen.tagID(ItemTags.WOODEN_STAIRS), JTag.tag().add(woodItem.stairs.getRegistryName()));
		RUNTIME_RESOURCE_PACK.addTag(TerrestriaDatagen.tagID(ItemTags.WOODEN_TRAPDOORS), JTag.tag().add(woodItem.trapdoor.getRegistryName()));
	}
}

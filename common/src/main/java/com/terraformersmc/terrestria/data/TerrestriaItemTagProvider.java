package com.terraformersmc.terrestria.data;

import com.terraformersmc.terraform.dirt.DirtBlocks;
import com.terraformersmc.terrestria.init.TerrestriaBlocks;
import com.terraformersmc.terrestria.init.TerrestriaBoats;
import com.terraformersmc.terrestria.init.TerrestriaItems;
import com.terraformersmc.terrestria.init.helpers.*;
import com.terraformersmc.terrestria.tag.TerrestriaItemTags;
import net.devtech.arrp.json.tags.JTag;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.tag.BlockTags;
import net.minecraft.tag.ItemTags;
import net.minecraft.tag.TagKey;
import net.minecraftforge.common.Tags;

import static com.terraformersmc.terrestria.data.TerrestriaDatagen.RUNTIME_RESOURCE_PACK;

public class TerrestriaItemTagProvider {

	@Override
	protected void generateTags() {
		RUNTIME_RESOURCE_PACK.addTag(ItemTags.BOATS)
			.add(TerrestriaBoats.CYPRESS_BOAT_TYPE.getItem())
			.add(TerrestriaBoats.HEMLOCK_BOAT_TYPE.getItem())
			.add(TerrestriaBoats.JAPANESE_MAPLE_BOAT_TYPE.getItem())
			.add(TerrestriaBoats.RAINBOW_EUCALYPTUS_BOAT_TYPE.getItem())
			.add(TerrestriaBoats.REDWOOD_BOAT_TYPE.getItem())
			.add(TerrestriaBoats.RUBBER_BOAT_TYPE.getItem())
			.add(TerrestriaBoats.SAKURA_BOAT_TYPE.getItem())
			.add(TerrestriaBoats.WILLOW_BOAT_TYPE.getItem())
			.add(TerrestriaBoats.YUCCA_PALM_BOAT_TYPE.getItem()));

		RUNTIME_RESOURCE_PACK.addTag(ItemTags.LEAVES)
			.add(TerrestriaItems.DARK_JAPANESE_MAPLE_LEAVES)
			.add(TerrestriaItems.JAPANESE_MAPLE_SHRUB_LEAVES)
			.add(TerrestriaItems.JUNGLE_PALM_LEAVES));

		RUNTIME_RESOURCE_PACK.addTag(ItemTags.OAK_LOGS)
			.addTag(TerrestriaItemTags.SMALL_OAK_LOGS));

		RUNTIME_RESOURCE_PACK.addTag(ItemTags.SAPLINGS)
			.add(TerrestriaItems.BRYCE_SAPLING)
			.add(TerrestriaItems.CYPRESS_SAPLING)
			.add(TerrestriaItems.DARK_JAPANESE_MAPLE_SAPLING)
			.add(TerrestriaItems.HEMLOCK_SAPLING)
			.add(TerrestriaItems.JAPANESE_MAPLE_SAPLING)
			.add(TerrestriaItems.JAPANESE_MAPLE_SHRUB_SAPLING)
			.add(TerrestriaItems.JUNGLE_PALM_SAPLING)
			.add(TerrestriaItems.RAINBOW_EUCALYPTUS_SAPLING)
			.add(TerrestriaItems.REDWOOD_SAPLING)
			.add(TerrestriaItems.RUBBER_SAPLING)
			.add(TerrestriaItems.SAKURA_SAPLING)
			.add(TerrestriaItems.SAGUARO_CACTUS_SAPLING)
			.add(TerrestriaItems.WILLOW_SAPLING)
			.add(TerrestriaItems.YUCCA_PALM_SAPLING));

		RUNTIME_RESOURCE_PACK.addTag(ItemTags.SMALL_FLOWERS)
			.add(TerrestriaItems.INDIAN_PAINTBRUSH)
			.add(TerrestriaItems.MONSTERAS));


		RUNTIME_RESOURCE_PACK.addTag(TerrestriaItemTags.BLACK_SAND)
			.add(TerrestriaItems.BLACK_SAND));

		RUNTIME_RESOURCE_PACK.addTag(TerrestriaItemTags.PLANKS_THAT_BURN)
			.add(TerrestriaItems.CYPRESS.planks)
			.add(TerrestriaItems.HEMLOCK.planks)
			.add(TerrestriaItems.JAPANESE_MAPLE.planks)
			.add(TerrestriaItems.RAINBOW_EUCALYPTUS.planks)
			.add(TerrestriaItems.REDWOOD.planks)
			.add(TerrestriaItems.RUBBER.planks)
			.add(TerrestriaItems.SAKURA.planks)
			.add(TerrestriaItems.WILLOW.planks)
			.add(TerrestriaItems.YUCCA_PALM.planks));

		RUNTIME_RESOURCE_PACK.addTag(TerrestriaItemTags.SMALL_OAK_LOGS)
			.add(TerrestriaItems.SMALL_OAK_LOG)
			.add(TerrestriaItems.STRIPPED_SMALL_OAK_LOG));


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

		RUNTIME_RESOURCE_PACK.addTag(ItemTags.LOGS_THAT_BURN)
			.addTag(TerrestriaItemTags.CYPRESS_LOGS)
			.addTag(TerrestriaItemTags.HEMLOCK_LOGS)
			.addTag(TerrestriaItemTags.JAPANESE_MAPLE_LOGS)
			.addTag(TerrestriaItemTags.RAINBOW_EUCALYPTUS_LOGS)
			.addTag(TerrestriaItemTags.REDWOOD_LOGS)
			.addTag(TerrestriaItemTags.RUBBER_LOGS)
			.addTag(TerrestriaItemTags.SAKURA_LOGS)
			.addTag(TerrestriaItemTags.SMALL_OAK_LOGS)
			.addTag(TerrestriaItemTags.WILLOW_LOGS)
			.addTag(TerrestriaItemTags.YUCCA_PALM_LOGS));
	}

	private void addDirt(DirtBlocks dirtBlock) {
		RUNTIME_RESOURCE_PACK.addTag(TerrestriaDatagen.tagID(ItemTags.DIRT), JTag.tag()
				.add(dirtBlock.getDirt().getRegistryName())
				.add(dirtBlock.getGrassBlock().getRegistryName())
				.add(dirtBlock.getPodzol().getRegistryName()));
	}

	private void addSand(BlockItem sandItem) {
		RUNTIME_RESOURCE_PACK.addTag(TerrestriaDatagen.tagID(ItemTags.SAND), JTag.tag().add(sandItem.getRegistryName()));
	}

	private void addStone(TagKey<Item> stoneTag, StoneItems stoneItem) {
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

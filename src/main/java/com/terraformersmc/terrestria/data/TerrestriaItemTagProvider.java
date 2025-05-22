package com.terraformersmc.terrestria.data;

import com.terraformersmc.terraform.dirt.DirtBlocks;
import com.terraformersmc.terrestria.Terrestria;
import com.terraformersmc.terrestria.init.TerrestriaBlocks;
import com.terraformersmc.terrestria.init.TerrestriaItems;
import com.terraformersmc.terrestria.init.helpers.QuarteredWoodItems;
import com.terraformersmc.terrestria.init.helpers.StoneItems;
import com.terraformersmc.terrestria.init.helpers.StoneVariantItems;
import com.terraformersmc.terrestria.init.helpers.WoodItems;
import com.terraformersmc.terrestria.tag.TerrestriaItemTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.server.BlockTagProvider;
import net.minecraft.data.server.ItemTagProvider;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.tag.ItemTags;
import net.minecraft.tag.TagKey;
import net.minecraftforge.common.data.ExistingFileHelper;

public class TerrestriaItemTagProvider extends ItemTagProvider {
	public TerrestriaItemTagProvider(DataGenerator dataGenerator, BlockTagProvider provider, ExistingFileHelper helper) {
		super(dataGenerator, provider, Terrestria.MOD_ID, helper);
	}

	@Override
	protected void configure() {
		this.getOrCreateTagBuilder(ItemTags.LEAVES)
			.add(TerrestriaItems.DARK_JAPANESE_MAPLE_LEAVES)
			.add(TerrestriaItems.JAPANESE_MAPLE_SHRUB_LEAVES)
			.add(TerrestriaItems.JUNGLE_PALM_LEAVES);

		copy(BlockTags.DIRT, ItemTags.DIRT);

		copy(BlockTags.CEILING_HANGING_SIGNS, ItemTags.HANGING_SIGNS);

		copy(BlockTags.FENCE_GATES, ItemTags.FENCE_GATES);

		copy(BlockTags.LEAVES, ItemTags.LEAVES);

		copy(BlockTags.LOGS_THAT_BURN, ItemTags.LOGS_THAT_BURN);

		copy(BlockTags.OAK_LOGS, ItemTags.OAK_LOGS);

		copy(BlockTags.PLANKS, ItemTags.PLANKS);

		copy(BlockTags.SAND, ItemTags.SAND);

		copy(BlockTags.SAPLINGS, ItemTags.SAPLINGS);

		copy(BlockTags.STANDING_SIGNS, ItemTags.SIGNS);

		copy(BlockTags.SLABS, ItemTags.SLABS);

		copy(BlockTags.SMALL_FLOWERS, ItemTags.SMALL_FLOWERS);

		copy(BlockTags.STAIRS, ItemTags.STAIRS);

		copy(BlockTags.WALLS, ItemTags.WALLS);

		copy(BlockTags.WOODEN_BUTTONS, ItemTags.WOODEN_BUTTONS);

		copy(BlockTags.WOODEN_DOORS, ItemTags.WOODEN_DOORS);

		copy(BlockTags.WOODEN_FENCES, ItemTags.WOODEN_FENCES);

		copy(BlockTags.WOODEN_PRESSURE_PLATES, ItemTags.WOODEN_PRESSURE_PLATES);

		copy(BlockTags.WOODEN_SLABS, ItemTags.WOODEN_SLABS);

		copy(BlockTags.WOODEN_STAIRS, ItemTags.WOODEN_STAIRS);

		copy(BlockTags.WOODEN_TRAPDOORS, ItemTags.WOODEN_TRAPDOORS);


		copy(TerrestriaBlockTags.BLACK_SAND, TerrestriaItemTags.BLACK_SAND);

		getOrCreateTagBuilder(TerrestriaItemTags.MOSSY_INGREDIENTS)
			.add(Items.MOSS_BLOCK)
			.add(Items.VINE);

		getOrCreateTagBuilder(TerrestriaItemTags.PLANKS_THAT_BURN)
			.add(TerrestriaItems.CYPRESS.planks)
			.add(TerrestriaItems.HEMLOCK.planks)
			.add(TerrestriaItems.JAPANESE_MAPLE.planks)
			.add(TerrestriaItems.RAINBOW_EUCALYPTUS.planks)
			.add(TerrestriaItems.REDWOOD.planks)
			.add(TerrestriaItems.RUBBER.planks)
			.add(TerrestriaItems.SAKURA.planks)
			.add(TerrestriaItems.WILLOW.planks)
			.add(TerrestriaItems.YUCCA_PALM.planks);

		copy(TerrestriaBlockTags.SMALL_OAK_LOGS, TerrestriaItemTags.SMALL_OAK_LOGS);


		// stone type tags
		copy(TerrestriaBlockTags.BASALT, TerrestriaItemTags.BASALT);

		// stone items
		addStone(TerrestriaItems.VOLCANIC_ROCK);

		// wood type tags
		copy(TerrestriaBlockTags.CYPRESS_LOGS, TerrestriaItemTags.CYPRESS_LOGS);
		copy(TerrestriaBlockTags.HEMLOCK_LOGS, TerrestriaItemTags.HEMLOCK_LOGS);
		copy(TerrestriaBlockTags.JAPANESE_MAPLE_LOGS, TerrestriaItemTags.JAPANESE_MAPLE_LOGS);
		copy(TerrestriaBlockTags.RAINBOW_EUCALYPTUS_LOGS, TerrestriaItemTags.RAINBOW_EUCALYPTUS_LOGS);
		copy(TerrestriaBlockTags.REDWOOD_LOGS, TerrestriaItemTags.REDWOOD_LOGS);
		copy(TerrestriaBlockTags.RUBBER_LOGS, TerrestriaItemTags.RUBBER_LOGS);
		copy(TerrestriaBlockTags.SAKURA_LOGS, TerrestriaItemTags.SAKURA_LOGS);
		copy(TerrestriaBlockTags.WILLOW_LOGS, TerrestriaItemTags.WILLOW_LOGS);
		copy(TerrestriaBlockTags.YUCCA_PALM_LOGS, TerrestriaItemTags.YUCCA_PALM_LOGS);

		// wood items
		addWood(TerrestriaItems.CYPRESS);
		addWood(TerrestriaItems.HEMLOCK);
		addWood(TerrestriaItems.JAPANESE_MAPLE);
		addWood(TerrestriaItems.RAINBOW_EUCALYPTUS);
		addWood(TerrestriaItems.REDWOOD);
		addWood(TerrestriaItems.RUBBER);
		addWood(TerrestriaItems.SAKURA);
		addWood(TerrestriaItems.WILLOW);
		addWood(TerrestriaItems.YUCCA_PALM);
	}

	private void addDirt(DirtBlocks dirtBlock) {
		getOrCreateTagBuilder(ItemTags.DIRT)
			.add(dirtBlock.getDirt().asItem())
			.add(dirtBlock.getGrassBlock().asItem())
			.add(dirtBlock.getPodzol().asItem());
	}

	private void addSand(BlockItem sandItem) {
		getOrCreateTagBuilder(ItemTags.SAND).add(sandItem);
	}

	@SuppressWarnings("SameParameterValue")
	private void addStone(TagKey<Item> stoneTag, StoneItems stoneItem) {
		ObjectBuilder<Item> stoneBuilder = getOrCreateTagBuilder(stoneTag);
		if (stoneItem.bricks != null) {
			stoneBuilder
				.add(stoneItem.bricks.full)

				.add(stoneItem.chiseledBricks)
				.add(stoneItem.crackedBricks);

			addStoneVariant(stoneItem.bricks);
			getOrCreateTagBuilder(ItemTags.STONE_BRICKS).add(stoneItem.bricks.full);
			getOrCreateTagBuilder(ItemTags.STONE_BRICKS).add(stoneItem.chiseledBricks);
			getOrCreateTagBuilder(ItemTags.STONE_BRICKS).add(stoneItem.crackedBricks);
		}
		if (stoneItem.cobblestone != null) {
			stoneBuilder.add(stoneItem.cobblestone.full);
			addStoneVariant(stoneItem.cobblestone);

			// Add any cobble variant to vanilla crafting tags.
			getOrCreateTagBuilder(ItemTags.STONE_CRAFTING_MATERIALS).add(stoneItem.cobblestone.full);
			getOrCreateTagBuilder(ItemTags.STONE_TOOL_MATERIALS).add(stoneItem.cobblestone.full);
			getOrCreateTagBuilder(TerrestriaItemTags.COBBLESTONE).add(stoneItem.cobblestone.full);
		}
		if (stoneItem.mossyBricks != null) {
			stoneBuilder.add(stoneItem.mossyBricks.full);
			addStoneVariant(stoneItem.mossyBricks);
			getOrCreateTagBuilder(ItemTags.STONE_BRICKS).add(stoneItem.mossyBricks.full);
		}
		if (stoneItem.mossyCobblestone != null) {
			stoneBuilder.add(stoneItem.mossyCobblestone.full);
			addStoneVariant(stoneItem.mossyCobblestone);
		}
		if (stoneItem.plain != null) {
			stoneBuilder.add(stoneItem.plain.full);
			addStoneVariant(stoneItem.plain);
			getOrCreateTagBuilder(TerrestriaItemTags.STONE).add(stoneItem.plain.full);
		}
		if (stoneItem.smooth != null) {
			stoneBuilder.add(stoneItem.smooth.full);
			addStoneVariant(stoneItem.smooth);
			getOrCreateTagBuilder(TerrestriaItemTags.STONE).add(stoneItem.smooth.full);
		}

		getOrCreateTagBuilder(ItemTags.BUTTONS).add(stoneItem.button);
		// There is no item tag for stone pressure plates...
	}

	private void addStoneVariant(StoneVariantItems stoneVariantItem) {
		getOrCreateTagBuilder(ItemTags.SLABS).add(stoneVariantItem.slab);
		getOrCreateTagBuilder(ItemTags.STAIRS).add(stoneVariantItem.stairs);
		getOrCreateTagBuilder(ItemTags.WALLS).add(stoneVariantItem.wall);
	}

	private void addWood(TagKey<Item> logTag, WoodItems woodItem) {
		ObjectBuilder<Item> woodBuilder = getOrCreateTagBuilder(logTag);
		woodBuilder
			.add(woodItem.log)
			.add(woodItem.strippedLog);
		getOrCreateTagBuilder(TerrestriaItemTags.STRIPPED_LOGS).add(woodItem.strippedLog);

		if (woodItem.strippedWood != null) {
			woodBuilder.add(woodItem.strippedWood);
			getOrCreateTagBuilder(TerrestriaItemTags.STRIPPED_WOOD).add(woodItem.strippedWood);
		}
		if (woodItem.wood != null) {
			woodBuilder.add(woodItem.wood);
		}

		if (woodItem instanceof QuarteredWoodItems quarteredWoodItems) {
			woodBuilder
				.add(quarteredWoodItems.quarterLog)
				.add(quarteredWoodItems.strippedQuarterLog);
			getOrCreateTagBuilder(TerrestriaItemTags.STRIPPED_LOGS).add(quarteredWoodItems.strippedQuarterLog);
		}

		// Add boats if they exist via the WoodItem.
		if (woodItem.boat != null) {
			getOrCreateTagBuilder(ItemTags.BOATS).add(woodItem.boat);
		}
		if (woodItem.chestBoat != null) {
			getOrCreateTagBuilder(ItemTags.CHEST_BOATS).add(woodItem.chestBoat);
		}

		// There is no item tag for fence gates...
		getOrCreateTagBuilder(ItemTags.LEAVES).add(woodItem.leaves);
		getOrCreateTagBuilder(ItemTags.PLANKS).add(woodItem.planks);
		getOrCreateTagBuilder(ItemTags.SLABS).add(woodItem.slab);
		getOrCreateTagBuilder(ItemTags.STAIRS).add(woodItem.stairs);
		getOrCreateTagBuilder(ItemTags.SIGNS).add(woodItem.sign);
		getOrCreateTagBuilder(ItemTags.WOODEN_BUTTONS).add(woodItem.button);
		getOrCreateTagBuilder(ItemTags.WOODEN_DOORS).add(woodItem.door);
		getOrCreateTagBuilder(ItemTags.WOODEN_FENCES).add(woodItem.fence);
		getOrCreateTagBuilder(ItemTags.WOODEN_PRESSURE_PLATES).add(woodItem.pressurePlate);
		getOrCreateTagBuilder(ItemTags.WOODEN_SLABS).add(woodItem.slab);
		getOrCreateTagBuilder(ItemTags.WOODEN_STAIRS).add(woodItem.stairs);
		getOrCreateTagBuilder(ItemTags.WOODEN_TRAPDOORS).add(woodItem.trapdoor);
	}
}

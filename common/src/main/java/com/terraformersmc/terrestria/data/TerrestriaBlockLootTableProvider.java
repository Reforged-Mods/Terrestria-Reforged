package com.terraformersmc.terrestria.data;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.terraformersmc.terraform.dirt.DirtBlocks;
import com.terraformersmc.terrestria.init.TerrestriaBlocks;
import com.terraformersmc.terrestria.init.helpers.QuarteredWoodBlocks;
import com.terraformersmc.terrestria.init.helpers.StoneBlocks;
import com.terraformersmc.terrestria.init.helpers.WoodBlocks;
import net.devtech.arrp.json.loot.JCondition;
import net.devtech.arrp.json.loot.JFunction;
import net.devtech.arrp.json.loot.JLootTable;
import net.minecraft.block.Block;
import net.minecraft.block.FlowerPotBlock;
import net.minecraft.block.SaplingBlock;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.util.Identifier;

import javax.annotation.Nullable;
import java.util.ArrayList;

import static com.terraformersmc.terrestria.data.TerrestriaDatagen.RUNTIME_RESOURCE_PACK;
import static net.devtech.arrp.json.loot.JLootTable.condition;
import static net.devtech.arrp.json.loot.JLootTable.entry;
import static net.devtech.arrp.json.loot.JLootTable.function;
import static net.devtech.arrp.json.loot.JLootTable.pool;

public class TerrestriaBlockLootTableProvider {

	public static void init() {
		// simple blocks
		addDrop(TerrestriaBlocks.AGAVE);
		addDrop(TerrestriaBlocks.ALOE_VERA);
		addDrop(TerrestriaBlocks.BLACK_SAND);
		addDrop(TerrestriaBlocks.BRYCE_SAPLING);
		addShearDrop(TerrestriaBlocks.CATTAIL, TerrestriaBlocks.CATTAIL);
		addDrop(TerrestriaBlocks.CYPRESS_SAPLING);
		addDrop(TerrestriaBlocks.DARK_JAPANESE_MAPLE_SAPLING);
		addDrop(TerrestriaBlocks.DEAD_GRASS);
		addDrop(TerrestriaBlocks.HEMLOCK_SAPLING);
		addDrop(TerrestriaBlocks.INDIAN_PAINTBRUSH);
		addDrop(TerrestriaBlocks.JAPANESE_MAPLE_SAPLING);
		addDrop(TerrestriaBlocks.JAPANESE_MAPLE_SHRUB_SAPLING);
		addDrop(TerrestriaBlocks.JUNGLE_PALM_SAPLING);
		JsonArray items = new JsonArray();
		items.add(new JsonPrimitive("minecraft:shears"));
		JsonObject predicate = new JsonObject();
		predicate.add("items", items);
		JsonObject parameters = new JsonObject();
		parameters.addProperty("bonusMultiplier", 2);
		RUNTIME_RESOURCE_PACK.addLootTable(blockTableID(new Identifier("terrestria:monsteras")), JLootTable.loot("minecraft:block")
				.pool(pool()
						.rolls(1)
						.entry(entry()
								.type("minecraft:alternatives")
								.child(entry()
										.type("minecraft:item")
										.condition(new JCondition("minecraft:match_tool").parameter("predicate", predicate))
										.name("terrestria:monsteras"))
								.child(entry()
										.type("minecraft:item")
										.condition(new JCondition("minecraft:random_chance").parameter("chance", 0.125f))
										.function(new JFunction("minecraft:apply_bonus")
												.parameter("enchantment", "minecraft:fortune")
												.parameter("formula", "minecraft:uniform_bonus_count")
												.parameter("parameters", parameters))
										.function("minecraft:explosion_decay")
										.name("minecraft:wheat_seeds")))));
		addDrop(TerrestriaBlocks.RAINBOW_EUCALYPTUS_SAPLING);
		addDrop(TerrestriaBlocks.REDWOOD_SAPLING);
		addDrop(TerrestriaBlocks.RUBBER_SAPLING);
		addDrop(TerrestriaBlocks.SAGUARO_CACTUS);
		addDrop(TerrestriaBlocks.SAGUARO_CACTUS_SAPLING);
		addDrop(TerrestriaBlocks.SAKURA_SAPLING);
		addDrop(TerrestriaBlocks.SMALL_OAK_LOG);
		addDrop(TerrestriaBlocks.STRIPPED_SMALL_OAK_LOG);
		addShearDrop(TerrestriaBlocks.TALL_CATTAIL, TerrestriaBlocks.CATTAIL);
		addDrop(TerrestriaBlocks.TINY_CACTUS);
		addDrop(TerrestriaBlocks.WILLOW_SAPLING);
		addDrop(TerrestriaBlocks.YUCCA_PALM_SAPLING);

		// dirt blocks
		addDirtDrops(TerrestriaBlocks.ANDISOL);

		// stone building blocks
		addStoneDrops(TerrestriaBlocks.VOLCANIC_ROCK);

		// wood building blocks
		addWoodDrops(TerrestriaBlocks.CYPRESS, TerrestriaBlocks.CYPRESS_SAPLING);
		addWoodDrops(TerrestriaBlocks.HEMLOCK, TerrestriaBlocks.HEMLOCK_SAPLING);
		addWoodDrops(TerrestriaBlocks.JAPANESE_MAPLE, TerrestriaBlocks.JAPANESE_MAPLE_SAPLING);
		addWoodDrops(TerrestriaBlocks.RAINBOW_EUCALYPTUS, TerrestriaBlocks.RAINBOW_EUCALYPTUS_SAPLING);
		addWoodDrops(TerrestriaBlocks.REDWOOD, TerrestriaBlocks.REDWOOD_SAPLING);
		addWoodDrops(TerrestriaBlocks.RUBBER, TerrestriaBlocks.RUBBER_SAPLING);
		addWoodDrops(TerrestriaBlocks.SAKURA, TerrestriaBlocks.SAKURA_SAPLING);
		addWoodDrops(TerrestriaBlocks.WILLOW, TerrestriaBlocks.WILLOW_SAPLING);
		addWoodDrops(TerrestriaBlocks.YUCCA_PALM, null);

		// potted things
		addPottedPlantDrop(TerrestriaBlocks.POTTED_AGAVE);
		addPottedPlantDrop(TerrestriaBlocks.POTTED_ALOE_VERA);
		addPottedPlantDrop(TerrestriaBlocks.POTTED_BRYCE_SAPLING);
		addPottedPlantDrop(TerrestriaBlocks.POTTED_CYPRESS_SAPLING);
		addPottedPlantDrop(TerrestriaBlocks.POTTED_DARK_JAPANESE_MAPLE_SAPLING);
		addPottedPlantDrop(TerrestriaBlocks.POTTED_HEMLOCK_SAPLING);
		addPottedPlantDrop(TerrestriaBlocks.POTTED_INDIAN_PAINTBRUSH);
		addPottedPlantDrop(TerrestriaBlocks.POTTED_JAPANESE_MAPLE_SAPLING);
		addPottedPlantDrop(TerrestriaBlocks.POTTED_JAPANESE_MAPLE_SHRUB_SAPLING);
		addPottedPlantDrop(TerrestriaBlocks.POTTED_JUNGLE_PALM_SAPLING);
		addPottedPlantDrop(TerrestriaBlocks.POTTED_MONSTERAS);
		addPottedPlantDrop(TerrestriaBlocks.POTTED_RAINBOW_EUCALYPTUS_SAPLING);
		addPottedPlantDrop(TerrestriaBlocks.POTTED_REDWOOD_SAPLING);
		addPottedPlantDrop(TerrestriaBlocks.POTTED_RUBBER_SAPLING);
		addPottedPlantDrop(TerrestriaBlocks.POTTED_SAGUARO_CACTUS_SAPLING);
		addPottedPlantDrop(TerrestriaBlocks.POTTED_SAKURA_SAPLING);
		addPottedPlantDrop(TerrestriaBlocks.POTTED_TINY_CACTUS);
		addPottedPlantDrop(TerrestriaBlocks.POTTED_WILLOW_SAPLING);
		addPottedPlantDrop(TerrestriaBlocks.POTTED_YUCCA_PALM_SAPLING);

		// specialty tree leaves
		addLeafDrop(TerrestriaBlocks.DARK_JAPANESE_MAPLE_LEAVES, TerrestriaBlocks.DARK_JAPANESE_MAPLE_SAPLING, 0.05f, 0.0625f, 0.083333336f, 0.1f);
		addLeafDrop(TerrestriaBlocks.JAPANESE_MAPLE_SHRUB_LEAVES, TerrestriaBlocks.JAPANESE_MAPLE_SHRUB_SAPLING, 0.05f, 0.0625f, 0.083333336f, 0.1f);
		addLeafDrop(TerrestriaBlocks.JUNGLE_PALM_LEAVES, TerrestriaBlocks.JUNGLE_PALM_SAPLING, 0.07f, 0.0875f, 0.116666667f, 0.14f);
		addLeafDrop(TerrestriaBlocks.SAKURA_LEAF_PILE, TerrestriaBlocks.SAKURA_SAPLING, 0.00625f, 0.0078125f, 0.010416667f, 0.0125f);
		addLeafDrop(TerrestriaBlocks.YUCCA_PALM.leaves, TerrestriaBlocks.YUCCA_PALM_SAPLING, 0.15f, 0.1875f, 0.24f, 0.333333333f);
	}

	private static void addDirtDrops(DirtBlocks dirtBlock) {
		if (dirtBlock.getDirt() != null) {
			addDrop(dirtBlock.getDirt());
			if (dirtBlock.getDirtPath() != null) {
				addDrop(TerrestriaBlocks.ANDISOL.getDirtPath(), TerrestriaBlocks.ANDISOL.getDirt());
			}
			if (dirtBlock.getFarmland() != null) {
				addDrop(TerrestriaBlocks.ANDISOL.getFarmland(), TerrestriaBlocks.ANDISOL.getDirt());
			}
			if (dirtBlock.getGrassBlock() != null) {
				addDropWithSilkTouch(TerrestriaBlocks.ANDISOL.getGrassBlock(), TerrestriaBlocks.ANDISOL.getDirt());
			}
		}
		if (dirtBlock.getPodzol() != null) {
			addDrop(TerrestriaBlocks.ANDISOL.getPodzol());
		}
	}

	private static void addStoneDrops(StoneBlocks stoneBlock) {
		if (stoneBlock.bricks != null) {
			addDrop(stoneBlock.bricks.full);
			addSlabDrop(stoneBlock.bricks.slab);
			addDrop(stoneBlock.bricks.stairs);
			addDrop(stoneBlock.bricks.wall);

			addDrop(stoneBlock.chiseledBricks);
			addDrop(stoneBlock.crackedBricks);
		}
		if (stoneBlock.cobblestone != null) {
			addDrop(stoneBlock.cobblestone.full);
			addSlabDrop(stoneBlock.cobblestone.slab);
			addDrop(stoneBlock.cobblestone.stairs);
			addDrop(stoneBlock.cobblestone.wall);
		}
		if (stoneBlock.mossyBricks != null) {
			addDrop(stoneBlock.mossyBricks.full);
			addSlabDrop(stoneBlock.mossyBricks.slab);
			addDrop(stoneBlock.mossyBricks.stairs);
			addDrop(stoneBlock.mossyBricks.wall);
		}
		if (stoneBlock.mossyCobblestone != null) {
			addDrop(stoneBlock.mossyCobblestone.full);
			addSlabDrop(stoneBlock.mossyCobblestone.slab);
			addDrop(stoneBlock.mossyCobblestone.stairs);
			addDrop(stoneBlock.mossyCobblestone.wall);
		}
		if (stoneBlock.plain != null) {
			if (stoneBlock.cobblestone != null) {
				addDropWithSilkTouch(stoneBlock.plain.full, stoneBlock.cobblestone.full);
			} else {
				addDrop(stoneBlock.plain.full);
			}
			addSlabDrop(stoneBlock.plain.slab);
			addDrop(stoneBlock.plain.stairs);
			addDrop(stoneBlock.plain.wall);
		}
		if (stoneBlock.smooth != null) {
			addDrop(stoneBlock.smooth.full);
			addSlabDrop(stoneBlock.smooth.slab);
			addDrop(stoneBlock.smooth.stairs);
			addDrop(stoneBlock.smooth.wall);
		}

		addDrop(stoneBlock.button);
		addDrop(stoneBlock.pressurePlate);
	}

	private static void addWoodDrops(WoodBlocks woodBlock, @Nullable SaplingBlock sapling) {
		addDrop(woodBlock.button);
		addDoorDrop(woodBlock.door);
		addDrop(woodBlock.fence);
		addDrop(woodBlock.fenceGate);
		addDrop(woodBlock.log);
		addDrop(woodBlock.planks);
		addDrop(woodBlock.pressurePlate);
		addDrop(woodBlock.sign, woodBlock.sign);
		addSlabDrop(woodBlock.slab);
		addDrop(woodBlock.stairs);
		addDrop(woodBlock.strippedLog);
		addDrop(woodBlock.strippedWood);
		addDrop(woodBlock.trapdoor);
		addDrop(woodBlock.wallSign, woodBlock.sign);
		addDrop(woodBlock.wood);

		if (woodBlock instanceof QuarteredWoodBlocks) {
			addDrop(((QuarteredWoodBlocks) woodBlock).quarterLog);
			addDrop(((QuarteredWoodBlocks) woodBlock).strippedQuarterLog);
		}

		if (sapling != null) {
			addLeafDrop(woodBlock.leaves, sapling, 0.05f, 0.0625f, 0.083333336f, 0.1f);
		}
	}

	private static void addLeafDrop(Block leaf, Block sapling, float... chances){
		Identifier blockID = leaf.getRegistryName();
		JsonObject count = new JsonObject();
		count.addProperty("type", "minecraft:uniform");
		count.addProperty("min", 1.0);
		count.addProperty("max", 2.0);
		RUNTIME_RESOURCE_PACK.addLootTable(blockTableID(blockID), JLootTable.loot("minecraft:block")
				.pool(pool()
						.rolls(1)
						.entry(entry()
								.type("minecraft:alternatives")
								.child(entry()
										.type("minecraft:item")
										.condition(new JCondition("minecraft:alternative")
												.parameter("terms", leafCondition()))
										.name(blockID.toString()))
								.child(entry()
										.type("minecraft:item")
										.condition("minecraft:survives_explosion")
										.condition(new JCondition("minecraft:table_bonus")
												.parameter("enchantment", "minecraft:fortune")
												.parameter("chances", chances(chances)))
										.name(sapling.getRegistryName().toString()))))
				.pool(pool()
						.rolls(1)
						.entry(entry()
								.type("minecraft:item")
								.condition(new JCondition("minecraft:table_bonus")
										.parameter("enchantment", "minecraft:fortune")
										.parameter("chances", chances(0.02f, 0.022222223f, 0.025f, 0.033333335f, 0.1f)))
								.function(new JFunction("minecraft:set_count")
										.parameter("count", count)
										.parameter("add", false))
								.function("minecraft:explosion_decay")
								.name("minecraft:stick"))
						.condition(new JCondition("minecraft:inverted").parameter("term", silkTouchInverted()))));
	}

	private static JsonElement silkTouchInverted(){
		JsonObject term = new JsonObject();
		term.addProperty("condition", "minecraft:alternative");
		term.add("terms", leafCondition());
		return term;
	}

	private static JsonElement chances(float... chances){
		JsonArray array = new JsonArray();
		for (float chance : chances) {
			array.add(new JsonPrimitive(chance));
		}
		return array;
	}

	private static JsonElement leafCondition(){
		JsonArray terms = new JsonArray();
		JsonObject condition = new JsonObject();
		condition.addProperty("condition", "minecraft:match_tool");
		JsonObject predicate = new JsonObject();
		JsonArray array = new JsonArray();
		array.add(new JsonPrimitive("minecraft:shears"));
		predicate.add("items", array);
		condition.add("predicate", predicate);
		terms.add(condition);
		condition = new JsonObject();
		condition.addProperty("condition", "minecraft:match_tool");
		predicate = new JsonObject();
		array = new JsonArray();
		JsonObject enchantment = new JsonObject();
		enchantment.addProperty("enchantment", "minecraft:silk_touch");
		JsonObject levels = new JsonObject();
		levels.addProperty("min", 1);
		enchantment.add("levels", levels);
		array.add(enchantment);
		predicate.add("enchantments", array);
		condition.add("predicate", predicate);
		terms.add(condition);
		return terms;
	}

	private static void addDrop(Block block){
		Identifier blockID = block.getRegistryName();
		RUNTIME_RESOURCE_PACK.addLootTable(blockTableID(blockID), JLootTable.loot("minecraft:block")
				.pool(pool()
						.rolls(1)
						.entry(entry()
								.type("minecraft:item")
								.name(blockID.toString()))
						.condition(condition("minecraft:survives_explosion")))
		);
	}

	private static void addDrop(Block block, ItemConvertible drop){
		Identifier blockID = block.getRegistryName();
		RUNTIME_RESOURCE_PACK.addLootTable(blockTableID(blockID), JLootTable.loot("minecraft:block")
				.pool(pool()
						.rolls(1)
						.entry(entry()
								.type("minecraft:item")
								.name(drop.asItem().getRegistryName().toString()))
						.condition(condition("minecraft:survives_explosion")))
		);
	}

	private static void addSlabDrop(Block slab) {
		Identifier blockID = slab.getRegistryName();
		RUNTIME_RESOURCE_PACK.addLootTable(blockTableID(blockID), JLootTable.loot("minecraft:block")
				.pool(pool()
						.rolls(1)
						.entry(entry()
								.type("minecraft:item")
								.function(function("minecraft:set_count")
										.condition(condition("minecraft:block_state_property")
												.parameter("block", blockID.toString())
												.parameter("properties", blockStringProperty("type", "double")))
										.parameter("count", 2))
								.function("minecraft:explosion_decay")
								.name(blockID.toString()))
						.condition(condition("minecraft:survives_explosion")))
		);
	}

	private static void addDoorDrop(Block door) {
		Identifier blockID = door.getRegistryName();
		RUNTIME_RESOURCE_PACK.addLootTable(blockTableID(blockID), JLootTable.loot("minecraft:block")
				.pool(pool()
						.rolls(1)
						.entry(entry()
								.type("minecraft:item")
								.condition(condition("minecraft:block_state_property")
										.parameter("block", blockID.toString())
										.parameter("properties", blockStringProperty("half", "lower")))
								.name(blockID.toString()))
						.condition(condition("minecraft:survives_explosion")))
		);
	}

	public static void addOreDrop(Block block, Item item){
		Identifier blockID = block.getRegistryName();
		Identifier itemID = item.getRegistryName();
		RUNTIME_RESOURCE_PACK.addLootTable(blockTableID(blockID), JLootTable.loot("minecraft:block")
				.pool(pool()
						.rolls(1)
						.bonus(0)
						.entry(entry()
								.type("minecraft:alternatives")
								.child(entry()
										.type("minecraft:item")
										.condition(condition("minecraft:match_tool")
												.parameter("predicate", silkTouchPredicate()))
										.name(blockID.toString()))
								.child(entry()
										.type("minecraft:item")
										.function(function("minecraft:apply_bonus")
												.parameter("enchantment", "minecraft:fortune")
												.parameter("formula", "minecraft:ore_drops"))
										.function(function("minecraft:explosion_decay"))
										.name(itemID.toString())
								)
						)
						.condition(condition("minecraft:survives_explosion")))
		);
	}

	public static void addDropWithSilkTouch(Block silk, Block nonSilk){
		Identifier silkID = silk.getRegistryName();
		Identifier nonSilkID = nonSilk.getRegistryName();
		RUNTIME_RESOURCE_PACK.addLootTable(blockTableID(silkID), JLootTable.loot("minecraft:block")
				.pool(pool()
						.rolls(1)
						.bonus(0)
						.entry(entry()
								.type("minecraft:alternatives")
								.child(entry()
										.type("minecraft:item")
										.condition(condition("minecraft:match_tool")
												.parameter("predicate", silkTouchPredicate()))
										.name(silkID.toString()))
								.child(entry()
										.type("minecraft:item")
										.function(function("minecraft:set_count")
												.parameter("count", 1))
										.function(function("minecraft:explosion_decay"))
										.name(nonSilkID.toString())
								)
						)
						.condition(condition("minecraft:survives_explosion")))
		);
	}

	private static void addShearDrop(Block block, ItemConvertible drop) {
		Identifier blockID = block.getRegistryName();
		RUNTIME_RESOURCE_PACK.addLootTable(blockTableID(blockID), JLootTable.loot("minecraft:block")
				.pool(pool()
						.rolls(1)
						.entry(entry()
								.type("minecraft:item")
								.name(drop.asItem().getRegistryName().toString()))
						.condition(condition("minecraft:match_tool")
								.parameter("predicate", shearsPredicate())))
		);
	}

	private static void addTallPlantDrop(Block block, Block drop) {
		RUNTIME_RESOURCE_PACK.addLootTable(blockTableID(block.getRegistryName()), JLootTable.loot("minecraft:block")
				.pool(pool()
						.rolls(1)
						.entry(entry()
								.type("minecraft:item")
								.name(drop.getRegistryName().toString()))
						.condition(condition("minecraft:match_tool")
								.parameter("predicate", shearsPredicate()))
						.function(function("minecraft:set_count").parameter("count", 2).parameter("add", false)))
		);
	}

	private static void addPottedPlantDrop(Block block){
		if (block instanceof FlowerPotBlock flowerPot){
			Identifier blockID = block.getRegistryName();
			RUNTIME_RESOURCE_PACK.addLootTable(blockTableID(blockID), JLootTable.loot("minecraft:block")
					.pool(pool()
							.rolls(1)
							.entry(entry()
									.type("minecraft:item")
									.name("minecraft:flower_pot"))
							.condition(condition("minecraft:survives_explosion")))
					.pool(pool()
							.rolls(1)
							.entry(entry()
									.type("minecraft:item")
									.name(flowerPot.getContent().getRegistryName().toString()))
							.condition(condition("minecraft:survives_explosion")))
			);
		}

	}

	private static JsonObject blockStringProperty(String name, String value) {
		var property = new JsonObject();
		property.addProperty(name, value);

		return property;
	}

	private static JsonObject silkTouchPredicate() {
		var level = new JsonObject();
		level.addProperty("min", 1);

		var silkTouch = new JsonObject();
		silkTouch.addProperty("enchantment", "minecraft:silk_touch");
		silkTouch.add("levels", level);

		JsonArray enchantments = new JsonArray();
		enchantments.add(silkTouch);

		var predicate = new JsonObject();
		predicate.add("enchantments", enchantments);

		return predicate;
	}

	private static JsonObject shearsPredicate() {
		JsonArray items = new JsonArray();
		items.add("minecraft:shears");
		var predicate = new JsonObject();
		predicate.add("items", items);
		return predicate;
	}

	private static void addDrops(ArrayList<Block> blocks) {
		for (var block : blocks) {
			addDrop(block);
		}
	}

	private static Identifier blockTableID(Identifier blockID) {
		return new Identifier(blockID.getNamespace(), "blocks/" + blockID.getPath());
	}
}

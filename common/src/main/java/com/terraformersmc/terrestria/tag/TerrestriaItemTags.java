package com.terraformersmc.terrestria.tag;

import com.terraformersmc.terrestria.Terrestria;
import net.minecraft.item.Item;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public final class TerrestriaItemTags {
	public static final TagKey<Item> BASALT = TerrestriaItemTags.of(Identifier.of("c", "basalt"));
	public static final TagKey<Item> BLACK_SAND = TerrestriaItemTags.of(Identifier.of("c", "black_sand"));
	public static final TagKey<Item> COBBLESTONE = TerrestriaItemTags.of(Identifier.of("c", "cobblestone"));
	public static final TagKey<Item> PLANKS_THAT_BURN = TerrestriaItemTags.of(Identifier.of("c", "planks_that_burn"));
	public static final TagKey<Item> STONE = TerrestriaItemTags.of(Identifier.of("c", "stone"));
	public static final TagKey<Item> STRIPPED_LOGS = TerrestriaItemTags.of(Identifier.of("c", "stripped_logs"));
	public static final TagKey<Item> STRIPPED_WOOD = TerrestriaItemTags.of(Identifier.of("c", "stripped_wood"));

	public static final TagKey<Item> CYPRESS_LOGS = TerrestriaItemTags.of("cypress_logs");
	public static final TagKey<Item> HEMLOCK_LOGS = TerrestriaItemTags.of("hemlock_logs");
	public static final TagKey<Item> JAPANESE_MAPLE_LOGS = TerrestriaItemTags.of("japanese_maple_logs");
	public static final TagKey<Item> MOSSY_INGREDIENTS = TerrestriaItemTags.of("mossy_ingredients");
	public static final TagKey<Item> RAINBOW_EUCALYPTUS_LOGS = TerrestriaItemTags.of("rainbow_eucalyptus_logs");
	public static final TagKey<Item> REDWOOD_LOGS = TerrestriaItemTags.of("redwood_logs");
	public static final TagKey<Item> RUBBER_LOGS = TerrestriaItemTags.of("rubber_logs");
	public static final TagKey<Item> SAKURA_LOGS = TerrestriaItemTags.of("sakura_logs");
	public static final TagKey<Item> SMALL_OAK_LOGS = TerrestriaItemTags.of("small_oak_logs");
	public static final TagKey<Item> WILLOW_LOGS = TerrestriaItemTags.of("willow_logs");
	public static final TagKey<Item> YUCCA_PALM_LOGS = TerrestriaItemTags.of("yucca_palm_logs");

	public static final TagKey<Item> BASALT = TerrestriaItemTags.of(new Identifier("forge", "basalt"));
	public static final TagKey<Item> BLACK_SAND = TerrestriaItemTags.of(new Identifier("forge", "black_sand"));
	public static final TagKey<Item> PLANKS_THAT_BURN = TerrestriaItemTags.of(new Identifier("forge", "planks_that_burn"));

	@SuppressWarnings("UnnecessaryReturnStatement")
	private TerrestriaItemTags() {
		return;
	}

	private static TagKey<Item> of(String path) {
		return TerrestriaItemTags.of(new Identifier(Terrestria.MOD_ID, path));
	}

	private static TagKey<Item> of(Identifier id) {
		return TagKey.of(Registry.ITEM_KEY, id);
	}
}

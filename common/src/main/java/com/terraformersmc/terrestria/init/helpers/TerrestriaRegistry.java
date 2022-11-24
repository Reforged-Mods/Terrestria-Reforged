package com.terraformersmc.terrestria.init.helpers;

import com.terraformersmc.terraform.leaves.ComposterRecipes;
import com.terraformersmc.terrestria.Terrestria;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SignItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.LinkedHashMap;
import java.util.Map;

public class TerrestriaRegistry {

	public static Map<Identifier, Block> BLOCKS = new LinkedHashMap<>();
	public static Map<Identifier, BlockItem> ITEM_BLOCKS = new LinkedHashMap<>();
	public static Map<Identifier, Item> ITEMS = new LinkedHashMap<>();
	public static BlockItem registerBuildingBlockItem(String name, Block block) {
		return registerBlockItem(name, block, ItemGroup.BUILDING_BLOCKS);
	}

	public static BlockItem registerDecorationBlockItem(String name, Block block) {
		return registerBlockItem(name, block, ItemGroup.DECORATIONS);
	}

	public static BlockItem registerRedstoneBlockItem(String name, Block block) {
		return registerBlockItem(name, block, ItemGroup.REDSTONE);
	}

	public static BlockItem registerBlockItem(String name, Block block, ItemGroup itemGroup) {
		BlockItem item = new BlockItem(block, new Item.Settings().group(itemGroup));
		item.appendBlocks(Item.BLOCK_ITEMS, item);

		ComposterRecipes.registerCompostableBlock(block);

		ITEM_BLOCKS.put(new Identifier(Terrestria.MOD_ID, name), item);
		return item;
	}

	public static SignItem registerSignItem(String name, Block standing, Block wall) {
		SignItem item = new SignItem(new Item.Settings().group(Terrestria.itemGroup).maxCount(16), standing, wall);
		ITEMS.put(new Identifier(Terrestria.MOD_ID, name), item);
		return item;
	}

	public static <I extends Item> I registerItem(String name, I item) {
		ITEMS.put(new Identifier(Terrestria.MOD_ID, name), item);
		return item;
	}

	public static <T extends Block> T register(String name, T block) {
		BLOCKS.put(new Identifier(Terrestria.MOD_ID, name), block);
		return block;
	}
}

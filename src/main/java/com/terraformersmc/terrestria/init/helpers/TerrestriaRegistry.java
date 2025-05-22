package com.terraformersmc.terrestria.init.helpers;

import com.terraformersmc.terraform.leaves.ComposterRecipes;
import com.terraformersmc.terrestria.Terrestria;
import net.minecraft.block.Block;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.List;

public class TerrestriaRegistry {
	public static final List<Block> BLOCKS = new ArrayList<>();
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

		ForgeRegistries.ITEMS.register(new Identifier(Terrestria.MOD_ID, name), item);
		ComposterRecipes.registerCompostableBlock(block);
		return item;
	}

	public static SignItem registerSignItem(String name, Block standing, Block wall) {
		SignItem item = new SignItem(new Item.Settings().group(ItemGroup.DECORATIONS).maxCount(16), standing, wall);
		ForgeRegistries.ITEMS.register(new Identifier(Terrestria.MOD_ID, name), item);
		return item;
	}

	public static <I extends Item> I registerItem(String name, I item) {
		ForgeRegistries.ITEMS.register(new Identifier(Terrestria.MOD_ID, name), item);
		return item;
	}

	public static <T extends Block> T register(String name, T block) {
		BLOCKS.add(block);
		ForgeRegistries.BLOCKS.register(new Identifier(Terrestria.MOD_ID, name), block);
		return block;
	}
}

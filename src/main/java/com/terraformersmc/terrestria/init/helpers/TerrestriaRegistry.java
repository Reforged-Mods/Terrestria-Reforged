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
	public static final List<Item> ITEMS = new ArrayList<>();

	public static BlockItem registerBlockItem(String name, Block block) {
		BlockItem item = new BlockItem(block, new Item.Settings());
		return register(name, item);
	}

	public static <I extends Item> I register(String name, I item) {
		if (item instanceof BlockItem blockItem) {
			blockItem.appendBlocks(Item.BLOCK_ITEMS, blockItem);
		}
		ForgeRegistries.ITEMS.register(new Identifier(Terrestria.MOD_ID, name), item);
		ITEMS.add(item);
		return item;
	}


	public static <T extends Block> T register(String name, T block) {
		BLOCKS.add(block);
		ForgeRegistries.BLOCKS.register(new Identifier(Terrestria.MOD_ID, name), block);
		return block;
	}
}

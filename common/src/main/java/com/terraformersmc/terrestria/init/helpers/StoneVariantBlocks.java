package com.terraformersmc.terrestria.init.helpers;

import com.terraformersmc.terraform.utils.TerraformUtils;
import com.terraformersmc.terraform.wood.block.TerraformStairsBlock;
import net.minecraft.block.*;

public class StoneVariantBlocks {
	public Block full;
	public SlabBlock slab;
	public TerraformStairsBlock stairs;
	public WallBlock wall;

	private StoneVariantBlocks() {}

	public static StoneVariantBlocks register(String name, MapColor color) {
		return register(name, name, color);
	}

	public static StoneVariantBlocks register(String name, String shapedName, MapColor color) {
		StoneVariantBlocks blocks = new StoneVariantBlocks();

		blocks.full = TerrestriaRegistry.register(name, new Block(TerraformUtils.copy(Blocks.COBBLESTONE, color)));
		blocks.slab = TerrestriaRegistry.register(shapedName + "_slab", new SlabBlock(TerraformUtils.copy(Blocks.COBBLESTONE_STAIRS, color)));
		blocks.stairs = TerrestriaRegistry.register(shapedName + "_stairs", new TerraformStairsBlock(blocks.full, TerraformUtils.copy(Blocks.COBBLESTONE_STAIRS, color)));
		blocks.wall = TerrestriaRegistry.register(shapedName + "_wall", new WallBlock(TerraformUtils.copy(Blocks.COBBLESTONE_WALL, color)));

		return blocks;
	}
}

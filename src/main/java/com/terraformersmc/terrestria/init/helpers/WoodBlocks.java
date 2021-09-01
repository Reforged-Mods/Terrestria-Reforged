package com.terraformersmc.terrestria.init.helpers;

import com.terraformersmc.terraform.leaves.block.TransparentLeavesBlock;
import com.terraformersmc.terraform.utils.TerraformUtils;
import com.terraformersmc.terraform.wood.block.*;
import com.terraformersmc.terraform.sign.block.TerraformSignBlock;
import com.terraformersmc.terraform.sign.block.TerraformWallSignBlock;
import com.terraformersmc.terrestria.Terrestria;
import com.terraformersmc.terrestria.block.TerrestriaOptiLeavesBlock;
import com.terraformersmc.terrestria.init.TerrestriaBlocks;
import net.minecraft.block.*;
import net.minecraft.util.Identifier;
import net.minecraftforge.common.ToolType;

public class WoodBlocks {
	public Block log;
	public Block wood;
	public Block leaves;
	public Block planks;
	public SlabBlock slab;
	public TerraformStairsBlock stairs;
	public FenceBlock fence;
	public FenceGateBlock fenceGate;
	public TerraformDoorBlock door;
	public TerraformButtonBlock button;
	public TerraformPressurePlateBlock pressurePlate;
	public TerraformSignBlock sign;
	public TerraformWallSignBlock wallSign;
	public TerraformTrapdoorBlock trapdoor;
	public Block strippedLog;
	public Block strippedWood;
	protected String name;
	protected WoodColors colors;

	public WoodBlocks() {}

	protected static WoodBlocks register(String name, WoodColors colors, LogSize size, boolean useExtendedLeaves) {
		WoodBlocks blocks = registerManufactured(name, colors);

		if (useExtendedLeaves) {
			if (size.equals(LogSize.SMALL)) {
				throw new IllegalArgumentException("Small log trees are not compatible with extended leaves, I'm not sure how you even did this...");
			}
			blocks.leaves = TerrestriaRegistry.register(name + "_leaves", new TerrestriaOptiLeavesBlock(TerraformUtils.copy(Blocks.OAK_LEAVES, colors.leaves).harvestTool(ToolType.HOE).allowsSpawning(TerrestriaBlocks::canSpawnOnLeaves).suffocates(TerrestriaBlocks::never).blockVision(TerrestriaBlocks::never)));
		} else {
			if (size.equals(LogSize.SMALL)) {
				blocks.leaves = TerrestriaRegistry.register(name + "_leaves", new TransparentLeavesBlock(TerraformUtils.copy(Blocks.OAK_LEAVES, colors.leaves).harvestTool(ToolType.HOE).allowsSpawning(TerrestriaBlocks::canSpawnOnLeaves).suffocates(TerrestriaBlocks::never).blockVision(TerrestriaBlocks::never)));
			} else {
				blocks.leaves = TerrestriaRegistry.register(name + "_leaves", new LeavesBlock(TerraformUtils.copy(Blocks.OAK_LEAVES, colors.leaves).harvestTool(ToolType.HOE).allowsSpawning(TerrestriaBlocks::canSpawnOnLeaves).suffocates(TerrestriaBlocks::never).blockVision(TerrestriaBlocks::never)));
			}
		}

		if (size.equals(LogSize.SMALL)) {
			blocks.strippedLog = TerrestriaRegistry.register("stripped_" + name + "_log", new SmallLogBlock(blocks.leaves, null, TerraformUtils.copy(Blocks.OAK_LOG, colors.planks)));
			blocks.strippedWood = blocks.strippedLog; //No need for a stripped wood type
			blocks.log = TerrestriaRegistry.register(name + "_log", new SmallLogBlock(blocks.leaves, () -> blocks.strippedLog, TerraformUtils.copy(Blocks.OAK_LOG, colors.bark)));
			blocks.wood = blocks.log; //No need for a stripped wood type
		} else {
			blocks.strippedLog = TerrestriaRegistry.register("stripped_" + name + "_log", new PillarBlock(TerraformUtils.copy(Blocks.OAK_LOG, colors.planks)));
			blocks.strippedWood = TerrestriaRegistry.register("stripped_" + name + "_wood", new PillarBlock(TerraformUtils.copy(Blocks.OAK_LOG, colors.planks)));
			blocks.log = TerrestriaRegistry.register(name + "_log", new StrippableLogBlock(() -> blocks.strippedLog, colors.planks, TerraformUtils.copy(Blocks.OAK_LOG, colors.bark)));
			blocks.wood = TerrestriaRegistry.register(name + "_wood", new StrippableLogBlock(() -> blocks.strippedWood, colors.bark, TerraformUtils.copy(Blocks.OAK_LOG, colors.bark)));
		}

		blocks.addTreeFireInfo();

		return blocks;
	}

	public static WoodBlocks register(String name, WoodColors colors, LogSize size) {
		return register(name, colors, size, false);
	}

	public static WoodBlocks register(String name, WoodColors colors) {
		return register(name, colors, LogSize.NORMAL, false);
	}

	public static WoodBlocks registerManufactured(String name, WoodColors colors) {
		WoodBlocks blocks = new WoodBlocks();
		blocks.name = name;
		blocks.colors = colors;

		blocks.planks = TerrestriaRegistry.register(name + "_planks", new Block(TerraformUtils.copy(Blocks.OAK_PLANKS, colors.planks)));
		blocks.slab = TerrestriaRegistry.register(name + "_slab", new SlabBlock(TerraformUtils.copy(Blocks.OAK_SLAB, colors.planks)));
		blocks.stairs = TerrestriaRegistry.register(name + "_stairs", new TerraformStairsBlock(blocks.planks, TerraformUtils.copy(Blocks.OAK_STAIRS, colors.planks)));
		blocks.fence = TerrestriaRegistry.register(name + "_fence", new FenceBlock(TerraformUtils.copy(Blocks.OAK_FENCE, colors.planks)));
		blocks.fenceGate = TerrestriaRegistry.register(name + "_fence_gate", new FenceGateBlock(TerraformUtils.copy(Blocks.OAK_FENCE_GATE, colors.planks)));
		blocks.door = TerrestriaRegistry.register(name + "_door", new TerraformDoorBlock(TerraformUtils.copy(Blocks.OAK_DOOR, colors.planks)));
		blocks.button = TerrestriaRegistry.register(name + "_button", new TerraformButtonBlock(TerraformUtils.copy(Blocks.OAK_BUTTON, colors.planks)));
		blocks.pressurePlate = TerrestriaRegistry.register(name + "_pressure_plate", new TerraformPressurePlateBlock(TerraformUtils.copy(Blocks.OAK_PRESSURE_PLATE, colors.planks)));
		blocks.trapdoor = TerrestriaRegistry.register(name + "_trapdoor", new TerraformTrapdoorBlock(TerraformUtils.copy(Blocks.OAK_TRAPDOOR, colors.planks)));

		Identifier signTexture = new Identifier(Terrestria.MOD_ID, "entity/signs/" + name);

		blocks.sign = TerrestriaRegistry.register(name + "_sign", new TerraformSignBlock(signTexture, TerraformUtils.copy(Blocks.OAK_SIGN, colors.planks)));
		blocks.wallSign = TerrestriaRegistry.register(name + "_wall_sign", new TerraformWallSignBlock(signTexture, TerraformUtils.copy(Blocks.OAK_WALL_SIGN, colors.planks)));

		blocks.addManufacturedFireInfo();

		//todo fabric - figure out fuel furnace stuff for these
		//FuelRegistry.INSTANCE.add(blocks.fence, 300);
		//FuelRegistry.INSTANCE.add(blocks.fenceGate, 300);

		return blocks;
	}

	public void addTreeFireInfo() {
		TerrestriaBlocks.add(log, 5, 5);
		TerrestriaBlocks.add(strippedLog, 5, 5);

		if (wood != log) {
			TerrestriaBlocks.add(wood, 5, 5);
		}

		if (strippedWood != strippedLog) {
			TerrestriaBlocks.add(strippedWood, 5, 5);
		}

		TerrestriaBlocks.add(leaves, 30, 60);
	}

	public void addManufacturedFireInfo() {
		TerrestriaBlocks.add(planks, 5, 20);
		TerrestriaBlocks.add(slab, 5, 20);
		TerrestriaBlocks.add(stairs, 5, 20);
		TerrestriaBlocks.add(fence, 5, 20);
		TerrestriaBlocks.add(fenceGate, 5, 20);
	}

	public enum LogSize {
		NORMAL("normal"),
		SMALL("small");

		private final String name;

		LogSize(String name) {
			this.name = name;
		}

		public String getName() {
			return this.name;
		}
	}
}

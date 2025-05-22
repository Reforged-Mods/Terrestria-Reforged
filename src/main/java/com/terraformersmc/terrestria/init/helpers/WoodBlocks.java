package com.terraformersmc.terrestria.init.helpers;

import com.terraformersmc.terraform.leaves.block.LeafPileBlock;
import com.terraformersmc.terraform.leaves.block.TransparentLeavesBlock;
import com.terraformersmc.terraform.sign.block.TerraformHangingSignBlock;
import com.terraformersmc.terraform.sign.block.TerraformSignBlock;
import com.terraformersmc.terraform.sign.block.TerraformWallHangingSignBlock;
import com.terraformersmc.terraform.sign.block.TerraformWallSignBlock;
import com.terraformersmc.terraform.utils.TerraformBlockSettings;
import com.terraformersmc.terraform.utils.TerraformFlammableBlockRegistry;
import com.terraformersmc.terraform.wood.StrippableBlockRegistry;
import com.terraformersmc.terraform.wood.block.PillarLogHelper;
import com.terraformersmc.terraform.wood.block.QuarterLogBlock;
import com.terraformersmc.terraform.wood.block.SmallLogBlock;
import com.terraformersmc.terraform.wood.block.StrippableLogBlock;
import com.terraformersmc.terrestria.Terrestria;
import com.terraformersmc.terrestria.block.TerrestriaOptiLeavesBlock;
import com.terraformersmc.terrestria.init.TerrestriaBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSetType;
import net.minecraft.block.Blocks;
import net.minecraft.block.ButtonBlock;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.FenceGateBlock;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.PillarBlock;
import net.minecraft.block.PressurePlateBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.TrapdoorBlock;
import net.minecraft.block.WoodType;
import net.minecraft.block.WoodenButtonBlock;
import net.minecraft.util.Identifier;
import net.minecraft.util.SignType;

public class WoodBlocks {
	private final String NAME;
	private final WoodColors COLORS;
	private final LogSize SIZE;

	public final BlockSetType setType;
	public final WoodType woodType;
	public final Block log;
	public final Block quarterLog;
	public final Block wood;
	public final Block leaves;
	public final LeafPileBlock leafPile;
	public final Block planks;
	public final SlabBlock slab;
	public final StairsBlock stairs;
	public final FenceBlock fence;
	public final FenceGateBlock fenceGate;
	public final DoorBlock door;
	public final ButtonBlock button;
	public final PressurePlateBlock pressurePlate;
	public final TerraformSignBlock sign;
	public final TerraformWallSignBlock wallSign;
	public final TerraformHangingSignBlock hangingSign;
	public final TerraformWallHangingSignBlock wallHangingSign;
	public final TrapdoorBlock trapdoor;
	public final Block strippedLog;
	public final Block strippedQuarterLog;
	public final Block strippedWood;

	private WoodBlocks(String name, WoodColors colors, LogSize size, boolean hasLeafPile, boolean hasQuarterLog, boolean usesExtendedLeaves) {
		this.NAME = name;
		this.COLORS = colors;
		this.SIZE = size;

		// register manufactured blocks
		setType = BlockSetType.register(new BlockSetType(Terrestria.MOD_ID + ":" + name));
		woodType = WoodType.register(new WoodType(Terrestria.MOD_ID + ":" + name, setType));

		planks = TerrestriaRegistry.register(name + "_planks", new Block(TerraformBlockSettings.copyOf(Blocks.OAK_PLANKS).mapColor(colors.planks)));
		slab = TerrestriaRegistry.register(name + "_slab", new SlabBlock(TerraformBlockSettings.copyOf(Blocks.OAK_SLAB).mapColor(colors.planks)));
		stairs = TerrestriaRegistry.register(name + "_stairs", new StairsBlock(planks.getDefaultState(), TerraformBlockSettings.copyOf(Blocks.OAK_STAIRS).mapColor(colors.planks)));
		fence = TerrestriaRegistry.register(name + "_fence", new FenceBlock(TerraformBlockSettings.copyOf(Blocks.OAK_FENCE).mapColor(colors.planks)));
		fenceGate = TerrestriaRegistry.register(name + "_fence_gate", new FenceGateBlock(TerraformBlockSettings.copyOf(Blocks.OAK_FENCE_GATE).mapColor(colors.planks), woodType));
		door = TerrestriaRegistry.register(name + "_door", new DoorBlock(TerraformBlockSettings.copyOf(Blocks.OAK_DOOR).mapColor(colors.planks), setType));
		button = TerrestriaRegistry.register(name + "_button", new ButtonBlock(TerraformBlockSettings.copyOf(Blocks.OAK_BUTTON).mapColor(colors.planks), setType, 30, true));
		pressurePlate = TerrestriaRegistry.register(name + "_pressure_plate", new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, TerraformBlockSettings.copyOf(Blocks.OAK_PRESSURE_PLATE).mapColor(colors.planks), setType));
		trapdoor = TerrestriaRegistry.register(name + "_trapdoor", new TrapdoorBlock(TerraformBlockSettings.copyOf(Blocks.OAK_TRAPDOOR).mapColor(colors.planks), setType));

		sign = TerrestriaRegistry.register(name + "_sign", new TerraformSignBlock(TerraformBlockSettings.copyOf(Blocks.OAK_SIGN).mapColor(colors.planks), woodType));
		wallSign = TerrestriaRegistry.register(name + "_wall_sign", new TerraformWallSignBlock(TerraformBlockSettings.copyOf(Blocks.OAK_WALL_SIGN).mapColor(colors.planks).dropsLike(sign), woodType));

		hangingSign = TerrestriaRegistry.register(name + "_hanging_sign", new TerraformHangingSignBlock(TerraformBlockSettings.copyOf(Blocks.OAK_HANGING_SIGN).mapColor(colors.planks), woodType));
		wallHangingSign = TerrestriaRegistry.register(name + "_wall_hanging_sign", new TerraformWallHangingSignBlock(TerraformBlockSettings.copyOf(Blocks.OAK_WALL_HANGING_SIGN).mapColor(colors.planks).dropsLike(hangingSign), woodType));

		// register natural and stripped blocks

		if (usesExtendedLeaves) {
			if (size.equals(LogSize.SMALL)) {
				throw new IllegalArgumentException("Small log trees are not compatible with extended leaves, I'm not sure how you even did this...");
			}
			leaves = TerrestriaRegistry.register(name + "_leaves", new TerrestriaOptiLeavesBlock(TerraformBlockSettings.copyOf(Blocks.OAK_LEAVES).mapColor(colors.leaves).allowsSpawning(TerrestriaBlocks::canSpawnOnLeaves).suffocates(TerrestriaBlocks::never).blockVision(TerrestriaBlocks::never)));
		} else {
			if (size.equals(LogSize.SMALL)) {
				leaves = TerrestriaRegistry.register(name + "_leaves", new TransparentLeavesBlock(TerraformBlockSettings.copyOf(Blocks.OAK_LEAVES).mapColor(colors.leaves).allowsSpawning(TerrestriaBlocks::canSpawnOnLeaves).suffocates(TerrestriaBlocks::never).blockVision(TerrestriaBlocks::never)));
			} else {
				leaves = TerrestriaRegistry.register(name + "_leaves", new LeavesBlock(TerraformBlockSettings.copyOf(Blocks.OAK_LEAVES).mapColor(colors.leaves).allowsSpawning(TerrestriaBlocks::canSpawnOnLeaves).suffocates(TerrestriaBlocks::never).blockVision(TerrestriaBlocks::never)));
			}
		}

		if (hasLeafPile) {
			leafPile = TerrestriaRegistry.register(name + "_leaf_pile", new LeafPileBlock(TerraformBlockSettings.copyOf(Blocks.PINK_PETALS).mapColor(colors.leaves)));
		} else {
			leafPile = null;
		}

		if (size.equals(LogSize.SMALL)) {
			// Small logs have neither wood nor quarter logs.
			log = TerrestriaRegistry.register(name + "_log", SmallLogBlock.of(leaves, colors.planks, colors.bark));
			strippedLog = TerrestriaRegistry.register("stripped_" + name + "_log", SmallLogBlock.of(leaves, colors.planks));

			wood = null;
			strippedWood = null;

			quarterLog = null;
			strippedQuarterLog = null;
		} else {
			log = TerrestriaRegistry.register(name + "_log", PillarLogHelper.of(colors.planks, colors.bark));
			strippedLog = TerrestriaRegistry.register("stripped_" + name + "_log", PillarLogHelper.of(colors.planks));

			wood = TerrestriaRegistry.register(name + "_wood", PillarLogHelper.of(colors.bark));
			strippedWood = TerrestriaRegistry.register("stripped_" + name + "_wood", PillarLogHelper.of(colors.planks));

			if (hasQuarterLog) {
				quarterLog = TerrestriaRegistry.register(name + "_quarter_log", QuarterLogBlock.of(colors.planks, colors.bark));
				strippedQuarterLog = TerrestriaRegistry.register("stripped_" + name + "_quarter_log", QuarterLogBlock.of(colors.planks));
			} else {
				quarterLog = null;
				strippedQuarterLog = null;
			}

		}
	}

	public static WoodBlocks register(String name, WoodColors colors, LogSize size, boolean hasLeafPile, boolean hasQuarteredLog, boolean usesExtendedLeaves) {
		WoodBlocks blocks = new WoodBlocks(name, colors, size, hasLeafPile, hasQuarteredLog, usesExtendedLeaves);

		blocks.addFlammables();
		blocks.addStrippables();

		return blocks;
	}

	public static WoodBlocks register(String name, WoodColors colors, LogSize size) {
		return register(name, colors, size, false, false, false);
	}

	public static WoodBlocks register(String name, WoodColors colors) {
		return register(name, colors, LogSize.NORMAL);
	}

	private void addFlammables() {
		// manufactured
		TerraformFlammableBlockRegistry.addFlammableBlock(fence, 5, 20);
		TerraformFlammableBlockRegistry.addFlammableBlock(fenceGate, 5, 20);
		TerraformFlammableBlockRegistry.addFlammableBlock(planks, 5, 20);
		TerraformFlammableBlockRegistry.addFlammableBlock(slab, 5, 20);
		TerraformFlammableBlockRegistry.addFlammableBlock(stairs, 5, 20);

		// tree
		TerraformFlammableBlockRegistry.addFlammableBlock(log, 5, 5);
		TerraformFlammableBlockRegistry.addFlammableBlock(strippedLog, 5, 5);
		if (hasWood()) {
			TerraformFlammableBlockRegistry.addFlammableBlock(wood, 5, 5);
			TerraformFlammableBlockRegistry.addFlammableBlock(strippedWood, 5, 5);
		}
		if (hasQuarterLog()) {
			TerraformFlammableBlockRegistry.addFlammableBlock(quarterLog, 5, 5);
			TerraformFlammableBlockRegistry.addFlammableBlock(strippedQuarterLog, 5, 5);
		}

		TerraformFlammableBlockRegistry.addFlammableBlock(leaves, 30, 60);
		if (hasLeafPile()) {
			TerraformFlammableBlockRegistry.addFlammableBlock(leafPile, 30, 60);
		}
	}

	private void addStrippables() {
		if (log != null && strippedLog != null) {
			StrippableBlockRegistry.register(log, strippedLog);
		}
		if (wood != null && strippedWood != null) {
			StrippableBlockRegistry.register(wood, strippedWood);
		}
		if (quarterLog != null && strippedQuarterLog != null) {
			StrippableBlockRegistry.register(quarterLog, strippedQuarterLog);
		}
	}

	public String getName() {
		return NAME;
	}

	public WoodColors getColors() {
		return COLORS;
	}

	public LogSize getSize() {
		return SIZE;
	}

	public boolean hasQuarterLog() {
		return (quarterLog != null && strippedQuarterLog != null);
	}

	public boolean hasLeafPile() {
		return (leafPile != null);
	}

	public boolean hasWood() {
		return (wood != null && strippedWood != null);
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

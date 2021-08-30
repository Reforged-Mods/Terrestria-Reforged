package com.terraformersmc.terrestria.init.helpers;

import com.terraformersmc.terraform.boat.TerraformBoatEntity;
import com.terraformersmc.terraform.boat.TerraformBoatItem;
import com.terraformersmc.terraform.leaves.ComposterRecipes;
import com.terraformersmc.terrestria.Terrestria;
import com.terraformersmc.terrestria.mixin.AbstractBlockAccessor;
import com.terraformersmc.terrestria.mixin.AbstractBlockSettingsAccessor;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MaterialColor;
import net.minecraft.entity.EntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.SignItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;

public class TerrestriaRegistry {

	public static Map<Identifier, Block> BLOCKS = new LinkedHashMap<>();
	public static Map<Identifier, BlockItem> ITEM_BLOCKS = new LinkedHashMap<>();
	public static Map<Identifier, Item> ITEMS = new LinkedHashMap<>();

	public static BlockItem registerBlockItem(String name, Block block) {
		BlockItem item = new BlockItem(block, new Item.Settings().group(Terrestria.itemGroup));
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

	public static TerraformBoatItem registerBoatItem(String name, Supplier<EntityType<TerraformBoatEntity>> boatType) {
		TerraformBoatItem item = new TerraformBoatItem(boatType, new Item.Settings().group(Terrestria.itemGroup).maxCount(1));
		ITEMS.put(new Identifier(Terrestria.MOD_ID, name), item);
		return item;
	}

	public static <T extends Block> T register(String name, T block) {
		BLOCKS.put(new Identifier(Terrestria.MOD_ID, name), block);
		return block;
	}

	public static AbstractBlock.Settings copy(Block block, MaterialColor color){
		AbstractBlock.Settings setting = AbstractBlock.Settings.of(block.getDefaultState().getMaterial(), color);
		AbstractBlockSettingsAccessor thisAccessor = (AbstractBlockSettingsAccessor) setting;
		AbstractBlockSettingsAccessor otherAccessor = (AbstractBlockSettingsAccessor) ((AbstractBlockAccessor)block).getSettings();

		thisAccessor.setMaterial(otherAccessor.getMaterial());
		((AbstractBlockSettingsAccessor) setting).setHardness(otherAccessor.getHardness());
		((AbstractBlockSettingsAccessor) setting).setResistance(otherAccessor.getResistance());
		((AbstractBlockSettingsAccessor) setting).setCollidable(otherAccessor.getCollidable());
		thisAccessor.setRandomTicks(otherAccessor.getRandomTicks());
		setting.luminance(otherAccessor.getLuminance());
		setting.sounds(otherAccessor.getSoundGroup());
		setting.slipperiness(otherAccessor.getSlipperiness());
		setting.velocityMultiplier(otherAccessor.getVelocityMultiplier());
		thisAccessor.setDynamicBounds(otherAccessor.getDynamicBounds());
		thisAccessor.setOpaque(otherAccessor.getOpaque());
		thisAccessor.setIsAir(otherAccessor.getIsAir());
		thisAccessor.setToolRequired(otherAccessor.isToolRequired());
		return setting;
	}
}

package com.terraformersmc.terrestria;

import com.terraformersmc.terraform.boat.api.client.TerraformBoatClientHelper;
import com.terraformersmc.terraform.sign.SpriteIdentifierRegistry;
import com.terraformersmc.terraform.sign.block.TerraformSignBlock;
import com.terraformersmc.terrestria.init.TerrestriaBlocks;
import com.terraformersmc.terrestria.init.TerrestriaItems;
import net.minecraft.block.Block;
import net.minecraft.client.color.block.BlockColorProvider;
import net.minecraft.client.color.item.ItemColorProvider;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.color.world.FoliageColors;
import net.minecraft.client.color.world.GrassColors;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.RenderLayers;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.util.Identifier;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import java.util.LinkedHashMap;
import java.util.Map;

// This class is an entrypoint
@OnlyIn(Dist.CLIENT)
public class TerrestriaClient {
	@SuppressWarnings("unused")
	private static final RenderLayer LEAVES_ITEM_LAYER = TexturedRenderLayers.getEntityCutout();
	private static final RenderLayer GRASS_BLOCK_LAYER = RenderLayer.getCutoutMipped();
	private static final RenderLayer PLANT_BLOCK_LAYER = RenderLayer.getCutout();
	private static final RenderLayer DOOR_BLOCK_LAYER = RenderLayer.getCutout();


	public void onInitializeClient() {
		// Load the client config if it hasn't been loaded already
		Terrestria.getConfigManager().getClientConfig();

		ColorProviderRegistry.BLOCK.register(
				FOLIAGE_BLOCK_COLORS,
				TerrestriaBlocks.RUBBER.leaves,
				TerrestriaBlocks.CYPRESS.leaves,
				TerrestriaBlocks.WILLOW.leaves,
				TerrestriaBlocks.RAINBOW_EUCALYPTUS.leaves,
				TerrestriaBlocks.JAPANESE_MAPLE_SHRUB_LEAVES,
				TerrestriaBlocks.REDWOOD.leaves,
				TerrestriaBlocks.HEMLOCK.leaves,
				TerrestriaBlocks.SMALL_OAK_LOG,
				TerrestriaBlocks.STRIPPED_SMALL_OAK_LOG
		);

		BlockRenderLayerMap.INSTANCE.putBlock(TerrestriaBlocks.SAKURA_LEAF_PILE, RenderLayer.getCutoutMipped());

		BlockRenderLayerMap.INSTANCE.putBlocks(
				DOOR_BLOCK_LAYER,
				TerrestriaBlocks.REDWOOD.door,
				TerrestriaBlocks.RAINBOW_EUCALYPTUS.door,
				TerrestriaBlocks.CYPRESS.door,
				TerrestriaBlocks.WILLOW.door,
				TerrestriaBlocks.JAPANESE_MAPLE.door,
				TerrestriaBlocks.RAINBOW_EUCALYPTUS.trapdoor,
				TerrestriaBlocks.CYPRESS.trapdoor,
				TerrestriaBlocks.WILLOW.trapdoor
		);

		BlockRenderLayerMap.INSTANCE.putBlocks(
				PLANT_BLOCK_LAYER,
				// Needs to be transparent because of the log cutout part.
				// TODO: Edit the model so that it can be conditionally transparent like actual leaves!
				// Currently they will always be transparent.
				TerrestriaBlocks.SAKURA.log,
				TerrestriaBlocks.SAKURA.strippedLog,
				TerrestriaBlocks.SMALL_OAK_LOG,
				TerrestriaBlocks.STRIPPED_SMALL_OAK_LOG,
				TerrestriaBlocks.YUCCA_PALM.log,
				TerrestriaBlocks.YUCCA_PALM.strippedLog,
				TerrestriaBlocks.REDWOOD_SAPLING,
				TerrestriaBlocks.HEMLOCK_SAPLING,
				TerrestriaBlocks.RUBBER_SAPLING,
				TerrestriaBlocks.CYPRESS_SAPLING,
				TerrestriaBlocks.WILLOW_SAPLING,
				TerrestriaBlocks.JAPANESE_MAPLE_SAPLING,
				TerrestriaBlocks.JAPANESE_MAPLE_SHRUB_SAPLING,
				TerrestriaBlocks.DARK_JAPANESE_MAPLE_SAPLING,
				TerrestriaBlocks.RAINBOW_EUCALYPTUS_SAPLING,
				TerrestriaBlocks.SAKURA_SAPLING,
				TerrestriaBlocks.JUNGLE_PALM_SAPLING,
				TerrestriaBlocks.BRYCE_SAPLING,
				TerrestriaBlocks.YUCCA_PALM_SAPLING,
				TerrestriaBlocks.CATTAIL,
				TerrestriaBlocks.TALL_CATTAIL,
				TerrestriaBlocks.INDIAN_PAINTBRUSH,
				TerrestriaBlocks.MONSTERAS,
				TerrestriaBlocks.ALOE_VERA,
				TerrestriaBlocks.AGAVE,
				TerrestriaBlocks.TINY_CACTUS,
				TerrestriaBlocks.DEAD_GRASS,
				TerrestriaBlocks.SAGUARO_CACTUS_SAPLING
		);

		BlockRenderLayerMap.INSTANCE.putBlocks(
				PLANT_BLOCK_LAYER,
				TerrestriaBlocks.POTTED_BRYCE_SAPLING,
				TerrestriaBlocks.POTTED_REDWOOD_SAPLING,
				TerrestriaBlocks.POTTED_HEMLOCK_SAPLING,
				TerrestriaBlocks.POTTED_RUBBER_SAPLING,
				TerrestriaBlocks.POTTED_CYPRESS_SAPLING,
				TerrestriaBlocks.POTTED_WILLOW_SAPLING,
				TerrestriaBlocks.POTTED_JAPANESE_MAPLE_SAPLING,
				TerrestriaBlocks.POTTED_JAPANESE_MAPLE_SHRUB_SAPLING,
				TerrestriaBlocks.POTTED_DARK_JAPANESE_MAPLE_SAPLING,
				TerrestriaBlocks.POTTED_RAINBOW_EUCALYPTUS_SAPLING,
				TerrestriaBlocks.POTTED_SAKURA_SAPLING,
				TerrestriaBlocks.POTTED_JUNGLE_PALM_SAPLING,
				TerrestriaBlocks.POTTED_INDIAN_PAINTBRUSH,
				TerrestriaBlocks.POTTED_MONSTERAS,
				TerrestriaBlocks.POTTED_AGAVE,
				TerrestriaBlocks.POTTED_ALOE_VERA,
				TerrestriaBlocks.POTTED_TINY_CACTUS,
				TerrestriaBlocks.POTTED_SAGUARO_CACTUS_SAPLING,
				TerrestriaBlocks.POTTED_YUCCA_PALM_SAPLING
		);

		addColoredGrass(TerrestriaBlocks.ANDISOL.getGrassBlock());

		addSigns(
				TerrestriaBlocks.REDWOOD.sign,
				TerrestriaBlocks.HEMLOCK.sign,
				TerrestriaBlocks.RUBBER.sign,
				TerrestriaBlocks.CYPRESS.sign,
				TerrestriaBlocks.WILLOW.sign,
				TerrestriaBlocks.JAPANESE_MAPLE.sign,
				TerrestriaBlocks.RAINBOW_EUCALYPTUS.sign,
				TerrestriaBlocks.SAKURA.sign,
				TerrestriaBlocks.YUCCA_PALM.sign
		);

		ColorProviderRegistry.ITEM.register(
				FOLIAGE_ITEM_COLORS,
				TerrestriaItems.RUBBER.leaves,
				TerrestriaItems.CYPRESS.leaves,
				TerrestriaItems.WILLOW.leaves,
				TerrestriaItems.RAINBOW_EUCALYPTUS.leaves,
				TerrestriaItems.JAPANESE_MAPLE_SHRUB_LEAVES,
				TerrestriaItems.REDWOOD.leaves,
				TerrestriaItems.HEMLOCK.leaves
		);

		BlockRenderLayerMap.INSTANCE.putItem(TerrestriaItems.SAKURA_LEAF_PILE, RenderLayer.getCutoutMipped());

		ColorProviderRegistry.ITEM.register(
				GRASS_ITEM_COLORS,
				TerrestriaItems.ANDISOL_GRASS_BLOCK
		);
		registerEntityRenderers();
	}

	private void registerEntityRenderers() {
		TerraformBoatClientHelper.registerModelLayer(new Identifier(Terrestria.MOD_ID, "redwood"));
		TerraformBoatClientHelper.registerModelLayer(new Identifier(Terrestria.MOD_ID, "hemlock"));
		TerraformBoatClientHelper.registerModelLayer(new Identifier(Terrestria.MOD_ID, "rubber"));
		TerraformBoatClientHelper.registerModelLayer(new Identifier(Terrestria.MOD_ID, "cypress"));
		TerraformBoatClientHelper.registerModelLayer(new Identifier(Terrestria.MOD_ID, "willow"));
		TerraformBoatClientHelper.registerModelLayer(new Identifier(Terrestria.MOD_ID, "japanese_maple"));
		TerraformBoatClientHelper.registerModelLayer(new Identifier(Terrestria.MOD_ID, "rainbow_eucalyptus"));
		TerraformBoatClientHelper.registerModelLayer(new Identifier(Terrestria.MOD_ID, "sakura"));
		TerraformBoatClientHelper.registerModelLayer(new Identifier(Terrestria.MOD_ID, "yucca_palm"));
	}

	private void addSigns(TerraformSignBlock... signs) {
		for (TerraformSignBlock sign : signs) {
			addSign(sign);
		}
	}

	private void addSign(TerraformSignBlock sign) {
		Identifier texture = sign.getTexture();

		SpriteIdentifierRegistry.INSTANCE.addIdentifier(new SpriteIdentifier(TexturedRenderLayers.SIGNS_ATLAS_TEXTURE, texture));
	}

	private void addColoredGrass(Block grass) {
		BlockRenderLayerMap.INSTANCE.putBlock(grass, GRASS_BLOCK_LAYER);
		ColorProviderRegistry.BLOCK.register(GRASS_BLOCK_COLORS, grass);
	}
}

package com.terraformersmc.terrestria.client;

import com.terraformersmc.terraform.boat.api.client.TerraformBoatClientHelper;
import com.terraformersmc.terraform.sign.SpriteIdentifierRegistry;
import com.terraformersmc.terraform.sign.block.TerraformSignBlock;
import com.terraformersmc.terrestria.Terrestria;
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
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

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

	private static final Map<Block, BlockColorProvider> COLOR_PROVIDERS = new LinkedHashMap<>();
	private static final Map<Item, ItemColorProvider> ITEM_COLOR_PROVIDERS = new LinkedHashMap<>();

	private static final BlockColorProvider FOLIAGE_BLOCK_COLORS =
			(block, world, pos, layer) -> world != null && pos != null ? BiomeColors.getFoliageColor(world, pos) : FoliageColors.getDefaultColor();
	private static final BlockColorProvider GRASS_BLOCK_COLORS =
			(block, world, pos, layer) -> world != null && pos != null ? BiomeColors.getGrassColor(world, pos) : GrassColors.getColor(0.5, 1.0);
	private static final ItemColorProvider FOLIAGE_ITEM_COLORS =
			(item, layer) -> FoliageColors.getColor(0.5, 1.0);
	private static final ItemColorProvider GRASS_ITEM_COLORS =
			(item, layer) -> GrassColors.getColor(0.5, 1.0);

	public TerrestriaClient(){
		IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
		eventBus.addListener(TerrestriaClient::onItemColorHandler);
		eventBus.addListener(TerrestriaClient::onBlockColorHandler);
		eventBus.addListener(this::clientSetup);
		registerEntityRenderers();
	}

	private void clientSetup(FMLClientSetupEvent event){
		onInitializeClient();
	}

	public static void addColors(){
		addArrayToColors(
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
		addItemArrayToColors(
				FOLIAGE_ITEM_COLORS,
				TerrestriaItems.RUBBER.leaves,
				TerrestriaItems.CYPRESS.leaves,
				TerrestriaItems.WILLOW.leaves,
				TerrestriaItems.RAINBOW_EUCALYPTUS.leaves,
				TerrestriaItems.JAPANESE_MAPLE_SHRUB_LEAVES,
				TerrestriaItems.REDWOOD.leaves,
				TerrestriaItems.HEMLOCK.leaves
		);
		addItemArrayToColors(
				GRASS_ITEM_COLORS,
				TerrestriaItems.ANDISOL_GRASS_BLOCK
		);
		addColoredGrass(TerrestriaBlocks.ANDISOL.getGrassBlock());
	}

	public void onInitializeClient() {
		// Load the client config if it hasn't been loaded already
		Terrestria.getConfigManager().getClientConfig();

		RenderLayers.setRenderLayer(TerrestriaBlocks.SAKURA_LEAF_PILE, RenderLayer.getCutoutMipped());

		addArrayToLayer(
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

		addArrayToLayer(
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

		addArrayToLayer(
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

		RenderLayers.setRenderLayer(TerrestriaBlocks.ANDISOL.getGrassBlock(), GRASS_BLOCK_LAYER);

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

		//RenderLayers.setRenderLayer(TerrestriaItems.SAKURA_LEAF_PILE, RenderLayer.getCutoutMipped());
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

	public static void addArrayToLayer(RenderLayer layer, Block... blocks){
		for (Block block : blocks) {
			RenderLayers.setRenderLayer(block, layer);
		}
	}

	private static void addColoredGrass(Block grass) {
		addArrayToColors(GRASS_BLOCK_COLORS, grass);
	}

	public static void addArrayToColors(BlockColorProvider color, Block... blocks){
		for (Block block : blocks) {
			COLOR_PROVIDERS.put(block, color);
		}
	}

	public static void addItemArrayToColors(ItemColorProvider color, Item... blocks){
		for (Item block : blocks) {
			ITEM_COLOR_PROVIDERS.put(block, color);
		}
	}

	public static void onItemColorHandler(ColorHandlerEvent.Item e) {
		for (Item item : ITEM_COLOR_PROVIDERS.keySet()){
			e.getItemColors().register(ITEM_COLOR_PROVIDERS.get(item), item);
		}
	}

	public static void onBlockColorHandler(ColorHandlerEvent.Block e) {
		addColors();
		for (Block block : COLOR_PROVIDERS.keySet()) {
			e.getBlockColors().registerColorProvider(COLOR_PROVIDERS.get(block), block);
		}
	}
}

package com.terraformersmc.terrestria;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.terraformersmc.terraform.config.BiomeConfig;
import com.terraformersmc.terraform.config.BiomeConfigHandler;
import com.terraformersmc.terraform.leaves.ComposterRecipes;
import com.terraformersmc.terrestria.config.TerrestriaConfigManager;
import com.terraformersmc.terrestria.feature.StructureBuilder;
import com.terraformersmc.terrestria.init.TerrestriaBiomes;
import com.terraformersmc.terrestria.init.TerrestriaBlocks;
import com.terraformersmc.terrestria.init.TerrestriaConfiguredFeatures;
import com.terraformersmc.terrestria.init.TerrestriaDecoratedFeatures;
import com.terraformersmc.terrestria.init.TerrestriaEntities;
import com.terraformersmc.terrestria.init.TerrestriaFeatures;
import com.terraformersmc.terrestria.init.TerrestriaFoliagePlacerTypes;
import com.terraformersmc.terrestria.init.TerrestriaGeneration;
import com.terraformersmc.terrestria.init.TerrestriaItems;
import com.terraformersmc.terrestria.init.TerrestriaStructures;
import com.terraformersmc.terrestria.init.TerrestriaSurfaces;
import com.terraformersmc.terrestria.init.TerrestriaTreeDecorators;
import com.terraformersmc.terrestria.init.TerrestriaTrunkPlacerTypes;
import com.terraformersmc.terrestria.init.TerrestriaVillagerTypes;
import com.terraformersmc.terrestria.init.helpers.TerrestriaRegistry;
import com.terraformersmc.terrestria.item.LogTurnerItem;
import com.terraformersmc.terrestria.mixin.StructureFeatureAccessor;
import com.terraformersmc.terrestria.mixin.StructuresConfigAccessor;
import com.terraformersmc.terrestria.proxy.IProxy;
import com.terraformersmc.terrestria.proxy.ProxyClient;
import com.terraformersmc.terrestria.proxy.ProxyCommon;
import net.minecraft.block.Block;
import net.minecraft.block.ComposterBlock;
import net.minecraft.entity.EntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.chunk.StructureConfig;
import net.minecraft.world.gen.chunk.StructuresConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraft.world.gen.foliage.FoliagePlacerType;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.tree.TreeDecoratorType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashSet;
import java.util.Set;

@Mod(Terrestria.MOD_ID)
public class Terrestria {
	public static final String MOD_ID = "terrestria";
	public static ItemGroup itemGroup;
	public static BiomeConfigHandler biomeConfigHandler;
	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);
	IProxy PROXY;
	public Terrestria(){
		// Load the general config if it hasn't been loaded already
		CONFIG_MANAGER.getGeneralConfig();
		PROXY = DistExecutor.runForDist(() -> ProxyClient::new, () -> ProxyCommon::new); // todo: scheduled to change in new Forge


		IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
		eventBus.addListener(this::setup);
		eventBus.addListener(this::clientSetup);
		eventBus.register(this);
		itemGroup = new ItemGroup(MOD_ID + ".items") {
			@Override
			public ItemStack createIcon() {
				return new ItemStack(TerrestriaItems.RUBBER_SAPLING);
			}
		};
		biomeConfigHandler = new BiomeConfigHandler(MOD_ID);

		TerrestriaBlocks.init();
		TerrestriaItems.init();
		TerrestriaEntities.init();
		TerrestriaFoliagePlacerTypes.init();
		TerrestriaTrunkPlacerTypes.init();
		TerrestriaTreeDecorators.init();
		TerrestriaFeatures.init();
		TerrestriaConfiguredFeatures.init();
		TerrestriaDecoratedFeatures.init();
		TerrestriaStructures.init();
		TerrestriaSurfaces.init();
		TerrestriaBiomes.init();
		TerrestriaVillagerTypes.init();
		PROXY.onConstruction();

		TerrestriaRegistry.ITEMS.put(new Identifier(MOD_ID, "log_turner"), new LogTurnerItem(new Item.Settings().group(itemGroup)));
	}

	@OnlyIn(Dist.CLIENT)
	private void clientSetup(final FMLClientSetupEvent e){
		ProxyClient.setup(e);
	}

	private void setup(final FMLCommonSetupEvent e) {
		BiomeConfig config = biomeConfigHandler.getBiomeConfig();
		Set<String> enabledBiomes = new HashSet<>();
		TerrestriaGeneration.init(config, enabledBiomes);
		biomeConfigHandler.save();
		StructuresConfigAccessor.setDefaults(
				ImmutableMap.<StructureFeature<?>, StructureConfig>builder()
				.putAll(StructuresConfig.DEFAULT_STRUCTURES)
				.putAll(StructureBuilder.STRUCTURE_TO_CONFIG_MAP)
				.build());
		StructureFeatureAccessor.setSurfaceAdjustingStructures(ImmutableList.<StructureFeature<?>>builder()
				.addAll(StructureFeature.JIGSAW_STRUCTURES)
				.addAll(StructureBuilder.ADJUSTS_SURFACE_LIST)
				.build());
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(TerrestriaBlocks.SAGUARO_CACTUS, 0.25F);
	}

	private static final TerrestriaConfigManager CONFIG_MANAGER = new TerrestriaConfigManager();

	public static TerrestriaConfigManager getConfigManager() {
		return CONFIG_MANAGER;
	}

	@SubscribeEvent
	public void onRegister(final RegistryEvent.Register<?> event){
		if (event.getRegistry() == ForgeRegistries.FEATURES){
			for (Identifier id : TerrestriaFeatures.FEATURES.keySet()){
				Feature<?> feature = TerrestriaFeatures.FEATURES.get(id);
				if (feature.getRegistryName() == null){
					feature.setRegistryName(id);
				}
				((IForgeRegistry)event.getRegistry()).register(feature);
			}
		}
		if (event.getRegistry() == ForgeRegistries.STRUCTURE_FEATURES){
			for (Identifier id : StructureBuilder.STRUCTURE_FEATURES.keySet()){
				StructureFeature<?> feature = StructureBuilder.STRUCTURE_FEATURES.get(id);
				if (feature.getRegistryName() == null){
					feature.setRegistryName(id);
				}
				((IForgeRegistry)event.getRegistry()).register(feature);
			}
		}
		if (event.getRegistry() == ForgeRegistries.ENTITIES){
			for (Identifier id : TerrestriaEntities.ENTITIES.keySet()){
				EntityType<?> feature = TerrestriaEntities.ENTITIES.get(id);
				if (feature.getRegistryName() == null){
					feature.setRegistryName(id);
				}
				((IForgeRegistry)event.getRegistry()).register(feature);
			}
		}
		if (event.getRegistry() == ForgeRegistries.SURFACE_BUILDERS){
			for (Identifier id : TerrestriaSurfaces.SURFACE_BUILDERS.keySet()){
				SurfaceBuilder<?> feature = TerrestriaSurfaces.SURFACE_BUILDERS.get(id);
				if (feature.getRegistryName() == null){
					feature.setRegistryName(id);
				}
				((IForgeRegistry)event.getRegistry()).register(feature);
			}
		}
		if (event.getRegistry() == ForgeRegistries.TREE_DECORATOR_TYPES){
			for (Identifier id : TerrestriaTreeDecorators.TREE_DECORATOR_TYPES.keySet()){
				TreeDecoratorType<?> feature = TerrestriaTreeDecorators.TREE_DECORATOR_TYPES.get(id);
				if (feature.getRegistryName() == null){
					feature.setRegistryName(id);
				}
				((IForgeRegistry)event.getRegistry()).register(feature);
			}
		}
		if (event.getRegistry() == ForgeRegistries.FOLIAGE_PLACER_TYPES){
			for (Identifier id : TerrestriaFoliagePlacerTypes.FOILAGE_PLACER_TYPES.keySet()){
				FoliagePlacerType<?> feature = TerrestriaFoliagePlacerTypes.FOILAGE_PLACER_TYPES.get(id);
				if (feature.getRegistryName() == null){
					feature.setRegistryName(id);
				}
				((IForgeRegistry)event.getRegistry()).register(feature);
			}
		}
		if (event.getRegistry() == ForgeRegistries.BIOMES){
			for (Identifier id : TerrestriaBiomes.BIOMES.keySet()){
				Biome feature = TerrestriaBiomes.BIOMES.get(id);
				if (feature.getRegistryName() == null){
					feature.setRegistryName(id);
				}
				((IForgeRegistry)event.getRegistry()).register(feature);
			}
		}
		if (event.getRegistry() == ForgeRegistries.BLOCKS){
			for (Identifier id : TerrestriaRegistry.BLOCKS.keySet()) {
				Block block = TerrestriaRegistry.BLOCKS.get(id);
				if (block.getRegistryName() == null){
					block.setRegistryName(id);
				}
				((IForgeRegistry)event.getRegistry()).register(block);
			}
		}
		if (event.getRegistry() == ForgeRegistries.ITEMS){
			for (Identifier id : TerrestriaRegistry.ITEMS.keySet()) {
				Item item = TerrestriaRegistry.ITEMS.get(id);
				if (item.getRegistryName() == null){
					item.setRegistryName(id);
				}
				((IForgeRegistry)event.getRegistry()).register(item);
			}
			for (Identifier id : TerrestriaRegistry.ITEM_BLOCKS.keySet()) {
				BlockItem item = TerrestriaRegistry.ITEM_BLOCKS.get(id);
				if (item.getRegistryName() == null){
					item.setRegistryName(id);
				}
				((IForgeRegistry)event.getRegistry()).register(item);
			}
		}

	}
}

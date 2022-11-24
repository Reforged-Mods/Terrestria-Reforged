package com.terraformersmc.terrestria;

import com.terraformersmc.terrestria.config.TerrestriaConfigManager;
import com.terraformersmc.terrestria.data.TerrestriaDatagen;
import com.terraformersmc.terrestria.init.*;
import com.terraformersmc.terrestria.init.helpers.TerrestriaPlacementModifierType;
import com.terraformersmc.terrestria.init.helpers.TerrestriaRegistry;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraft.world.gen.foliage.FoliagePlacerType;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModContainer;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

@Mod("terrestria_common")
public class Terrestria {
	public static final String MOD_ID = "terrestria";
	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

	private static final TerrestriaConfigManager CONFIG_MANAGER = new TerrestriaConfigManager();

	private static Boolean initialized = false;
	private static final ArrayList<Runnable> runnables = new ArrayList<>(1);

	public static ItemGroup itemGroup;

	public Terrestria(){
		IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
		eventBus.addListener(this::commonLoad);
		eventBus.register(this);
		itemGroup = new ItemGroup(MOD_ID + ".items") {
			@Override
			public ItemStack createIcon() {
				return new ItemStack(TerrestriaItems.RUBBER_SAPLING);
			}
		};
	}

	private static void register() {
		ModContainer previous = ModLoadingContext.get().getActiveContainer();
		ModContainer newContainer = ModList.get().getModContainerById(MOD_ID).orElse(null);
		if (newContainer == null) return;
		ModLoadingContext.get().setActiveContainer(newContainer);
		// Load the general config if it hasn't been loaded already
		CONFIG_MANAGER.getGeneralConfig();

		TerrestriaBlocks.init();
		TerrestriaBoats.init();
		TerrestriaItems.init();
		TerrestriaPlacementModifierType.init();
		TerrestriaFoliagePlacerTypes.init();
		TerrestriaTrunkPlacerTypes.init();
		TerrestriaTreeDecorators.init();
		TerrestriaFeatures.init();
		TerrestriaConfiguredFeatures.init();
		TerrestriaPlacedFeatures.init();
		TerrestriaStructures.init();
		StructureFeature.init();
		TerrestriaBiomes.init();
		TerrestriaVillagerTypes.init();

		// This must be after TerrestriaBiomes.init()
		CONFIG_MANAGER.getBiomeConfig();
		ModLoadingContext.get().setActiveContainer(previous);
	}

	public void onInitialize() {
		register();

		if (!ModList.get().isLoaded("terrestria_worldgen")) {
			Terrestria.LOGGER.info("No Terrestria worldgen module present; Terrestria biomes will not generate.");
		}

		// At this point Terrestria is completely initialized.
		initialized = true;
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
		/*if (event.getRegistry() == ForgeRegistries.STRUCTURE_FEATURES){
			for (Identifier id : StructureBuilder.STRUCTURE_FEATURES.keySet()){
				StructureFeature<?> feature = StructureBuilder.STRUCTURE_FEATURES.get(id);
				if (feature.getRegistryName() == null){
					feature.setRegistryName(id);
				}
				((IForgeRegistry)event.getRegistry()).register(feature);
			}
		}*/
		/*if (event.getRegistry() == ForgeRegistries.ENTITIES){
			for (Identifier id : TerrestriaEntities.ENTITIES.keySet()){
				EntityType<?> feature = TerrestriaEntities.ENTITIES.get(id);
				if (feature.getRegistryName() == null){
					feature.setRegistryName(id);
				}
				((IForgeRegistry)event.getRegistry()).register(feature);
			}
		}*/
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
		/*if (event.getRegistry() == ForgeRegistries.BIOMES){
			for (Identifier id : TerrestriaBiomes.BIOMES.keySet()){
				Biome feature = TerrestriaBiomes.BIOMES.get(id);
				if (feature.getRegistryName() == null){
					feature.setRegistryName(id);
				}
				((IForgeRegistry)event.getRegistry()).register(feature);
			}
		}*/
		if (event.getRegistry() == ForgeRegistries.BLOCKS){
			onInitialize();
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

	private void commonLoad(FMLCommonSetupEvent event){
		runnables.forEach(event::enqueueWork);
		TerrestriaDatagen.onInitializeDataGenerator();
	}

	public static void callbackWhenInitialized(Runnable callback) {
		if (initialized) {
			callback.run();
		} else {
			runnables.add(callback);
		}
	}

	public static TerrestriaConfigManager getConfigManager() {
		return CONFIG_MANAGER;
	}
}

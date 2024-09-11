package com.terraformersmc.terrestria;

import com.terraformersmc.terrestria.client.TerrestriaClient;
import com.terraformersmc.terrestria.config.TerrestriaConfigManager;
import com.terraformersmc.terrestria.init.TerrestriaBiomes;
import com.terraformersmc.terrestria.init.TerrestriaBlocks;
import com.terraformersmc.terrestria.init.TerrestriaConfiguredFeatures;
import com.terraformersmc.terrestria.init.TerrestriaFeatures;
import com.terraformersmc.terrestria.init.TerrestriaFoliagePlacerTypes;
import com.terraformersmc.terrestria.init.TerrestriaItems;
import com.terraformersmc.terrestria.init.TerrestriaPlacedFeatures;
import com.terraformersmc.terrestria.init.TerrestriaStructures;
import com.terraformersmc.terrestria.init.TerrestriaTreeDecorators;
import com.terraformersmc.terrestria.init.TerrestriaTrunkPlacerTypes;
import com.terraformersmc.terrestria.init.TerrestriaVillagerTypes;
import com.terraformersmc.terrestria.init.helpers.TerrestriaPlacementModifierType;
import com.terraformersmc.terrestria.worldgen.TerrestriaWorldgen;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModContainer;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

@Mod(Terrestria.MOD_ID)
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
		DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> TerrestriaClient::new);
		new TerrestriaWorldgen();
		itemGroup = new ItemGroup(MOD_ID + ".items") {

			@Override
			public void appendStacks(DefaultedList<ItemStack> stacks) {
				super.appendStacks(stacks);
				Registry.ITEM.forEach(item -> {
					if (Registry.ITEM.getId(item).getNamespace().equals(MOD_ID)) {
						item.appendStacks(item.getGroup(), stacks);
					}
				});
			}

			@Override
			public ItemStack createIcon() {
				return new ItemStack(TerrestriaItems.RUBBER_SAPLING);
			}
		};
	}

	private static void register() {
		// Load the general config if it hasn't been loaded already
		CONFIG_MANAGER.getGeneralConfig();

		TerrestriaBlocks.init();
		TerrestriaItems.init();
		TerrestriaPlacementModifierType.init();
		TerrestriaFoliagePlacerTypes.init();
		TerrestriaTrunkPlacerTypes.init();
		TerrestriaTreeDecorators.init();
		TerrestriaFeatures.init();
		TerrestriaConfiguredFeatures.init();
		TerrestriaPlacedFeatures.init();
		TerrestriaStructures.init();
		TerrestriaBiomes.init();
		TerrestriaVillagerTypes.init();

		// This must be after TerrestriaBiomes.init()
		CONFIG_MANAGER.getBiomeConfig();
	}

	public void onInitialize() {
		register();

		// At this point Terrestria is completely initialized.
		initialized = true;
	}

	@SubscribeEvent
	public void onRegister(final RegisterEvent event){
		if (event.getRegistryKey() == ForgeRegistries.Keys.BLOCKS) {
			onInitialize();
		}
	}

	private void commonLoad(FMLCommonSetupEvent event){
		runnables.forEach(event::enqueueWork);
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

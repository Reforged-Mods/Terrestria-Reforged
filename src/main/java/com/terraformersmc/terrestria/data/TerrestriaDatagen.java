package com.terraformersmc.terrestria.data;

import com.terraformersmc.terrestria.Terrestria;
import net.minecraft.data.DataGenerator;
import net.minecraft.registry.RegistryWrapper.WrapperLookup;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = Terrestria.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class TerrestriaDatagen {
	public static void onInitializeDataGenerator(DataGenerator dataGenerator, ExistingFileHelper helper, CompletableFuture<WrapperLookup> lookup) {
		dataGenerator.addProvider(true, new TerrestriaBiomeTagProvider(dataGenerator.getPackOutput(), lookup, helper));
		dataGenerator.addProvider(true, new TerrestriaLootTableProvider(dataGenerator.getPackOutput()));
		BlockTagsProvider provider = new TerrestriaBlockTagProvider(dataGenerator.getPackOutput(), lookup, helper);
		dataGenerator.addProvider(true, provider);
		dataGenerator.addProvider(true, new TerrestriaItemTagProvider(dataGenerator.getPackOutput(), lookup, provider.getTagLookupFuture(), helper));
		dataGenerator.addProvider(true, new TerrestriaRecipeProvider(dataGenerator.getPackOutput()));
		dataGenerator.addProvider(true, new TerrestriaDatapackBuiltinEntriesProvider(dataGenerator.getPackOutput(), lookup));
	}

	@SubscribeEvent
	public static void onGatherDataEvent(GatherDataEvent event){
		onInitializeDataGenerator(event.getGenerator(), event.getExistingFileHelper(), event.getLookupProvider());
	}
}

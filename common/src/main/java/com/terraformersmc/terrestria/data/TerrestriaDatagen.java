package com.terraformersmc.terrestria.data;

import com.terraformersmc.terrestria.Terrestria;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.server.BlockTagProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = Terrestria.MOD_ID + "_common", bus = Mod.EventBusSubscriber.Bus.MOD)
public class TerrestriaDatagen {
	public static void onInitializeDataGenerator(DataGenerator dataGenerator, ExistingFileHelper helper) {
		dataGenerator.addProvider(new TerrestriaBiomeTagProvider(dataGenerator, helper));
		dataGenerator.addProvider(new TerrestriaLootTableProvider(dataGenerator));
		BlockTagProvider provider = new TerrestriaBlockTagProvider(dataGenerator, helper);
		dataGenerator.addProvider(provider);
		dataGenerator.addProvider(new TerrestriaItemTagProvider(dataGenerator, provider, helper));
		dataGenerator.addProvider(new TerrestriaRecipeProvider(dataGenerator));
	}

	@SubscribeEvent
	public static void onGatherDataEvent(GatherDataEvent event){
		onInitializeDataGenerator(event.getGenerator(), event.getExistingFileHelper());
	}
}

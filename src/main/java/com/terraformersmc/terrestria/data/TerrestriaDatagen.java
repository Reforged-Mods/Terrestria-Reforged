package com.terraformersmc.terrestria.data;

import com.terraformersmc.terrestria.Terrestria;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.server.BlockTagProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Terrestria.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class TerrestriaDatagen {
	public static void onInitializeDataGenerator(DataGenerator dataGenerator, ExistingFileHelper helper) {
		dataGenerator.addProvider(true, new TerrestriaBiomeTagProvider(dataGenerator, helper));
		dataGenerator.addProvider(true, new TerrestriaLootTableProvider(dataGenerator));
		BlockTagProvider provider = new TerrestriaBlockTagProvider(dataGenerator, helper);
		dataGenerator.addProvider(true, provider);
		dataGenerator.addProvider(true, new TerrestriaItemTagProvider(dataGenerator, provider, helper));
		dataGenerator.addProvider(true, new TerrestriaRecipeProvider(dataGenerator));
	}

	@SubscribeEvent
	public static void onGatherDataEvent(GatherDataEvent event){
		onInitializeDataGenerator(event.getGenerator(), event.getExistingFileHelper());
	}
}

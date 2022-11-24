package com.terraformersmc.terrestria.data;

import com.terraformersmc.terrestria.Terrestria;
import net.devtech.arrp.api.RRPEvent;
import net.devtech.arrp.api.RuntimeResourcePack;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Terrestria.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class TerrestriaDatagen {

	public static final RuntimeResourcePack RUNTIME_RESOURCE_PACK = RuntimeResourcePack.create("terrestria:dynamic");

	public static void onInitializeDataGenerator() {
		TerrestriaBiomeTagProvider.init();
		TerrestriaBlockLootTableProvider.init();
		TerrestriaBlockTagProvider.init();
		TerrestriaItemTagProvider.init();
		//TerrestriaRecipeProvider.init();
		RUNTIME_RESOURCE_PACK.dump();
	}

	@SubscribeEvent
	public static void onResourcePackAddAfter(RRPEvent.AfterVanilla event){
		event.addPack(RUNTIME_RESOURCE_PACK);
	}

	public static Identifier tagID(TagKey<?> key){
		return new Identifier(key.id().getNamespace(), key.registry().getValue().getPath() + "/" + key.id().getPath());
	}
}

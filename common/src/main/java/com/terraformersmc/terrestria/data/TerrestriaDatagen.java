package com.terraformersmc.terrestria.data;

import net.devtech.arrp.api.RuntimeResourcePack;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;

public class TerrestriaDatagen {

	public static final RuntimeResourcePack RUNTIME_RESOURCE_PACK = RuntimeResourcePack.create("terrestria:dynamic");

	public void onInitializeDataGenerator() {
		TerrestriaBiomeTagProvider.init();
		TerrestriaBlockLootTableProvider.init();
		TerrestriaBlockTagProvider.init();
		dataGenerator.addProvider(TerrestriaItemTagProvider::new);
		dataGenerator.addProvider(TerrestriaRecipeProvider::new);
	}

	public static Identifier tagID(TagKey<?> key){
		return new Identifier(key.id().getNamespace(), key.registry().getValue().getPath() + "/" + key.id().getPath());
	}
}

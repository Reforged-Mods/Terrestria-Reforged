package com.terraformersmc.terrestria.data;

import com.terraformersmc.terrestria.Terrestria;
import com.terraformersmc.terrestria.init.TerrestriaBiomes;
import com.terraformersmc.terrestria.init.TerrestriaConfiguredFeatures;
import com.terraformersmc.terrestria.init.TerrestriaPlacedFeatures;
import net.minecraft.data.DataOutput;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper.WrapperLookup;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class TerrestriaDatapackBuiltinEntriesProvider extends DatapackBuiltinEntriesProvider {
	public static final RegistryBuilder BUILDER = new RegistryBuilder()
		.addRegistry(RegistryKeys.BIOME, TerrestriaBiomes::populate)
		.addRegistry(RegistryKeys.CONFIGURED_FEATURE, TerrestriaConfiguredFeatures::populate)
		.addRegistry(RegistryKeys.PLACED_FEATURE, TerrestriaPlacedFeatures::populate);

	public TerrestriaDatapackBuiltinEntriesProvider(DataOutput output, CompletableFuture<WrapperLookup> registries) {
		super(output, registries, BUILDER, Set.of(Terrestria.MOD_ID, "minecraft"));
	}
}

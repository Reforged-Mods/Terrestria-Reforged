package com.terraformersmc.terrestria.mixin;

import com.google.common.collect.ImmutableMap;
import net.minecraft.world.gen.chunk.StructureConfig;
import net.minecraft.world.gen.chunk.StructuresConfig;
import net.minecraft.world.gen.feature.StructureFeature;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(StructuresConfig.class)
public interface StructuresConfigAccessor {

	@Accessor("DEFAULT_STRUCTURES")
	static void setDefaults(ImmutableMap<StructureFeature<?>, StructureConfig> newMap) {
		throw new Error("Mixin did not apply!");
	}
}

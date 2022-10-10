package com.terraformersmc.terrestria.mixin;

import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.StructureFeature;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.List;
import java.util.Map;

@Mixin(StructureFeature.class)
public interface StructureFeatureAccessor {
	@Accessor("JIGSAW_STRUCTURES")
	@Mutable
	static void setSurfaceAdjustingStructures(List<StructureFeature<?>> surfaceAdjustingStructures) {
		throw new AssertionError("Untransformed accessor");
	}

	@Accessor("STRUCTURE_TO_GENERATION_STEP")
	static Map<StructureFeature<?>, GenerationStep.Feature> getStructureStep() {
		throw new Error("Mixin did not apply!");
	}
}

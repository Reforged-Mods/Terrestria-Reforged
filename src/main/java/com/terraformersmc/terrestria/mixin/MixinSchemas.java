package com.terraformersmc.terrestria.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.mojang.datafixers.DataFixerBuilder;
import com.mojang.datafixers.schemas.Schema;
import com.terraformersmc.terrestria.data.TerrestriaExtendedDistanceFix;
import net.minecraft.datafixer.Schemas;
import net.minecraft.datafixer.schema.IdentifierNormalizingSchema;
import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Slice;

import java.util.function.BiFunction;

@Debug(export = true)
@Mixin(Schemas.class)
public class MixinSchemas {
	/*
	 * This fix updates Terraform API ExtendedLeaves from a globally expanded DISTANCE property to the standard
	 * DISTANCE property with an auxiliary EXTENDED_DISTANCE property.
	 */
	@WrapOperation(method = "build",
		slice = @Slice(
			from = @At(value = "NEW", target = "(Lcom/mojang/datafixers/schemas/Schema;Ljava/lang/String;Ljava/util/function/Predicate;)Lnet/minecraft/datafixer/fix/PointOfInterestRemoveFix;")
		),
		at = @At(value = "INVOKE", target = "Lcom/mojang/datafixers/DataFixerBuilder;addSchema(ILjava/util/function/BiFunction;)Lcom/mojang/datafixers/schemas/Schema;", ordinal = 0)
	)
	@SuppressWarnings("unused")
	private static Schema terrestria$injectExtendedDistanceFix(DataFixerBuilder builder, int version, BiFunction<Integer, Schema, Schema> factory, Operation<Schema> original) {
		Schema extendedDistanceSchema = builder.addSchema(3118, IdentifierNormalizingSchema::new);
		builder.addFixer(new TerrestriaExtendedDistanceFix(extendedDistanceSchema, false));

		return original.call(builder, version, factory);
	}
}

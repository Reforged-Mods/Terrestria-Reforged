package com.terraformersmc.terrestria.feature;

import com.google.common.collect.ImmutableList;
import com.terraformersmc.terrestria.mixin.FlatChunkGeneratorConfigAccessor;
import com.terraformersmc.terrestria.mixin.StructureFeatureAccessor;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.StructureAccessor;
import net.minecraft.world.gen.chunk.FlatChunkGeneratorConfig;
import net.minecraft.world.gen.chunk.StructureConfig;
import net.minecraft.world.gen.chunk.StructuresConfig;
import net.minecraft.world.gen.feature.ConfiguredStructureFeature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class StructureBuilder<FC extends FeatureConfig, S extends StructureFeature<FC>> {
	public static final Map<Identifier, StructureFeature<?>> STRUCTURE_FEATURES = new LinkedHashMap<>();
	public static final Map<StructureFeature<?>, StructureConfig> STRUCTURE_TO_CONFIG_MAP = new HashMap<>();
	public static final List<StructureFeature<?>> ADJUSTS_SURFACE_LIST = new ArrayList<>();
	private final Identifier id;
	private final S structure;
	private GenerationStep.Feature step;
	private StructureConfig defaultConfig;
	private ConfiguredStructureFeature<FC, ? extends StructureFeature<FC>> superflatFeature;
	private boolean adjustsSurface = false;

	private StructureBuilder(Identifier id, S structure) {
		this.id = id;
		this.structure = structure;
	}

	/**
	 * Creates a new {@code StructureBuilder} for registering a structure.
	 *
	 * @param id The structure ID.
	 * @param structure The {@linkplain StructureFeature} you want to register.
	 */
	public static <FC extends FeatureConfig, S extends StructureFeature<FC>> StructureBuilder<FC, S> create(Identifier id, S structure) {
		Objects.requireNonNull(id, "id must not be null");
		Objects.requireNonNull(structure, "structure must not be null");
		return new StructureBuilder<>(id, structure);
	}

	/**
	 * Sets the generation step of this structure. The generation step specifies when the structure is generated, to
	 * ensure they are generated in the correct order to reduce the amount of floating blocks.
	 *
	 * <p>The most commonly used values for structures are {@linkplain GenerationStep.Feature#SURFACE_STRUCTURES} and
	 * {@linkplain GenerationStep.Feature#UNDERGROUND_STRUCTURES}, however technically any value in the
	 * {@linkplain GenerationStep.Feature} enum may be used.</p>
	 *
	 * <p>This is a required option.</p>
	 */
	public StructureBuilder<FC, S> step(GenerationStep.Feature step) {
		Objects.requireNonNull(step, "step must not be null");
		this.step = step;
		return this;
	}

	/**
	 * Sets the default {@linkplain StructureConfig} for this structure. See the alternative
	 * {@linkplain #defaultConfig(int, int, int)} for details.
	 *
	 * <p>This is a required option.</p>
	 */
	public StructureBuilder<FC, S> defaultConfig(StructureConfig config) {
		Objects.requireNonNull(config, "config must not be null");
		this.defaultConfig = config;
		return this;
	}

	/**
	 * Sets the default {@linkplain StructureConfig} for this structure. This sets the default configuration of where in
	 * the world to place structures.
	 *
	 * <p>Note: the {@code spacing} and {@code separation} options are subject to other checks for whether the structure
	 * can spawn, such as biome. If these checks always pass and the structure can spawn in every biome, then the
	 * description of these values below would be exactly correct.</p>
	 *
	 * <p>This is a required option. Vanilla needs it to function.</p>
	 *
	 * @param spacing The average distance between 2 structures of this type along the X and Z axes.
	 * @param separation The minimum distance between 2 structures of this type.
	 * @param salt The random salt of the structure. This does not affect how common the structure is, but every
	 *                structure must have an unique {@code salt} in order to spawn in different places.
	 *
	 * @see #defaultConfig(StructureConfig)
	 */
	public StructureBuilder<FC, S> defaultConfig(int spacing, int separation, int salt) {
		return defaultConfig(new StructureConfig(spacing, separation, salt));
	}

	/**
	 * Sets the structure configuration which spawns in superflat worlds. If unset, this structure will not spawn in
	 * superflat worlds.
	 *
	 * @see #superflatFeature(FeatureConfig)
	 */
	public StructureBuilder<FC, S> superflatFeature(ConfiguredStructureFeature<FC, ? extends StructureFeature<FC>> superflatFeature) {
		Objects.requireNonNull(superflatFeature, "superflatFeature must not be null");
		this.superflatFeature = superflatFeature;
		return this;
	}

	/**
	 * Sets the structure configuration which spawns in superflat worlds. If unset, this structure will not spawn in
	 * superflat worlds.
	 *
	 * @see #superflatFeature(ConfiguredStructureFeature)
	 */
	public StructureBuilder<FC, S> superflatFeature(FC config) {
		return superflatFeature(structure.configure(config));
	}

	/**
	 * Causes structure pieces of this structure to adjust the surface of the world to fit them, so that they don't
	 * stick out of or into the ground.
	 */
	public StructureBuilder<FC, S> adjustsSurface() {
		this.adjustsSurface = true;
		return this;
	}

	/**
	 * Registers this structure and applies the other changes from the {@linkplain StructureBuilder}.
	 */
	public S register() {
		Objects.requireNonNull(step, "Structure \"" + id + "\" is missing a generation step");
		Objects.requireNonNull(defaultConfig, "Structure \"" + id + "\" is missing a default config");

		// Ensure StructuresConfig class is initialized, so the assertion in its static {} block doesn't fail
		StructuresConfig.DEFAULT_STRUCTURES.size();
		STRUCTURE_FEATURES.put(id, structure);

		StructureFeature.STRUCTURES.put(id.toString(), structure);
		StructureFeatureAccessor.getStructureStep().put(structure, step);

		if (!id.toString().equals(structure.getName())) {
			// mods should not be overriding getName, but if they do and it's incorrect, this gives an error
			throw new IllegalStateException(String.format("Structure \"%s\" has mismatching name \"%s\". Structures should not override \"getName\".", id, structure.getName()));
		}

		STRUCTURE_TO_CONFIG_MAP.put(structure, defaultConfig);

		if (superflatFeature != null) {
			FlatChunkGeneratorConfigAccessor.getStructureToFeatures().put(structure, superflatFeature);
		}

		if (adjustsSurface) {
			ADJUSTS_SURFACE_LIST.add(structure);
		}

		return structure;
	}
}

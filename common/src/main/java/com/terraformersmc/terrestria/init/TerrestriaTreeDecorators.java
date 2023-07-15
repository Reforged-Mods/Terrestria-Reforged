package com.terraformersmc.terrestria.init;

import com.mojang.serialization.Codec;
import com.terraformersmc.terrestria.Terrestria;
import com.terraformersmc.terrestria.feature.tree.treedecorators.DanglingLeavesTreeDecorator;
import com.terraformersmc.terrestria.feature.tree.treedecorators.SakuraTreeDecorator;

import net.minecraft.util.Identifier;
import net.minecraft.world.gen.treedecorator.TreeDecorator;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.LinkedHashMap;
import java.util.Map;

public class TerrestriaTreeDecorators {
	public static TreeDecoratorType<DanglingLeavesTreeDecorator> DANGLING_LEAVES;
	public static TreeDecoratorType<SakuraTreeDecorator> SAKURA;

	public static void init() {
		DANGLING_LEAVES = register("dangling_leaves_tree_decorator", DanglingLeavesTreeDecorator.CODEC);
		SAKURA = register("sakura_tree_decorator", SakuraTreeDecorator.CODEC);
	}

	private static <P extends TreeDecorator> TreeDecoratorType<P> register(String name, Codec<P> codec) {
		TreeDecoratorType<P> type = new TreeDecoratorType<>(codec);
		ForgeRegistries.TREE_DECORATOR_TYPES.register(new Identifier(Terrestria.MOD_ID, name), type);
		return type;
	}
}

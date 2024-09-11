package com.terraformersmc.terrestria.data;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.server.LootTableProvider;
import net.minecraft.loot.LootManager;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.LootTableReporter;
import net.minecraft.loot.context.LootContextType;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class TerrestriaLootTableProvider extends LootTableProvider {
    public TerrestriaLootTableProvider(DataGenerator root) {
        super(root);
    }

    @Override
    protected void validate(Map<Identifier, LootTable> map, LootTableReporter validationtracker) {
        map.forEach((name, table) -> LootManager.validate(validationtracker, name, table));
    }

    @Override
    protected List<Pair<Supplier<Consumer<BiConsumer<Identifier, LootTable.Builder>>>, LootContextType>> getTables() {
        return ImmutableList.of(
                Pair.of(TerrestriaBlockLootTableProvider::new, LootContextTypes.BLOCK)
        );
    }
}

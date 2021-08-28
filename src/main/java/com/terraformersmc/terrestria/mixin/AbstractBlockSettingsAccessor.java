package com.terraformersmc.terrestria.mixin;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

import java.util.function.Function;
import java.util.function.ToIntFunction;

@Mixin(AbstractBlock.Settings.class)
public interface AbstractBlockSettingsAccessor {
    /* GETTERS */
    @Accessor
    Material getMaterial();

    @Accessor
    float getHardness();

    @Accessor
    float getResistance();

    @Accessor
    boolean getCollidable();

    @Accessor
    boolean getRandomTicks();

    @Accessor("luminance")
    ToIntFunction<BlockState> getLuminance();

    @Accessor
    Function<BlockState, MaterialColor> getMaterialColorFactory();

    @Accessor
    BlockSoundGroup getSoundGroup();

    @Accessor
    float getSlipperiness();

    @Accessor
    float getVelocityMultiplier();

    @Accessor
    boolean getDynamicBounds();

    @Accessor
    boolean getOpaque();

    @Accessor
    boolean getIsAir();

    @Accessor
    boolean isToolRequired();

    /* SETTERS */
    @Accessor
    void setMaterial(Material material);

    @Accessor
    void setHardness(float hardness);

    @Accessor
    void setResistance(float resistance);

    @Accessor
    void setCollidable(boolean collidable);

    @Accessor
    void setRandomTicks(boolean ticksRandomly);

    @Accessor
    void setMaterialColorFactory(Function<BlockState, MaterialColor> materialColorFunction);

    @Accessor
    void setDynamicBounds(boolean dynamicBounds);

    @Accessor
    void setOpaque(boolean opaque);

    @Accessor
    void setIsAir(boolean isAir);

    @Accessor
    void setLootTableId(Identifier lootTableId);

    @Accessor
    void setToolRequired(boolean toolRequired);

    // Cannot be an invoker due to conflicts in mixin: method_9631(Ljava/util/function/ToIntFunction;)Lnet/minecraft/class_4970$class_2251; for target net.minecraft.block.AbstractBlock$Settings conflicts with existing mapping field_10663:Ljava/util/function/ToIntFunction;
    @Accessor("luminance")
    void setLuminanceFunction(ToIntFunction<BlockState> luminanceFunction);

    /* INVOKERS */
    @Invoker
    AbstractBlock.Settings invokeSounds(BlockSoundGroup group);

    @Invoker
    AbstractBlock.Settings invokeBreakInstantly();

    @Invoker
    AbstractBlock.Settings invokeStrength(float strength);

    @Invoker
    AbstractBlock.Settings invokeTicksRandomly();

    @Invoker
    AbstractBlock.Settings invokeDropsNothing();

}

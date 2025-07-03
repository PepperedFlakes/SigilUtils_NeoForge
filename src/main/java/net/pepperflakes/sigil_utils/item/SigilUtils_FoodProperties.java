package net.pepperflakes.sigil_utils.item;

import net.minecraft.world.food.FoodProperties;

public class SigilUtils_FoodProperties {
    public static final FoodProperties CHERRY = new FoodProperties.Builder().nutrition(4).saturationModifier(4f).build();
    public static final FoodProperties PEACH = new FoodProperties.Builder().nutrition(8).saturationModifier(4f).build();
    public static final FoodProperties PERFECT_PEACH = new FoodProperties.Builder().nutrition(16).saturationModifier(20f).build();
    public static final FoodProperties MOSS_BALL = new FoodProperties.Builder().nutrition(2).saturationModifier(1f).build();
}
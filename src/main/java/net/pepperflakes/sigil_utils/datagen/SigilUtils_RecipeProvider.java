package net.pepperflakes.sigil_utils.datagen;

import net.pepperflakes.sigil_utils.SigilUtils;
import net.pepperflakes.sigil_utils.block.SigilUtils_Blocks;
import net.pepperflakes.sigil_utils.item.SigilUtils_Items;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class SigilUtils_RecipeProvider extends RecipeProvider implements IConditionBuilder {
        public SigilUtils_RecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
                super(output, registries);
        }

        @Override
        protected void buildRecipes(RecipeOutput recipeOutput) {
                List<ItemLike> VARENTIUM_SMELTABLES = List.of(SigilUtils_Blocks.VARENTIUM_ORE, SigilUtils_Blocks.DEEPSLATE_VARENTIUM_ORE);
                // varentium - temp recipe, until i get ore generation sorted
                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, SigilUtils_Items.VARENTIUM.get())
                        .pattern("RL")
                        .pattern("LR")
                        .define('R', Items.REDSTONE)
                        .define('L', Items.LAPIS_LAZULI)
                        .unlockedBy(getHasName(SigilUtils_Items.VARENTIUM.get()),
                                has(SigilUtils_Items.VARENTIUM.get()))
                        .save(recipeOutput, "varentium");

                // cooking varentium ores into varentium
                oreSmelting(recipeOutput, VARENTIUM_SMELTABLES, RecipeCategory.MISC, SigilUtils_Items.VARENTIUM.get(), 0.7f,
                        200, "varentium");
                oreBlasting(recipeOutput, VARENTIUM_SMELTABLES, RecipeCategory.MISC, SigilUtils_Items.VARENTIUM.get(), 0.7f,
                        100, "varentium");

                // varentium block
                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, SigilUtils_Blocks.VARENTIUM_BLOCK.get())
                        .pattern("###")
                        .pattern("###")
                        .pattern("###")
                        .define('#', SigilUtils_Items.VARENTIUM.get())
                        .unlockedBy(getHasName(SigilUtils_Items.VARENTIUM.get()),
                                has(SigilUtils_Items.VARENTIUM.get()))
                        .save(recipeOutput, "varentium_block");

                // varentium from block
                ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, SigilUtils_Items.VARENTIUM.get(), 9)
                        .requires(SigilUtils_Blocks.VARENTIUM_BLOCK.get())
                        .unlockedBy(getHasName(SigilUtils_Blocks.VARENTIUM_BLOCK.get()),
                                has(SigilUtils_Blocks.VARENTIUM_BLOCK.get()))
                        .save(recipeOutput, "varentium_from_block");

                // varentium shards
                ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, SigilUtils_Items.VARENTIUM_SHARD.get(), 9)
                        .requires(SigilUtils_Items.VARENTIUM.get())
                        .unlockedBy(getHasName(SigilUtils_Items.VARENTIUM_SHARD.get()),
                                has(SigilUtils_Items.VARENTIUM.get()))
                        .save(recipeOutput, "varentium_shard");

                // varentium from shards
                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, SigilUtils_Items.VARENTIUM.get())
                        .pattern("###")
                        .pattern("###")
                        .pattern("###")
                        .define('#', SigilUtils_Items.VARENTIUM_SHARD.get())
                        .unlockedBy(getHasName(SigilUtils_Items.VARENTIUM_SHARD.get()),
                                has(SigilUtils_Items.VARENTIUM_SHARD.get()))
                        .save(recipeOutput, "varentium_from_shards");

                // circadium ingots
                ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, SigilUtils_Items.CIRCADIUM_INGOT.get(), 2)
                        .requires(SigilUtils_Items.RING_OF_TRANSMUTATION.get())
                        .requires(Items.AMETHYST_SHARD).requires(Items.AMETHYST_SHARD)
                        .requires(Items.BLAZE_POWDER).requires(Items.BLAZE_POWDER)
                        .unlockedBy(getHasName(SigilUtils_Items.RING_OF_TRANSMUTATION.get()),
                                has(SigilUtils_Items.RING_OF_TRANSMUTATION.get()))
                        .save(recipeOutput, "circadium_ingot");

                // circadium blend
                ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, SigilUtils_Items.CIRCADIUM_BLEND.get(), 4)
                        .requires(SigilUtils_Items.CIRCADIUM_INGOT.get())
                        .unlockedBy(getHasName(SigilUtils_Items.CIRCADIUM_INGOT.get()),
                                has(SigilUtils_Items.CIRCADIUM_INGOT.get()))
                        .save(recipeOutput, "circadium_blend");

                // circadium plating
                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, SigilUtils_Items.CIRCADIUM_PLATING.get())
                        .pattern("CC")
                        .pattern("CC")
                        .define('C', SigilUtils_Items.CIRCADIUM_INGOT.get())
                        .unlockedBy(getHasName(SigilUtils_Items.CIRCADIUM_INGOT.get()),
                                has(SigilUtils_Items.CIRCADIUM_INGOT.get()))
                        .save(recipeOutput, "circadium_plating");

                // circadium block
                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, SigilUtils_Blocks.CIRCADIUM_BLOCK.get())
                        .pattern("CC")
                        .pattern("CC")
                        .define('C', SigilUtils_Items.CIRCADIUM_PLATING.get())
                        .unlockedBy(getHasName(SigilUtils_Items.CIRCADIUM_PLATING.get()),
                                has(SigilUtils_Items.CIRCADIUM_PLATING.get()))
                        .save(recipeOutput, "circadium_block");

                // circadium ingots from block
                ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, SigilUtils_Items.CIRCADIUM_INGOT.get(), 16)
                        .requires(SigilUtils_Blocks.CIRCADIUM_BLOCK.get())
                        .unlockedBy(getHasName(SigilUtils_Blocks.CIRCADIUM_BLOCK.get()),
                                has(SigilUtils_Blocks.CIRCADIUM_BLOCK.get()))
                        .save(recipeOutput, "circadium_ingots_from_block");

                // orichalcom alloy
                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, SigilUtils_Items.ORICHALCOM_ALLOY.get())
                        .pattern("CVC")
                        .pattern("VRV")
                        .pattern("CVC")
                        .define('C', SigilUtils_Items.CIRCADIUM_BLEND.get())
                        .define('V', SigilUtils_Items.VARENTIUM.get())
                        .define('R', SigilUtils_Items.RING_OF_TRANSMUTATION.get())
                        .unlockedBy(getHasName(SigilUtils_Items.CIRCADIUM_BLEND.get()),
                                has(SigilUtils_Items.CIRCADIUM_BLEND.get()))
                        .save(recipeOutput, "orichalcom_alloy");

                // cooking orichalcom alloy into an orichalcom ingot
                oreSmelting(recipeOutput, List.of(SigilUtils_Items.ORICHALCOM_ALLOY.get()), RecipeCategory.MISC,
                        SigilUtils_Items.ORICHALCOM_INGOT.get(), 0.7f, 200, "orichalcom");
                oreBlasting(recipeOutput, List.of(SigilUtils_Items.ORICHALCOM_ALLOY.get()), RecipeCategory.MISC,
                        SigilUtils_Items.ORICHALCOM_INGOT.get(), 0.7f, 100, "orichalcom");

                // orichalcom block
                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, SigilUtils_Blocks.ORICHALCOM_BLOCK.get())
                        .pattern("###")
                        .pattern("###")
                        .pattern("###")
                        .define('#', SigilUtils_Items.ORICHALCOM_INGOT.get())
                        .unlockedBy(getHasName(SigilUtils_Items.ORICHALCOM_INGOT.get()),
                                has(SigilUtils_Items.ORICHALCOM_INGOT.get()))
                        .save(recipeOutput, "orichalcom_block");

                // orichalcom from block
                ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, SigilUtils_Items.ORICHALCOM_INGOT.get(), 9)
                        .requires(SigilUtils_Blocks.ORICHALCOM_BLOCK.get())
                        .unlockedBy(getHasName(SigilUtils_Blocks.ORICHALCOM_BLOCK.get()),
                                has(SigilUtils_Blocks.ORICHALCOM_BLOCK.get()))
                        .save(recipeOutput, "orichalcom_ingots_from_block");

                // orichalcom nuggets
                ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, SigilUtils_Items.ORICHALCOM_NUGGET.get(), 9)
                        .requires(SigilUtils_Items.ORICHALCOM_INGOT.get())
                        .unlockedBy(getHasName(SigilUtils_Items.ORICHALCOM_NUGGET.get()),
                                has(SigilUtils_Items.ORICHALCOM_INGOT.get()))
                        .save(recipeOutput, "orichalcom_nugget");

                // orichalcom from nuggets
                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, SigilUtils_Items.ORICHALCOM_INGOT.get())
                        .pattern("###")
                        .pattern("###")
                        .pattern("###")
                        .define('#', SigilUtils_Items.ORICHALCOM_NUGGET.get())
                        .unlockedBy(getHasName(SigilUtils_Items.ORICHALCOM_NUGGET.get()),
                                has(SigilUtils_Items.ORICHALCOM_NUGGET.get()))
                        .save(recipeOutput, "orichalcom_ingot_from_nuggets");

                // astral star
                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, SigilUtils_Items.ASTRAL_STAR.get())
                        .pattern("OVO")
                        .pattern("VNV")
                        .pattern("OVO")
                        .define('O', SigilUtils_Items.ORICHALCOM_INGOT.get())
                        .define('V', SigilUtils_Items.VARENTIUM.get())
                        .define('N', Items.NETHER_STAR)
                        .unlockedBy(getHasName(Items.NETHER_STAR), has(Items.NETHER_STAR))
                        .save(recipeOutput, "astral_star");

                // reglazed terracottas
                reglazedTerracottaRecipe(Items.BLACK_GLAZED_TERRACOTTA,
                        SigilUtils_Blocks.BLACK_REGLAZED_TERRACOTTA.get(), recipeOutput,
                        "black_reglazed_terracotta");
                reglazedTerracottaRecipe(Items.BLUE_GLAZED_TERRACOTTA, SigilUtils_Blocks.BLUE_REGLAZED_TERRACOTTA.get(),
                        recipeOutput, "blue_reglazed_terracotta");
                reglazedTerracottaRecipe(Items.BROWN_GLAZED_TERRACOTTA,
                        SigilUtils_Blocks.BROWN_REGLAZED_TERRACOTTA.get(), recipeOutput,
                        "brown_reglazed_terracotta");
                reglazedTerracottaRecipe(Items.CYAN_GLAZED_TERRACOTTA, SigilUtils_Blocks.CYAN_REGLAZED_TERRACOTTA.get(),
                        recipeOutput, "cyan_reglazed_terracotta");
                reglazedTerracottaRecipe(Items.GRAY_GLAZED_TERRACOTTA, SigilUtils_Blocks.GRAY_REGLAZED_TERRACOTTA.get(),
                        recipeOutput, "gray_reglazed_terracotta");
                reglazedTerracottaRecipe(Items.GREEN_GLAZED_TERRACOTTA,
                        SigilUtils_Blocks.GREEN_REGLAZED_TERRACOTTA.get(), recipeOutput,
                        "green_reglazed_terracotta");
                reglazedTerracottaRecipe(Items.LIGHT_BLUE_GLAZED_TERRACOTTA,
                        SigilUtils_Blocks.LIGHT_BLUE_REGLAZED_TERRACOTTA.get(), recipeOutput,
                        "light_blue_reglazed_terracotta");
                reglazedTerracottaRecipe(Items.LIGHT_GRAY_GLAZED_TERRACOTTA,
                        SigilUtils_Blocks.LIGHT_GRAY_REGLAZED_TERRACOTTA.get(), recipeOutput,
                        "light_gray_reglazed_terracotta");
                reglazedTerracottaRecipe(Items.LIME_GLAZED_TERRACOTTA, SigilUtils_Blocks.LIME_REGLAZED_TERRACOTTA.get(),
                        recipeOutput, "lime_reglazed_terracotta");
                reglazedTerracottaRecipe(Items.MAGENTA_GLAZED_TERRACOTTA,
                        SigilUtils_Blocks.MAGENTA_REGLAZED_TERRACOTTA.get(), recipeOutput,
                        "magenta_reglazed_terracotta");
                reglazedTerracottaRecipe(Items.ORANGE_GLAZED_TERRACOTTA,
                        SigilUtils_Blocks.ORANGE_REGLAZED_TERRACOTTA.get(), recipeOutput,
                        "orange_reglazed_terracotta");
                reglazedTerracottaRecipe(Items.PINK_GLAZED_TERRACOTTA, SigilUtils_Blocks.PINK_REGLAZED_TERRACOTTA.get(),
                        recipeOutput, "pink_reglazed_terracotta");
                reglazedTerracottaRecipe(Items.PURPLE_GLAZED_TERRACOTTA,
                        SigilUtils_Blocks.PURPLE_REGLAZED_TERRACOTTA.get(), recipeOutput,
                        "purple_reglazed_terracotta");
                reglazedTerracottaRecipe(Items.RED_GLAZED_TERRACOTTA, SigilUtils_Blocks.RED_REGLAZED_TERRACOTTA.get(),
                        recipeOutput, "red_reglazed_terracotta");
                reglazedTerracottaRecipe(Items.WHITE_GLAZED_TERRACOTTA,
                        SigilUtils_Blocks.WHITE_REGLAZED_TERRACOTTA.get(), recipeOutput,
                        "white_reglazed_terracotta");
                reglazedTerracottaRecipe(Items.YELLOW_GLAZED_TERRACOTTA,
                        SigilUtils_Blocks.YELLOW_REGLAZED_TERRACOTTA.get(), recipeOutput,
                        "yellow_reglazed_terracotta");

                // chiseled obsidian
                SingleItemRecipeBuilder.stonecutting(Ingredient.of(Items.OBSIDIAN), RecipeCategory.BUILDING_BLOCKS,
                        SigilUtils_Blocks.CHISELED_OBSIDIAN.get());

                // coal chunks
                ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, SigilUtils_Items.COAL_CHUNK.get(), 8)
                        .requires(Items.COAL)
                        .unlockedBy(getHasName(Items.COAL), has(Items.COAL))
                        .save(recipeOutput);

                // coal from chunks
                ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.COAL)
                        .requires(SigilUtils_Items.COAL_CHUNK.get()).requires(SigilUtils_Items.COAL_CHUNK.get())
                        .requires(SigilUtils_Items.COAL_CHUNK.get()).requires(SigilUtils_Items.COAL_CHUNK.get())
                        .requires(SigilUtils_Items.COAL_CHUNK.get()).requires(SigilUtils_Items.COAL_CHUNK.get())
                        .requires(SigilUtils_Items.COAL_CHUNK.get()).requires(SigilUtils_Items.COAL_CHUNK.get())
                        .unlockedBy(getHasName(SigilUtils_Items.COAL_CHUNK.get()),
                                has(SigilUtils_Items.COAL_CHUNK.get()))
                        .save(recipeOutput);

                // charcoal chunks
                ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, SigilUtils_Items.CHARCOAL_CHUNK.get(), 8)
                        .requires(Items.CHARCOAL)
                        .unlockedBy(getHasName(Items.CHARCOAL), has(Items.CHARCOAL))
                        .save(recipeOutput);

                // charcoal from chunks
                ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.CHARCOAL)
                        .requires(SigilUtils_Items.CHARCOAL_CHUNK.get())
                        .requires(SigilUtils_Items.CHARCOAL_CHUNK.get())
                        .requires(SigilUtils_Items.CHARCOAL_CHUNK.get())
                        .requires(SigilUtils_Items.CHARCOAL_CHUNK.get())
                        .requires(SigilUtils_Items.CHARCOAL_CHUNK.get())
                        .requires(SigilUtils_Items.CHARCOAL_CHUNK.get())
                        .requires(SigilUtils_Items.CHARCOAL_CHUNK.get())
                        .requires(SigilUtils_Items.CHARCOAL_CHUNK.get())
                        .unlockedBy(getHasName(SigilUtils_Items.CHARCOAL_CHUNK.get()),
                                has(SigilUtils_Items.CHARCOAL_CHUNK.get()))
                        .save(recipeOutput);

                // moss balls
                ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, SigilUtils_Items.MOSS_BALL.get(), 4)
                        .requires(Items.MOSS_BLOCK)
                        .unlockedBy(getHasName(Items.MOSS_BLOCK), has(Items.MOSS_BLOCK))
                        .save(recipeOutput);

                // ring of transmutation
                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, SigilUtils_Items.RING_OF_TRANSMUTATION.get())
                        .pattern(" V ")
                        .pattern("VNV")
                        .pattern(" V ")
                        .define('V', SigilUtils_Items.VARENTIUM.get())
                        .define('N', Items.NETHERITE_INGOT)
                        .unlockedBy(getHasName(Items.NETHERITE_INGOT), has(Items.NETHERITE_INGOT))
                        .save(recipeOutput);

                // transmutation recipes
                oneToOneTransmutationRecipe(Items.COAL, Items.CHARCOAL, recipeOutput, "coal_to_charcoal",
                        "charcoal_to_coal");
                oneToOneTransmutationRecipe(Items.AMETHYST_SHARD, Items.QUARTZ, recipeOutput, "amethyst_to_quartz",
                        "quartz_to_amethyst");
                oneToOneTransmutationRecipe(Items.SAND, Items.GRAVEL, recipeOutput, "sand_to_gravel", "gravel_to_sand");
                oneToOneTransmutationRecipe(Items.REDSTONE, Items.GLOWSTONE_DUST, recipeOutput, "redstone_to_glowstone",
                        "glowstone_to_redstone");
                oneToOneTransmutationRecipe(Items.RED_MUSHROOM, Items.BROWN_MUSHROOM, recipeOutput,
                        "red_mushroom_to_brown_mushroom", "brown_mushroom_to_red_mushroom");
                oneToOneTransmutationRecipe(Items.RED_MUSHROOM_BLOCK, Items.BROWN_MUSHROOM_BLOCK, recipeOutput,
                        "red_mushroom_block_to_brown_mushroom_block",
                        "brown_mushroom_block_to_red_mushroom_block");
                twoToOneTransmutationRecipe(Items.BLAZE_ROD, Items.PRISMARINE_SHARD, recipeOutput, "blaze_to_prismarine",
                        "prismarine_to_blaze");
                twoToOneTransmutationRecipe(SigilUtils_Items.PEACH, Items.APPLE, recipeOutput, "apple_to_peach", "peach_to_apple");
                fourToOneTransmutationRecipe(Items.GOLD_INGOT, Items.IRON_INGOT, recipeOutput, "gold_to_iron",
                        "iron_to_gold");
                fourToOneTransmutationRecipe(Items.DIAMOND, Items.GOLD_INGOT, recipeOutput, "diamond_to_gold",
                        "gold_to_diamond");
                eightToOneTransmutationRecipe(Items.IRON_INGOT, Items.COPPER_INGOT, recipeOutput, "iron_to_copper",
                        "copper_to_iron");
                eightToOneTransmutationRecipe(Items.DIAMOND, Items.EMERALD, recipeOutput, "diamond_to_emerald",
                        "emerald_to_diamond");

//                // upgrade core recipes
//                upgradeCoreRecipe(SigilUtils_Items.UPGRADE_CATALYST, Items.WOODEN_SWORD, Items.COBBLESTONE, Items.STONE_SWORD, recipeOutput, "wooden_sword_to_stone");
//                upgradeCoreRecipe(SigilUtils_Items.UPGRADE_CATALYST, Items.WOODEN_PICKAXE, Items.COBBLESTONE, Items.STONE_PICKAXE, recipeOutput, "wooden_pickaxe_to_stone");
//                upgradeCoreRecipe(SigilUtils_Items.UPGRADE_CATALYST, Items.WOODEN_AXE, Items.COBBLESTONE, Items.STONE_AXE, recipeOutput, "wooden_axe_to_stone");
//                upgradeCoreRecipe(SigilUtils_Items.UPGRADE_CATALYST, Items.WOODEN_SHOVEL, Items.COBBLESTONE, Items.STONE_SHOVEL, recipeOutput, "wooden_shovel_to_stone");
//                upgradeCoreRecipe(SigilUtils_Items.UPGRADE_CATALYST, Items.WOODEN_HOE, Items.COBBLESTONE, Items.STONE_HOE, recipeOutput, "wooden_hoe_to_stone");
//                upgradeCoreRecipe(SigilUtils_Items.UPGRADE_CATALYST, Items.STONE_SWORD, Items.IRON_INGOT, Items.IRON_SWORD, recipeOutput, "stone_sword_to_iron");
//                upgradeCoreRecipe(SigilUtils_Items.UPGRADE_CATALYST, Items.STONE_PICKAXE, Items.IRON_INGOT, Items.IRON_PICKAXE, recipeOutput, "stone_pickaxe_to_iron");
//                upgradeCoreRecipe(SigilUtils_Items.UPGRADE_CATALYST, Items.STONE_AXE, Items.IRON_INGOT, Items.IRON_AXE, recipeOutput, "stone_axe_to_iron");
//                upgradeCoreRecipe(SigilUtils_Items.UPGRADE_CATALYST, Items.STONE_SHOVEL, Items.IRON_INGOT, Items.IRON_SHOVEL, recipeOutput, "stone_shovel_to_iron");
//                upgradeCoreRecipe(SigilUtils_Items.UPGRADE_CATALYST, Items.STONE_HOE, Items.IRON_INGOT, Items.IRON_HOE, recipeOutput, "stone_hoe_to_iron");
//                upgradeCoreRecipe(SigilUtils_Items.UPGRADE_CATALYST, Items.IRON_SWORD, Items.GOLD_INGOT, Items.GOLDEN_SWORD, recipeOutput, "iron_sword_to_golden");
//                upgradeCoreRecipe(SigilUtils_Items.UPGRADE_CATALYST, Items.IRON_PICKAXE, Items.GOLD_INGOT, Items.GOLDEN_PICKAXE, recipeOutput, "iron_pickaxe_to_golden");
//                upgradeCoreRecipe(SigilUtils_Items.UPGRADE_CATALYST, Items.IRON_AXE, Items.GOLD_INGOT, Items.GOLDEN_AXE, recipeOutput, "iron_axe_to_golden");
//                upgradeCoreRecipe(SigilUtils_Items.UPGRADE_CATALYST, Items.IRON_SHOVEL, Items.GOLD_INGOT, Items.GOLDEN_SHOVEL, recipeOutput, "iron_shovel_to_golden");
//                upgradeCoreRecipe(SigilUtils_Items.UPGRADE_CATALYST, Items.IRON_HOE, Items.GOLD_INGOT, Items.GOLDEN_HOE, recipeOutput, "iron_hoe_to_golden");
//                upgradeCoreRecipe(SigilUtils_Items.UPGRADE_CATALYST, Items.GOLDEN_SWORD, Items.DIAMOND, Items.DIAMOND_SWORD, recipeOutput, "golden_sword_to_diamond");
//                upgradeCoreRecipe(SigilUtils_Items.UPGRADE_CATALYST, Items.GOLDEN_PICKAXE, Items.DIAMOND, Items.DIAMOND_PICKAXE, recipeOutput, "golden_pickaxe_to_diamond");
//                upgradeCoreRecipe(SigilUtils_Items.UPGRADE_CATALYST, Items.GOLDEN_AXE, Items.DIAMOND, Items.DIAMOND_AXE, recipeOutput, "golden_axe_to_diamond");
//                upgradeCoreRecipe(SigilUtils_Items.UPGRADE_CATALYST, Items.GOLDEN_SHOVEL, Items.DIAMOND, Items.DIAMOND_SHOVEL, recipeOutput, "golden_shovel_to_diamond");
//                upgradeCoreRecipe(SigilUtils_Items.UPGRADE_CATALYST, Items.GOLDEN_HOE, Items.DIAMOND, Items.DIAMOND_HOE, recipeOutput, "golden_hoe_to_diamond");
//
//                upgradeCoreRecipe(SigilUtils_Items.UPGRADE_CATALYST, Items.LEATHER_HELMET, Items.CHAIN, Items.CHAINMAIL_HELMET, recipeOutput, "leather_helmet_to_chainmail");
//                upgradeCoreRecipe(SigilUtils_Items.UPGRADE_CATALYST, Items.LEATHER_CHESTPLATE, Items.CHAIN, Items.CHAINMAIL_CHESTPLATE, recipeOutput, "leather_chestplate_to_chainmail");
//                upgradeCoreRecipe(SigilUtils_Items.UPGRADE_CATALYST, Items.LEATHER_LEGGINGS, Items.CHAIN, Items.CHAINMAIL_LEGGINGS, recipeOutput, "leather_leggings_to_chainmail");
//                upgradeCoreRecipe(SigilUtils_Items.UPGRADE_CATALYST, Items.LEATHER_BOOTS, Items.CHAIN, Items.CHAINMAIL_BOOTS, recipeOutput, "leather_boots_to_chainmail");
//                upgradeCoreRecipe(SigilUtils_Items.UPGRADE_CATALYST, Items.CHAINMAIL_HELMET, Items.IRON_INGOT, Items.IRON_HELMET, recipeOutput, "chainmail_helmet_to_iron");
//                upgradeCoreRecipe(SigilUtils_Items.UPGRADE_CATALYST, Items.CHAINMAIL_CHESTPLATE, Items.IRON_INGOT, Items.IRON_CHESTPLATE, recipeOutput, "chainmail_chestplate_to_iron");
//                upgradeCoreRecipe(SigilUtils_Items.UPGRADE_CATALYST, Items.CHAINMAIL_LEGGINGS, Items.IRON_INGOT, Items.IRON_LEGGINGS, recipeOutput, "chainmail_leggings_to_iron");
//                upgradeCoreRecipe(SigilUtils_Items.UPGRADE_CATALYST, Items.CHAINMAIL_BOOTS, Items.IRON_INGOT, Items.IRON_BOOTS, recipeOutput, "chainmail_boots_to_iron");
//                upgradeCoreRecipe(SigilUtils_Items.UPGRADE_CATALYST, Items.IRON_HELMET, Items.GOLD_INGOT, Items.GOLDEN_HELMET, recipeOutput, "iron_helmet_to_golden");
//                upgradeCoreRecipe(SigilUtils_Items.UPGRADE_CATALYST, Items.IRON_CHESTPLATE, Items.GOLD_INGOT, Items.GOLDEN_CHESTPLATE, recipeOutput, "iron_chestplate_to_golden");
//                upgradeCoreRecipe(SigilUtils_Items.UPGRADE_CATALYST, Items.IRON_LEGGINGS, Items.GOLD_INGOT, Items.GOLDEN_LEGGINGS, recipeOutput, "iron_leggings_to_golden");
//                upgradeCoreRecipe(SigilUtils_Items.UPGRADE_CATALYST, Items.IRON_BOOTS, Items.GOLD_INGOT, Items.GOLDEN_BOOTS, recipeOutput, "iron_boots_to_golden");
//                upgradeCoreRecipe(SigilUtils_Items.UPGRADE_CATALYST, Items.GOLDEN_HELMET, Items.DIAMOND, Items.DIAMOND_HELMET, recipeOutput, "golden_helmet_to_diamond");
//                upgradeCoreRecipe(SigilUtils_Items.UPGRADE_CATALYST, Items.GOLDEN_CHESTPLATE, Items.DIAMOND, Items.DIAMOND_CHESTPLATE, recipeOutput, "golden_chestplate_to_diamond");
//                upgradeCoreRecipe(SigilUtils_Items.UPGRADE_CATALYST, Items.GOLDEN_LEGGINGS, Items.DIAMOND, Items.DIAMOND_LEGGINGS, recipeOutput, "golden_leggings_to_diamond");
//                upgradeCoreRecipe(SigilUtils_Items.UPGRADE_CATALYST, Items.GOLDEN_BOOTS, Items.DIAMOND, Items.DIAMOND_BOOTS, recipeOutput, "golden_boots_to_diamond");

                // blackstone
                ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, Items.BLACKSTONE)
                        .pattern("BC")
                        .pattern("CB")
                        .define('B', Items.BASALT)
                        .define('C', Items.COAL)
                        .unlockedBy(getHasName(Items.BLACKSTONE), has(Items.BLACKSTONE))
                        .save(recipeOutput);

                // bread
                ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.BREAD)
                        .requires(Items.WHEAT).requires(Items.WHEAT).requires(Items.WHEAT)
                        .unlockedBy(getHasName(Items.WHEAT), has(Items.WHEAT))
                        .save(recipeOutput, "bread_shapeless");

                // bundle
                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.BUNDLE)
                        .pattern("SRS")
                        .pattern("R R")
                        .pattern("RRR")
                        .define('R', Items.RABBIT_HIDE)
                        .define('S', Items.STRING)
                        .unlockedBy(getHasName(Items.RABBIT_HIDE), has(Items.RABBIT_HIDE))
                        .save(recipeOutput);

                // gravel from flint
                ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, Items.GRAVEL)
                        .pattern("FF")
                        .pattern("FF")
                        .define('F', Items.FLINT)
                        .unlockedBy(getHasName(Items.FLINT), has(Items.FLINT))
                        .save(recipeOutput, "gravel_from_flint");

                // name tag
                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.NAME_TAG)
                        .pattern(" IS")
                        .pattern(" PI")
                        .pattern("P  ")
                        .define('I', Items.IRON_NUGGET)
                        .define('S', Items.STRING)
                        .define('P', Items.PAPER)
                        .unlockedBy(getHasName(Items.PAPER), has(Items.PAPER))
                        .save(recipeOutput);

                // paper
                ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.PAPER)
                        .requires(Items.SUGAR_CANE).requires(Items.SUGAR_CANE).requires(Items.SUGAR_CANE)
                        .unlockedBy(getHasName(Items.SUGAR_CANE), has(Items.SUGAR_CANE))
                        .save(recipeOutput, "paper_shapeless");

                // shulker box
                ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.SHULKER_BOX)
                        .requires(Items.SHULKER_SHELL)
                        .requires(Items.CHEST)
                        .requires(Items.SHULKER_SHELL)
                        .unlockedBy(getHasName(Items.SHULKER_SHELL), has(Items.SHULKER_SHELL))
                        .save(recipeOutput, "shulker_box_shapeless");

                // raw metal blocks → metal blocks
                oreBlasting(recipeOutput, List.of(Items.RAW_COPPER_BLOCK), RecipeCategory.MISC, Items.COPPER_BLOCK, 1f, 400,
                        "copper");
                oreBlasting(recipeOutput, List.of(Items.RAW_GOLD_BLOCK), RecipeCategory.MISC, Items.GOLD_BLOCK, 1f, 400,
                        "gold");
                oreBlasting(recipeOutput, List.of(Items.RAW_IRON_BLOCK), RecipeCategory.MISC, Items.IRON_BLOCK, 1f, 400,
                        "iron");

                // spawn eggs
                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, SigilUtils_Items.ORICHALCOM_EGG.get(), 4)
                        .pattern(" O ")
                        .pattern("OEO")
                        .pattern(" O ")
                        .define('O', SigilUtils_Items.ORICHALCOM_INGOT.get())
                        .define('E', Items.EGG)
                        .unlockedBy(getHasName(SigilUtils_Items.ORICHALCOM_INGOT.get()),
                                has(SigilUtils_Items.ORICHALCOM_INGOT.get()))
                        .save(recipeOutput, "orichalcom_egg");

                spawnEggRecipe(SigilUtils_Items.ORICHALCOM_EGG.get(), Items.COOKED_BEEF, Items.LEATHER,
                        Items.COW_SPAWN_EGG, recipeOutput);
                spawnEggRecipe(SigilUtils_Items.ORICHALCOM_EGG.get(), Items.COOKED_CHICKEN, Items.FEATHER,
                        Items.CHICKEN_SPAWN_EGG, recipeOutput);
                spawnEggRecipe(SigilUtils_Items.ORICHALCOM_EGG.get(), Items.COOKED_PORKCHOP, Items.COOKED_PORKCHOP,
                        Items.PIG_SPAWN_EGG, recipeOutput);

                // thank you sheep for being complicated
                TagKey<Item> wool = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("minecraft", "wool"));
                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.SHEEP_SPAWN_EGG)
                        .pattern(" M ")
                        .pattern("WOW")
                        .pattern(" M ")
                        .define('O', SigilUtils_Items.ORICHALCOM_EGG.get())
                        .define('M', Items.COOKED_MUTTON)
                        .define('W', Ingredient.of(wool))
                        .unlockedBy(getHasName(SigilUtils_Items.ORICHALCOM_EGG.get()),
                                has(SigilUtils_Items.ORICHALCOM_EGG.get()))
                        .save(recipeOutput);

                spawnEggRecipe(SigilUtils_Items.ORICHALCOM_EGG.get(), Items.EMERALD, Items.EMERALD,
                        Items.VILLAGER_SPAWN_EGG, recipeOutput);
                spawnEggRecipe(SigilUtils_Items.ORICHALCOM_EGG.get(), Items.ROTTEN_FLESH, Items.ROTTEN_FLESH,
                        Items.ZOMBIE_SPAWN_EGG, recipeOutput);
                spawnEggRecipe(SigilUtils_Items.ORICHALCOM_EGG.get(), Items.BONE, Items.ARROW, Items.SKELETON_SPAWN_EGG,
                        recipeOutput);
                spawnEggRecipe(SigilUtils_Items.ORICHALCOM_EGG.get(), Items.GUNPOWDER, Items.GUNPOWDER,
                        Items.CREEPER_SPAWN_EGG, recipeOutput);
                spawnEggRecipe(SigilUtils_Items.ORICHALCOM_EGG.get(), Items.STRING, Items.SPIDER_EYE,
                        Items.SPIDER_SPAWN_EGG, recipeOutput);
                spawnEggRecipe(SigilUtils_Items.ORICHALCOM_EGG.get(), Items.ENDER_PEARL, Items.ENDER_PEARL,
                        Items.ENDERMAN_SPAWN_EGG, recipeOutput);
                spawnEggRecipe(SigilUtils_Items.ORICHALCOM_EGG.get(), Items.BLAZE_ROD, Items.BLAZE_ROD,
                        Items.BLAZE_SPAWN_EGG, recipeOutput);
                spawnEggRecipe(SigilUtils_Items.ORICHALCOM_EGG.get(), Items.GHAST_TEAR, Items.GUNPOWDER,
                        Items.GHAST_SPAWN_EGG, recipeOutput);
                spawnEggRecipe(SigilUtils_Items.ORICHALCOM_EGG.get(), Items.SHULKER_SHELL, Items.SHULKER_SHELL,
                        Items.SHULKER_SPAWN_EGG, recipeOutput);

                // some of these are transmutation recipes
                spawnEggTransmutationRecipe(Items.COW_SPAWN_EGG, Items.LEATHER_HORSE_ARMOR, Items.HORSE_SPAWN_EGG,
                        recipeOutput);
                spawnEggTransmutationRecipe(Items.ZOMBIE_SPAWN_EGG, Items.NAUTILUS_SHELL, Items.DROWNED_SPAWN_EGG,
                        recipeOutput);
                spawnEggTransmutationRecipe(Items.SKELETON_SPAWN_EGG, Items.BLUE_ICE, Items.STRAY_SPAWN_EGG, recipeOutput);
                spawnEggTransmutationRecipe(Items.VILLAGER_SPAWN_EGG, Items.CROSSBOW, Items.PILLAGER_SPAWN_EGG,
                        recipeOutput);
                spawnEggTransmutationRecipe(Items.VILLAGER_SPAWN_EGG, Items.SPLASH_POTION, Items.WITCH_SPAWN_EGG,
                        recipeOutput);
                spawnEggTransmutationRecipe(Items.VILLAGER_SPAWN_EGG, Items.IRON_AXE, Items.VINDICATOR_SPAWN_EGG,
                        recipeOutput);
                spawnEggTransmutationRecipe(Items.VILLAGER_SPAWN_EGG, Items.TOTEM_OF_UNDYING, Items.EVOKER_SPAWN_EGG,
                        recipeOutput);
                spawnEggTransmutationRecipe(Items.SKELETON_SPAWN_EGG, Items.WITHER_SKELETON_SKULL,
                        Items.WITHER_SKELETON_SPAWN_EGG, recipeOutput);
                spawnEggTransmutationRecipe(Items.VILLAGER_SPAWN_EGG, Items.GOLD_INGOT, Items.PIGLIN_SPAWN_EGG,
                        recipeOutput);
                spawnEggTransmutationRecipe(Items.ZOMBIE_SPAWN_EGG, Items.PORKCHOP, Items.ZOMBIFIED_PIGLIN_SPAWN_EGG,
                        recipeOutput);

                // budding amethyst
                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.BUDDING_AMETHYST)
                        .pattern("BSB")
                        .pattern("SAS")
                        .pattern("BSB")
                        .define('B', Items.AMETHYST_BLOCK)
                        .define('S', Items.AMETHYST_SHARD)
                        .define('A', SigilUtils_Items.ASTRAL_STAR.get())
                        .unlockedBy(getHasName(SigilUtils_Items.ASTRAL_STAR.get()),
                                has(SigilUtils_Items.ASTRAL_STAR.get()))
                        .save(recipeOutput);

                // dragon egg
                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.DRAGON_EGG)
                        .pattern("BHB")
                        .pattern("HAH")
                        .pattern("BHB")
                        .define('B', Items.DRAGON_BREATH)
                        .define('H', Items.DRAGON_HEAD)
                        .define('A', SigilUtils_Items.ASTRAL_STAR.get())
                        .unlockedBy(getHasName(SigilUtils_Items.ASTRAL_STAR.get()),
                                has(SigilUtils_Items.ASTRAL_STAR.get()))
                        .save(recipeOutput);

                // elytra
                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.ELYTRA)
                        .pattern("PEP")
                        .pattern("EAE")
                        .pattern("PEP")
                        .define('P', Items.PURPUR_BLOCK)
                        .define('E', Items.ENDER_PEARL)
                        .define('A', SigilUtils_Items.ASTRAL_STAR.get())
                        .unlockedBy(getHasName(SigilUtils_Items.ASTRAL_STAR.get()),
                                has(SigilUtils_Items.ASTRAL_STAR.get()))
                        .save(recipeOutput);

                // enchanted golden apple
                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.ENCHANTED_GOLDEN_APPLE)
                        .pattern("BIB")
                        .pattern("IAI")
                        .pattern("BIB")
                        .define('B', Items.GOLD_BLOCK)
                        .define('I', Items.GOLD_INGOT)
                        .define('A', SigilUtils_Items.ASTRAL_STAR.get())
                        .unlockedBy(getHasName(SigilUtils_Items.ASTRAL_STAR.get()),
                                has(SigilUtils_Items.ASTRAL_STAR.get()))
                        .save(recipeOutput);

                // nether star
                ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.NETHER_STAR)
                        .requires(SigilUtils_Items.RING_OF_TRANSMUTATION.get())
                        .requires(Items.WITHER_SKELETON_SKULL).requires(Items.WITHER_SKELETON_SKULL)
                        .requires(Items.WITHER_SKELETON_SKULL)
                        .requires(Items.SOUL_SAND).requires(Items.SOUL_SAND).requires(Items.SOUL_SAND)
                        .requires(Items.SOUL_SAND)
                        .requires(SigilUtils_Items.ORICHALCOM_INGOT.get())
                        .unlockedBy(getHasName(SigilUtils_Items.ORICHALCOM_INGOT.get()),
                                has(SigilUtils_Items.ORICHALCOM_INGOT.get()))
                        .save(recipeOutput);

                // spawner
                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.SPAWNER)
                        .pattern("MHM")
                        .pattern("CAL")
                        .pattern("MBM")
                        .define('M', Items.MOSSY_COBBLESTONE)
                        .define('H', Items.CHAINMAIL_HELMET)
                        .define('C', Items.CHAINMAIL_CHESTPLATE)
                        .define('A', SigilUtils_Items.ASTRAL_STAR.get())
                        .define('L', Items.CHAINMAIL_LEGGINGS)
                        .define('B', Items.CHAINMAIL_BOOTS)
                        .unlockedBy(getHasName(SigilUtils_Items.ASTRAL_STAR.get()),
                                has(SigilUtils_Items.ASTRAL_STAR.get()))
                        .save(recipeOutput);

                // totem of undying
                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.TOTEM_OF_UNDYING)
                        .pattern("GEG")
                        .pattern("EAE")
                        .pattern("GEG")
                        .define('G', Items.GOLDEN_APPLE)
                        .define('E', Items.EMERALD_BLOCK)
                        .define('A', SigilUtils_Items.ASTRAL_STAR.get())
                        .unlockedBy(getHasName(SigilUtils_Items.ASTRAL_STAR.get()),
                                has(SigilUtils_Items.ASTRAL_STAR.get()))
                        .save(recipeOutput);

                // trident
                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.TRIDENT)
                        .pattern("PNP")
                        .pattern("NAN")
                        .pattern("PNP")
                        .define('P', Items.PRISMARINE_SHARD)
                        .define('N', Items.NAUTILUS_SHELL)
                        .define('A', SigilUtils_Items.ASTRAL_STAR.get())
                        .unlockedBy(getHasName(SigilUtils_Items.ASTRAL_STAR.get()),
                                has(SigilUtils_Items.ASTRAL_STAR.get()))
                        .save(recipeOutput);
        }

        // function to make the recipes for converting glazed terracotta into reglazed
        // terracotta and vice versa
        public static void reglazedTerracottaRecipe(ItemLike glazed, ItemLike reglazed,
                                                    RecipeOutput recipeOutput, String recipe_name) {
                // glazed → reglazed
                ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, reglazed)
                        .pattern("TT")
                        .pattern("TT")
                        .define('T', glazed)
                        .unlockedBy(getHasName(glazed), has(glazed))
                        .save(recipeOutput, recipe_name);
                // reglazed → glazed
                stonecutterResultFromBase(recipeOutput, RecipeCategory.MISC, glazed, reglazed, 1);
        }

        // 1:1 recipes using the ring of transmutation
        public static void oneToOneTransmutationRecipe(ItemLike input, ItemLike output,
                                                       RecipeOutput recipeOutput, String recipeNameA, String recipeNameB) {
                ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, output)
                        .requires(SigilUtils_Items.RING_OF_TRANSMUTATION.get())
                        .requires(input)
                        .unlockedBy(getHasName(SigilUtils_Items.RING_OF_TRANSMUTATION.get()),
                                has(SigilUtils_Items.RING_OF_TRANSMUTATION.get()))
                        .save(recipeOutput, recipeNameA);

                ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, input)
                        .requires(SigilUtils_Items.RING_OF_TRANSMUTATION.get())
                        .requires(output)
                        .unlockedBy(getHasName(SigilUtils_Items.RING_OF_TRANSMUTATION.get()),
                                has(SigilUtils_Items.RING_OF_TRANSMUTATION.get()))
                        .save(recipeOutput, recipeNameB);
        }

        // 2:1 recipes using the ring of transmutation
        public static void twoToOneTransmutationRecipe(ItemLike one, ItemLike two, RecipeOutput recipeOutput,
                                                       String recipeNameA, String recipeNameB) {
                ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, two, 2)
                        .requires(SigilUtils_Items.RING_OF_TRANSMUTATION.get())
                        .requires(one)
                        .unlockedBy(getHasName(SigilUtils_Items.RING_OF_TRANSMUTATION.get()),
                                has(SigilUtils_Items.RING_OF_TRANSMUTATION.get()))
                        .save(recipeOutput, recipeNameA);

                ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, one)
                        .requires(SigilUtils_Items.RING_OF_TRANSMUTATION.get())
                        .requires(two).requires(two)
                        .unlockedBy(getHasName(SigilUtils_Items.RING_OF_TRANSMUTATION.get()),
                                has(SigilUtils_Items.RING_OF_TRANSMUTATION.get()))
                        .save(recipeOutput, recipeNameB);
        }

        // 4:1 recipes using the ring of transmutation
        public static void fourToOneTransmutationRecipe(ItemLike one, ItemLike four, RecipeOutput recipeOutput,
                                                        String recipeNameA, String recipeNameB) {
                ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, four, 4)
                        .requires(SigilUtils_Items.RING_OF_TRANSMUTATION.get())
                        .requires(one)
                        .unlockedBy(getHasName(SigilUtils_Items.RING_OF_TRANSMUTATION.get()),
                                has(SigilUtils_Items.RING_OF_TRANSMUTATION.get()))
                        .save(recipeOutput, recipeNameA);

                ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, one)
                        .requires(SigilUtils_Items.RING_OF_TRANSMUTATION.get())
                        .requires(four).requires(four).requires(four).requires(four)
                        .unlockedBy(getHasName(SigilUtils_Items.RING_OF_TRANSMUTATION.get()),
                                has(SigilUtils_Items.RING_OF_TRANSMUTATION.get()))
                        .save(recipeOutput, recipeNameB);
        }

        // 8:1 recipes using the ring of transmutation
        public static void eightToOneTransmutationRecipe(ItemLike one, ItemLike eight, RecipeOutput recipeOutput,
                                                         String recipeNameA, String recipeNameB) {
                ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, eight, 8)
                        .requires(SigilUtils_Items.RING_OF_TRANSMUTATION.get())
                        .requires(one)
                        .unlockedBy(getHasName(SigilUtils_Items.RING_OF_TRANSMUTATION.get()),
                                has(SigilUtils_Items.RING_OF_TRANSMUTATION.get()))
                        .save(recipeOutput, recipeNameA);

                ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, one)
                        .requires(SigilUtils_Items.RING_OF_TRANSMUTATION.get())
                        .requires(eight).requires(eight).requires(eight).requires(eight).requires(eight)
                        .requires(eight).requires(eight).requires(eight)
                        .unlockedBy(getHasName(SigilUtils_Items.RING_OF_TRANSMUTATION.get()),
                                has(SigilUtils_Items.RING_OF_TRANSMUTATION.get()))
                        .save(recipeOutput, recipeNameB);
        }

//        // recipes for upgrading gear in the smithing table
//        public static void upgradeCoreRecipe(DeferredItem<Item> upgradeCatalyst, Item baseGear, Item resultMaterial, Item resultGear, RecipeOutput recipeOutput, String recipeName) {
//                SmithingTransformRecipeBuilder.smithing(Ingredient.of(upgradeCatalyst), Ingredient.of(baseGear), Ingredient.of(resultMaterial), RecipeCategory.TOOLS, resultGear).save(recipeOutput, recipeName);
//        }

        // recipe for spawn eggs, since they mostly kinda follow a similar format
        public static void spawnEggRecipe(ItemLike egg, ItemLike catalystA, ItemLike catalystB, ItemLike result, RecipeOutput recipeOutput) {
                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, result)
                        .pattern(" A ")
                        .pattern("BEB")
                        .pattern(" A ")
                        .define('A', catalystA)
                        .define('B', catalystB)
                        .define('E', egg)
                        .unlockedBy(getHasName(SigilUtils_Items.ORICHALCOM_EGG), has(SigilUtils_Items.ORICHALCOM_EGG)).save(recipeOutput);
        }

        public static void spawnEggTransmutationRecipe(ItemLike base, ItemLike catalyst, ItemLike result,
                                                       RecipeOutput recipeOutput) {
                ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, result)
                        .requires(SigilUtils_Items.RING_OF_TRANSMUTATION.get())
                        .requires(base)
                        .requires(catalyst)
                        .unlockedBy(getHasName(SigilUtils_Items.ORICHALCOM_EGG.get()),
                                has(SigilUtils_Items.ORICHALCOM_EGG.get()))
                        .save(recipeOutput);
        }

        protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                          float pExperience, int pCookingTIme, String pGroup) {
                oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                        pExperience, pCookingTIme, pGroup, "_from_smelting");
        }

        protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                          float pExperience, int pCookingTime, String pGroup) {
                oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                        pExperience, pCookingTime, pGroup, "_from_blasting");
        }

        protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                           List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
                for(ItemLike itemlike : pIngredients) {
                        SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                                .save(recipeOutput, SigilUtils.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
                }
        }
}

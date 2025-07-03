package net.pepperflakes.sigil_utils.block;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.pepperflakes.sigil_utils.SigilUtils;
import net.pepperflakes.sigil_utils.item.SigilUtils_Items;

import java.util.function.Supplier;

public class SigilUtils_Blocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(SigilUtils.MOD_ID);

    public static final DeferredBlock<Block> VARENTIUM_BLOCK = registerBlock("varentium_block", () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));
    public static final DeferredBlock<Block> CIRCADIUM_BLOCK = registerBlock("circadium_block", () -> new Block(BlockBehaviour.Properties.of().strength(6f).requiresCorrectToolForDrops().sound(SoundType.METAL)));
    public static final DeferredBlock<Block> ORICHALCOM_BLOCK = registerBlock("orichalcom_block", () -> new Block(BlockBehaviour.Properties.of().strength(10f).requiresCorrectToolForDrops().sound(SoundType.METAL)));

    public static final DeferredBlock<Block> VARENTIUM_ORE = registerBlock("varentium_ore", () -> new DropExperienceBlock(UniformInt.of(7, 14), BlockBehaviour.Properties.of().strength(6f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> DEEPSLATE_VARENTIUM_ORE = registerBlock("deepslate_varentium_ore", () -> new DropExperienceBlock(UniformInt.of(7, 14), BlockBehaviour.Properties.of().strength(7f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));

    public static final DeferredBlock<Block> BLACK_REGLAZED_TERRACOTTA = registerBlock("black_reglazed_terracotta", () -> new Block(BlockBehaviour.Properties.of().strength(6f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> BLUE_REGLAZED_TERRACOTTA = registerBlock("blue_reglazed_terracotta", () -> new Block(BlockBehaviour.Properties.of().strength(6f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> BROWN_REGLAZED_TERRACOTTA = registerBlock("brown_reglazed_terracotta", () -> new Block(BlockBehaviour.Properties.of().strength(6f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> CYAN_REGLAZED_TERRACOTTA = registerBlock("cyan_reglazed_terracotta", () -> new Block(BlockBehaviour.Properties.of().strength(6f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> GRAY_REGLAZED_TERRACOTTA = registerBlock("gray_reglazed_terracotta", () -> new Block(BlockBehaviour.Properties.of().strength(6f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> GREEN_REGLAZED_TERRACOTTA = registerBlock("green_reglazed_terracotta", () -> new Block(BlockBehaviour.Properties.of().strength(6f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> LIME_REGLAZED_TERRACOTTA = registerBlock("lime_reglazed_terracotta", () -> new Block(BlockBehaviour.Properties.of().strength(6f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> LIGHT_BLUE_REGLAZED_TERRACOTTA = registerBlock("light_blue_reglazed_terracotta", () -> new Block(BlockBehaviour.Properties.of().strength(6f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> LIGHT_GRAY_REGLAZED_TERRACOTTA = registerBlock("light_gray_reglazed_terracotta", () -> new Block(BlockBehaviour.Properties.of().strength(6f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> MAGENTA_REGLAZED_TERRACOTTA = registerBlock("magenta_reglazed_terracotta", () -> new Block(BlockBehaviour.Properties.of().strength(6f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> ORANGE_REGLAZED_TERRACOTTA = registerBlock("orange_reglazed_terracotta", () -> new Block(BlockBehaviour.Properties.of().strength(6f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> PINK_REGLAZED_TERRACOTTA = registerBlock("pink_reglazed_terracotta", () -> new Block(BlockBehaviour.Properties.of().strength(6f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> PURPLE_REGLAZED_TERRACOTTA = registerBlock("purple_reglazed_terracotta", () -> new Block(BlockBehaviour.Properties.of().strength(6f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> RED_REGLAZED_TERRACOTTA = registerBlock("red_reglazed_terracotta", () -> new Block(BlockBehaviour.Properties.of().strength(6f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> WHITE_REGLAZED_TERRACOTTA = registerBlock("white_reglazed_terracotta", () -> new Block(BlockBehaviour.Properties.of().strength(6f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> YELLOW_REGLAZED_TERRACOTTA = registerBlock("yellow_reglazed_terracotta", () -> new Block(BlockBehaviour.Properties.of().strength(6f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> CHISELED_OBSIDIAN = registerBlock("chiseled_obsidian", () -> new Block(BlockBehaviour.Properties.of().strength(12f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        SigilUtils_Items.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
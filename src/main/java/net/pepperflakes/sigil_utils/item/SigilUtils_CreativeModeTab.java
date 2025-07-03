package net.pepperflakes.sigil_utils.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.pepperflakes.sigil_utils.SigilUtils;
import net.pepperflakes.sigil_utils.block.SigilUtils_Blocks;

import java.util.function.Supplier;

public class SigilUtils_CreativeModeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SigilUtils.MOD_ID);

    public static final Supplier<CreativeModeTab> SIGIL_TAB = CREATIVE_MODE_TAB.register("sigil_utils",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(SigilUtils_Items.RING_OF_TRANSMUTATION.get()))
                    .title(Component.translatable("creativetab.sigil_utils.creative"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(SigilUtils_Items.VARENTIUM);
                        output.accept(SigilUtils_Items.VARENTIUM_SHARD);
                        output.accept(SigilUtils_Blocks.VARENTIUM_BLOCK);
                        output.accept(SigilUtils_Blocks.VARENTIUM_ORE);
                        output.accept(SigilUtils_Blocks.DEEPSLATE_VARENTIUM_ORE);
                        output.accept(SigilUtils_Items.CIRCADIUM_BLEND);
                        output.accept(SigilUtils_Items.CIRCADIUM_INGOT);
                        output.accept(SigilUtils_Items.CIRCADIUM_PLATING);
                        output.accept(SigilUtils_Blocks.CIRCADIUM_BLOCK);
                        output.accept(SigilUtils_Items.ORICHALCOM_INGOT);
                        output.accept(SigilUtils_Items.ORICHALCOM_NUGGET);
                        output.accept(SigilUtils_Blocks.ORICHALCOM_BLOCK);
                        output.accept(SigilUtils_Items.UPGRADE_CATALYST);
                        output.accept(SigilUtils_Items.RING_OF_TRANSMUTATION);
                        output.accept(SigilUtils_Items.RING_OF_HOLDING);
                        output.accept(SigilUtils_Items.ORICHALCOM_EGG);
                        output.accept(SigilUtils_Items.ASTRAL_STAR);

                        output.accept(SigilUtils_Items.COAL_CHUNK);
                        output.accept(SigilUtils_Items.CHARCOAL_CHUNK);

                        output.accept(SigilUtils_Blocks.BLACK_REGLAZED_TERRACOTTA);
                        output.accept(SigilUtils_Blocks.BLUE_REGLAZED_TERRACOTTA);
                        output.accept(SigilUtils_Blocks.BROWN_REGLAZED_TERRACOTTA);
                        output.accept(SigilUtils_Blocks.CYAN_REGLAZED_TERRACOTTA);
                        output.accept(SigilUtils_Blocks.GRAY_REGLAZED_TERRACOTTA);
                        output.accept(SigilUtils_Blocks.GREEN_REGLAZED_TERRACOTTA);
                        output.accept(SigilUtils_Blocks.MAGENTA_REGLAZED_TERRACOTTA);
                        output.accept(SigilUtils_Blocks.LIGHT_BLUE_REGLAZED_TERRACOTTA);
                        output.accept(SigilUtils_Blocks.LIGHT_GRAY_REGLAZED_TERRACOTTA);
                        output.accept(SigilUtils_Blocks.LIME_REGLAZED_TERRACOTTA);
                        output.accept(SigilUtils_Blocks.ORANGE_REGLAZED_TERRACOTTA);
                        output.accept(SigilUtils_Blocks.PINK_REGLAZED_TERRACOTTA);
                        output.accept(SigilUtils_Blocks.PURPLE_REGLAZED_TERRACOTTA);
                        output.accept(SigilUtils_Blocks.RED_REGLAZED_TERRACOTTA);
                        output.accept(SigilUtils_Blocks.WHITE_REGLAZED_TERRACOTTA);
                        output.accept(SigilUtils_Blocks.YELLOW_REGLAZED_TERRACOTTA);
                        output.accept(SigilUtils_Blocks.CHISELED_OBSIDIAN);

                        output.accept(SigilUtils_Items.CHERRY);
                        output.accept(SigilUtils_Items.PEACH);
                        output.accept(SigilUtils_Items.PERFECT_PEACH);
                        output.accept(SigilUtils_Items.MOSS_BALL);

                        output.accept(SigilUtils_Items.MUSIC_DISC_RUDEBUSTER);
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
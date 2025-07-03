package net.pepperflakes.sigil_utils.datagen;

import net.pepperflakes.sigil_utils.SigilUtils;
import net.pepperflakes.sigil_utils.block.SigilUtils_Blocks;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class SigilUtils_BlockStateProvider extends BlockStateProvider {
    public SigilUtils_BlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, SigilUtils.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(SigilUtils_Blocks.VARENTIUM_BLOCK);
        blockWithItem(SigilUtils_Blocks.VARENTIUM_ORE);
        blockWithItem(SigilUtils_Blocks.DEEPSLATE_VARENTIUM_ORE);
        blockWithItem(SigilUtils_Blocks.CIRCADIUM_BLOCK);
        blockWithItem(SigilUtils_Blocks.ORICHALCOM_BLOCK);

        blockWithItem(SigilUtils_Blocks.BLACK_REGLAZED_TERRACOTTA);
        blockWithItem(SigilUtils_Blocks.BLUE_REGLAZED_TERRACOTTA);
        blockWithItem(SigilUtils_Blocks.BROWN_REGLAZED_TERRACOTTA);
        blockWithItem(SigilUtils_Blocks.CYAN_REGLAZED_TERRACOTTA);
        blockWithItem(SigilUtils_Blocks.GRAY_REGLAZED_TERRACOTTA);
        blockWithItem(SigilUtils_Blocks.GREEN_REGLAZED_TERRACOTTA);
        blockWithItem(SigilUtils_Blocks.LIGHT_BLUE_REGLAZED_TERRACOTTA);
        blockWithItem(SigilUtils_Blocks.LIGHT_GRAY_REGLAZED_TERRACOTTA);
        blockWithItem(SigilUtils_Blocks.LIME_REGLAZED_TERRACOTTA);
        blockWithItem(SigilUtils_Blocks.MAGENTA_REGLAZED_TERRACOTTA);
        blockWithItem(SigilUtils_Blocks.ORANGE_REGLAZED_TERRACOTTA);
        blockWithItem(SigilUtils_Blocks.PINK_REGLAZED_TERRACOTTA);
        blockWithItem(SigilUtils_Blocks.PURPLE_REGLAZED_TERRACOTTA);
        blockWithItem(SigilUtils_Blocks.RED_REGLAZED_TERRACOTTA);
        blockWithItem(SigilUtils_Blocks.WHITE_REGLAZED_TERRACOTTA);
        blockWithItem(SigilUtils_Blocks.YELLOW_REGLAZED_TERRACOTTA);
        blockWithItem(SigilUtils_Blocks.CHISELED_OBSIDIAN);
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }
}

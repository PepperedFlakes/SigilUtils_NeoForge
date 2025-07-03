package net.pepperflakes.sigil_utils.datagen;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.pepperflakes.sigil_utils.block.SigilUtils_Blocks;
import net.pepperflakes.sigil_utils.item.SigilUtils_Items;

import java.util.Set;

public class SigilUtils_BlockLootTableProvider extends BlockLootSubProvider {
    protected SigilUtils_BlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropSelf(SigilUtils_Blocks.VARENTIUM_BLOCK.get());
        dropSelf(SigilUtils_Blocks.CIRCADIUM_BLOCK.get());
        dropSelf(SigilUtils_Blocks.ORICHALCOM_BLOCK.get());
        dropSelf(SigilUtils_Blocks.BLACK_REGLAZED_TERRACOTTA.get());
        dropSelf(SigilUtils_Blocks.BLUE_REGLAZED_TERRACOTTA.get());
        dropSelf(SigilUtils_Blocks.BROWN_REGLAZED_TERRACOTTA.get());
        dropSelf(SigilUtils_Blocks.CYAN_REGLAZED_TERRACOTTA.get());
        dropSelf(SigilUtils_Blocks.GRAY_REGLAZED_TERRACOTTA.get());
        dropSelf(SigilUtils_Blocks.GREEN_REGLAZED_TERRACOTTA.get());
        dropSelf(SigilUtils_Blocks.LIGHT_BLUE_REGLAZED_TERRACOTTA.get());
        dropSelf(SigilUtils_Blocks.LIGHT_GRAY_REGLAZED_TERRACOTTA.get());
        dropSelf(SigilUtils_Blocks.LIME_REGLAZED_TERRACOTTA.get());
        dropSelf(SigilUtils_Blocks.MAGENTA_REGLAZED_TERRACOTTA.get());
        dropSelf(SigilUtils_Blocks.ORANGE_REGLAZED_TERRACOTTA.get());
        dropSelf(SigilUtils_Blocks.PINK_REGLAZED_TERRACOTTA.get());
        dropSelf(SigilUtils_Blocks.PURPLE_REGLAZED_TERRACOTTA.get());
        dropSelf(SigilUtils_Blocks.RED_REGLAZED_TERRACOTTA.get());
        dropSelf(SigilUtils_Blocks.WHITE_REGLAZED_TERRACOTTA.get());
        dropSelf(SigilUtils_Blocks.YELLOW_REGLAZED_TERRACOTTA.get());
        dropSelf(SigilUtils_Blocks.CHISELED_OBSIDIAN.get());

        add(SigilUtils_Blocks.VARENTIUM_ORE.get(), block -> createMultipleOreDrops(SigilUtils_Blocks.VARENTIUM_ORE.get(), SigilUtils_Items.VARENTIUM.get(), 1, 4));
        add(SigilUtils_Blocks.DEEPSLATE_VARENTIUM_ORE.get(), block -> createMultipleOreDrops(SigilUtils_Blocks.DEEPSLATE_VARENTIUM_ORE.get(), SigilUtils_Items.VARENTIUM.get(), 1, 4));
    }

    protected LootTable.Builder createMultipleOreDrops(Block pBlock, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock, LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                        .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return SigilUtils_Blocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}

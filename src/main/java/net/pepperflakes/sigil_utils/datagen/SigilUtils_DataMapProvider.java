package net.pepperflakes.sigil_utils.datagen;

import net.pepperflakes.sigil_utils.item.SigilUtils_Items;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.registries.datamaps.builtin.FurnaceFuel;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;

import java.util.concurrent.CompletableFuture;

public class SigilUtils_DataMapProvider extends DataMapProvider {
    protected SigilUtils_DataMapProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(packOutput, lookupProvider);
    }

    @Override
    protected void gather() {
        this.builder(NeoForgeDataMaps.FURNACE_FUELS)
                .add(SigilUtils_Items.COAL_CHUNK.getId(), new FurnaceFuel(200), false)
                .add(SigilUtils_Items.CHARCOAL_CHUNK.getId(), new FurnaceFuel(200), false);
    }
}
package net.pepperflakes.sigil_utils.datagen;

import net.pepperflakes.sigil_utils.SigilUtils;
import net.pepperflakes.sigil_utils.item.SigilUtils_Items;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class SigilUtils_ItemModelProvider extends ItemModelProvider {
    public SigilUtils_ItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, SigilUtils.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(SigilUtils_Items.VARENTIUM.get());
        basicItem(SigilUtils_Items.VARENTIUM_SHARD.get());
        basicItem(SigilUtils_Items.CIRCADIUM_INGOT.get());
        basicItem(SigilUtils_Items.CIRCADIUM_BLEND.get());
        basicItem(SigilUtils_Items.CIRCADIUM_PLATING.get());
        basicItem(SigilUtils_Items.ORICHALCOM_ALLOY.get());
        basicItem(SigilUtils_Items.ORICHALCOM_INGOT.get());
        basicItem(SigilUtils_Items.ORICHALCOM_NUGGET.get());

        basicItem(SigilUtils_Items.RING_OF_TRANSMUTATION.get());
        basicItem(SigilUtils_Items.RING_OF_HOLDING.get());
        basicItem(SigilUtils_Items.ORICHALCOM_EGG.get());
        basicItem(SigilUtils_Items.ASTRAL_STAR.get());

        basicItem(SigilUtils_Items.COAL_CHUNK.get());
        basicItem(SigilUtils_Items.CHARCOAL_CHUNK.get());

        basicItem(SigilUtils_Items.MOSS_BALL.get());
    }
}

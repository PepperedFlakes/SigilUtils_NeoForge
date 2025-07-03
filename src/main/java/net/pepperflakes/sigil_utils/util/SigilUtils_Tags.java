package net.pepperflakes.sigil_utils.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.pepperflakes.sigil_utils.SigilUtils;

public class SigilUtils_Tags {
    public static class Blocks {
        public static final TagKey<Block> REGLAZED_TERRACOTTA = tag("reglazed_terracotta");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(SigilUtils.MOD_ID, name));
        }
    }

    public static class Items {

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(SigilUtils.MOD_ID, name));
        }
    }
}

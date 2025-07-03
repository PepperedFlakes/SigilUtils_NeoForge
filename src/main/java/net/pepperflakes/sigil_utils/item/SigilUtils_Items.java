package net.pepperflakes.sigil_utils.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.datamaps.builtin.FurnaceFuel;
import net.pepperflakes.sigil_utils.SigilUtils;

public class SigilUtils_Items {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(SigilUtils.MOD_ID);

    // progression
    public static final DeferredItem<Item> VARENTIUM = ITEMS.register("varentium", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> VARENTIUM_SHARD = ITEMS.register("varentium_shard", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> CIRCADIUM_BLEND = ITEMS.register("circadium_blend", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> CIRCADIUM_INGOT = ITEMS.register("circadium_ingot", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> CIRCADIUM_PLATING = ITEMS.register("circadium_plating", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> ORICHALCOM_INGOT = ITEMS.register("orichalcom_ingot", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> ORICHALCOM_ALLOY = ITEMS.register("orichalcom_alloy", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> ORICHALCOM_NUGGET = ITEMS.register("orichalcom_nugget", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> UPGRADE_CATALYST = ITEMS.register("upgrade_catalyst", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> ANCIENT_UPGRADE_CATALYST = ITEMS.register("ancient_upgrade_catalyst", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RING_OF_TRANSMUTATION = ITEMS.register("ring_of_transmutation", () -> new Item(new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> RING_OF_HOLDING = ITEMS.register("ring_of_holding", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> ORICHALCOM_EGG = ITEMS.register("orichalcom_egg", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> ASTRAL_STAR = ITEMS.register("astral_star", () -> new Item(new Item.Properties()));

    // fuels
    public static final DeferredItem<Item> COAL_CHUNK = ITEMS.register("coal_chunk", () -> new FuelItem(new Item.Properties(), 200));
    public static final DeferredItem<Item> CHARCOAL_CHUNK = ITEMS.register("charcoal_chunk", () -> new FuelItem(new Item.Properties(), 200));

    // foods
    public static final DeferredItem<Item> CHERRY = ITEMS.register("cherry", () -> new Item(new Item.Properties().food(SigilUtils_FoodProperties.CHERRY)));
    public static final DeferredItem<Item> PEACH = ITEMS.register("peach", () -> new Item(new Item.Properties().food(SigilUtils_FoodProperties.PEACH)));
    public static final DeferredItem<Item> PERFECT_PEACH = ITEMS.register("perfect_peach", () -> new Item(new Item.Properties().food(SigilUtils_FoodProperties.PERFECT_PEACH)));
    public static final DeferredItem<Item> MOSS_BALL = ITEMS.register("moss_ball", () -> new Item(new Item.Properties().food(SigilUtils_FoodProperties.MOSS_BALL)));

    // misc
    public static final DeferredItem<Item> MUSIC_DISC_RUDEBUSTER = ITEMS.register("music_disc_rudebuster", () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

package sniffer.sniffermod.potion;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.stat.Stat;
import net.minecraft.util.Identifier;
import sniffer.sniffermod.SnifferMod;
import sniffer.sniffermod.block.ModBlocks;
import sniffer.sniffermod.effect.ModEffects;
import sniffer.sniffermod.item.ModItems;
import sniffer.sniffermod.mixin.BrewingRecipeRegistryMixin;

public class ModPotions {
    public static Potion RESISTANCE;
    public static Potion FREEZE;
    public static Potion FIRE;
    public static Potion STRONG_FIRE;
    public static Potion SHORT_FIRE_RESISTANCE;

    public static Potion registerPotion(String name, StatusEffect effect, int duration, int amp) {
        return Registry.register(Registries.POTION, new Identifier(SnifferMod.MOD_ID, name),
                new Potion(new StatusEffectInstance(effect, duration, amp)));
    }

    public static void registerPotions() {
        RESISTANCE = registerPotion("resistance_potion", StatusEffects.RESISTANCE, 1800, 0);
        FREEZE = registerPotion("freeze_potion", ModEffects.FREEZE, 200, 0);
        FIRE = registerPotion("fire_potion", ModEffects.FIRE, 1, 0);
        STRONG_FIRE = registerPotion("strong_fire_potion", ModEffects.FIRE, 1, 1); // fire res II
        SHORT_FIRE_RESISTANCE = registerPotion("short_fire_resistance_potion", StatusEffects.FIRE_RESISTANCE,1200 , 0);
        registerPotionRecipes();
    }

    public static void registerPotionRecipes() {
        // normal
        BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(Potions.AWKWARD, Items.TORCHFLOWER, ModPotions.SHORT_FIRE_RESISTANCE); // fire resistance
        BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(Potions.AWKWARD, ModBlocks.SHELL_FLOWER.asItem(), ModPotions.RESISTANCE); // resistance
        BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(Potions.AWKWARD, ModBlocks.ICE_FLOWER.asItem(), ModPotions.FREEZE); // freeze

        // corrupt
        BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(ModPotions.FREEZE, Items.FERMENTED_SPIDER_EYE, ModPotions.FIRE); // fire
        BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(ModPotions.FIRE, Items.SUGAR, ModPotions.STRONG_FIRE); // strong fire
    }
}
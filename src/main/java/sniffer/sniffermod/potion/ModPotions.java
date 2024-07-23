package sniffer.sniffermod.potion;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import sniffer.sniffermod.SnifferMod;
import sniffer.sniffermod.block.ModBlocks;
import sniffer.sniffermod.item.ModItems;
import sniffer.sniffermod.mixin.BrewingRecipeRegistryMixin;

public class ModPotions {
    public static Potion RESISTANCE;

    public static Potion registerPotion(String name, StatusEffect effect, int duration, int amp) {
        return Registry.register(Registries.POTION, new Identifier(SnifferMod.MOD_ID, name),
                new Potion(new StatusEffectInstance(effect, duration, amp)));
    }

    public static void registerPotions() {
        RESISTANCE = registerPotion("resistance_potion", StatusEffects.RESISTANCE, 1200, 0);
    }

    //public static void registerPotionRecipes() {
        //BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(Potions.AWKWARD, ModBlocks.SHELL_FLOWER, ModPotions.RESISTANCE);
    //}
}
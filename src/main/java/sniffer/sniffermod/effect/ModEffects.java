package sniffer.sniffermod.effect;

import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import sniffer.sniffermod.SnifferMod;

import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.runtime.ObjectMethods;


public class ModEffects extends StatusEffects {
    public static StatusEffect DOUBLE_JUMP;
    public static StatusEffect FIRE;
    public static StatusEffect FREEZE;
    public static StatusEffect REACH;


    public static StatusEffect register(String name, StatusEffect statusEffect) {
        return Registry.register(Registries.STATUS_EFFECT, new Identifier(SnifferMod.MOD_ID, name),
                statusEffect);
    }

    public static void registerEffects() {
        FREEZE = register("freeze", new FreezeEffect(StatusEffectCategory.HARMFUL, 3124687));
        FIRE = register("fire", new FireEffect(StatusEffectCategory.HARMFUL, 14768675));

//        REACH = register(
//                "reach",
//                new StatusEffect(StatusEffectCategory.BENEFICIAL, 3402751)
//                        .addAttributeModifier(
//                                EntityAttributes., "91AEAA56-376B-4498-935B-2F7F68070635", 0.2F, EntityAttributeModifier.Operation.MULTIPLY_TOTAL
//                        )
//        );
    }
}

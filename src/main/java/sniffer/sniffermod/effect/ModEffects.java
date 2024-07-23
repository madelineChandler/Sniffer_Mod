package sniffer.sniffermod.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ModEffects extends StatusEffects {
    public static StatusEffect DOUBLE_JUMP;

    private static StatusEffect register(String name, StatusEffect entry) {
        return null; //Registry.register(Registries.STATUS_EFFECT)
    }
}

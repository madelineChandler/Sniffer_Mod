package sniffer.sniffermod.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class ReachEffect extends StatusEffect {
    protected ReachEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int pAmp) {
        //entity.
        super.applyUpdateEffect(entity, pAmp);
    }

    @Override
    public boolean canApplyUpdateEffect(int pDuration, int pAmp) {
        return true;
    }
}

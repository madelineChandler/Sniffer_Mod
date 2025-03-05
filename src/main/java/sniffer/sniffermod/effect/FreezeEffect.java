package sniffer.sniffermod.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class FreezeEffect extends StatusEffect {
    protected FreezeEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void applyUpdateEffect(LivingEntity pLivingEntity, int pAmp) {
        if (!pLivingEntity.getEntityWorld().isClient()) {
            double x = pLivingEntity.getX();
            double y = pLivingEntity.getY();
            double z = pLivingEntity.getZ();

            pLivingEntity.teleport(x, y, z);
            pLivingEntity.setVelocity(0, 0, 0);
        }

        if (pLivingEntity.isOnFire()) {
            pLivingEntity.extinguish();
        }

        super.applyUpdateEffect(pLivingEntity, pAmp);
    }

    @Override
    public boolean canApplyUpdateEffect(int pDuration, int pAmp) {
        return true;
    }
}

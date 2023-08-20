package com.mrfuzzihead.fuzzitweaks.mixin;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EntityLiving.class)
public abstract class EntityLivingMixin extends EntityLivingBase {

    @Shadow private boolean persistenceRequired;

    @Shadow public abstract ItemStack getHeldItem();

    @Shadow public abstract boolean hasCustomNameTag();

    public EntityLivingMixin(World p_i1594_1_) {
        super(p_i1594_1_);
    }

    @Inject(at = @At("TAIL"), method = "onLivingUpdate")
    private void updatePersistanceStatus(CallbackInfo ci) {
        if (this.getHeldItem() != null) {
            if (!this.hasCustomNameTag())
                this.persistenceRequired = false;
        }
    }

    @Redirect(method = "despawnEntity", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/EntityLiving;setDead()V"))
    private void despawnCheck(EntityLiving instance) {
        this.setDead();
    }
}
package com.mrfuzzihead.fuzzitweaks.mixin;

import com.mrfuzzihead.fuzzitweaks.handlers.ConfigurationHandler;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.IMob;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(EntityMob.class)
public abstract class EntityMobMixin extends EntityCreature implements IMob
{
    public EntityMobMixin(World p_i1602_1_)
    {
        super(p_i1602_1_);
        this.experienceValue = 5;
    }

    /**
     * @author MrFuzzihead
     * @reason Bc I fucking wanted to
     */
    @Overwrite
    protected boolean isValidLightLevel()
    {
        int i = MathHelper.floor_double(this.posX);
        int j = MathHelper.floor_double(this.boundingBox.minY);
        int k = MathHelper.floor_double(this.posZ);

        if (this.worldObj.getSavedLightValue(EnumSkyBlock.Sky, i, j, k) > this.rand.nextInt(32))
        {
            return false;
        }
        else
        {
            int l = this.worldObj.getBlockLightValue(i, j, k);

            if (this.worldObj.isThundering())
            {
                int i1 = this.worldObj.skylightSubtracted;
                this.worldObj.skylightSubtracted = 10;
                l = this.worldObj.getBlockLightValue(i, j, k);
                this.worldObj.skylightSubtracted = i1;
            }

            return l <= this.rand.nextInt(ConfigurationHandler.mobSpawnLightLevelCutoff);
        }
    }
}

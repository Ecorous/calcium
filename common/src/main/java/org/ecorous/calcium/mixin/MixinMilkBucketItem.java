/*
 * Copyright 2024 Ecorous
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.ecorous.calcium.mixin;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.MilkBucketItem;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.common.ModConfigSpec;
import org.ecorous.calcium.CalciumConfig;
import org.ecorous.calcium.platform.CommonClass;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MilkBucketItem.class)
public class MixinMilkBucketItem {
    // finishUsingItem at tail
    @Inject(at = @At("TAIL"), method = "finishUsingItem")
    public void wawa(ItemStack $$0, Level $$1, LivingEntity $$2, CallbackInfoReturnable<ItemStack> cir) {
        CalciumConfig config = CommonClass.INSTANCE.getConfig().getLeft();
        String id = config.potionId.get();
        MobEffect effect = BuiltInRegistries.MOB_EFFECT.get(new ResourceLocation(id));
        int time = config.potionTime.get();
        int amplifier = config.potionAmplifier.get();
        //MobEffect strength = BuiltInRegistries.MOB_EFFECT.get(new ResourceLocation("minecraft", "strength"));
        MobEffectInstance effectInstance = new MobEffectInstance(effect, time, amplifier);
        $$2.addEffect(effectInstance);
    }
}

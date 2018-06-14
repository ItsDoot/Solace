@file:Suppress("NOTHING_TO_INLINE")

package pw.dotdash.solace.sponge.effect.potion

import org.spongepowered.api.effect.potion.PotionEffect
import org.spongepowered.api.effect.potion.PotionEffectType

inline operator fun PotionEffectType.invoke(amplifier: Int, duration: Int) =
        PotionEffect.of(this, amplifier, duration)
@file:Suppress("NOTHING_TO_INLINE")

package solace.sponge.data.value

import org.spongepowered.api.data.key.Key
import org.spongepowered.api.data.value.ValueContainer

inline operator fun ValueContainer<*>.contains(key: Key<*>): Boolean =
        this.supports(key)
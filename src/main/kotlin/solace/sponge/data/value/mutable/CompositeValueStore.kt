@file:Suppress("NOTHING_TO_INLINE")

package solace.sponge.data.value.mutable

import org.spongepowered.api.data.DataTransactionResult
import org.spongepowered.api.data.key.Key
import org.spongepowered.api.data.value.BaseValue
import org.spongepowered.api.data.value.mutable.CompositeValueStore

inline operator fun <E : Any> CompositeValueStore<*, *>.set(key: Key<out BaseValue<E>>, value: E): DataTransactionResult =
        this.offer(key, value)
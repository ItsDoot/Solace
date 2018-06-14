@file:Suppress("NOTHING_TO_INLINE")

package pw.dotdash.solace.sponge.data.property

import org.spongepowered.api.Sponge
import org.spongepowered.api.data.Property
import org.spongepowered.api.data.property.PropertyRegistry
import org.spongepowered.api.data.property.PropertyStore
import pw.dotdash.solace.java.unwrapped

inline val PropertyRegistry: PropertyRegistry
    get() = Sponge.getPropertyRegistry()

inline fun <T : Property<*, *>> Class<T>.registerPropertyStore(propertyStore: PropertyStore<T>) =
        PropertyRegistry.register(this, propertyStore)

inline val <T : Property<*, *>> Class<T>.propertyStore: PropertyStore<T>?
    get() = PropertyRegistry.getStore(this).unwrapped